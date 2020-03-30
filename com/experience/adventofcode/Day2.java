package experience.adventofcode;

import org.jetbrains.annotations.NotNull;

import java.io.*;

/**
 * @author dje
 * Program Alarm
 */
public class Day2 {

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {

        //read from txt-file, add coma-separated in array
        int[] operationsArray = getOperators();
        int[] origArray = operationsArray.clone();
        //int[] origArray = getOperators();
        operationsArray[1] = 12;
        operationsArray[2] = 2;

        operate(operationsArray);
//operationsArray.length
        for (int i = 0; i < operationsArray.length; i ++) {
            System.out.println("#"+i+" ( "+ operationsArray[i] + " / was "+ origArray[i]+" )" );
        }
    }

    /**
     * read the values in pos 0, 1, 2, 3 containing operator, valueAposition, valueBposition, targetPosition
     * get values of input positions and operate with it
     * @param operationsArray
     */
    private static void operate(@NotNull int[] operationsArray) {
        // | operation | position of A | position of B | target position | ...
        //starting at position 0
        int posArrayOperation = 0;

        // position defines the position of the operator

        while (posArrayOperation < operationsArray.length - 4) {


            int posArraySourceA = posArrayOperation + 1;
            int posArraySourceB = posArraySourceA + 1;
            int posArrayTarget = posArraySourceB + 1;

            int posA = operationsArray[posArraySourceA];
            int posB = operationsArray[posArraySourceB];
            int posTarget = operationsArray[posArrayTarget];

            int a = operationsArray[posA];
            int b = operationsArray[posB];
            int target = posTarget;     //operationsArray[posTarget]; //attention!!!!!
            int operation = operationsArray[posArrayOperation];


            if (operation == 1) {

                //System.out.println("adding " + a + " + " + b + " to pos " + target);
                operationsArray[target] = a + b; //works
                posArrayOperation = posArrayOperation + 4;

            } else if (operation == 2) {

                //System.out.println("multiply " + a + " * " + b + " to pos " + target);
                operationsArray[target] = a * b;
                posArrayOperation = posArrayOperation + 4;

            } else if (operation == 99) {

                System.out.println(operation + " halts the system; " + target +" is target; " + a +" and "+b+" are operators");
               // posArrayOperation = posArrayOperation + 1;
                //falsche position
                return;
            }
        }
    }

    /**
     * fetch all operators from my csv-file, add into an array
     *
     * @return operators as int-array
     * @throws IOException
     */
    private static int[]
    getOperators() throws IOException {
        String csvFile = "com/experience/adventofcode/part2_input.csv";
        String separator = ",";
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        String allOperations = br.readLine();
        String[] operationString = allOperations.split(separator);
        int inputLength = operationString.length;
        int[] operationsArray = new int[inputLength];

        for (int i = 0; i < inputLength; i++) {
            operationsArray[i] = Integer.parseInt(operationString[i]);
        }

        return operationsArray;
    }
}
