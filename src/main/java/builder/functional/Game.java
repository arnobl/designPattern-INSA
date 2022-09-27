package builder.functional;


// Example of a functional builder

class Main {
	public static void main(String[] args) {
		final Game game = new NewGameBuilder()
			.setName("the game")
			.setNameP1("player 1")
			.build();
	}
}


record Player(String name) { }

class Game {
	private final String name;
	private final Player p1;
	private final Player p2;

	public Game(final String name, final Player p1, final Player p2) {
		this.name = name;
		this.p1 = p1;
		this.p2 = p2;
	}
}

abstract class GameBuilder {
	protected String name = "Game";

	public GameBuilder setName(final String name) {
		this.name = name;
		return this;
	}

	public abstract Game build();
}

class LoadGameBuilder extends GameBuilder {
	private final String fileName;

	LoadGameBuilder(final String fileName) {
		this.fileName = fileName;
	}

	@Override
	public LoadGameBuilder setName(final String name) {
		// berk
		return (LoadGameBuilder) super.setName(name);
	}

	@Override
	public Game build() {
		Player p1 = null;
		Player p2 = null;
		// Load the file using the filename
		// ...
		return new Game(name, p1, p2);
	}
}

class NewGameBuilder extends GameBuilder {
	private String nameP1 = "p1";
	private String nameP2 = "p2";

	public NewGameBuilder setNameP1(final String nameP1) {
		this.nameP1 = nameP1;
		return this;
	}

	public NewGameBuilder setNameP2(final String nameP2) {
		this.nameP2 = nameP2;
		return this;
	}

	@Override
	public NewGameBuilder setName(final String name) {
		// berk
		return (NewGameBuilder) super.setName(name);
	}

	@Override
	public Game build() {
		return new Game(name, new Player(nameP1), new Player(nameP2));
	}
}
