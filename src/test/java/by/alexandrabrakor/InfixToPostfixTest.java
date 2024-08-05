package by.alexandrabrakor;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.alexandrabrakor.InfixToPostfix.*;
import static org.junit.jupiter.api.Assertions.*;

class InfixToPostfixTest {


    @BeforeAll
    public static void setUpAll(){
        System.out.println("Начало тестов");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Конец тестов");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Тест start");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Тест finish");
    }




    @DisplayName("Тест конвертации из инфиксной в постфиксную запись для двоичной системы счисления ")
    @Test
    void convertTestFor2NumeralSystem() {
        String mathInfix = "1_1010*101/(100+1)";
        Assertions.assertEquals("1 10 5 * 4 1 + / ",convert(mathInfix));
    }


    @DisplayName("Тест конвертации из инфиксной в постфиксную запись для  восьмеричной системы счисления ")
    @Test
    void convertTestFor8NumeralSystem() {
        String mathInfix = "7_12*5/(4+1)";
        Assertions.assertEquals("7 10 5 * 4 1 + / ",convert(mathInfix));
    }
//
//
    @DisplayName("Тест конвертации из инфиксной в постфиксную запись для шестнадцатиричной системы счисления ")
    @Test
    void convertTestFor16NumeralSystem() {
           String mathInfix = "f_-A*5/(4+1)";
           String mathInfix2 = "f_A*5/(4+1)";

        Assertions.assertEquals("-10 5 * 4 1 + / ",convert(mathInfix));
        Assertions.assertEquals("10 5 * 4 1 + / ",convert(mathInfix2));
    }

    @DisplayName("Тест конвертации из инфиксной в постфиксную запись для десятеричной системы счисления ")
    @Test
    void convertTestFor10NumeralSystem() {
        String mathInfix = "9_-10*5/(4+1)";
        String mathInfix2 = "9_10*5/(4+1)";

        Assertions.assertEquals("9 -10 5 * 4 1 + / ", convert(mathInfix));
        Assertions.assertEquals("9 10 5 * 4 1 + / ", convert(mathInfix2));

    }

    @DisplayName("Тест есть ли в строке  число для разн. систем счисления, соответствующеее РВ ")
    @Test
    void isNumericTest() {
        String string = "1_1010*101/(100+1)";
        String string1 = "1_10A0*0.25*(-101)/(100,55+1F)"; // отрицательные, дробные, целые, положительные? ,буквы от A до F, точка или запятая для десятичной
        String string2 = "P";

        Assertions.assertTrue(isNumeric(string));
        Assertions.assertTrue(isNumeric(string1));
        Assertions.assertFalse(isNumeric(string2));
    }





}