//Домашнее задание, урок 5: Владимир Греков
package lesson5;


import java.util.Objects;

public class Employee {
    private String fullname;
    private String jobtitle;
    private String email;
    private String telephone;
    private int salary;
    private int age;

    public void printInfo() {
        System.out.println(this);
    }

    public String toString() {
        return String.format("Сотрудник: %s, должность: %s, электронная почта: %s, мобильный телефон: %s, зарплата: %d, возраст: %d", fullname, jobtitle, email, telephone, salary, age);
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public void setEmail(String email) {
        if (isMailBox(email)){
            this.email = email;
        } else {
            this.email = "отсутствует";
        }
    }

    public void setTelephone(String telephone) {
        if (isMailBox(telephone)){
            this.telephone = "отсутствует";
        } else {
            this.telephone = telephone;
        }
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullname() {
        return fullname;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    private static boolean isMailBox(String strCheckValue) {
        //является ли запись адресом электронной почты
        String[] arDelimiter = {"@","."};
        boolean result1 = false;
        boolean result2 = false;

        String[] strMailBox = strCheckValue.split("");

        for (int i = 0; i < strMailBox.length; i++) {
            if (Objects.equals(strMailBox[i], arDelimiter[0])) {
                result1 = true;
            }

            if (Objects.equals(strMailBox[i], arDelimiter[1])) {
                result2 = true;
            }
        }
        return (result1 && result1);
    }

    public Employee(String fullname, String jobtitle, int salary, int age) {
        this.fullname = fullname;
        this.jobtitle = jobtitle;
        this.email = "отсутствует";
        this.telephone = "отсутствует";
        this.salary = salary;
        this.age = age;
    }



    public Employee(String fullname, String jobtitle, String email, int salary, int age ) {
        this.fullname = fullname;
        this.jobtitle = jobtitle;
        setEmail(email);
        setTelephone(email);
        this.salary = salary;
        this.age = age;
    }



    public Employee(String fullname, String jobtitle, String email, String telephone, int salary,  int age) {
        this.fullname = fullname;
        this.jobtitle = jobtitle;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }


}




