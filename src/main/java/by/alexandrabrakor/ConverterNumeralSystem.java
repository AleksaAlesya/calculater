package by.alexandrabrakor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConverterNumeralSystem {

    public static String convertForNumeralSystem(String mathInfix,String mathElement) {
        int numSystem=getNumberSystem(mathInfix);
        String convert;

        switch (numSystem) {
            case 2:
                convert = String.valueOf(Long.parseLong(mathElement, numSystem));
                System.out.println("Конвертировали из двоичной системы в десятеричную: " + convert);
//                convert = Long.toBinaryString(Long.parseLong(mathElement)); //обратный перевод в двоичную систему
//                System.out.println("Двоичная система: " + convert);
                return convert;
            case 8:
                convert = String.valueOf(Long.parseLong(mathElement, numSystem));
                System.out.println("Конвертировали из восьмеричной системы в десятеричную: " + convert);
//                convert = Long.toOctalString(Long.parseLong(mathElement));
//                System.out.println("Воcьмеричная система: " + convert);
                return convert;
            case 16:
                convert = String.valueOf(Long.parseLong(mathElement, numSystem));
                System.out.println("Конвертировали из шестнадцатиричной системы в десятеричную: " + convert);
//                convert = Long.toHexString(Long.parseLong(mathElement)).toUpperCase();
//                System.out.println("Шестнадцатеричная система: " + convert);
                return convert;

            default:
                return mathElement;
        }

    }


    private static int getNumberSystem(String mathInfix){
        int numberSystem=0;
        Matcher matcherForNumeralSystem = getMatcherForNumeralSystem(mathInfix);

        while (matcherForNumeralSystem.find()) {
            String mathElementPrefix = matcherForNumeralSystem.group();
            if (checkNumeralSystem(mathElementPrefix)){
                numberSystem = getBaseFromNumeralSystem(mathElementPrefix);
                System.out.println("система счисления " + numberSystem);
            }
        }
        return numberSystem;
    }


    private static Matcher getMatcherForNumeralSystem(String mathInfix){
        //сгененрирует паттерн из строки с регуляр. выраж
        Pattern patternMath = Pattern.compile( getPatternStringPrefix());
        //паттерн возвращает матчер, который будет работать с той строкой,которую  передаем - инфиксное выражение
        return patternMath.matcher(mathInfix);

    }


    //Регулярное выражение c префиксом
//    1 - двоичная
//    7 - восьмеричная
//    9 - десятеричная
//    f - шестнадцатеричная)
    // "^([1-9a-f])_(.*)$" нам не подходит под условия

    private static String getPatternStringPrefix() {
        return "(^[179f]_)";
    }

   private static boolean checkNumeralSystem(String mathElement) {
        // формирует паттерсн с которым будем сравнивать строку
        Pattern patternNum = Pattern.compile(getPatternStringPrefix());
        //find -  тру - если есть такая часть во всем РВ
        return patternNum.matcher(mathElement).find();

    }


    private static int getBaseFromNumeralSystem(String numeralSystem) {
        switch (numeralSystem) {
            case "1_":
                return 2;
            case "7_":
                return 8;
            case "9_":
                return 10;
            case "f_":
                return 16;
            default:
                throw new IllegalArgumentException("Неподдерживаемая система счисления");
        }
    }


// для теста
//    public static void main(String[] args)
//    {
//        getNumberSystem("f_27*6/(4+1)"); //16
//
//        System.out.println(convertForNumeralSystem("9_", "45")); // 45  десятиричная
//        //
//        convertForNumeralSystem("7_", "15"); //13 восьмеричная
//        convertForNumeralSystem("1_", "100"); //4 двоичная
//        convertForNumeralSystem("f_", "A"); //10 шестнадцатиричная
//
////        Scanner sc = new Scanner(System.in);
////
////        char letter; // q and Q
////        int number; // вводимое число
////        int ns; //номер системы счисления
////        int nsnumb; //номер системы в которой число
////
////        do
////        {
////            System.out.println("Введите число: ");
////            number = sc.nextInt();
////            System.out.println("В какой системе счисления число?");
////            nsnumb = sc.nextInt();
////            System.out.println("Введите систему счисления: ");
////            ns = sc.nextInt();
////
////            switch (ns)
////            {
////                case 2:
////                    String convert = Long.toBinaryString(number);
////                    System.out.println("Двоичная система: " + convert);
////                    break;
////                case 8:
////                    convert = Long.toOctalString(number);
////                    System.out.println("Воьмиричная система: "+ convert);
////                    break;
////                case 16:
////                    convert = Long.toHexString(number).toUpperCase();
////                    System.out.println("Шестнадцатеричная система: " + convert);
////            }
////            letter = sc.next().charAt(0);
////
////        }while(letter != 'q' && letter != 'Q');
//
//
////        Переводит число из любой системы счисления в любую другую с помощью обёртки Long
////        Scanner sc1 = new Scanner(System.in);
////        long number1; // вводимое число
////        int ns1; //номер системы счисления
////        int nsnumb1; //номер системы в которой число
////        System.out.println("В какой системе счисления число?");
////        nsnumb1 = Integer.parseInt(sc1.nextLine());
////        System.out.println("Введите число: ");
////        number1 = Long.parseLong(sc1.nextLine(), nsnumb1);
////        System.out.println("Введите систему счисления: ");
////        ns1 = sc1.nextInt();
////        System.out.println("Полученое число " + Long.toString(number1, ns1));
//    }
}


