//Домашнее задание, урок 7: Владимир Греков
package lesson7;

import java.util.concurrent.ThreadLocalRandom;

public class Cat {
    private String name;
    private int appetite;

    private int oneBiteFoodEat;

    private boolean satiety;

    public Cat (String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getAppetite() {
        return this.appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public int getOneBiteFoodEat() {//может съесть за один укус
        setOneBiteFoodEat(ThreadLocalRandom.current().nextInt(4) + 3);
        return oneBiteFoodEat;
    }

    public void setOneBiteFoodEat(int oneBiteFoodEat) {//съедает корма за один укус
        if (appetite - oneBiteFoodEat < 0) {//аппетит не должен быть отрицательным
            oneBiteFoodEat = appetite;
        }
        this.oneBiteFoodEat = oneBiteFoodEat;
    }

    public void catEat(Plate plate) {
        if (!getSatiety()) {
            plate.decreaseFood(oneBiteFoodEat);
            this.appetite -= oneBiteFoodEat;
            System.out.printf("Кот %s съел %d гр корма.\n", name, oneBiteFoodEat);
        }
        setSatiety();
    }

    public boolean getSatiety() {
        return this.satiety;
    }

    public void setSatiety() { //сытость
        this.satiety = (this.appetite == 0);

    }

    public void catInfo() {
        if(getSatiety()) {
            System.out.println("Кот " + getName() + " наелся, умывается!!!");
        } else {
            System.out.println("Кот " + getName() + " хочет еще.");
        }
    }
}
