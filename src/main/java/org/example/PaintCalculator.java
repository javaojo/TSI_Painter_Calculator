package org.example;

import java.util.Scanner;

public class PaintCalculator {

    private static int getPositiveInt(Scanner scanner, String prompt) {

        int number;

        do {

            System.out.print(prompt);

            while (!scanner.hasNextInt()) {
                System.out.println("Enter a positive number.");
                // ask for user input again ?????????????????
                scanner.next();

            }
            //System.out.println("TESTING");

            number = scanner.nextInt();

            if (number <= 0) {
                System.out.println("Enter a positive number.");
            }
        } while (number <= 0);
        return number;
    }
    private static double getPositiveDouble(Scanner scanner, String prompt) {

        double number;

        do {

            System.out.print(prompt);

            while (!scanner.hasNextInt()) {
                System.out.print("Enter a number with no characters.");
                scanner.next();
            }

            number = scanner.nextInt();

            if (number <= 0) {
                System.out.print("Enter a positive number.");
            }
        } while (number <= 0);
        return number;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfWalls = getPositiveInt(scanner, "Enter the number of walls: ");

        // array of wall areas for each wall
        double[] wallAreas = calculateTotalArea(numberOfWalls);

        double coveragePerLiter = getPositiveDouble(scanner, "Enter the coverage of the paint (square meters per liter pls): "); // add error checking

        // add up the array of areas for a single sum
        double totalWallArea = calculateSum(wallAreas);
        double totalPaintNeeded = totalWallArea / coveragePerLiter;

        System.out.println("Total paint needed: " + totalPaintNeeded + " liters");

    }


    private static double[] calculateTotalArea(int numberOfWalls) {

        double[] areas = new double[numberOfWalls];
        Scanner scanner_2 = new Scanner(System.in);

        for (int i = 0; i < numberOfWalls; i++) {

            System.out.println("Wall " +  (i + 1) + ":");

            double width = getPositiveDouble(scanner_2, "Enter width (meters only): ");
            double height = getPositiveDouble(scanner_2, "Enter height (meters only): ");

            areas[i] = width * height;
        }

        return areas;
    }

    private static double calculateSum(double[] areas) {
        double total = 0;
        for (double area : areas) {
            total += area;
        }
        return total;
    }





}
