package lesson_7;

public class Plate {
    private int food;
    FoodSupplier owner;

    public Plate(int food, Man owner) {
        this.food = food;
        this.owner = owner;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("В тарелке " + food + " корма");
    }

    public boolean decreaseFood(int n){
        if (n <= food) {
            food -= n;
            return true;
        } else {
            owner.getFood(this);
            return false;
        }
    }

    public void addFood(int food){
        this.food += food;
    }
}
