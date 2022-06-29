//Домашнее задание, урок 6: Владимир Греков
package lesson6;

public class Dog extends Animal {
    private static final int LIMIT_DOG_AGE = 20;
    private static final int LIMIT_RUNNING_DISTANCE = 500;
    private static final int LIMIT_SWIMMING_DISTANCE = 10;
    private static int dogCount = 0;
    private int dogNumber;


    public Dog(String name) {
        super(name);
        Dog.dogCount++;
        dogNumber = getDogCount();
    }

    public Dog(String name, String color) {
        super(name, color);
        Dog.dogCount++;
        dogNumber = getDogCount();
    }

    public Dog(String name, String color, int age) {
        super(name, color);
        setDogAge(age);
        Dog.dogCount++;
        dogNumber = getDogCount();
        setDogSound();
    }

    public String getDogName() {
        return super.getName();
    }

    public void setDogCount(int dogCount) {
        Dog.dogCount = dogCount;
    }

    public int getDogCount() {
        return dogCount;
    }

    public int getDogNumber() {
        return dogNumber;
    }

    public String getDogColor() {
        return super.getColor();
    }

    public int getDogAge() {
        return super.getAge();
    }

    public void setDogAge(int age) {
        String strWarning1 = "Возраст собаки - положительное значение не больше 20";
        String strWarning2 = "Введите цифрами правильный возраст собаки";
        super.setAge(age, LIMIT_DOG_AGE, strWarning1, strWarning2);
    }

    public void dogPrintInfo() {
        System.out.println(this.ToString());
    }

    public String ToString() {
        return String.format("Пес %d: %s, окрас %s, возраст: %d", getDogNumber(), getName(), getDogColor(), getDogAge());
    }

    public static void dogCountInfo() {
        System.out.println("Всего собак: " + Dog.dogCount);
    }



    public void voice() {
        System.out.println(super.getSound());
    }


    public void setDogSound() {
        String strVoice;
        if (getDogAge() <= 2) {
            strVoice = "Тяв-тяв";
        } else if (getDogAge() <= 8) {
            strVoice = "Р-р-р-гав";
        } else {
            strVoice = "Ваф-Ваф";
        }
        super.setSound(strVoice);
    }

    public String getDogSound() {
        return super.getSound();
    }


    public void running(int runDistance) throws InterruptedException {
        int relaxDistance;
        int intStep;

        if (getDogAge() <= 2) {
            //пробежал 250, отдохнул и дальще
            relaxDistance = 300;
            intStep = 60;
            super.running(runDistance, intStep, relaxDistance, LIMIT_RUNNING_DISTANCE);
        } else if (getDogAge() <= 7) {
            // за один раз
            relaxDistance = 0;
            intStep = 40;
            super.running(runDistance, intStep, relaxDistance, LIMIT_RUNNING_DISTANCE);
        } else {
            //пробежал 200, отдохнул и еще
            relaxDistance = 200;
            intStep = 20;
            super.running(runDistance, intStep, relaxDistance, LIMIT_RUNNING_DISTANCE);
        }

    }

    public String swimming (int runDistance) {
        String strDistance = "";

        if (getDogAge() <= 2) {
            //проплыл 4,  если далеко назад
            if ((runDistance-4) > 4) {
                strDistance = "Пес " + getDogName() + " проплыл 4м, развернулся поплыл назад.";
            } else {
                strDistance = "Пес " + getDogName() + " проплыл " + runDistance + "м, добрался до берега.";
            }

        } else if (getAge() <= 7) {
            // проплыл 5, если далеко назад
            if (runDistance <= LIMIT_RUNNING_DISTANCE) {
                strDistance = "Пес " + getDogName() + " проплыл " + runDistance + "м, добрался до берега.";
            } else {
                strDistance = "Пес " + getDogName() + " проплыл 5м, развернулся поплыл назад.";
            }

        } else {
            //проплыл 3,  если далеко назад
            if ((runDistance - 3) > 3 ) {
                strDistance = "Пес " + getDogName() + " проплыл 3м, развернулся поплыл назад.";
            } else {
                strDistance = "Пес " + getDogName() + " проплыл " + runDistance + "м, добрался до берега.";
            }
        }
        return strDistance;
    }
}


