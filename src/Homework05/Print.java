package Homework05;

public class Print {
    public static void main(String[] args) {


        Employee[] emplArray = new Employee[5];
            emplArray[0] = new Employee("Николай Майоров", "Разработчик", "nikolaym@gmail.com", 5553535, 1500, 32);
            emplArray[1] = new Employee("Иванов Кирилл", "Маркетолог", "kirillivanov@gmail.com", 5651035, 1300, 25);
            emplArray[2] = new Employee("Николай Майоров", "Социолог", "nikolaym@gmail.com", 5153569, 1400, 41);
            emplArray[3] = new Employee("Александр Пряхин", "Аналитик", "nikolaym@gmail.com", 5053570, 1900, 56);
            emplArray[4] = new Employee("Иван Алексеевич", "Техник", "nikolaym@gmail.com", 5853540, 1000, 26);

        System.out.println("Сотрудник 1: " + emplArray[0].fullName + "| Позиция: " + emplArray[0].position + "| Электронная почта: " + emplArray[0].email + "| Номер телефона:" + emplArray[0].phoneNumber + "| Зарплата:" + emplArray[0].salary + "| Возраст: " + emplArray[0].age);
        System.out.println("Сотрудник 1: " + emplArray[0].fullName + "| Позиция: " + emplArray[1].position + "| Электронная почта: " + emplArray[1].email + "| Номер телефона:" + emplArray[1].phoneNumber + "| Зарплата:" + emplArray[1].salary + "| Возраст: " + emplArray[1].age);
        System.out.println("Сотрудник 1: " + emplArray[0].fullName + "| Позиция: " + emplArray[2].position + "| Электронная почта: " + emplArray[2].email + "| Номер телефона:" + emplArray[2].phoneNumber + "| Зарплата:" + emplArray[2].salary + "| Возраст: " + emplArray[2].age);
        System.out.println("Сотрудник 1: " + emplArray[0].fullName + "| Позиция: " + emplArray[3].position + "| Электронная почта: " + emplArray[3].email + "| Номер телефона:" + emplArray[3].phoneNumber + "| Зарплата:" + emplArray[3].salary + "| Возраст: " + emplArray[3].age);
        System.out.println("Сотрудник 1: " + emplArray[0].fullName + "| Позиция: " + emplArray[4].position + "| Электронная почта: " + emplArray[4].email + "| Номер телефона:" + emplArray[4].phoneNumber + "| Зарплата:" + emplArray[4].salary + "| Возраст: " + emplArray[4].age);

        System.out.println("___________________________________________________________________________________________________________________________");

        for (int i = 0; i <emplArray.length; i++) {
            if (emplArray[i].age > 40) emplArray[i].info();
        }


    }
}
