package com.rainer.pawel.project.adapters.inbound.utils;

import java.util.Scanner;
import java.util.UUID;

public class ConsoleUtils {

    private static final Scanner scanner = new Scanner(System.in);

    public static String readLine() {
        return scanner.nextLine();
    }

    public static int readNumber() {
        return scanner.nextInt();
    }

    public static UUID readUUID() {
        return UUID.fromString(readLine());
    }

    public static void println() {
        System.out.println();
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void println(Object o) {
        System.out.println(o);
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void error(String s) {
        System.err.println(s);
    }
}
