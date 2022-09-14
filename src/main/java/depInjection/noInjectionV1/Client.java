package depInjection.noInjectionV1;

// This client depends on ServiceImpl
public class Client {
	private final Service service;

	public Client() {
		// Explicit use of implementations.
		// This has an impact on the coupling:
		// This class is coupled with ServiceImpl and this
		// is an issue as it makes the code more complex
		// to maintain
		service = new ServiceImpl();
	}

	public void foo() {
		service.fooService();
	}
}
