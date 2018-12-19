package example.withbuilder

import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths

/*
This builder has one class attribute: the path of the file to read
 */
class ProductBuilderFile(private val filePath: String) : ProductBuilder {

    override fun build(): Product {
        val product = Product()
        product.addData(Files.readString(Paths.get(filePath), Charset.forName("utf8")).split(";"))
        return product
    }
}