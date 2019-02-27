package lesson_7;

public class Cat {
    private String name;
    private int appetite;
    private boolean hungry = true;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }

    public void eat(Plate p) {
        if (hungry && p.decreaseFood(this.appetite)) {
            System.out.println(name + " ест");
            hungry = false;
        }
    }

    @Override
    public String toString() {
        return "Кот " + name + " голоден = " + hungry;
    }
}
