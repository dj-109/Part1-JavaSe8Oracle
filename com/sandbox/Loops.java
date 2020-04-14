package sandbox;

public class Loops {

    public static void main(String[] args) {

        System.out.println("For-Loop");
        System.out.println();//new line

        for (int i = 0; i < 5; ) {
            i++;
            i += 1;
            i = i + 1;
            //i++ === i=i+1
            //++i === i=i+1
            System.out.println(i);
            System.out.println("Hallo Leute");
        }

    }
}
