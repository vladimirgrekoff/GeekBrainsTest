//Домашнее задание, урок 1: Владимир Греков
package lesson1;

public class HomeWorkApp {
    public static void main(String[] args) {

        printThreeWord(); //печать столбца
        checkSumSign();   //проверка знака суммы чисел
        printColor();     //определим цвет
        compareNumbers(); //сравним числа

    }
    private static void printThreeWord() {
        // Метод печати столбца из 3-х слов
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    private static void checkSumSign() {
        //Метод проверки знака суммы переменных
        int a = -3;
        int b = 5;
        int intSum = a + b;

        if (intSum >= 0){
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отррицательная");
        }

    }
    public static void printColor() {
        //метод определения цвета по значению переменной
        int value = 110;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    private static void compareNumbers() {
        //метод сравнеия двух чисел
        int a = 180;
        int b = 150;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

}

