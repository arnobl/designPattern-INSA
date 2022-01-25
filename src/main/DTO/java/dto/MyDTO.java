package dto;

import java.util.List;

// I use a record, but can be a class
public record MyDTO(int value, List<Integer> seconds) {
}
