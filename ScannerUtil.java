package util;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Scanner工具类
 * 用于读取用户输入
 * @author 李朔
 */

public class ScannerUtil {

    public static Scanner scanner = new Scanner(System.in);

    /**
     * 读取一个整数
     * @return
     */
    public static int readInt() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("请输入一个整数");
            return 0;
        }
    }

    /**
     * 读取一个浮点数
     * @return
     */
    public static double readDouble() {
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("请输入一个浮点数");
            return 0.0;
        }
    }

    /**
     * 读取一行字符串
     * @return
     */
    public static String readLine() {
        try {
            return scanner.nextLine();
        } catch (Exception e) {
            System.out.println("发生了错误：" + e.getMessage());
            return "";
        }
    }

    /**
     * 读取一个float
     * @return
     */
    public static float readFloat() {
        try {
            return scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("请输入一个float");
            return 0.0f;
        }
    }

    /**
     * 读取一个boolean
     * @return
     */
    public static boolean readBoolean() {
        try {
            return scanner.nextBoolean();
        } catch (InputMismatchException e) {
            System.out.println("请输入一个boolean");
            return false;
        }
    }

    /**
     * 排除非整数的输入的实现代码，否则一直循环输入，直到输入整数
     * 
     * @return
     */
    public static int nextInt() {
        while (!scanner.hasNextInt()) {
            System.err.println("请输入整数：");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * 获取输入的float类型的小数的方法
     * 
     * @return
     */
    public static float nextFloat() {
        while (!scanner.hasNextFloat()) {
            System.err.println("请输入小数：");
            scanner.next();
        }
        return scanner.nextFloat();
    }

    /**
     * 获取输入的double类型的小数的方法
     * 
     * @return
     */
    public static double nextDouble() {
        while (!scanner.hasNextDouble()) {
            System.err.println("请输入小数：");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    /**
     * 获取输入的boolean类型数值的方法
     * 
     * @return
     */
    public static boolean nextBoolean() {
        while (!scanner.hasNextDouble()) {
            System.err.println("请输入布尔类型数值：");
            scanner.next();
        }
        return scanner.nextBoolean();
    }

    public static String next() {
        return scanner.next();
    }

    public static String nextLine() {
        return scanner.nextLine();
    }

    /**
     * 关闭Scanner对象的方法
     */
    public static void scannerClose() {
        scanner.close();
    }
}
