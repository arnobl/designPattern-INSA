package imperativeEx

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val builder: GameBuilder = NewGameBuilder("foo1", "foo2")
        val game: Game = builder.build()
    }
}
