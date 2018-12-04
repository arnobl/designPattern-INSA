package imperativeEx

interface GameBuilder {
    fun build() : Game
}

class NewGameBuilder(val p1Name: String, val p2Name: String): GameBuilder {
    override fun build(): Game {
        return Game(Player(p1Name), Player(p2Name))
    }
}

class LoadGameBuilder(val file: String): GameBuilder {
    override fun build(): Game {
        //***
        // Load file and transform its content as a Game instance
        val p1Name: String = "p1"
        val p2Name: String = "p2"
        //***

        return Game(Player(p1Name), Player(p2Name))
    }
}


object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val builder: GameBuilder = NewGameBuilder("foo1", "foo2")
        val game: Game = builder.build()
    }
}