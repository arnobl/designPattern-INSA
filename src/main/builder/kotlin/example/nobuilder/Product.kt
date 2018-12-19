package example.nobuilder

import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths

class Product {
    val myattribute = ArrayList<String>()

    /**
     * Building the object from a file
     * Problem: how to know that this constructor is doing that? Not clear:
     * unnamed constructor; must pore over the doc and the parameter's name
     */
    constructor(filepath: String) {
        myattribute.addAll(Files.readString(Paths.get(filepath), Charset.forName("utf8")).split(";"))
        // Should call the second constructor by giving the array of strings, but this is an example
    }

    /*
    /**
     * Building the object from data provided by a server
     */
    constructor(httpAdress: String) {
        // Oops. Not possible (does not compile): this constructor has the same prototype than the previous one. Must
        // use a factory or a builder to overcome this problem
        //etc.
    }
    */

    /**
     * Building the object from given data
     */
    constructor(values: List<String>) {
        myattribute.addAll(values)
    }

    /*
    etc.
    Can imagine more constructors.
    Constructors are OK. Should use it in many cases.
    In specific cases (see the hard-copy of the class) builders are preferable.
     */
}
