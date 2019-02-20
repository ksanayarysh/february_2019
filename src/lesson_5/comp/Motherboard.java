package lesson_5.comp;

public class Motherboard {
    private CPU cpu;
    private Video video;
    private RAM ram;

    public Motherboard(CPU cpu, Video video, RAM ram) {
        this.cpu = cpu;
        this.video = video;
        this.ram = ram;
    }

    public void print(){
        video.print();
        cpu.print();
        ram.print();
    }
}
