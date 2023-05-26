package Application.Classes;

import Application.Classes.HardwareAndSoftware.*;

import java.util.Objects;

public class Laptop {
    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private ROM rom;
    private OS os;

    public Laptop(CPU centralProcessingUnit, GPU graphicsProcessingUnit, RAM randomAccessMemory, ROM readOnlyMemory, OS operatingSystemSoftware) {
        this.cpu = centralProcessingUnit;
        this.gpu = graphicsProcessingUnit;
        this.ram = randomAccessMemory;
        this.rom = readOnlyMemory;
        os = operatingSystemSoftware;
    }

    public Laptop getCopy() {
        return new Laptop(this.cpu.getCopy(), this.gpu.getCopy(), this.ram.getCopy(), this.rom.getCopy(), this.os.getCopy());
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public ROM getRom() {
        return rom;
    }

    public void setRom(ROM rom) {
        this.rom = rom;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public boolean moreOrEqual(Object object){
        if (this == object) return true;
        if (!(object instanceof Laptop laptop)) return false;
        return this.getCpu().moreOrEqual(laptop.getCpu())
                && this.getGpu().moreOrEqual(laptop.getGpu())
                && this.getRam().moreOrEqual(laptop.getRam())
                && this.getRom().moreOrEqual(laptop.getRom());
    }

    public boolean lessOrEqual(Object object) {
        if (this == object) return true;
        if (!(object instanceof Laptop laptop)) return false;
        return this.getCpu().lessOrEqual(laptop.getCpu())
                && this.getGpu().lessOrEqual(laptop.getGpu())
                && this.getRam().lessOrEqual(laptop.getRam())
                && this.getRom().lessOrEqual(laptop.getRom());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Laptop laptop)) return false;
        return Objects.equals(getCpu(), laptop.getCpu())
                && Objects.equals(getGpu(), laptop.getGpu())
                && Objects.equals(getRam(), laptop.getRam())
                && Objects.equals(getRom(), laptop.getRom())
                && Objects.equals(getOs(), laptop.getOs());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCpu(),
                            getGpu(),
                            getRam(),
                            getRom(),
                            getOs()
                            );
    }

    @Override
    public String toString() {
        return String.format("Ноутбук: процессор %s; видеокарта %s; ОЗУ %s; ПЗУ %s; ОС %s.",
                             cpu, gpu, ram, rom, os);
    }
}
