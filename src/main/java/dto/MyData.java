package dto;

import java.util.List;

class MyData {
	// I do want to send this sensitive attribute
	// So either I add an 'ignore' annotation
	// or I use a DTO that does not use this attribute
	private String hashPwd;

	private int value;

	private List<List<MySecondData>> second;

	MyData() {
		hashPwd = "";
		value = 1;
		second = List.of(
			List.of(MySecondData.ONE, MySecondData.ONE, MySecondData.TWO),
			List.of(MySecondData.THREE, MySecondData.TWO, MySecondData.THREE),
			List.of(MySecondData.TWO, MySecondData.ONE, MySecondData.THREE));
	}

	public int getValue() {
		return value;
	}

	public List<List<MySecondData>> getSecond() {
		return second;
	}
}


// I want to optimise the marshalling of this enum by
// returning an integer instead of the name of the items.
enum MySecondData {
	ONE, TWO, THREE
}
