import java.util.ArrayList;


public class BlockingQueue {

	private static int LIMIT_CHARS = 100;
	private ArrayList<String> list;
	private int size;
	
	public BlockingQueue() {
		size = 0;
		list = new ArrayList<String>();
	}
	
	public synchronized void put(String input) throws InterruptedException {
		while(input.length() + size > LIMIT_CHARS) {
			wait();
		}
		size += input.length();
		list.add(input);
		notifyAll();
		
	}
	
	public synchronized String take() throws InterruptedException {
		while(size == 0) {
			wait();
		}
		String result = list.remove(0);
		size -= result.length();
		notifyAll();
		return result;
	}

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue bq = new BlockingQueue();
		bq.put(new String("abacedef"));
		bq.put(new String("abacedefghij"));
		bq.put(new String("abacedefpqrst"));
		System.out.println(bq.take());
		System.out.println(bq.take());
		bq.put(new String("abacedefghijklmnopqrstuvwxyz"));
		System.out.println(bq.take());
		
	}

}
