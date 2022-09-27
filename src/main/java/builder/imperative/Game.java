package builder.imperative;

// Example of an imperative builder

class Main {
	public static void main(String[] args) {
		final GameBuilder builder = new LoadGameBuilder("filename.json");
		foo(builder);
	}

	static void foo(final GameBuilder builder) {
		// This method does not know the real builder
		// This can be viewed as an anonymous constructor.
		final Game build = builder.build();
	}
}


record Player(String name) {
}

class Game {
	private final Player p1;
	private final Player p2;

	public Game(final Player p1, final Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
}

interface GameBuilder {
	Game build();
}

class LoadGameBuilder implements GameBuilder {
	private final String fileName;

	LoadGameBuilder(final String fileName) {
		this.fileName = fileName;
	}

	@Override
	public Game build() {
		Player p1 = null;
		Player p2 = null;
		// Load the file using the filename
		// ...
		return new Game(p1, p2);
	}
}

class NewGameBuilder implements GameBuilder {
	private final String nameP1;
	private final String nameP2;

	NewGameBuilder(final String nameP1, final String nameP2) {
		this.nameP1 = nameP1;
		this.nameP2 = nameP2;
	}

	@Override
	public Game build() {
		// Not very useful but this is an example
		return new Game(new Player(nameP1), new Player(nameP2));
	}
}
