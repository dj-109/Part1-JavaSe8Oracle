package sandbox;

public class Sandbox {

    static String classname;
    public static void main(String[] args) {

        System.out.println("classname: "+ classname);
    }

    public static void setClassname(String classname) {
        Sandbox.classname = classname;
    }
}
