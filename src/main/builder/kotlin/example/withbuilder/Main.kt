package example.withbuilder

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        // Delegating the build of Product objects to dedicated builder
        doBuild(ProductBuilderFile("file.txt"))

        doBuild(ProductBuilderServer("localhost:4444/foo/bar"))
    }

    fun doBuild(builder: ProductBuilder) {
        // The constructor is hidden from the developers
        // (similarly than with abstract factory, factory)
        // The motto is: Here, I do not care about how the object is going to be built, I just want it
        val product = builder.build()

        // Doing stuffs with the product
    }
}
