//Домашнее задание, урок 7: Владимир Греков
package lesson7;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("ПРИМЕР С ОДНИМ КОТОМ:");
        System.out.println();
        oneCatEatFromPlate(); //ест один кот
        System.out.println();

        //Объекты
        Plate pl = new Plate(75);
        Cat[] cats = new Cat[5];


        cats[0] = new Cat("Васька", 20);
        cats[1] = new Cat("Мурзик", 15);
        cats[2] = new Cat("Барсик", 20);
        cats[3] = new Cat("Марсик", 25);
        cats[4] = new Cat("Персик", 15);


        System.out.println("ПРИМЕР С ПЯТЬЮ КОТАМИ БЕЗ ДОБАВКИ КОРМА:");
        System.out.println();
        //несколько котов едят, корм не добавляют
        allCatsEatOneFromPlate(pl, cats, false);
        System.out.println();


        System.out.println("ПРИМЕР С ПЯТЬЮ КОТАМИ И ДОБАВЛЕНИЕМ КОРМА:");
        //несколько котов едят, можно добавлять корм
        allCatsEatOneFromPlate(pl, cats, true);
        System.out.println();
    }

    private static void oneCatEatFromPlate() {
        //один кот ест из тарелки
        Plate plate = new Plate(10);
        Cat barsik = new Cat("Барсик", 20);

        plate.foodInfo();
        while (plate.getFood() > 0) {//если в тарелке есть корм
            if (plate.getFood() > 0) {
                selectHowToEat(plate, barsik);
                barsik.catInfo();
                plate.foodInfo();
            }
            if (plate.getFood() == 0 && !barsik.getSatiety()) {
                plate.addFood(barsik.getAppetite()); // Добавить необходимое количество корма
                plate.foodInfo();
            }
            if (barsik.getSatiety()){//если кот наелся
                break;
            }
        }
    }




    private static void allCatsEatOneFromPlate(Plate pl, Cat[] cats, boolean enableAddFood) {
        //все коты едят из тарелки, не дожидаясь пока один наестся
        pl.foodInfo();
        do {
            if (isAllCatSatiety(cats)){//если все сыты
                break;
            }
            for (Cat cat : cats) {
                if ((!cat.getSatiety()) && pl.getFood() > 0) { //если кот голоден, и в тарелке есть корм
                    selectHowToEat(pl, cat);
                    cat.catInfo();
                    pl.foodInfo();
                }
            }
            if (enableAddFood) { //если корм добавляется
                if (pl.getFood() == 0 && !isAllCatSatiety(cats)) {
                    pl.addFood(countExtraFood(cats)); // Добавить необходимое количество корма
                    pl.foodInfo();
                }
            }
        } while (pl.getFood() > 0);
        System.out.println();
        catSatietyInfo(cats); //вывести информацию о сытости котов
    }

    private static void catSatietyInfo(Cat[] cats) {
        //информация о сытости котов
        System.out.println("ВСЕ КОТЫ СЫТЫ?");
        for (Cat cat : cats) {
            cat.catInfo();
        }
    }


    private static void selectHowToEat(Plate plate, Cat objectName) {
        //выбор доесть остаток в тарелке, или есть как обычно
        if ((plate.getFood() - objectName.getOneBiteFoodEat()) < 0) {//если остаток в тарелке может уйти в минус
            objectName.setOneBiteFoodEat(plate.getFood());//разовая порция стала меньше (равна остатку в тарелке)
            objectName.catEat(plate);
        } else {
            objectName.catEat(plate);
        }
    }
    private static int countExtraFood (Cat[] cats) {
        //дополнительное количество корма, если есть голодные коты
        int extraFood = 0;
        for (Cat cat : cats) {
            if (!cat.getSatiety()) {
                extraFood = extraFood + cat.getAppetite();
            }
        }
        return extraFood;
    }

    private static boolean isAllCatSatiety(Cat[] cats) {
        //проверка все ли коты сыты
        int counter = 0;
        for (Cat cat : cats) {
            if (cat.getSatiety()) {
                counter++;
            }
        }
        return counter == cats.length;
    }
}
