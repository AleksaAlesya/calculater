package by.alexandrabrakor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
//        File file = new File("D:/java_code/calculaterGit/src/calculation.txt");
//        String path = file.getAbsolutePath();
//        System.out.println(file.getName());
//        System.out.println(path);
//        try {
//            FileInputStream fis = new FileInputStream(file);
//            System.out.println(fis);
//
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        try {

            String string = Files.readString(Path.of("src/calculation.txt"));
            System.out.println(string);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
