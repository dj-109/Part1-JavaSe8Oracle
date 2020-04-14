package sandbox;

public class Sandbox {

    static String classname;
    public static void main(String[] args) {

        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};
        String hallo = "hallo";
        String auch = "auch";
        System.out.println(a + " " + b);
        a = b;
        System.out.println(a + " " + b);

        System.out.println(hallo + " " + auch);
        auch = hallo;
        System.out.println(hallo + " " + auch);
        //     hashMap
    }

    public static void setClassname(String classname) {
        Sandbox.classname = classname;
    }
}
