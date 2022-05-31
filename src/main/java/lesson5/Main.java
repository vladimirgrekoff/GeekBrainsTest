//Домашнее задание, урок 5: Владимир Греков
package lesson5;

public class Main {
    public static void main(String[] args) {
        Employee[] employeeArr = new  Employee[5];


        employeeArr[0] = new Employee("Сухов Александр Сергеевич", "директор", 70000, "sukhov_as@mail.ru", 50, "89139214427");
        employeeArr[1] = new Employee("Иванов Сидор Петрович", "инженер", 40000, "ivanoff@mail.ru", 35,"89139261127");
        employeeArr[2] = new Employee("Петров Иван Сидорович", "дизайнер", 45000, "petrov_is@mail.ru",30, "89089116081");
        employeeArr[3] = new Employee("Сидоров Петр Иванович", "токарь", 55000,"sidorovpi@mail.ru",  45);
        employeeArr[4] = new Employee("Александров Сергей Зиновьевич", "сварщик", 60000,  42, "89189193017");

        printInfoEmployeeOlderAge(employeeArr, 40); //вывести список сотрудников старше 40 лет
    }

    private static void printInfoEmployeeOlderAge(Employee[] array, int limitAge) {
        //вывести информацию на сотрудников старше указанного возраста
        for (int i = 0; i < array.length; i++) {
            if (array[i].getAge() > limitAge) {
                array[i].printInfo();
            }
        }
    }


}


