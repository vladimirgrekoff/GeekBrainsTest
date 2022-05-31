//Домашнее задание, урок 3: Владимир Греков
package lesson3;

import java.util.Arrays;
import java.util.Random;

public class HomeWorkApp3 {

    public static void main(String[] args) {
        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] binaryArr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        // создать со случайным заполнением 0 и 1
        int[] intBinaryArr = getRandomValueArray(20, 2);

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(binaryArr));
        System.out.println("Заменены 0 на 1, 1 на 0:");
        System.out.println(Arrays.toString(changeZeroToOne(binaryArr))); // заменим 1 на 0, 0 на 1 в элементах массива
        //для созданного со случайным заполнением 0 и 1
        System.out.println(("Исходный массив со случайным заполнением 0 и 1:"));
        System.out.println(Arrays.toString(intBinaryArr));
        System.out.println("Заменены 0 на 1, 1 на 0::");
        System.out.println(Arrays.toString(changeZeroToOne(intBinaryArr))); // заменим 1 на 0, 0 на 1 в элементах массива


        // 2. Задать пустой целочисленный массив длиной 100.
        // С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
        int[] intArray = new int[100];

        intArray = assignValuesToArrayElements(intArray); // присвоим значения элементам массива о 1 до 100
        System.out.println("Заполненый значениями массив длиной 100:");
        System.out.println(Arrays.toString(intArray));

        // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти
        // по нему циклом, и числа меньшие 6 умножить на 2;
        int[] intNumbers =  {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(intNumbers));
        System.out.println("Значения меньшне 6, умножены на 2:");
        // умножим значение элемента массива на 2, если < 6
        System.out.println(Arrays.toString(multiplyByTwoIfLessSix(intNumbers)));

        // 4. Создать квадратный двумерный целочисленный массив,
        // с помощью цикла(-ов) заполнить его диагональные элементы единицами
        int[][] squareArray = new int[5][5];

        System.out.println("Заполненые единицами диагональные элементы:");
        fillDiagonalsArrayWithOnes(squareArray);


        //5. Написать метод, принимающий два аргумента: len и initialValue,
        // и возвращающий одномерный массив типа int длиной len, каждая ячейка
        // которого равна initialValue;
        int len = 7;
        int initialValue = 747;

        System.out.println("Массив заданной длины: " + len + ", заполненный заданным значением: " + initialValue);
        System.out.println(Arrays.toString(getArrayWithLengthAndValues(7, initialValue)));


        // 6. Задать одномерный массив и найти в нем минимальный и максимальный элементы ;

        System.out.println(("Проверяемый массив из задачи 3:"));
        System.out.println(Arrays.toString(intNumbers));
        // поиск максимального и минимального элементов
        System.out.println(findMaxAndMinValuesArray(intNumbers));

        // 7. Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true, если в массиве есть место,
        // в котором сумма левой и правой части массива равны.
        int[] intNumArray =  {2, 2, 2, 1, 2, 2, 10, 1};

        System.out.println("Проверим массив:");
        System.out.println(Arrays.toString(intNumArray));
        System.out.println("Есть ли место в массиве, в котором сумма " +
                "левой и правой части равны: " + checkBalance(intNumArray));


        //8. Написать метод, которому на вход подается одномерный массив и
        // число n (может быть положительным, или отрицательным), при этом
        // метод должен сместить все элементы массива на n позиций.
        // Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        int[] intCheckedArray =  {1, 2, 3, 4, 5};
        int intShift = 4;

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(intCheckedArray));
        System.out.println("Сместить все элементы массива на n = " + intShift + " позиций:");
        shiftPositionArrayElement(intCheckedArray, intShift);

        // массив из задачи 2
        intShift = 20;
        System.out.println("Исходный массив из задачи 2:");
        System.out.println(Arrays.toString(intArray));
        System.out.println("Сместить все элементы массива на n = " + intShift + " позиций:");
        shiftPositionArrayElement(intArray, intShift);

    }






    public static int[] getRandomValueArray (int arrayLength, int range) {
        //метод: заполнение элементов массива случайными числами
        //range устанавливает диапазон присваиваемых зачений элементу массива
        int[] randomBinaryArray = new int[arrayLength];
        Random random = new Random(); // экземпляр класса Random

        for (int i = 0; i < arrayLength; i++) {
            randomBinaryArray[i] = random.nextInt(range);
        }
//        System.out.println(Arrays.toString(randomBinaryArray));
        return randomBinaryArray;
    }

    private static int[] changeZeroToOne(int[] intArr) {
        //метод: замена 0 на 1, 1 на 0 в элементах массива
        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] == 0) {
                intArr[i] = 1;
            } else {
                intArr[i] = 0;
            }
        }
//        System.out.println(Arrays.toString(intArr));
        return intArr;
    }

    private static int[] assignValuesToArrayElements(int[] intArray) {
        //метод: заполнение массива последовательностью
        // чисел от 1 до 100 (размера массива)
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i + 1;
        }
//        System.out.println(Arrays.toString(intArray));
        return intArray;
    }

    private static int[] multiplyByTwoIfLessSix(int[] intArray) {
        //метод: умножение значений на 2, если они < 6
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] < 6) {
                intArray[i] *= 2;
            }
        }
