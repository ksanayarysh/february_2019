package lesson_7;

public class Man implements FoodSupplier {

    private String name;

    public Man(String name) {
        this.name = name;
    }

    @Override
    public void getFood(Plate p) {
        System.out.println(name + " добавил в тарелку корм ");
        p.addFood(10);
    }

}
