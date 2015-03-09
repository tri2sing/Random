import java.util.Iterator;

public class LList<T> implements Iterable<T> {

	private class LNode {
		private T data;
		private LNode next;
		private LNode prev;

		public LNode(T data) {
			this.data = data;
			next = null;
			prev = null;
		}
	}

	private LNode head;
	private LNode tail;
	private int size;

	public LList() {
		head = null;
		tail = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public void insertLast(T data) {
		if (head == null && tail == null) {
			head = new LNode(data);
			tail = head;
		} else {
			LNode last = tail;
			tail = new LNode(data);
			last.next = tail;
			tail.prev = last;
		}
		++size;
	}

	public T removeFirst() {
		T data = null;

		if (size == 1) {
			data = head.data;
			head = null;
			tail = null;
		} else {
			data = head.data;
			head = head.next;
			head.prev = null;
		}
		--size;
		return data;
	}

	// Iterator
	public Iterator<T> iterator() {
		return new LIterator();
	}

	public class LIterator implements Iterator<T> {
		private LNode current;
		
		public LIterator() {
			current = head;
		}
		
		public boolean hasNext() {
			if (current == null)
				return false;
			else
				return true;
		}

		public T next() {
			T data = current.data;
			current = current.next;
			return data;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	// Reverse

	// Clone

	// Reverse Clone

	public void print() {
		System.out.println("Size = " + String.valueOf(size));
		LNode trav = head;
		int i = 0;
		while (trav != null) {
			System.out.println("Node " + String.valueOf(i) + " = "
					+ trav.data.toString());
			trav = trav.next;
			++i;
		}
	}

	public static void main(String[] args) {

		System.out.println("Adding nodes\n");
		LList<Integer> list = new LList<Integer>();
		list.insertLast(new Integer(3));
		list.insertLast(new Integer(4));
		list.insertLast(new Integer(5));
		list.print();

		System.out.println("\nRemoving nodes\n");
		Integer val = list.removeFirst();
		System.out.println(val.toString());
		val = list.removeFirst();
		System.out.println(val.toString());
		val = list.removeFirst();
		System.out.println(val.toString());

		System.out.println("Adding more nodes\n");
		list.insertLast(new Integer(13));
		list.insertLast(new Integer(14));
		list.insertLast(new Integer(15));
		list.print();

		System.out.println("Iterating through nodes\n");
		for(Integer i: list) {
			System.out.println(i.toString());
		}

		System.out.println("\nRemoving more nodes\n");
		val = list.removeFirst();
		System.out.println(val.toString());


	}

}