//        System.out.println(Arrays.toString(intArray));
        return intArray;
    }

    private static void fillDiagonalsArrayWithOnes(int[][] sqrArray) {
        // метод: заполнение единицами диагоналей массива
        for (int i = 0; i < sqrArray.length; i++) {
            for (int j = 0; j < sqrArray[i].length; j++) {
                if (i == j || j == sqrArray[i].length - 1 - i) {
                    sqrArray[i][j] = 1;
                    System.out.print(sqrArray[i][j] + "  ");
                } else {
                    System.out.print(sqrArray[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }

    private static int[] getArrayWithLengthAndValues(int len, int initialValue) {
        // метод: получить целочисленный массив длиной len,
        // заполненный initialValue
        int[] intNewArray = new int[len];

        for (int i = 0; i < len; i++) {
            intNewArray[i] = initialValue;
        }
        return intNewArray;
    }

    private static String findMaxAndMinValuesArray(int[] intTestArray) {
        // метод: поиск максимального
        // и минимального значения элементов
        int maxValue = intTestArray[0];
        int minValue = intTestArray[0];
        String maxIndex = "" + 0;
        String minIndex = "" + 0;
        String result;


        for (int i = 0; i < intTestArray.length; i++) {
            if (maxValue < intTestArray[i]) {
                maxValue = intTestArray[i];
                maxIndex = String.valueOf(i);
            } else if (maxValue == intTestArray[i] && i != 0) {
                maxIndex = maxIndex + ", " + i;
            }

            if (minValue > intTestArray[i]) {
                minValue = intTestArray[i];
                minIndex = String.valueOf(i);
            } else if (minValue == intTestArray[i] && i != 0) {
                minIndex = minIndex + ", " + i;
            }
        }
        result = "максимальное значение: " + maxValue + ", индекс элемента массива: " + maxIndex + "\n" +
                "минимальное значение: " + minValue + ", индекс элемента массива: " + minIndex;
        return result;
    }

    private static String checkBalance(int[] checkArray){
        // метод: проверка есть ли место в массиве,
        // в котором сумма левой и правой частей равны
        int intLeftSum = 0; // сумма элементов массива слева
        int intRightSum = 0; // сумма элементов массива слева
        int intCheckSum = 0; // сумма элементов массива
        int positionL = 0;
        int positionR = 0;
        String resString = "";

        intCheckSum = countSum(checkArray);
        if (intCheckSum % 2 == 0) {
            //сумма слева
            for (int i = 0; i < checkArray.length; i++) {
                intLeftSum = intLeftSum + checkArray[i];
                if (intLeftSum == intCheckSum/2) {
                    positionL = i;
                    break;
                } else if (intLeftSum > intCheckSum/2) {
                    break;
                }
            }
            //сумма слева
            for (int j = checkArray.length-1; j >= 0; j--) {
                intRightSum = intRightSum + checkArray[j];
                if (intRightSum == intCheckSum/2) {
                    positionR = j;
                    break;
                } else if (intLeftSum > intCheckSum/2) {
                    break;
                }
            }
        }
        if ((intLeftSum == intCheckSum/2) && (intRightSum == intCheckSum/2)) {
            resString = "Да, между индексами: " + positionL + " и " + positionR;
        } else {
            resString = "Нет.";
        }
        return resString;
    }

    private static int countSum(int[] checkArray) {
        //сумма элементов массива
        int intSum = 0;

        for (int i = 0; i < checkArray.length; i++) {
            intSum = intSum + checkArray[i];
        }
        return  intSum;
    }

    private static void shiftPositionArrayElement(int[] procArray, int shift) {
        // метод: сдвиг значений элементов массива на заданную величину
        int shiftChecked = getModulReducedValue(shift, procArray.length);


        for (int n = 0; n < shiftChecked; n++) {
            if (shift > 0) {
                procArray = getShiftRightOnePosition(procArray);
            }else {
                procArray = getShiftLeftOnePosition(procArray);
            }
        }
        System.out.println(Arrays.toString(procArray));
    }

    private static int getModulReducedValue(int shift, int arrayLength) {
        // метод: проверка сдвига на избыточность значения.
        // Сдвиг равный длине массива возвращает в исходное положение,
        // для сдвига больше длины значим остаток от целочисленного деления
        int result;

        if (Math.abs(shift) >= arrayLength) {
            //если сдвиг больше длинны массива
            result = Math.abs(shift) % arrayLength;
        } else {
            result = Math.abs(shift);
        }
        return result;
    }

    private static int[] getShiftRightOnePosition(int[] procArray) {
        //метод: сдвиг значений элементов вправо на 1 позицию
        int tempValue;

        tempValue = procArray[procArray.length-1]; //значение последнего элемента в переменную
        for (int i = procArray.length - 1; i > 0; i--) { //цикл с последнего элемента до второго
            procArray[i] = procArray[i-1]; //значение предыдущего
        }
        procArray[0] = tempValue; // присвоить первому элементу
        return procArray;
    }

    private static int[] getShiftLeftOnePosition(int[] procArray) {
        //метод: сдвиг значений элементов влево на 1 позицию
        int tempValue;

        tempValue = procArray[0]; //значение первого элемента в переменную
        for (int i = 0; i < procArray.length-1; i++) { //цикл со второго элемента до предпоследнего
            procArray[i] = procArray[i+1]; //значение следующего
        }
        procArray[procArray.length-1] = tempValue; // присвоить последнему элементу
        return procArray;
    }

}


