package memento.basic;

public class AClass implements Mutable<AClass.AClassMemento> {
	private int value;

	public AClass(final int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(final int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "AClass{" + "value=" + value + '}';
	}

	@Override
	public AClassMemento getState() {
		return new AClassMemento();
	}

	// In this example, a memento can only be applied on the object that created it.
	// We can imagine mementos that can be applied to any object of the same type.
	class AClassMemento implements memento.basic.Memento {
		private final int valueMemento;

		AClassMemento() {
			super();
			valueMemento = AClass.this.value;
		}

		@Override
		public void applyMemento() {
			AClass.this.value = valueMemento;
		}

		@Override
		public Object getObject() {
			return AClass.this;
		}
	}
}
