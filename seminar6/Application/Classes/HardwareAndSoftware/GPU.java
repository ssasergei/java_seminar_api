package Application.Classes.HardwareAndSoftware;

import java.util.Objects;

public class GPU {
    private String manufacture;
    private String model;
    private Integer baseClock;
    private Integer maxMemorySize;
    private String memoryType;

    public GPU(String manufacture, String model, Integer baseClock, Integer maxMemorySize, String memoryType) {
        this.manufacture = manufacture;
        this.model = model;
        this.baseClock = baseClock;
        this.maxMemorySize = maxMemorySize;
        this.memoryType = memoryType;
    }

    public GPU getCopy() {
        return new GPU(this.manufacture, this.model, this.baseClock, this.maxMemorySize, this.memoryType);
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getBaseClock() {
        return baseClock;
    }

    public void setBaseClock(Integer baseClock) {
        this.baseClock = baseClock;
    }

    public Integer getMaxMemorySize() {
        return maxMemorySize;
    }

    public void setMaxMemorySize(Integer maxMemorySize) {
        this.maxMemorySize = maxMemorySize;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public boolean moreOrEqual(Object object){
        if (this == object) return true;
        if (!(object instanceof GPU gpu)) return false;
        return this.getBaseClock() >= gpu.getBaseClock()
                && this.getMaxMemorySize() >= gpu.getMaxMemorySize();
    }

    public boolean lessOrEqual(Object object) {
        if (this == object) return true;
        if (!(object instanceof GPU gpu)) return false;
        return this.getBaseClock() <= gpu.getBaseClock()
                && this.getMaxMemorySize() <= gpu.getMaxMemorySize();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof GPU gpu)) return false;
        return Objects.equals(getManufacture(), gpu.getManufacture())
               && Objects.equals(getModel(), gpu.getModel())
               && Objects.equals(getBaseClock(), gpu.getBaseClock())
               && Objects.equals(getMaxMemorySize(), gpu.getMaxMemorySize())
               && Objects.equals(getMemoryType(), gpu.getMemoryType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getManufacture(),
                            getModel(),
                            getBaseClock(),
                            getMaxMemorySize(),
                            getMemoryType()
                            );
    }

    @Override
    public String toString() {
        return String.format("%s %s, %d Hz, %d Gb, %s",
                manufacture, model, baseClock, maxMemorySize, memoryType);
    }
}
