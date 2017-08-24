package insa.singleton

object SingletonScalaMain {
	def main(args: Array[String]) {
		MyScalaExceptionCollector.add(new Exception())
	}
}
