class Foo {
    private Lazy<MyObject> bar = new Lazy<MyObject>();

    public MyObject getBar() {
        return bar.Value; 
    }
}

public class MyObject:Object {
    public MyObject() {
        Console.WriteLine("Creating Object"); 
    }
}