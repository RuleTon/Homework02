package Homework05;

    public class Employee {
        String fullName;
        String position;
        String email;
        long phoneNumber;
        int salary;
        int age;


        public Employee (String fullName, String position, String email, long phoneNumber, int salary, int age) {

            this.fullName = fullName;
            this.position = position;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.salary = salary;
            this.age = age;
        }


        @Override
        public String toString(){
            return String.format("Имя: %s Должность: %s Email: %s  Номер телефона: %s Зарплата: %d Возраст: %d",
                    fullName, position, email, phoneNumber, salary, age);}

        public void info() {
            System.out.println(this);
        }

    }


