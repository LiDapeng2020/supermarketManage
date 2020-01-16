package com.supermarket.utils;

public class PrintUtil {
    public static void greenPrint(Object object) {
        System.out.println("\033[32m" + object + "\033[0m");
    }
    public static void printSplitLine(){
        System.out.println("\033[31m------------------------------------------------\033[0m");
    }
}
