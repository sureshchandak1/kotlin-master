package companionObject;

public class Companion {
    public static void main(String[] args) {
        MyClass.MyObject.print();
        MyClass.print();
        MyClass.AnotherObject.INSTANCE.print();
    }
}
