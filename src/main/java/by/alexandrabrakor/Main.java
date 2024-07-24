package by.alexandrabrakor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

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
            Path pathFile =Path.of("src/calculation.txt");

            String stringMathOut = Files.readString(pathFile);
            String resultIn =MathParse.calculation(stringMathOut).toString();
            Files.writeString(pathFile,   "=" + resultIn, StandardOpenOption.APPEND);

            System.out.println(stringMathOut);
            System.out.println(InfixToPostfix.convert(stringMathOut) + " = " + resultIn);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
