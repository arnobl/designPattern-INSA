package nullObject.nullable;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NullableExample {
	@NotNull
	Object obj;

	NullableExample(@Nullable final Object o) {
		super();
		// A warning is raised by intellij since obj may be null (o may be null and obj is tagged has not null).
		obj = o;
	}

	@NotNull
	public String foo(@Nullable final Object o) {
		// A warning is raised since o can be null and no nullity check is done on 'o'.
		return o.toString();
	}

	public void bar(@NotNull final Object o) {
		final String result = foo(o);

		// A warning is raised since foo return an object that cannot be null, so the nullity check is useless here.
		if(result != null) {
			System.out.println(result);
		}
	}
}
