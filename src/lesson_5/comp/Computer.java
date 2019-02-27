package lesson_5.comp;

import java.text.MessageFormat;

public class Computer {
    private Motherboard m;
    private PowerSupply ps;
    private HDD hdd;

    public Computer(Motherboard m, PowerSupply ps, HDD hdd) {
        this.m = m;
        this.ps = ps;
        this.hdd = hdd;
    }

    public void print(){
        //System.out.println(MessageFormat.format({}));
        m.print();
        hdd.print();
        ps.print();
    }

}
