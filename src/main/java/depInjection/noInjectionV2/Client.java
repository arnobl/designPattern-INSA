package depInjection.noInjectionV2;

// This client does not depend on ServiceImpl anymore
public class Client {
	private final Service service;


	// Someone will provide the concrete service to this class
	// Question here: how will provide this parameter?
	Client(final Service providedService) {
		service = providedService;
	}

	public void foo() {
		service.fooService();
	}
}

// However, another client class of the app may have the dependency to ServiceImpl
// So, the problem has just been moved from one client class to another one
class OtherClientClass {
	void createClient() {
		Client client = new Client(new ServiceImpl());
	}
}
