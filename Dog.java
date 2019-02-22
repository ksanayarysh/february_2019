
public class Dog extends Animal {
    private double maxSwim;

    public Dog(String name) {
        super(name);
        this.maxJump = 0.5;
        this.maxRun = 500.0;
        this.maxSwim = 10.0;
    }

    public Dog(String name, double maxRun, double maxJump, double maxSwim) {
        super(name, maxRun, maxJump);
        this.maxSwim = maxSwim;
    }

    public void swim(double length) {
        if (length <= maxSwim) System.out.println(name + " swims " + length + " : true");
        else System.out.println(name + " swims " + length + " : false") ;
    }
}
