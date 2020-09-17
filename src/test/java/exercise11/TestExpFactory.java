package exercise11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestExpFactory {
	ExpFactory fact;

	@BeforeEach
	void setUp() {
		fact = new ExpFactory();
	}

	@Test
	void testUnknown() {
		assertNull(fact.createExp("ifihdsoi"));
	}

	@Test
	void testNull() {
		assertNull(fact.createExp(null));
	}

	@Test
	void testMult() {
		assertTrue(fact.createExp("mult") instanceof Mult);
	}

	@Test
	void testMin() {
		assertTrue(fact.createExp("min") instanceof Min);
	}

	@Test
	void testMod() {
		assertTrue(fact.createExp("mod") instanceof Mod);
	}

	@Test
	void testPlus() {
		assertTrue(fact.createExp("plus") instanceof Plus);
	}

	@Test
	void testPlusPlus() {
		assertNotSame(fact.createExp("plus"), fact.createExp("plus"));
	}

	@Test
	void testModMod() {
		assertNotSame(fact.createExp("mod"), fact.createExp("mod"));
	}

	@Test
	void testMultMult() {
		assertNotSame(fact.createExp("mult"), fact.createExp("mult"));
	}

	@Test
	void testMinMin() {
		assertNotSame(fact.createExp("min"), fact.createExp("min"));
	}
}
