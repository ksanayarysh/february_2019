package lesson_5.comp;

public class MainComp {
    public static void main(String[] args) {

        CPU cpu = new CPU("Intel Core i5-8400", "LGA 1151-v2", "Coffee Lake S", 6, 2800, "DDR4", 64, true, "Intel UHD Graphics 630");
        HDD hdd = new HDD("Seagate 7200 BarraCuda [ST1000DM010]", 1, "SATA III", 210);
        RAM ram = new RAM("DDR4", 2400, 1, "DIMM", "Corsair ValueSelect [CMV8GX4M1A2400C16]");
        Video v = new Video("Palit GeForce RTX 2080 DUAL", "GeForce RTX 2080", 8, "GDDR6", true, "7680x4320", false);

        Motherboard m = new Motherboard(cpu, v, ram);
        PowerSupply ps = new PowerSupply("SEASONIC FOCUS Plus SSR-650PX", 650, "АТХ12V");
        Computer c = new Computer(m, ps, hdd);
        c.print();
    }
}
