using System;

class Main {
    static void Main() {
        List<int> items = new List<int> { 4, 3, 1, 2 };
        Comparison<int> functionObject = (x, y) => x - y;
        items.Sort(functionObject);

        Console.write(items);
    }
}
