public class Cat extends Animal {
    public Cat(String name) {
        super(name);
        maxJump = 2.0;
        maxRun = 200.0;
    }

    public Cat(String name, double maxRun, double maxJump) {
        super(name, maxRun, maxJump);
    }
}
