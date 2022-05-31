//Домашнее задание, урок 4: Владимир Греков
package lesson4;

import java.util.Random;
import java.util.Scanner;


public class TicTacToe {
    private static final char DOT_EMPTY = '•';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final String HEADER_FIRST_SYMBOL = "♥";
    private static final String SPACE_MAP = "\t";

    private static Scanner in = new Scanner(System.in);
    private static Random random = new Random();

    private static  int intSIZE; //изменяется при настройке игры

    public static int intDOTS_TO_WIN; //изменяется при настройке игры

    private static char[][] charMAP; //изменяется при настройке игры

    private static int turnsCount; //счетчик ходов
    private static int rowLastNumber; // координата строки последнего хода
    private static int columnLastNumber; // координата колонки последнего хода

    public static void turnGame() {
        settingGame();

        do {
            System.out.println("\n\nИГРА НАЧИНАЕТСЯ!!!");
            init();
            printMap();
            playGame();
        } while (isContinueGame());
        endGame();
    }

    private static void settingGame() {
        //настройки игры

        intSIZE = getSizeMap();//получить размер игрового поля
        //подобрать победную серию фишек для выбранного размера
        intDOTS_TO_WIN = getDotsToWin(intSIZE);
        charMAP = new char[intSIZE][intSIZE];
    }

    private static void init() {
        turnsCount = 0;
        initMap();
    }

    private static int getDotsToWin(int size) {
        //получение победного числа знаков
        int result;

        if (size >= 3 && size <= 6) {
            //размер 3-6 -> победная серия 3
            result = 3;
        } else if (size >= 7 && size <= 10) {
            //размер 7-10 -> победная серия 4
            result = 4;
        } else {
            //размер 10+ -> победная серия 5
            result = 5;
        }
        return result;
    }

    private static int getSizeMap() {
        int sizeMap = 3;
        boolean flagSetting = true;
        String strWarning = "!!!Значение размера игрового поля должно быть от 3 и больше";

        System.out.print("Введите размер игрового поля: ");
        sizeMap = getValidNumberFromScanner(strWarning, flagSetting);
        return  sizeMap;
    }

