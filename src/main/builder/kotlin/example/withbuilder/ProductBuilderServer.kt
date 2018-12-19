package example.withbuilder

/*
This builder has one class attribute: the path of the file to read
 */
class ProductBuilderServer(private val httpAddress: String) : ProductBuilder {

    override fun build(): Product {
        val product = Product()
        // Reading data from the given http address
        // product.addData(...)
        return product
    }
}
