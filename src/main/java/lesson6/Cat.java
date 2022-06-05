//Домашнее задание, урок 6: Владимир Греков
package lesson6;



public class Cat extends Animal {
    private static final int LIMIT_CAT_AGE = 30;
    private static final int LIMIT_RUNNING_DISTANCE = 200;
    private static final int LIMIT_SWIMMING_DISTANCE = 0;

    private static int catCount = 0;
    private int catNumber;


    public Cat(String name) {
        super(name);
        Cat.catCount++;
        catNumber = getCatCount();
    }

    public Cat(String name, String color) {
        super(name, color);
        Cat.catCount++;
        catNumber = getCatCount();
    }
    public Cat(String name, String color, int age) {
        super(name, color);
        setCatAge(age);
        Cat.catCount++;
        catNumber = getCatCount();
        setCatSound();
    }

    public String getCatName() {
        return super.getName();
    }

    public void setCatCount(int catCount) {
        Cat.catCount = catCount;
    }

    public int getCatCount() {
        return catCount;
    }

    public int getCatNumber() {
        return catNumber;
    }
    public String getCatColor() {
        return super.getColor();
    }

    public int getCatAge() {
        return super.getAge();
    }

    public void setCatAge(int age) {
        String strWarning1 = "Возраст кота - положительное значение не больше 30";
        String strWarning2 = "Введите цифрами правильный возраст кота";
        super.setAge(age, LIMIT_CAT_AGE, strWarning1, strWarning2 );
    }

    public void catPrintInfo(){
        System.out.println(this.ToString());
    }
    public String ToString() {
        return String.format("Кот %d: %s, окрас %s, возраст: %d", getCatNumber(), getName(), getCatColor(), getCatAge());
    }

    public static void catCountInfo() {
        System.out.println("Всего котов: " + Cat.catCount);
    }

    public void voice() {
        System.out.println(getCatSound());
    }


    public void setCatSound() {
        String strVoice = "Мяу-мяу!";
        super.setSound(strVoice);
    }

    public String getCatSound() {
        return super.getSound();
    }


    public void running(int runDistance) throws InterruptedException {
        int relaxDistance;
        int intStep;

        if (getCatAge() <= 2) {
            relaxDistance = 50;
            intStep = 20;
            super.running(runDistance, intStep, relaxDistance, LIMIT_RUNNING_DISTANCE);
        } else if (getAge() <= 7) {
            relaxDistance = 80;
            intStep = 30;
            super.running(runDistance, intStep, relaxDistance, LIMIT_RUNNING_DISTANCE);
        } else {
            relaxDistance = 40;
            intStep = 15;
            super.running(runDistance, intStep, relaxDistance, LIMIT_RUNNING_DISTANCE);
        }

    }
    public String swimming(int runDistance) {
        String strDistance = "";

        if (getCatAge() <= 2) {
            strDistance = "Кот " + getCatName() + " увидел воду, развернулся и погнался за бабочкой.";
        } else if (getCatAge() <= 7) {
            strDistance = "Кот " + getCatName() + " увидел воду, развернулся и, увидев птичек, пошел охотится.";
        } else {
            strDistance = "Кот " + getCatName() + " увидел воду, развернулся и пошел поваляться в травке.";
        }
        return strDistance;
    }

}
