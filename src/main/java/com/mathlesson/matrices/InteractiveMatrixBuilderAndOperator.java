package com.mathlesson.matrices;

import java.util.Scanner;

public class InteractiveMatrixBuilderAndOperator {

    private static final String CURSOR = ">> ";

    public static void runInterpreter() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("No matrices exist. You can add up to two.");
        System.out.println("Choices:");
        System.out.println("\t1. Add first matrix in operation order");
        System.out.println("\t2. Add second matrix in operation order");
        System.out.println("\t3. Set Number type of matrices (default is Integer)");
        System.out.println();
        System.out.print(CURSOR);

        int choice = scanner.nextInt();

        if (choice == 1) {

            BinaryMatrixOperationEquationHandler<Integer>
                bmoeh = new BinaryMatrixOperationEquationHandler<>();

            System.out.println("Add the first comma-separated row.");
            System.out.println("Subsequent rows must be the same length.");
            System.out.println();
            System.out.println(CURSOR);

        }
    }
}
