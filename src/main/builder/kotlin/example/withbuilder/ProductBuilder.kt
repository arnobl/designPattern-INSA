package example.withbuilder

interface ProductBuilder {
    // Can define an abstract class if you have attributes, implemented methods
    // Can be an anonymous function as well (Supplier<Product>)

    fun build(): Product
}