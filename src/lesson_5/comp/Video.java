package lesson_5.comp;

import java.text.MessageFormat;

public class Video {
    private  String model;
    private String cpu;
    private int memory;
    private String memoryType;
    private boolean isPCI;
    private String maxResolution;
    private boolean isLowProfile;

    public Video(String model, String cpu, int memory, String memoryType, boolean isPCI, String maxResolution, boolean isLowProfile) {
        this.model = model;
        this.cpu = cpu;
        this.memory = memory;
        this.memoryType = memoryType;
        this.isPCI = isPCI;
        this.maxResolution = maxResolution;
        this.isLowProfile = isLowProfile;
    }

    public void print(){
        System.out.println(MessageFormat.format("{0} {1} {2} {3} {4} {5} {6}", model,
                cpu, memory, memoryType, isPCI, maxResolution, isLowProfile));
    }
}
