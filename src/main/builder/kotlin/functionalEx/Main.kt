package functionalEx

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val builder: GameBuilder = NewGameBuilder()
                .setP1Name("p1Name")
                .setP2Name("p2Name")
        val game: Game = builder.build()
    }
}
