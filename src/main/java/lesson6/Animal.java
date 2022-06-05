//Домашнее задание, урок 6: Владимир Греков
package lesson6;

import java.util.Scanner;

public abstract class Animal extends Object {

    public static Scanner scanInput = new Scanner(System.in);
    private String color;
    private String name;

    private String sound;

    private int age;

    int limit_running_distance;

    private static int animalCount = 0;


    public Animal(String name) {
        this.name = name;
        animalCount++;
    }
    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
        animalCount++;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static int getAnimalCount() {
        return animalCount;
    }


    public static void setAnimalCount(int animalCount) {
        Animal.animalCount = animalCount;
    }

    public static void printCountInfo() {
        System.out.println("Всего животных: "+ Animal.getAnimalCount());
    }

    public String ToString() {
        return String.format("Животное: %s, всего животных: %d", name, Animal.getAnimalCount());
    }

    public void printInfo() {
        System.out.println(toString());
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age, int limitAge, String strWarning1, String strWarning2) {

        if ( age >= 0 && age <= limitAge) {
            this.age = age;
        } else {
            System.out.println(strWarning1);
            System.out.println(strWarning2);
            this.age = (getValidNumberFromScanner(limitAge, strWarning1, strWarning2));
        }
    }

    public static int getValidNumberFromScanner(int limitAge, String strWarning1,String strWarning2) {
        while (true) {
            if (scanInput.hasNextInt()) {
                int n = scanInput.nextInt();
                if (n >=0 && n <= limitAge) {
                    //scanInput.close();
                    return n;
                }
                System.out.println("!!! " + strWarning1);
            } else {
                System.out.println("!!! " + strWarning2);
                scanInput.next();
            }
        }
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    abstract void voice();

    public void running(int runDistance,int intStep, int relaxDistance,int limitRunningDistance) throws InterruptedException {
        limit_running_distance = limitRunningDistance;

        runPartPath( runDistance, intStep, relaxDistance);
    }



    public void runPartPath(int runDistance,int intStep, int relaxDistance) throws InterruptedException {
        int partPath = 0;

        do {

            if (runDistance - intStep < 0) {
                intStep = runDistance;
            }
            runDistance -= intStep;
            partPath += intStep;
            Thread.sleep(1000);
            System.out.println(getName() + " пробежал " + partPath);
            if (partPath % limit_running_distance == 0 || (partPath >= limit_running_distance && partPath % limit_running_distance < intStep)) {
                System.out.println(getName() + " отдыхает, устал: " + getSound());
                Thread.sleep(5000);
            } else if (relaxDistance > 0) {
                if (partPath % relaxDistance == 0 || (partPath >= relaxDistance && partPath % relaxDistance < intStep)) {
                    System.out.println(getName() + " отдыхает: " + getSound());;
                    Thread.sleep(2000);
                }
            }
        } while (runDistance > 0);

        System.out.println("Все!!! "+ getSound() + "-" + getSound());
    }
}

