import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static boolean isNumeric(String str) {
        return str != null && str.matches("[0-9]+");
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String enter = s.nextLine();
        String[] comp = enter.split(" ");
        if (comp.length == 3) { //проверка коректности введения выражения

            if (isNumeric(comp[0]) && isNumeric(comp[2])) { //если арабские цифры
                int num1 = Integer.valueOf(comp[0]);
                int num2 = Integer.valueOf(comp[2]);
                if (((num1 >= 0) && (num1 <= 10)) && ((num2 >= 0) && (num2 <= 10))) { //проверка на промежуток от 0 до 10
                    switch (comp[1]) {
                        case "+":
                            System.out.println(num1 + num2);
                            break;
                        case "-":
                            System.out.println(num1 - num2);
                            break;
                        case "*":
                            System.out.println(num1 * num2);
                            break;
                        case "/":
                            System.out.println(num1 / num2);
                            break;
                        default:
                            try {
                                throw new IOException();
                            } catch (IOException e) {
                                System.out.println("Неверная математическая операция");
                            }
                    }
                }else {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("Неверные числа");
                    }
                }
            }else { //Работа с римскими цифрами

                int num1 = IntegerConverter.romanToInt(comp[0]);
                int num2 = IntegerConverter.romanToInt(comp[2]);
                if (num1 == 0 || num2 == 0){ //проверка на системы счисления
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        if (isNumeric(comp[0]) || isNumeric(comp[2])) //проверка на диапозон чисел
                            System.out.println("Используются одновременно разные системы счисления");
                        else System.out.println("Неверное число");
                    }
                } else {
                    int resp;
                    switch (comp[1]) {
                        case "+":
                            resp = num1 + num2;
                            System.out.println(IntegerConverter.intToRoman(resp));
                            break;
                        case "-":
                            if (num1 > num2) { //проверка отрицательности разности
                                resp = num1 - num2;
                                System.out.println(IntegerConverter.intToRoman(resp));
                            } else{
                                try {
                                    throw new IOException();
                                } catch (IOException e) {
                                    System.out.println("В римской системе нет отрицательных чисел");
                                }
                            }
                            break;
                        case "*":
                            resp = num1 * num2;
                            System.out.println(IntegerConverter.intToRoman(resp));
                            break;
                        case "/":
                            resp = num1 / num2;
                            System.out.println(IntegerConverter.intToRoman(resp));
                            break;
                        default:
                            try {
                                throw new IOException();
                            } catch (IOException e) {
                                System.out.println("Неверная математическая операция");
                            }
                    }
                }
            }
        }else{
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        }
    }
}