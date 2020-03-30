package experience.adventofcode;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author dje
 * Program Alarm
 */
public class Day2b {

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {

        //read from txt-file, add coma-separated in array
        int[] memory = getOperators();
        int[] sourceMemory = getOperators();
        //memory[1] = 12;
        //memory[2] = 2;



        int pos = 0;

        for (int j = 0; j < 100; j++) {
            memory[1] = j;
            for (int k = 0; k < 100; k++) {
                memory[2] = k;

                operate(memory);
                memory = sourceMemory;
                for (int i = 0; i < memory.length; i++) {

                    if (memory[i] == 19690720) {
                        System.out.println("pos: " + i);
                    }
                    else System.out.println("something! j = " + j+" k= " + k);
//            System.out.println("#"+i+" ( "+ memory[i] + " / was "+ sourceMemory[i]+" )" );

                }

            }
        }
    }

    /**
     * read the values in pos 0, 1, 2, 3 containing operator, valueAposition, valueBposition, targetPosition
     * get values of input positions and operate with it
     * @param instructionsArray
     */
    private static void operate(@NotNull int[] instructionsArray) {
        // | operation | position of A | position of B | target position | ...
        //starting at adress  0
        int [] resetMemory = instructionsArray;

        int adressInstructionPointer = 0;

        // position defines the position of the operator

        while (adressInstructionPointer < instructionsArray.length - 4) {

            int adressArrayNoun = adressInstructionPointer + 1;
            int adressArrayVerb = adressArrayNoun + 1;
            int adressArrayTarget = adressArrayVerb + 1;

            int posNoun = instructionsArray[adressArrayNoun];
            int posVerb = instructionsArray[adressArrayVerb];
            int posTarget = instructionsArray[adressArrayTarget];

            int noun = instructionsArray[posNoun];
            int verb = instructionsArray[posVerb];
            int target = posTarget;
            int operation = instructionsArray[adressInstructionPointer];

            if (operation == 1) {

                //System.out.println("adding " + noun + " + " + verb + " = " + noun+verb + " to pos " + target);
                instructionsArray[target] = noun + verb; //works
                adressInstructionPointer = adressInstructionPointer + 4;

            } else if (operation == 2) {

                //System.out.println("multiply " + noun + " * " + verb + " = " + noun*verb + " to pos " + target);
                instructionsArray[target] = noun * verb;
                adressInstructionPointer = adressInstructionPointer + 4;

            } else if (operation == 99) {
                return;
                //System.out.println(operation + " halts the system; " + target + " is target; " + noun + " and " + verb + " are operators");
                //adressInstructionPointer = adressInstructionPointer + 1;

            }
        }
    }

    /**
     * fetch all operators from my csv-file, add into an array
     *
     * @return operators as int-array
     * @throws IOException
     */
    private static int[] getOperators() throws IOException {
        String csvFile = "com/experience/adventofcode/part2b-input.csv";
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
