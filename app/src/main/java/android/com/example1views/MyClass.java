package android.com.example1views;

public class MyClass {

    static MyClass myClass;

    private MyClass() {

    }

    public static MyClass getInstance() {
        if (myClass == null)
            myClass = new MyClass();
        return myClass;
    }

}
