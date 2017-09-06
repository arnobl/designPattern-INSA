package insa.proxy.lazyexample

object Main {
	def main(args: Array[String]) {
		println("Creating a Foo")
		val foo = new Foo
		println("Getting its bar")
		foo.getBar
	}
}
