//Домашнее задание, урок 5: Владимир Греков
package lesson5;

public class Main {
    public static void main(String[] args) {
        Employee[] employeeArr = new  Employee[5];


        employeeArr[0] = new Employee("Сухов Александр Сергеевич", "директор", "sukhov_as@mail.ru", "89139214427", 70000, 50);
        employeeArr[1] = new Employee("Иванов Сидор Петрович", "инженер", "ivanoff@mail.ru","89139261127", 40000, 35);
        employeeArr[2] = new Employee("Петров Иван Сидорович", "дизайнер", "petrov_is@mail.ru", "89089116081", 45000,30);
        employeeArr[3] = new Employee("Сидоров Петр Иванович", "токарь", "sidorovpi@mail.ru", 55000,  45);
        employeeArr[4] = new Employee("Александров Сергей Зиновьевич", "сварщик", "89189193017", 60000,  42);

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


