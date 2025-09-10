package exercises.exercise1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Foo {
}

public class OptionalTest {
//    Optional<String> opt;
//
//    @Nested
//    class WhenEmpty {
//        @BeforeEach
//        void setUp() {
//            opt = Optional.of(null);
//        }
//
//        @Test
//        void courseExample() {
//            Foo foo = new Foo();
//            Optional<Foo> opt = Optional.of(foo);
//            if (opt.isPresent()) {
//            }
//            String res = opt.map(value -> value.toString()).orElse(" ");
//        }
//
//        @Test
//        void ofNotNull() {
//            assertNotNull(opt);
//        }
//
//        // @Test
//        // void ofNull() {
//        // assertSame(Optional.EMPTY, opt);
//        // }
//
//        @Test
//        void orElseWithEmptyOptional() {
//            assertEquals("bar", opt.orElse("bar"));
//        }
//
//        @Test
//        void isPresentEmpty() {
//            assertFalse(opt.isPresent());
//        }
//
////	 	@Test
////	 	void ifPresentWhenEmpty() {
////	 		Consumer<String> cons = Mockito.mock(Consumer.class);
////	 		opt.ifPresent(cons);
////	 		Mockito.verify(cons, Mockito.never()).accept(Mockito.anyString());
////	 	}
//    }
//
//    @Nested
//    class WhenNotEmpty {
//        @BeforeEach
//        void setUp() {
//            opt = Optional.of("foo");
//        }
//
//        @Test
//        void ofNotNull() {
//            assertNotNull(opt);
//        }
//
//        @Test
//        void isPresentOk() {
//            assertTrue(opt.isPresent());
//        }
//
//        @Test
//        void orElseOKNotEmpty() {
//            assertEquals("foo", opt.orElse(""));
//        }
//
////	 	@Test
////	 	void ifPresentWhenNotEmpty() {
////	 		Consumer<String> cons = Mockito.mock(Consumer.class);
////	 		opt.ifPresent(cons);
////	 		Mockito.verify(cons, Mockito.times(1)).accept("foo");
////	 	}
//
//        @Test
//        void map() {
//            final Optional<Integer> opt2 = opt.map(v -> v.length());
//            assertNotNull(opt2);
//            assertEquals(3, opt2.orElse(0));
//        }
//
//        @Test
//        void mapNull() {
//            final Optional<Integer> opt2 = Optional.of((String) null).map(v ->
//                    v.length());
//
//            assertNotNull(opt2);
//            // assertSame(Optional.EMPTY, opt2);
//            assertEquals(0, opt2.orElse(0));
//        }
//    }
}
