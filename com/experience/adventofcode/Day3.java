package experience.adventofcode;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Math.abs;

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
        int anz = 0;
        int prevManhattanDist = 999999;
        int manhattanDistance = 0;
        //find crossing coordinates
        for (int i = 0; i < xCoordinatesFirst.size() - 1; i++) {
            //find intersection between first...

            int startOneX = xCoordinatesFirst.get(i);
            int startOneY = yCoordinatesFirst.get(i);
            int endOneX = xCoordinatesFirst.get(i + 1);
            int endOneY = yCoordinatesFirst.get(i + 1);

            //... and sec
            if (startOneX != endOneX ^ startOneY != endOneY) {
                //System.out.println("Debug: Start zweite Zeichnung " + i);
                //  if (startOneX != endOneX) System.out.println("mit x : " + startOneX + " nach " + endOneX);
                //   if (startOneY != endOneY) System.out.println("mit y : " + startOneY + " nach " + endOneY);

                for (int j = 0; j < xCoordinatesSec.size() - 1; j++) {
                    int startTwoX = xCoordinatesSec.get(j);
                    int startTwoY = yCoordinatesSec.get(j);
                    int endTwoX = xCoordinatesSec.get(j + 1);
                    int endTwoY = yCoordinatesSec.get(j + 1);

                    //check if line between coordinates is crossed by other line between coordinates
                    if (i > 1 && j > 1) {
                        if (Line2D.linesIntersect(startOneX, startOneY, endOneX, endOneY, startTwoX, startTwoY, endTwoX, endTwoY)) {

                            //find intersection
                            Point pointAone = new Point();
                            Point pointBone = new Point();
                            pointAone.setLocation(startOneX, startOneY);
                            pointBone.setLocation(endOneX, endOneY);

                            Point pointAtwo = new Point();
                            Point poitBtwo = new Point();
                            pointAtwo.setLocation(startTwoX, startTwoY);
                            poitBtwo.setLocation(endTwoX, endTwoY);

                            Point intersectionPoint = lineLineIntersection(pointAone, pointBone, pointAtwo, poitBtwo);
                            //System.out.println(intersectionPoint);
                            Point foundPoint = intersectionPoint;

                            //manhattan dist from root to point
                            manhattanDistance = abs(foundPoint.x) + abs(foundPoint.y);

                            if (manhattanDistance < prevManhattanDist) {
                                prevManhattanDist = manhattanDistance;

                            }


                            //System.out.println(i + " bzw " + j);
                            anz++;
                        }
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
//                System.out.println("anz "+anz);
                System.out.println("hab einen!");
                System.out.println(manhattanDistance);
            }
        }


        System.out.println("xcoord" + xCoordinatesFirst);
        System.out.println("ycoord" + yCoordinatesFirst);
        System.out.println("xsecond" + xCoordinatesSec);
        System.out.println("ysecond" + yCoordinatesSec);


    }

    private static Point lineLineIntersection(Point A, Point B, Point C, Point D) {
        // Line AB represented as a1x + b1y = c1
        int a1 = B.y - A.y;
        int b1 = A.x - B.x;
        int c1 = a1 * (A.x) + b1 * (A.y);

        // Line CD represented as a2x + b2y = c2
        int a2 = D.y - C.y;
        int b2 = C.x - D.x;
        int c2 = a2 * (C.x) + b2 * (C.y);

        int determinant = a1 * b2 - a2 * b1;

        if (determinant == 0) {
            // The lines are parallel. This is simplified
            // by returning a pair of FLT_MAX
            return new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        } else {
            int x = (b2 * c1 - b1 * c2) / determinant;
            int y = (a1 * c2 - a2 * c1) / determinant;
            return new Point(x, y);
        }
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
        //String filepath = "com/experience/adventofcode/part3_input.csv";
        String filepath = "com/experience/adventofcode/part3Test.csv";
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String thisLine = null;
        ArrayList<String> input = new ArrayList<String>();
        while ((thisLine = br.readLine()) != null) {
            input.add(thisLine);
        }
        return input;
    }


}