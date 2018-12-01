package com.mathlesson.matrices;

import com.mathlesson.util.InputValidationUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InteractiveMatrixDirector {

    private static final String CURSOR = ">> ";

    public static void runSimpleMenuInterpreter() {

        BufferedReader br = getSystemInputBufferedReader();

        BinaryMatrixOperationEquationHandler
            bmoeh = new BinaryMatrixOperationEquationHandler();

        int mainMenuChoice = 0;

        try {
            while (mainMenuChoice != 7) {
                System.out.println();
                System.out.println("\t1. Add row to first matrix in operation order");
                System.out.println("\t2. Add row to second matrix in operation order");
                System.out.println("\t3. View first matrix in operation order");
                System.out.println("\t4. View second matrix in operation order");
                System.out.println("\t5. View both matrix operands");
                System.out.println("\t6. View Sum of both matrices");
                System.out.println("\t7. Exit");
                System.out.println();
                System.out.print(CURSOR);

                String mainMenuChoiceLine = br.readLine();

                while (!InputValidationUtil.validateMenuChoiceInput(mainMenuChoiceLine)) {
                    System.out.println();
                    System.out.print(CURSOR);
                    mainMenuChoiceLine = br.readLine();
                }

                mainMenuChoice = Integer.parseInt(mainMenuChoiceLine);

                if (mainMenuChoice == 1) {
                    addRowToMatrix(br, bmoeh.getFirstMatrix());
                }
                else if (mainMenuChoice == 2) {
                    addRowToMatrix(br, bmoeh.getSecondMatrix());
                }
                else if (mainMenuChoice == 3) {
                    System.out.println("First matrix in operation order: ");
                    System.out.println(bmoeh.getFirstMatrix());
                }
                else if (mainMenuChoice == 4) {
                    System.out.println("Second matrix in operation order: ");
                    System.out.println(bmoeh.getSecondMatrix());
                }
                else if (mainMenuChoice == 5) {
                    bmoeh.printOperands();
                }
                else if (mainMenuChoice == 6) {
                    System.out.println(bmoeh.addOperands());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedReader getSystemInputBufferedReader() {

        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return br;
    }

    private static void addRowToMatrix(BufferedReader br, Matrix matrix) throws IOException {
        System.out.println("Add a comma-separated row.");
        System.out.println("Subsequent rows must be the same length.");
        System.out.println();
        System.out.print(CURSOR);

        String commaSeparatedRow = br.readLine();

        while (!InputValidationUtil.validateCommaSeparatedRowInput(commaSeparatedRow)) {
            System.out.println();
            System.out.print(CURSOR);
            commaSeparatedRow = br.readLine();
        }

        String commaSepRowNoWhiteSpace = commaSeparatedRow.replaceAll("\\s", "");

        List<Integer> rowInts = Arrays.stream(commaSepRowNoWhiteSpace.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        matrix.insertRow(rowInts);
    }

}
