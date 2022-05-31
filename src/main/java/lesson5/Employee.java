//Домашнее задание, урок 5: Владимир Греков
package lesson5;


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
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public Employee(String fullname, String jobtitle, int salary, int age) {
        this.fullname = fullname;
        this.jobtitle = jobtitle;
        this.email = "отсутствует";
        this.telephone = "отсутствует";
        this.salary = salary;
        this.age = age;
    }

    public Employee(String fullname, String jobtitle, int salary, String email, int age) {
        this.fullname = fullname;
        this.jobtitle = jobtitle;
        this.email = email;
        this.telephone = "отсутствует";
        this.salary = salary;
        this.age = age;
    }

    public Employee(String fullname, String jobtitle, int salary, int age, String telephone ) {
        this.fullname = fullname;
        this.jobtitle = jobtitle;
        this.email = "отсутствует";
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public Employee(String fullname, String jobtitle, int salary, String email,  int age, String telephone) {
        this.fullname = fullname;
        this.jobtitle = jobtitle;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }


}




