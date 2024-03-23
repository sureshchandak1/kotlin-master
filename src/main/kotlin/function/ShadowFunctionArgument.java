package function;

public class ShadowFunctionArgument {

    public static void main(String[] args) {
        String str = "Suresh";
        System.out.println(str);
        printValue(str);
        System.out.println(str);
    }

    private static void printValue(String str) {
        str = "Ramesh";
        System.out.println(str);
    }

}
