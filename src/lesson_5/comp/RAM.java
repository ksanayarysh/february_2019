package lesson_5.comp;

import java.text.MessageFormat;

public class RAM {
    private String gen;
    private int speed;
    private int volume;
    private String form;
    private String model;

    public RAM(String gen, int speed, int volume, String form, String model) {
        this.gen = gen;
        this.speed = speed;
        this.volume = volume;
        this.form = form;
        this.model = model;
    }

    public void print(){
        System.out.println(MessageFormat.format("{0} {1} {2} {3} {4}",
                gen, speed, volume, form, model));
    }

}
