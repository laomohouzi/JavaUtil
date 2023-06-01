package util;

import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Scanner工具类
 * 用于读取用户输入
 * @author 李朔
 */

public class PrintUtil {

    /**
     * 定义一个控制台对象
     */
    private static Console console = System.console();

    /**
     * 定义不同的打印级别
     */
    public static final int DEBUG = 0;
    public static final int INFO = 1;
    public static final int WARN = 2;
    public static final int ERROR = 3;

    /**
     * 定义一个打印开关，可以根据需要修改
     */
    private static boolean printEnabled = true;

    /**
     * 定义一个打印级别，可以根据需要修改
     */
    private static int printLevel = DEBUG;

    /**
     * 定义一个文件对象，用来保存打印信息
     */
    private static File file = new File("print.log");

    /**
     * 定义一个线程池对象，用来异步处理打印任务
     */
    private static ExecutorService executor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), new ThreadPoolExecutor.DiscardPolicy());


    /**
     * 定义一个打印方法，根据不同的级别输出不同的颜色或者格式，并且将打印信息保存到文件中
     * @param message
     * @param level
     */
    public static void print(String message, int level) {
        if (printEnabled && level >= printLevel) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                        switch (level) {
                            case DEBUG:
                                console.writer().println("[DEBUG] " + message);
                                writer.write("[DEBUG] " + message + "\n");
                                break;
                            case INFO:
                                console.writer().println("[INFO] " + message);
                                writer.write("[INFO] " + message + "\n");
                                break;
                            case WARN:
                                console.writer().println("\u001B[33m[WARN] " + message + "\u001B[0m");
                                writer.write("[WARN] " + message + "\n");
                                break;
                            case ERROR:
                                console.writer().println("\u001B[31m[ERROR] " + message + "\u001B[0m");
                                writer.write("[ERROR] " + message + "\n");
                                break;
                            default:
                                console.writer().println(message);
                                writer.write(message + "\n");
                                break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * 定义一些重载的打印方法，方便使用
     * @param message
     */
    public static void print(String message) {
        print(message, INFO);
    }

    public static void println(String message, int level) {
        print(message + "\n", level);
    }

    public static void println(String message) {
        println(message, INFO);
    }

    public static void debug(String message) {
        print(message, DEBUG);
    }

    public static void info(String message) {
        print(message, INFO);
    }

    public static void warn(String message) {
        print(message, WARN);
    }

    public static void error(String message) {
        print(message, ERROR);
    }
}