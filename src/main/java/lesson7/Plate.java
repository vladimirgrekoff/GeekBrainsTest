//Домашнее задание, урок 7: Владимир Греков
package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return this.food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void addFood(int food) {//в тарелку добавлен корм
        this.food += food;
        System.out.println("ДОБАВЛЕНО " + this.food + " гр корма.");
    }

    public void decreaseFood(int n) {
        food -= n;
    }

    public void foodInfo() {
        System.out.printf("В тарелке находится %d гр корма.\n", getFood());
    }
}


