public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Peter dog", 400, 0.5, 10);
        dog.jump(0.1);
        dog.run(100);
        dog.swim(11);

        System.out.println();

        Cat cat = new Cat("Sandra kitty", 300, 3);
        cat.jump(2.5);
        cat.run(250);

        System.out.println();
        System.out.println("This is a default kitty");
        Cat cat1 = new Cat("Kitty");
        cat1.jump(2.5);
        cat1.run(250);
    }
}
