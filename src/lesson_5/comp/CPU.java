package lesson_5.comp;

import java.text.MessageFormat;

public class CPU {
    private String model;
    private String socket;
    private String core;
    private int coreCount;
    private int baseFrequency;
    private String memoryType;
    private int maxMemory;
    private boolean integratedGraphicCore;
    private String integratedGraphicName;

    CPU(String model, String socket, String core, int coreCount, int baseFrequency, String memoryType, int maxMemory, boolean integratedGraphicCore, String integratedGraphicName) {
        this.model = model;
        this.socket = socket;
        this.core = core;
        this.coreCount = coreCount;
        this.baseFrequency = baseFrequency;
        this.memoryType = memoryType;
        this.maxMemory = maxMemory;
        this.integratedGraphicCore = integratedGraphicCore;
        this.integratedGraphicName = integratedGraphicName;
    }

    public void print(){
        System.out.println(MessageFormat.format("{0} {1} {2} {3} {4} {5} {6} {7} {8}", model,
                socket, core, coreCount, baseFrequency, memoryType, maxMemory, integratedGraphicCore, integratedGraphicName));

    }
}
