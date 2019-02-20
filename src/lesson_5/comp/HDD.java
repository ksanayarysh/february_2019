package lesson_5.comp;

import java.text.MessageFormat;

public class HDD {
    private String model;
    private int volume;
    private String hddInterface;
    private int speed;

    public HDD(String model, int volume, String hddInterface, int speed) {
        this.model = model;
        this.volume = volume;
        this.hddInterface = hddInterface;
        this.speed = speed;
    }
    public void print(){
        System.out.println(MessageFormat.format("{0} {1} {2} {3}", model, volume, hddInterface, speed));
    }
}
