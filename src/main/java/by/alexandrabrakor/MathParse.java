package by.alexandrabrakor;

import java.util.Stack;

public class MathParse {
    private  static Stack<Double> numbers = new Stack<>();
    private static String mathPostfix;


    /* В методе делаем калькулирование выражения и находим результат
     * cтроку с выражением конвертируем в постфиксную запись// в маине
     *  сплитуем по пробелам
     *  пробегаем по массиву,если число, то записываем в стэк
     * когда доходим до оператора, в стеке полюбому уже есть 2 числа, мы извлекаем их
     *  делаем операцию с этими числами и оператором и записываем в стэк
     *  и так проходимся до конца всех элементов в стэке, в итоге будет одно число - оно и есть результат
     * удаляем из стэка и возвращаем это число*/
    public static  Double calculation (String mathInfix){
        mathPostfix = InfixToPostfix.convert(mathInfix); // todo перенести в класс маин
        String [] mathArr =mathPostfix.split("\\s+");
        for (String mathElem : mathArr) {
            if (InfixToPostfix.isNumeric(mathElem)){
                numbers.push(Double.parseDouble(mathElem));
                continue;
            }
           double num2 = numbers.pop();
           double num1 = numbers.pop();
           numbers.push(calc(num1,num2,mathElem));

        }
        return numbers.pop();
    }

    private static double calc(double num1, double num2, String operator) {
       return switch (operator){
           case "+" -> num1+num2;
           case "*" -> num1*num2;
           case "-" -> num1-num2;
           case "/" -> num1/num2;
           case "^" -> Math.pow(num1,num2);
           default -> 0;
        };
    }

//    //для проверки
//    public static void main(String[] args) {
//        System.out.println(calculation("f_27*6/(4+1)"));
//    }


}
