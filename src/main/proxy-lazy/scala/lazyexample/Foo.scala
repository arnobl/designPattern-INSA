package insa.proxy.lazyexample

class Foo {
	private lazy val bar: Object = {
		println("Creating Bar")
		new Object()
	}

	def getBar: Object = bar
}
