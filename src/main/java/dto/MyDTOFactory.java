package dto;

import java.util.stream.Collectors;

public class MyDTOFactory {
	public MyDTO toMyDTO(final MyData data) {
		// I convert this complex double list into a simple list of integer
		final var seconds = data.getSecond()
			.stream()
			// flatmap transforms a stream of streams, into a single stream
			.flatMap(stream -> stream.stream())
			// conversion of the data
			.map(second -> secondDatatoInteger(second))
			.collect(Collectors.toList());

		return new MyDTO(data.getValue(), seconds);
	}

	private int secondDatatoInteger(final MySecondData second) {
		return second.ordinal();
	}
}
