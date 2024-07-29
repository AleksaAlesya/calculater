package by.alexandrabrakor;

import java.util.Scanner;

public class NumeralSystemTest {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        char letter; // q and Q
        int number; // вводимое число
        int ns; //номер системы счисления
        int nsnumb; //номер системы в которой число

        do
        {
            System.out.println("Введите число: ");
            number = sc.nextInt();
            System.out.println("В какой системе счисления число?");
            nsnumb = sc.nextInt();
            System.out.println("Введите систему счисления: ");
            ns = sc.nextInt();

            switch (ns)
            {
                case 2:
                    String convert = Long.toBinaryString(number);
                    System.out.println("Двоичная система: " + convert);
                    break;
                case 8:
                    convert = Long.toOctalString(number);
                    System.out.println("Воьмиричная система: "+ convert);
                    break;
                case 16:
                    convert = Long.toHexString(number).toUpperCase();
                    System.out.println("Шестнадцатеричная система: " + convert);
            }
            letter = sc.next().charAt(0);

        }while(letter != 'q' && letter != 'Q');


//        Переводит число из любой системы счисления в любую другую с помощью обёртки Long
//        Scanner sc = new Scanner(System.in);
//        long number; // вводимое число
//        int ns; //номер системы счисления
//        int nsnumb; //номер системы в которой число
//        System.out.println("В какой системе счисления число?");
//        nsnumb = Integer.parseInt(sc.nextLine());
//        System.out.println("Введите число: ");
//        number = Long.parseLong(sc.nextLine(), nsnumb);
//        System.out.println("Введите систему счисления: ");
//        ns = sc.nextInt();
//        System.out.println("Полученое число " + Long.toString(number, ns));
    }
}
