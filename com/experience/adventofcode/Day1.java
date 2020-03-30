package experience.adventofcode;


import java.io.File;
import java.util.Scanner;

/**
 * @author dje
 * adventofcode.com/2019/day/1/
 */
public class Day1 {

    private static int divider = 3;
    private static int substractor = 2;

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //initial fuel requirement
        int requiredFuel = 0;
        File file = new File("com/experience/adventofcode/Part1-JavaSe8Oracle.txt");
        Scanner rawFile = new Scanner(file);
//        int testcounter = 0; //testvalue
        while (rawFile.hasNext()) {
            int element;
            element = rawFile.nextInt();
//            element = 100756; //testvalue
            int fuelMass = getFuelMass(element);
//            System.out.println(fuelMass); //only for debug
            requiredFuel+=fuelMass;

//            testcounter++;          //testvalue
        }
//        System.out.println("\nrequired testfuel: " + requiredFuel/testcounter);//testoutput
        System.out.println("\nrequired fuel: " + requiredFuel);
        rawFile.close();
    }

    /**
     * to retrieve the complete fuelmass for a given mass including the fuel needed to carry the fuel
     * @param mass
     * @return
     */
    private static int getFuelMass(int mass) {
        int origmass = mass;
        int extraRequiredFuel = mass;
        while (fuelCalculator(extraRequiredFuel)>0) {
            extraRequiredFuel = fuelCalculator(extraRequiredFuel);
            mass = mass+extraRequiredFuel;
        }
        return mass-origmass;
    }

    /**
     * to calculate the required fuel you need to define the divider and the substractor
     * @param mass
     * @return required fuel for the given mass
     */
    public static int fuelCalculator(int mass) {
        return mass/divider-substractor;
    }

}