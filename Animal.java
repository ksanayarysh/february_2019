public class Animal {
    protected String name;

    protected double maxRun;
    protected double maxJump;


    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, double maxRun, double maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    public double getMaxRun() {
        return maxRun;
    }

    public void setMaxRun(double maxRun) {
        this.maxRun = maxRun;
    }

    public double getMaxJump() {
        return maxJump;
    }

    public void setMaxJump(double maxJump) {
        this.maxJump = maxJump;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void jump(double height) {
        if (height <= maxJump) System.out.println(name + " jumps " + height + " : true");
        else System.out.println(name + " jumps " + height + " : false ");
    }

    public void run(double length) {
        if (length <= maxRun) System.out.println(name + " runs " + length + " : true");
        else System.out.println(name + " runs " + length + " : false") ;
    }

}
