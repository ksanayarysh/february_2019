package lesson_7;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Барсик", 5));
        cats.add(new Cat("Сандра", 3));
        cats.add(new Cat("Васька", 10));
        cats.add(new Cat("Дымок", 4));
        cats.add(new Cat("Муха", 7));
        cats.add(new Cat("Кузя", 6));
        cats.add(new Cat("Пиксель", 15));
        cats.add(new Cat("Халло", 14));


        // Хозяин кормилки, является подписчиком событий от нашей встроенной в кормилку патентованной "Умной системы кормления котов!"

        Man man = new Man("Master");
        Plate plate = new Plate(10, man);
        plate.info();


        // Кормим котов

        for (Cat c : cats) {
            c.eat(plate);
            plate.info();
        }


        // Проверим какие коты голодные

        System.out.println("Статус котов: всего - " + cats.size() + ", из них голодные - " + cats.stream().filter(c -> c.isHungry()).count() +
                ", сытые - " + cats.stream().filter(c -> !c.isHungry()).count());

        System.out.println("Голодные коты:");
        cats.stream().filter(c -> c.isHungry()).forEach(System.out::println);

        System.out.println("Сытые коты:");
        cats.stream().filter(c -> !c.isHungry()).forEach(System.out::println);

    }
}
