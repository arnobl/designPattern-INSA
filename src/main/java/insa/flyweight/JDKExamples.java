package insa.flyweight;

import java.util.Collections;
import java.util.List;

public class JDKExamples {
	public void exampleCollections() {
		List<String> myList = Collections.singletonList("foo");

		myList = Collections.emptyList();
	}
}