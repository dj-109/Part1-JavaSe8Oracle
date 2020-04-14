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
        int[] memory = Day2.getOperators();
        int[] sourceMemory = memory.clone();

        for (int j = 0; j < 100; j++) {

            for (int k = 0; k < 100; k++) {
                memory = sourceMemory.clone();

                memory[1] = j;
                memory[2] = k;
                Day2.operate(memory);

                if (memory[0] == 19690720) {
                    System.out.println("congrats: " + 100 * j + k);
                    return;
                }
            }
        }
    }
}