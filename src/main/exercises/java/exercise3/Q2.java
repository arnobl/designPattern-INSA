package exercise3;

interface AnInterface {
	// The keyword 'default' identifies operations implemented by default in their interface.
	default void op1() {
		op2();
		if(op3()) {
			op4();
		}
	}

	void op2();

	boolean op3();

	void op4();
}
