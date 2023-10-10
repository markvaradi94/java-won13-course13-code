package ro.fasttrackit.course13.exceptions;

import java.io.*;

public class ExceptionsMain {
    public static void main(String[] args) {
//        int[] arr = new int[3];
//        System.out.println(arr[4]);

//        try {
//            riskyMethod(new int[3]);
//            System.out.println("Hello after risky method");
//        } catch (ArrayIndexOutOfBoundsException exception) {
//            System.err.println("Could not extract element from array");
//        }

//        riskyMethod(new int[3]);

        visiblyRiskyMethod("files/input/test.txt");
        tryWithResources();

        try {
            throwMyChecked(6);
        } catch (MyCheckedException exception) {
            System.out.println(exception.getMessage());
        } catch (SecondCheckedException exception) {
            System.out.println(exception.getMessage());
            System.out.println("value received = " + exception.getMinValue());
        }

        System.out.println("Other important operation");

        throwMyUnchecked("");
    }

    public static void throwMyUnchecked(String string) {
        if (string.isEmpty()) {
            throw new MyUncheckedException("You gave me an empty string");
        }
    }

    public static void throwMyChecked(int number) throws MyCheckedException, SecondCheckedException {
        if (number > 50) {
            throw new MyCheckedException("Number is equal to %s".formatted(number));
        } else if (number < 10) {
            throw new SecondCheckedException("Number is too low", number);
        }

        System.out.println(number);
    }

    public static void riskyMethod(int[] array) {
        System.out.println(array[4]);
        System.out.println("Hello after exception ");
    }

    public static void visiblyRiskyMethod(String path) {
        try {
            FileReader reader = new FileReader(path);
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void tryWithResources() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("files/output/try-with-resources.txt"));
             BufferedReader reader = new BufferedReader(new FileReader("files/input/test.txt"))) {
            writer.write("line 1");
            writer.newLine();
            writer.write("line 2");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void tryCatchFinally() {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("files/output/try-catch-finally.txt"));
            writer.write("line 1");
            writer.newLine();
            writer.write("line 2");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Could not close");
                }
            }
        }
    }
}
