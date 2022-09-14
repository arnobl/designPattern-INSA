package future.simpleExample;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class Example {
	public static void main(final String[] args) {
		final var ex = new Example();
		ex.example1();
		ex.example2();

		ex.shutdown();
	}

	private final ExecutorService service = Executors.newFixedThreadPool(3);

	private void example1() {
		final var future = new FutureTask<>(() -> {
			// Do not use sleep()! For demonstration only
			Thread.sleep(2000);
			return "foo";
		});
		System.out.println("Future1 created");

		service.submit(future);
		System.out.println("Future2 submitted");
		try {
			// Waits for the end of the future.
			// Not a good practice as it blocks this main thread.
			System.out.println(future.get());
			System.out.println("Future1 ended");
		}catch(final InterruptedException | ExecutionException ex) {
			ex.printStackTrace();
		}
	}


	private void example2() {
		final var future = new MyFutureTask(() -> {
			// Do not use sleep()! For demonstration only
			Thread.sleep(2000);
			return "bar";
		}, result -> System.out.printf("Future2 ended with results: %s", result));
		System.out.println("Future2 created");

		service.submit(future);
		System.out.println("Future2 submitted");
	}


	private void shutdown() {
		try {
			// Waiting for the end of the tasks.
			// Quite a bad practice IRL but necessary here as this is the end of the app
			service.awaitTermination(3, TimeUnit.SECONDS);
			// Do not forget to shutdown thread pools
			service.shutdownNow();
		}catch(final InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyFutureTask extends FutureTask<String> {
	/**
	 * In this example the future takes a lambda that will 'consume'
	 * the results of the task. This lambda will be automatically
	 * called at the end of the task. So no need to wait for that
	 * in the main thread. Better practice.
	 */
	private final Consumer<String> onDone;

	public MyFutureTask(@NotNull final Callable<String> task, @NotNull final Consumer<String> onDone) {
		super(task);
		this.onDone = onDone;
	}

	@Override
	protected void done() {
		if(!isCancelled()) {
			try {
				onDone.accept(get());
			}catch(final InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
