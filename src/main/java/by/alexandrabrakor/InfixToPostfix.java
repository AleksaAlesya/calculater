package by.alexandrabrakor;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class InfixToPostfix {
    private static final StringBuilder mathPostfix = new StringBuilder();
    private static final LinkedList<String> operators = new LinkedList<>();
    //храним все существующие операторы
    private static final Stack<String> operatorsStack = new Stack<>(); // временно б. хранить отложенные операторы

    static {
        operators.add("*");
        operators.add("/");
        operators.add("-");
        operators.add("+");
        operators.add("^");

    }

    public static String convert(String mathInfix) {
        operators.clear();
        mathPostfix.setLength(0); // служит как очистка

        Matcher matcher = getMatcher(mathInfix);
        while (matcher.find()){

        }
        return "";
    }

    //получаем экземл. для сравнения регулярных выражений
    private static Matcher getMatcher(String mathInfix) {
        //сгененрирует паттерн из строки с регуляр. выраж
        Pattern patternMath = Pattern.compile(getPatternStrings());
        //паттерн возвращает матчер, который будет работать с той строкой,которую  передаем - инфиксное выражение
        return patternMath.matcher(mathInfix);

    }

    //в строке должно остаться, только, то что указано в рег.выр., остальное не попадает
    private static String getPatternStrings() {
        return getPatternStringNumbers() + "|" + getPatternStringOperators() + "|" + getPatternStringBrackets();

    }

    //скобки
    private static String getPatternStringBrackets() {

        return "([\\(\\)])";
    }

    //операторы
    // из листа с операторами добавляем все в стрингбилдер и экранируем для безопасности
    private static String getPatternStringOperators() {
        StringBuilder sb = new StringBuilder("([");
        for (String operator : operators) {
           sb.append("\\").append(operator);
        }
       return sb.append("])").toString();
    }

    //числа.. в любом количестве, может быть точка и после точки любое количество чисел...т.е. вечественные числа тоже подойдут
    //        \d    любая  цифра [0-9]
    ////         +    любое количеств
    ////        (  )  еще может что-то быть
    ////        ()?   но может и не быть
    ////        \.    может быть точка
    ////         \d   цифры после точки
    ////         +    любое количество
    private static String getPatternStringNumbers() {
        return "(\\d+((\\.\\d+)?)+)";
    }

    public static void main(String[] args) {

//        InfixToPostfix infixToPostfix = new InfixToPostfix();
//        System.out.println(getPatternStringOperators());;
    }

}
