package lesson_5.emp;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван", "Инженер", "123@mail.ru", "12547890", 20000.00, 20);
        employees[1] = new Employee("Петров Петр", "Product manager", "178@mail.ru", "125885252", 120000.00, 50);
        employees[2] = new Employee("Сидоров Алексей", "Project manager", "lex@mail.ru", "12547890", 40000.00, 40);
        employees[3] = new Employee("Кузнецов Сергей", "Дизайнер", "serg@mail.ru", "12547890", 50000.00, 42);
        employees[4] = new Employee("Кевин Уэйн", "Ученый", "kebin@mail.ru", "12547890", 135000.00, 60);

        for (Employee e:employees) {
            if (e.getAge() > 40) e.printEmployee();
        }

    }
}
