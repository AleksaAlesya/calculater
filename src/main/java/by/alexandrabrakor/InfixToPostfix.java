package by.alexandrabrakor;

import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class InfixToPostfix {
    private static final StringBuilder mathPostfix = new StringBuilder();
    private static final LinkedList<String> operators = new LinkedList<>();//храним все существующие операторы
    private static final Stack<String> operatorsStack = new Stack<>();// временно б. хранить отложенные операторы

    static {
        operators.add("*");
        operators.add("/");
        operators.add("-");
        operators.add("+");
        operators.add("^");
    }


/* Берем строку с инфиксной записью выражения и переводим в постфиксную запись
     f_27*6/(4+1) -  инфиксная запись
     27 6 * 4 1 + / - постфиксная запись
* последоватеельно каждый элемент сравниваем с Рег. Выр, пока нахоодим подходящий кусок, продолжаем
* Ести это число, то мы добавляем его сразу в стринбилдер, в котором формируем  постфиксоное выражение и пробел
* Если это  открыв. скобка ( - то мы ее добаляем в Стэк ( для временнного хранения операторов
* Если это закрывающаяся скобка ), то мы берем все операторы из стэка до открыв. скобки ( записываем в стрингбилдер постф.  и удаляем  из стэка, скобку ( - удаляем
* Если пришло, что то др. , т.е. операторы, и если в стеке пусто - то записываем с Стэк. Если не пусто, то достаем последний оператор и проверям их приоритеты, если у имеющегося выше приоритет, то его добавляем в стрингбилдер и удаляем из стэка, а этот записываем в стэк. Если же ниже, то этот добавляем в стэк
* и так  пока не будет пустой стэк
* В итоге получаем пустой стэк и  постфиксное выражение*/

    public static String convert(String mathInfix) {
        operatorsStack.clear();
        mathPostfix.setLength(0); // служит как очистка

        Matcher matcher = getMatcher(mathInfix);
        while (matcher.find()){
            String mathElement =matcher.group();
            if (isNumeric(mathElement)){
                mathPostfix.append(mathElement).append(" ");

            }else if (mathElement.equals("(")){
                operatorsStack.add(mathElement);
            }else if(mathElement.equals(")")){
                while (!operatorsStack.peek().equals("(")){
                    mathPostfix.append(operatorsStack.pop()).append(" ");
                }
                operatorsStack.pop();
            }else {
                while (!operatorsStack.isEmpty() && getOperatorPriority(operatorsStack.peek())>= getOperatorPriority(mathElement)){
                    mathPostfix.append(operatorsStack.pop()).append(" ");
                }
                operatorsStack.push(mathElement);
            }
        }
        while (!operatorsStack.isEmpty()){
            mathPostfix.append(operatorsStack.pop()).append(" ");
        }
        return mathPostfix.toString();
    }

    private static int getOperatorPriority(String operator){
        return switch (operator){
            case "^"->3;
            case "*", "/"->2;
            case "+","-"->1;
            default -> 0;

        };
    }

    public static boolean isNumeric(String mathElement){
        // формирует паттерсн с которым будем сравнивать строку
        Pattern patternNum = Pattern.compile(getPatternStringNumbers());
        //find - сравнит, тру - если есть такая часть во всей строке
        return  patternNum.matcher(mathElement).find();

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

    //Регулярное выражение со скобками
    private static String getPatternStringBrackets() {
        return "([\\(\\)])";
    }

    //Регулярное выражение с операторами
    // из листа с операторами добавляем все в стрингбилдер и экранируем для безопасности
    private static String getPatternStringOperators() {
        StringBuilder sb = new StringBuilder("([");
        for (String operator : operators) {
           sb.append("\\").append(operator);
        }
       return sb.append("])").toString();
    }

    /*Регулярное выражение с цифрами
    числа.. в любом количестве, может быть точка и после точки любое количество чисел...т.е. вечественные числа тоже подойдут
         \d    любая  цифра [0-9]
          +    любое количеств
         (  )  еще может что-то быть
         ()?   но может и не быть
         \.    может быть точка
         \d   цифры после точки
          +    любое количество*/
    private static String getPatternStringNumbers() {
        return "(\\d+((\\.\\d+)?)+)";
    }

//    //Для проверки
//    public static void main(String[] args) {
//        System.out.println(getPatternStringOperators());
//        System.out.println(getPatternStringBrackets());
//        System.out.println(getPatternStringNumbers());
//        System.out.println(getPatternStrings());
//        System.out.println(convert("f_27*6/(4+1)"));
//        System.out.println(convert("5+3"));
//        System.out.println(convert("5+5*45-(7-17)*8+6*9"));
//    }

}
