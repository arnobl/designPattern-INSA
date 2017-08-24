package insa.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Composite implements Component {
	private final List<Component> components;

	public Composite() {
		super();
		components = new ArrayList<>();
	}

	@Override
	public String doSomething() {
		return components.stream().map(comp -> comp.doSomething()).collect(Collectors.joining(", ", "composite [", "]"));
	}

	public void addComponent(final Component comp) {
		if(comp != null) {
			components.add(comp);
		}
	}

	public Optional<Component> getComponentAt(final int index) {
		if(index < 0 || index >= components.size()) return Optional.empty();
		return Optional.of(components.get(index));
	}
}
