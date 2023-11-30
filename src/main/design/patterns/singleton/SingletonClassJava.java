package singleton;

/*
*  Singleton is a creational design pattern
*  that lets you ensure that a class has only one instance,
*  while providing a global access point to this instance.
* */
public class SingletonClassJava {

    private static SingletonClassJava instance = null;

    private SingletonClassJava() {  }

    public static SingletonClassJava getInstance() {
        if (instance == null) {
            synchronized (SingletonClassJava.class) {
                if (instance == null) {
                    instance = new SingletonClassJava();
                }
            }
        }
        return instance;
    }

    public void print(String message) {
        System.out.println(message);
    }
}



