package experience.adventofcode;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day3 {

    //the place to store all values
    private static ArrayList<Integer> xCoordinatesFirst = new ArrayList<>();
    private static ArrayList<Integer> yCoordinatesFirst = new ArrayList<>();
    private static ArrayList<Integer> xCoordinatesSec = new ArrayList<>();
    private static ArrayList<Integer> yCoordinatesSec = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        ArrayList<String> input = getAllMovements();

        int rowNum = 0;
        //first coordinates to variable
        getCoordinates(input, rowNum, xCoordinatesFirst, yCoordinatesFirst);

        //second coordinates
        rowNum++;
        getCoordinates(input, rowNum, xCoordinatesSec, yCoordinatesSec);

        //find crossing coordinates
        for (int i = 0; i < xCoordinatesFirst.size() - 1; i++) {
            //find intersection between first...
            int startOneX = xCoordinatesFirst.get(i);
            int endOneX = xCoordinatesFirst.get(i + 1);
            int startOneY = yCoordinatesFirst.get(i);
            int endOneY = yCoordinatesFirst.get(i + 1);

            //... and sec
            if (startOneX != endOneX || startOneY != endOneY) {
                System.out.println("Debug: Start zweite Zeichnung " + i);
                if (startOneX != endOneX) System.out.println("mit x : " + startOneX + " nach " + endOneX);
                if (startOneY != endOneY) System.out.println("mit y : " + startOneY + " nach " + endOneY);

                for (int j = 0; j < xCoordinatesSec.size() - 1; j++) {
                    int startTwoX = xCoordinatesSec.get(j);
                    int endTwoX = xCoordinatesSec.get(j + 1);
                    int startTwoY = yCoordinatesSec.get(j);
                    int endTwoY = yCoordinatesSec.get(j + 1);

                    //check if line between coordinates is crossed by other line between coordinates
                    //moving x-direction
                    if (startOneY == endOneY) {
                        int oneY = startOneY;
                        int oneX;

                    }
                    //moving y-direction
                    if (startOneY != endOneY) {

                    }

                /*  if(startOneX!=endOneX) {
                    System.out.println(i + " " + j);
                    System.out.println("ONE Moving in x ");
                    System.out.println("X: " + startOneX + ", " + endOneX + " | " + startTwoX + ", " + endTwoX);
                    System.out.println("Y: " + startOneY + ", " + endOneY + " | " + startTwoY + ", " + endTwoY);
                }
                if(startOneY!=endOneY) {
                    System.out.println(i + " " + j);
                    System.out.println("ONE Moving in y ");
                    System.out.println("X: " + startOneX + ", " + endOneX + " | " + startTwoX + ", " + endTwoX);
                    System.out.println("Y: " + startOneY + ", " + endOneY + " | " + startTwoY + ", " + endTwoY);
                }
                /*
                if(startTwoX!=endTwoX) {
                    System.out.println(i + " " + j);
                    System.out.println("TWO Moving in x ");
                    System.out.println("X: " + startOneX + ", " + endOneX + " | " + startTwoX + ", " + endTwoX);
                    System.out.println("Y: " + startOneY + ", " + endOneY + " | " + startTwoY + ", " + endTwoY);
                }
                if(startTwoY!=endTwoY) {
                    System.out.println(i + " " + j);
                    System.out.println("TWO Moving in y ");
                    System.out.println("X: " + startOneX + ", " + endOneX + " | " + startTwoX + ", " + endTwoX);
                    System.out.println("Y: " + startOneY + ", " + endOneY + " | " + startTwoY + ", " + endTwoY);
                }
                else {
                    System.out.println(" - - - no movement  - - -  ");

                }*/
                }

/*              //Line2D Playground
                Line2D line1 = new Line2D();
                line1.setLine(startOneX, startOneY, endOneX, endOneY);

                Line2D line2 = new Line2D();
                line2.setLine(startTwoX, startTwoY, endTwoX, endTwoY);

                if(line2.intersectsLine(line1)) {
                    System.out.println("intersection in i = " + i + " j = "+ j);
                    Point2D intersectionPoint = new Point2D();

                }*/
            }
        }


        System.out.println("xcoord" + xCoordinatesFirst);
        System.out.println("ycoord" + yCoordinatesFirst);
        System.out.println("second" + xCoordinatesSec);
        System.out.println("second" + yCoordinatesSec);


    }

    private static void getCoordinates(ArrayList<String> input, int rowNum, ArrayList<Integer> xCoordinates, ArrayList<Integer> yCoordinates) {
        //coordinates helpers
        int x = 0;
        int y = 0;
        xCoordinates.add(x);
        yCoordinates.add(y);
        //split row
        String[] operatorsRow = input.get(rowNum).split(",");
        //operate
        for (String o : operatorsRow) {

            //check first letter and calculate position
            switch (o.charAt(0)) {
                case 'R':
                    x += Integer.parseInt(o.substring(1));
                    break;
                case 'L':
                    x -= Integer.parseInt(o.substring(1));
                    break;
                case 'U':
                    y += Integer.parseInt(o.substring(1));
                    break;
                case 'D':
                    y -= Integer.parseInt(o.substring(1));
                    break;
                default:
                    System.out.println(" fubar ");
            }

            xCoordinates.add(x);
            yCoordinates.add(y);
        }
    }

    @NotNull
    private static ArrayList<String> getAllMovements() throws IOException {
        String filepath = "com/experience/adventofcode/part3_input.csv";
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String thisLine = null;
        ArrayList<String> input = new ArrayList<String>();
        while ((thisLine = br.readLine()) != null) {
            input.add(thisLine);
        }
        return input;
    }


}