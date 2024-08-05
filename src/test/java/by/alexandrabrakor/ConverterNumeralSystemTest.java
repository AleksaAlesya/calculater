package by.alexandrabrakor;

import org.junit.jupiter.api.*;

import static by.alexandrabrakor.ConverterNumeralSystem.convertForNumeralSystem;
import static by.alexandrabrakor.InfixToPostfix.convert;
import static org.junit.jupiter.api.Assertions.*;

class ConverterNumeralSystemTest {

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
    void convertForNumeralSystemFor2NSTest() {
        String mathInfix = "1_1010*101/(100+1)";
        String mathElement = "1010";
        Assertions.assertEquals("10",convertForNumeralSystem(mathInfix,mathElement));
    }

    @DisplayName("Тест конвертации из инфиксной в постфиксную запись для восьмеричнокй системы счисления ")
    @Test
    void convertForNumeralSystemFor8NSTest() {
        String mathInfix = "7_12*5/(4+1)";
        String mathElement = "12";
        Assertions.assertEquals("10",convertForNumeralSystem(mathInfix,mathElement));

    }
}