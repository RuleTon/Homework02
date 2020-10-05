package Homework02_03;

public class Homework_02_03_02 {

    public static void main(String[] args){
        System.out.println("Создаем справочник");
        Phonebook phonebook = new Phonebook();
        System.out.println("-----------------");

        System.out.println("Наполняем справочник");
        phonebook.add("Иванов", "22334442");
        phonebook.add("Еремеев", "22334411123");
        phonebook.add("Масальцев", "2233449944");
        phonebook.add("Антовнов", "2233448855");
        phonebook.add("Иванов", "2233442266");
        System.out.println("-----------------");

        System.out.println("Получаем номера");
        System.out.println("Иванов");
        System.out.println(phonebook.get("Иванов"));
        System.out.println("Еремеев");
        System.out.println(phonebook.get("Еремеев"));
        System.out.println("Масальцев");
        System.out.println(phonebook.get("Масальцев"));
        System.out.println("Антовнов");
        System.out.println(phonebook.get("Антовнов"));
        System.out.println("-----------------");

        System.out.println("Добавляем номер");
        phonebook.add("Масальцев", "223344786");
        System.out.println("Масальцев");
        System.out.println(phonebook.get("Масальцев"));
    }
}
