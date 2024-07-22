package by.alexandrabrakor;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfixToPostfix {
    private static StringBuilder mathPostfix = new StringBuilder();
    private static List<String> operators = new LinkedList<>();
    private static Stack<String> operatordStack = new Stack<>();

    static {
        operators.add("*");
        operators.add("/");
        operators.add("-");
        operators.add("+");
        operators.add("^");
        operators.add("=");
    }

    public static String convert(String mathInfix){
        operators.clear();
        mathPostfix.setLength(0); // очистка
return "";
    }

    //получаем экземл. для сравнения регулярных выражений
    private static Matcher getMatcherMath(String mathInfix){
        //сгененрирует паттерн из строки с регуляр. выраж
        Pattern patternMath =Pattern.compile(getPatternStrings());
        //паттерн возврасчает матчер, который будет работать с той строкой,которую  передаем - инфиксное выражение
        return patternMath.matcher(mathInfix);

    }

    private static String getPatternStrings() {
        return getPatternStringNumbers() + "|" + getPatternStringOperators() +"|" + getPatternStringBrackets();

    }

    //скобки
    private static String getPatternStringBrackets() {
        return "([\\(\\)])";
    }

    //операторы
    private static String getPatternStringOperators() {
        StringBuilder sb = new StringBuilder("([");
        for (String operator : operators) {
            sb.append("\\").append(operator);

        }
        return  sb.append("])").toString();
    }


    //числа
    private static String getPatternStringNumbers() {
//        \d    любая  цифра
//         +    любое количеств
//        (  )  еще может что-то быт
//        ()?   но может и не быть
//        \.    может быть точка
//         \d   цифры после точки
//         +    любое количество
        // т.е. берем числа с плавающей точкой тоже
        return  "(\\d+((\\.\\d+)?)+)";
    }


}
