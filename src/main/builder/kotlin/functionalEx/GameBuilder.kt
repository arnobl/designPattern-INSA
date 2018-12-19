package functionalEx

interface GameBuilder {
    fun build() : Game
}

class NewGameBuilder: GameBuilder {
    // default values
    private var p1Name: String = "p1"
    private var p2Name: String = "p2"

    override fun build(): Game {
        return Game(Player(p1Name), Player(p2Name))
    }

    fun setP1Name(n: String) : NewGameBuilder {
        p1Name = n
        return this
    }

    fun setP2Name(n: String) : NewGameBuilder {
        p2Name = n
        return this
    }
}

/**
 * Cannot be in a functional style as the file name is mandatory and is
 * the single argument of the builder
 */
class LoadGameBuilber(val file: String): GameBuilder {
    override fun build(): Game {
        //***
        // Load file and transform its content as a Game instance
        val p1Name: String = "p1"
        val p2Name: String = "p2"
        //***

        return Game(Player(p1Name), Player(p2Name))
    }
}
