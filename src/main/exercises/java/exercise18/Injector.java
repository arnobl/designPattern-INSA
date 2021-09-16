package exercise18;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Optional;

// There already exists Inject annotations in javax.inject for example.
// Retention means: by default an annotation is not kept in class files to be used at run time.
// So, we need to tell the compiler this annotation Inject must be saved in class files
// (otherwise, the injection will not work as the program will not find annotations at run time).
@Retention(RetentionPolicy.RUNTIME)
@interface Inject {
}

public class Injector {
	public <T> Optional<T> createInstance(final Class<T> cl) {
		//TODO
		return Optional.empty();
	}
}
