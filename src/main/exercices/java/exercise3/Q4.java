package exercise3;

import java.util.HashMap;
import java.util.Map;

class Bar {
	final Map<String, MyInterface> map;

	Bar() {
		map = new HashMap<>();
		map.put("B", () -> new B());
		map.put("C", () -> new C());
	}

	public A foo(final String str) {
		return map.getOrDefault(str, () -> null).myOperation();
	}

	private interface MyInterface {
		A myOperation();
	}
}

abstract class A {
}

class B extends A {
}

class C extends A {
}

public class Q4 {
	public static void main(final String[] args) {
		final Bar bar = new Bar();
		System.out.println(bar.foo("B"));
		System.out.println(bar.foo("B"));
		System.out.println(bar.foo("C"));
		System.out.println(bar.foo("C"));
		System.out.println(bar.foo("D"));
	}
}
