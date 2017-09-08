package insa.memento.basic;

public class Main {
	public static void main(final String[] args) {
		final AClass aclass = new AClass(10);
		System.out.println(aclass);
		final Memento memento = aclass.getState();
		Keeper.INSTANCE.addMemento(memento);

		aclass.setValue(20);
		System.out.println(aclass);

		aclass.setState(Keeper.INSTANCE.getMemento(aclass).orElse(null));
		System.out.println(aclass);
	}
}
