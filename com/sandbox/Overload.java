package sandbox;

public class Overload {
    public static void main(String[] args) {
        machwat();
        System.out.println("#########");
        machwat(666);
        machwat(7, "hier kommt die: ");
    }

    static void machwat() {
        System.out.println("macht wat");
        machwat(6);
    }

    static void machwat(int a) {
        System.out.println("macht wat und hat einen wert: " + a);
    }

    static void machwat(int a, String b) {
        System.out.println(b + a);
    }
}
