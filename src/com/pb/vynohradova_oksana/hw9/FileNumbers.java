package com.pb.vynohradova_oksana.hw9;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileNumbers {
    private static final Logger LOGGER = Logger.getLogger(FileNumbers.class.getName());

    public static void main(String[] args) throws IOException {
        LOGGER.setLevel(Level.ALL);
        Handler handler = new FileHandler("files\\FileNumbers.log",0,1);
        LOGGER.addHandler(handler);

        String str = createNumbersFile();
        System.out.println("Создан файл " + str);

        String sb = createOddNumbersFile(str);
        System.out.println("Создан файл " + sb);
    }

    static String createNumbersFile() {
        LOGGER.entering(FileNumbers.class.getName(), "createNumbersFile");

        StringBuilder sb = new StringBuilder();
        Random rand = new Random();

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                sb.append(rand.nextInt(100));
                if (i != 9) {
                    sb.append(" ");
                } else if (j != 9) {
                    sb.append(System.lineSeparator());
                }
            }
        }

        String fileName = "files\\numbers.txt";
        try (Writer writer = new FileWriter(fileName)){
            writer.write(sb.toString());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            System.out.println(e.getMessage());
        }

        LOGGER.exiting(FileNumbers.class.getName(), "createNumbersFile");
       return fileName;
    }

    static String createOddNumbersFile(String fileName) {
        LOGGER.entering(FileNumbers.class.getName(), "createOddNumbersFile");

        StringBuilder sb = new StringBuilder();
        Path path = Paths.get(fileName);

        try (Scanner scan = new Scanner(path)) {
            while (scan.hasNextLine()) {
                String[] str =  scan.nextLine().split(" ");
                for (int j = 0; j < str.length; j++) {
                    int x = Integer.parseInt(str[j]);
                    if (x%2 != 0) {
                        sb.append(x);
                    } else {
                        sb.append(0);
                    }

                    if (j != 9) {
                        sb.append(" ");
                    } else {
                        sb.append(System.lineSeparator());
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            System.out.println(e.getMessage());
        }

        sb.delete(sb.length() - 2,sb.length());

        try (Writer writer = new FileWriter("files\\odd-numbers.txt")){
            writer.write(sb.toString());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            System.out.println(e.getMessage());
        }

        LOGGER.exiting(FileNumbers.class.getName(), "createOddNumbersFile");
        return "files\\odd-numbers.txt";
    }
}
