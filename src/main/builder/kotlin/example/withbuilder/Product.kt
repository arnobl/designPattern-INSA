package example.withbuilder

class Product {
    val myattribute = ArrayList<String>()

    fun addData(data: List<String>) {
        myattribute.addAll(data)
    }
}