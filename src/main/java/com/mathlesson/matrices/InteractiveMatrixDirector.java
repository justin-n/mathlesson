package com.mathlesson.matrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveMatrixDirector {

    private static final String CURSOR = ">> ";

    public static void runInterpreter() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("No matrices exist. You can add up to two.");
        System.out.println("Choices:");
        System.out.println("\t1. Add first matrix in operation order");
        System.out.println("\t2. Add second matrix in operation order");
        System.out.println("\t3. Set Number type of matrices (default is Integer)");
        System.out.println();
        System.out.print(CURSOR);

        String choiceLine = br.readLine();

        int choice = Integer.parseInt(choiceLine);

        if (choice == 1 || choice == 2) {

            BinaryMatrixOperationEquationHandler<Integer>
                bmoeh = new BinaryMatrixOperationEquationHandler<>();

            System.out.println("Add a comma-separated row.");
            System.out.println("Subsequent rows must be the same length.");
            System.out.println();
            System.out.print(CURSOR);

            String commaSeparatedRow = br.readLine();

            System.out.println(commaSeparatedRow);

        }
    }
}
