package lesson_5.comp;

import java.text.MessageFormat;

public class PowerSupply {
    private String model;
    private int power;
    private String form;

    public PowerSupply(String model, int power, String form) {
        this.model = model;
        this.power = power;
        this.form = form;
    }

    public void print(){
        System.out.println(MessageFormat.format("{0} {1} {2}", model, power, form));
    }
}