    private static void initMap() {
        for (int i = 0; i < intSIZE; i++) {
            for (int j = 0; j < intSIZE; j++) {
                charMAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printMapHeader();
        printMapBody();
    }

    private static void printMapHeader() {
        System.out.print(HEADER_FIRST_SYMBOL + SPACE_MAP);
        for (int i = 0; i < intSIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printMapNumber(int i) {

        System.out.print(i + 1 + SPACE_MAP);
    }

    private static void printMapBody() {
        for (int i = 0; i < intSIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < intSIZE; j++) {
                System.out.print(charMAP[i][j] + SPACE_MAP);
            }
            System.out.println();
        }
    }

    private static void playGame() {
        while (true) {
            humanTurn();
            printMap();
            if (checkEnd(DOT_HUMAN)) {
                break;
            }

            aiTurn();
            printMap();
            if (checkEnd(DOT_AI)) {
                break;
            }
        }
    }

    private static void humanTurn() {
        System.out.println("ХОД ЧЕЛОВЕКА!");

        int rowNumber;
        int columnNumber;
        String strWarning = "!!!Проверьте значение координаты. Должно быть от 1 до " + intSIZE;

        while (true) {
            boolean flagSetting = false;

            System.out.print("Введите координату строки: ");
            rowNumber = getValidNumberFromScanner(strWarning, flagSetting) - 1;

            System.out.print("Введите координату столбца: ");
            columnNumber = getValidNumberFromScanner(strWarning, flagSetting) - 1;

            if (isCellFree(rowNumber, columnNumber)) {
                rowLastNumber = rowNumber;
                columnLastNumber = columnNumber;
                break;
            }
            System.out.printf("Ячейка с координатами: %d:%d уже занята%n%n", rowNumber + 1, columnNumber + 1);
        }

        charMAP[rowNumber][columnNumber] = DOT_HUMAN;

        turnsCount++;
    }

    private static void aiTurn() {
        System.out.println("ХОД КОМПЬЮТЕРА!");

        int rowNumber;
        int columnNumber;


        do {
            rowNumber = random.nextInt(intSIZE);
            columnNumber = random.nextInt(intSIZE);
        } while (!isCellFree(rowNumber, columnNumber));

        rowLastNumber = rowNumber;
        columnLastNumber = columnNumber;

        charMAP[rowNumber][columnNumber] = DOT_AI;
        turnsCount++;
    }

    private static int getValidNumberFromScanner(String strWarning , boolean flagSetting) {
        while (true) {
            if (in.hasNextInt()) {
                int n = in.nextInt();
                if (isNumberValid(n, flagSetting)) {
                    return n;
                }
                System.out.println(strWarning);
            } else {
                System.out.println("!!!Ввод допускает лишь целые числа!");
                in.next();
            }
        }
    }

    private static boolean isNumberValid(int n, boolean flagSetting ) {
        //проверка соответствия введенного числа
        boolean result = false;

        if (!flagSetting) {
            result = ( n >= 1 && n <= intSIZE);
        } else if (flagSetting) {
            result =  (n >= 3);
        }
        return result;
    }

    private static boolean isCellFree(int rowNumber, int columnNumber) {
        return charMAP[rowNumber][columnNumber] == DOT_EMPTY;
    }

    private static boolean checkEnd(char symbol) {
        //проверка на окончание текущей игры
        if (checkWin(symbol, rowLastNumber, columnLastNumber)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("УРА! ВЫ ПОБЕДИЛИ!");
            } else {
                System.out.println("ВОССТАНИЕ БЛИЗКО... ИИ ПОБЕДИЛ...");
            }
            return true;
        }

        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }

        return false;
    }

    private static boolean checkWin(char symbol, int rowLastNumber, int columnLastNumber) {
        //проверка наличия победы после последнего хода
        if (horizontalCheckWin(symbol, rowLastNumber)) {
            return true;
        }

        if (verticalCheckWin(symbol, columnLastNumber)) {
            return true;
        }

        // диагональ слева-вверху вправо-внизу diagonalLeftTopRightBottom
        if (diagonalLeftTopRightBottom(symbol, rowLastNumber, columnLastNumber)) {
            return true;
        }
        // диагональ справа-вверху влево-внизу diagonalRightTopLeftBottom
        if (diagonalRightTopLeftBottom(symbol, rowLastNumber, columnLastNumber)) {
            return true;
        }

        return false;
    }

    private static boolean diagonalRightTopLeftBottom(char symbol, int i, int j) {
        //проверка диагонали справа-вверху влево-внизу на победу
        boolean leftTop = false;   //начало диагонали слева вверху (нет)
        int topCellRowNumber;
        int topCellColumnNumber;
        int topColumn = intSIZE-1; //верхняя правая колонка
        int deltaCount = 1; //приращение счетчика получения координат верхней ячейки
        int intDelta = -1;  //приращение счетчика колонок при чтении в массив
        int[] topCellCoordinates;
        int intArrayLength;
        char[] arrayTest;

        topCellCoordinates = getCoordinatesTopCell(i, j, topColumn, deltaCount);

        topCellRowNumber = topCellCoordinates[0];
        topCellColumnNumber = topCellCoordinates[1];

        intArrayLength = getArraySize(topCellRowNumber, topCellColumnNumber, leftTop);

        arrayTest = readDiagonalToArray(topCellRowNumber, topCellColumnNumber, intArrayLength, intDelta);

        return isWinSequence(arrayTest, symbol);
    }

    private static boolean diagonalLeftTopRightBottom(char symbol, int i, int j) {
        //проверка диагонали слева-вверху вправо-внизу на победу
        boolean leftTop = true; //начало диагонали слева вверху
        int topCellRowNumber;
        int topCellColumnNumber;
        int topColumn = 0;   //верхняя левая колонка
        int deltaCount = -1; //приращение счетчика получения координат верхней ячейки
        int intDelta = 1;    //приращение счетчика колонок при чтении в массив
        int[] topCellCoordinates;
        int intArrayLength;
        char[] arrayTest;


        topCellCoordinates = getCoordinatesTopCell(i, j, topColumn, deltaCount);

        topCellRowNumber = topCellCoordinates[0];
        topCellColumnNumber = topCellCoordinates[1];

        intArrayLength = getArraySize(topCellRowNumber, topCellColumnNumber, leftTop);

        arrayTest = readDiagonalToArray(topCellRowNumber, topCellColumnNumber, intArrayLength, intDelta);

        return isWinSequence(arrayTest, symbol);
    }

    private static int[] getCoordinatesTopCell(int i, int j, int topColumn, int deltaCount) {
        //получение массива координат верхней ячейки диагонали,
        //поднимаясь снизу-вверх по диагонали от последнего хода.
        //для диагонали слева-вверху вправо-внизу deltaCount = -1
        //для диагонали справа-вверху влево-внизу deltaCount = 1
        int topCellRowNumber;
        int topCellColumnNumber;
        int[] topCellCoordinates = new int[2];

        while (true) {
            if (i == 0 || j == topColumn) {
                topCellRowNumber = i;
                topCellColumnNumber = j;
                break;
            }
            i--;
            j += deltaCount;
        }
        topCellCoordinates[0] = topCellRowNumber;
        topCellCoordinates[1] = topCellColumnNumber;
        return topCellCoordinates;
    }

    private static int getArraySize(int topCellRowNumber, int topCellColumnNumber, boolean leftTop) {
        //получить размер одномерного массива
        int arraySize = 0;

        if (topCellRowNumber == 0 && (topCellColumnNumber == 0 && leftTop)) {
            arraySize = intSIZE;
        }

        if (topCellRowNumber == 0 && (topCellColumnNumber == intSIZE-1 && !leftTop)) {
            arraySize = intSIZE;
        }

        if (topCellRowNumber > 0) {
            arraySize = intSIZE - topCellRowNumber;
        }

        if (topCellRowNumber == 0 && !leftTop){
            arraySize = topCellColumnNumber + 1;
        }

        if (topCellRowNumber == 0 && leftTop) {
            arraySize =  intSIZE - topCellColumnNumber;
        }
        return arraySize;
    }

    private static char[] readDiagonalToArray(int i, int j, int arrayLength, int intDelta) {
        //чтение диагонали справа-вверху влево-внизу в линейный массив, intDelta = -1,
        //для диагонали слева-верх справа-низ intDelta = 1
        char[] arrayTest = new char[arrayLength];

        for (int k = 0; k < arrayLength; k++) {
            arrayTest[k] = charMAP[i][j];
            i++;
            j += intDelta;
        }
        return arrayTest;
    }

    private static boolean isWinSequence(char[] arrayTest, char symbol) {
        //проверка массива на наличие победной последовательности
        int intCounter = 0;

        if (arrayTest.length >= intDOTS_TO_WIN) {
            for (int i = 0; i < arrayTest.length; i++) {
                if (arrayTest[i] == symbol){
                    intCounter += 1;
                } else {
                    intCounter = 0;
                }
                if (intCounter == intDOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean horizontalCheckWin(char symbol, int rowLastNumber) {
        //проверка горизонтали на наличие победной последовательности
        char[] arrayTest = new char[intSIZE];

        //чтение в линейный массив для проверки
        for (int i = 0; i < charMAP[rowLastNumber].length; i++) {
            arrayTest[i] = charMAP[rowLastNumber][i];
        }
        return isWinSequence(arrayTest, symbol);
    }

    private static boolean verticalCheckWin(char symbol, int columnLastNumber) {
        //проверка вертикали на наличие победной последовательности
        char[] arrayTest = new char[intSIZE];

        //чтение в линейный массив для проверки
        for (int i = 0; i < charMAP.length; i++) {
            arrayTest[i] = charMAP[i][columnLastNumber];
        }
        return isWinSequence(arrayTest, symbol);
    }

    private static boolean checkDraw() {
        //проверка на ничью
        return turnsCount >= intSIZE * intSIZE;
    }


    private static boolean isContinueGame() {
        //предложение продолжить игру
        System.out.println("Хотите продолжить? y\\n");
        return switch (in.next()) {
            case "y", "yes", "да", "+", "д" -> true;
            default -> false;
        };
    }

    private static void endGame() {
        //завершение игры
        in.close();
        System.out.println("Ты заходи, если что");
    }
}

