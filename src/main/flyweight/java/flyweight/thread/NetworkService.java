package flyweight.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkService {
	private final ExecutorService pool;

	public static void main(final String[] args) {
		new NetworkService().executeSomeThreads();
	}

	public NetworkService() {
		super();
		// This pool is a flyweight: it manages a given number of threads.
		pool = Executors.newFixedThreadPool(1);
	}

	public void executeSomeThreads() {
		// Executing several threads. The pool manages the execution and waits for
		// the end of one of them if all the threads are used.

		pool.execute(() -> {
			System.out.println("thread1");
			try {
				Thread.sleep(4000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		});
		pool.execute(() -> {
			System.out.println("thread2");
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		});
		pool.execute(() -> {
			System.out.println("thread3");
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		});
		pool.execute(() -> {
			System.out.println("thread4");
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		});
		pool.execute(() -> {
			System.out.println("thread5");
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
}
