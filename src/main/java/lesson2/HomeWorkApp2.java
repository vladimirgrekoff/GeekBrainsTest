//Домашнее задание, урок 2: Владимир Греков

package lesson2;

public class HomeWorkApp2 {
    public static void main(String[] args) {

        //1. Написать метод, принимающий на вход два целых числа и проверяющий,
        // что их сумма лежит в пределах от 10 до 20 (включительно),
        // если да – вернуть true, в противном случае – false.
        int a = 5;
        int b = 15;

        System.out.println("Сумма чисел а = " + a + " и b = " + 10 +
                " находится в диапазоне от 10 до 20 включительно? " + checkSumRange(a, b));
        System.out.println();

        //2. Написать метод, которому в качестве параметра передается целое число,
        // метод должен напечатать в консоль, положительное ли число передали или отрицательное.
        // Замечание: ноль считаем положительным числом.
        int c = -5;

        checkNumberPositiveOrNegative(c);
        System.out.println();

        //3. Написать метод, которому в качестве параметра передается целое число.
        // Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
        int d = -5;

        System.out.println("Относится число " + d + " к положительным? " + isNumberPositive(d));
        System.out.println();

        //4. Написать метод, которому в качестве аргументов передается строка и число,
        // метод должен отпечатать в консоль указанную строку, указанное количество раз;
        int intCount = 3;
        String strPrint = "Сколько раз печатаем?";

        cyclePrintString(strPrint, intCount);


        //5. * Написать метод, который определяет, является ли год високосным, и
        // возвращает boolean (високосный - true, не високосный - false). Каждый 4-й год является високосным,
        // кроме каждого 100-го, при этом каждый 400-й – високосный.
        int intYear = 1812;

        System.out.println("Год " + intYear + " високосный? " + isLeapYear(intYear));


    }

    private static boolean checkSumRange(int a, int b) {
        // метод проверки нахождения суммы в диапазоне от 10 до 20 включительно
        boolean result = false;

        if ((a + b >= 10) && (a + b <= 20)) {
            result = true;
        }

        return result;

    }

    private static void checkNumberPositiveOrNegative(int num) {
        //метод проверки положительное или отрицательное число с выводом на консоль

        String strResult = "отрицательное";

        if (num >= 0) {
            strResult = "положительное";
        }
        // вывод на консоль
        System.out.println("Число а = " + num + " " + strResult);;
    }

    private static boolean isNumberPositive(int num) {
        //метод проверки является личисло положительным
        boolean result = false;

        if (num >= 0) {
            result = true;
        }
        return result;
    }

    private static void cyclePrintString(String strPrint, int intCounter) {
        //метод вывода строки указанное количество раз
        for (int i = 0; i < intCounter; i++) {
            System.out.println(strPrint + " " + intCounter + ". Cчетчик: " + (i + 1));
        }
        System.out.println();
    }

    private static boolean isLeapYear(int year) {
        //метод проверки года на високосность
        if (year % 4 == 0) { //может быть високосным, если не
            if (year % 100 == 0) {//может быть невисокосным, если не
                if (year % 400 == 0) {//высокосный
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

}

