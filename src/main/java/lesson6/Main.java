//Домашнее задание, урок 6: Владимир Греков
package lesson6;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Animal murzik = new Cat("Мурзик","Палевый", 3);
        Animal barsik = new Cat("Барсик", "Рыжий", 8);
        Animal vaska = new Cat("Васька", "Чёрный", 1);

        Animal bobik = new Dog("Бобик", "Чёрный", 25);
        Animal polkan = new Dog("Полкан", "Коричневый", 4);
        Animal tuzik = new Dog("Тузик", "Рыжий", 2);


        //голоса
        System.out.printf("Залаяли собаки - Бобик: %s!, Тузик: %s! и Полкан: %s! \n",  ((Dog)bobik).getDogSound(), ((Dog)tuzik).getDogSound(), ((Dog)polkan).getDogSound());
        System.out.printf("Замяукали коты - Мурзик: %s, Барсик: %s и Васька: %s \n",  ((Cat)murzik).getCatSound(), ((Cat)barsik).getCatSound(), ((Cat)vaska).getCatSound());
        System.out.println();
        //информация
        ((Cat)murzik).catPrintInfo();
        ((Cat)barsik).catPrintInfo();
        ((Cat)vaska).catPrintInfo();
        System.out.println();
        ((Dog)bobik).dogPrintInfo();
        ((Dog)polkan).dogPrintInfo();
        ((Dog)tuzik).dogPrintInfo();
        System.out.println();
        //подсчет
        Cat.catCountInfo();
        Dog.dogCountInfo();
        Animal.printCountInfo();
        System.out.println();
        //плавание
        System.out.println(((Dog)bobik).swimming(10));
        System.out.println(((Dog)polkan).swimming(10));
        System.out.println(((Dog)tuzik).swimming(10));
        System.out.println();
        System.out.println(((Cat)murzik).swimming(10));
        System.out.println(((Cat)barsik).swimming(10));
        System.out.println(((Cat)vaska).swimming(10));
        System.out.println();
        //бег
        ((Dog)polkan).running(400);
        System.out.println();
        ((Dog)tuzik).running(350);
        System.out.println();
        ((Dog)bobik).running(200);
        System.out.println();
        ((Cat)murzik).running(200);
        System.out.println();
        ((Cat)vaska).running(180);
        System.out.println();
        ((Cat)barsik).running(150);
    }
}
