package Application.Classes.HardwareAndSoftware;

import java.util.Objects;

public class CPU {
    private String manufacture;
    private String model;
    private Integer totalCores;
    private Integer totalThreats;
    private Integer baseClock;
    private Integer boostClock;

    public CPU(String manufacture, String model, Integer totalCores,
               Integer totalThreats, Integer baseClock, Integer boostClock) {
        this.manufacture = manufacture;
        this.model = model;
        this.totalCores = totalCores;
        this.totalThreats = totalThreats;
        this.baseClock = baseClock;
        this.boostClock = boostClock;
    }

    public CPU getCopy() {
        return new CPU(this.manufacture, this.model, this.totalCores, this.totalThreats, this.baseClock, this.boostClock);
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

    public Integer getTotalCores() {
        return totalCores;
    }

    public void setTotalCores(Integer totalCores) {
        this.totalCores = totalCores;
    }

    public Integer getTotalThreats() {
        return totalThreats;
    }

    public void setTotalThreats(Integer totalThreats) {
        this.totalThreats = totalThreats;
    }

    public Integer getBaseClock() {
        return baseClock;
    }

    public void setBaseClock(Integer baseClock) {
        this.baseClock = baseClock;
    }

    public Integer getBoostClock() {
        return boostClock;
    }

    public void setBoostClock(Integer boostClock) {
        this.boostClock = boostClock;
    }

    public boolean moreOrEqual(Object object){
        if (this == object) return true;
        if (!(object instanceof CPU cpu)) return false;
        return  this.getTotalCores() >= cpu.getTotalCores()
                && this.getTotalThreats() >= cpu.getTotalThreats()
                && this.getBaseClock() >= cpu.getBaseClock()
                && this.getBoostClock() >= cpu.getBoostClock();
    }

    public boolean lessOrEqual(Object object) {
        if (this == object) return true;
        if (!(object instanceof CPU cpu)) return false;
        return  this.getTotalCores() <= cpu.getTotalCores()
                && this.getTotalThreats() <= cpu.getTotalThreats()
                && this.getBaseClock() <= cpu.getBaseClock()
                && this.getBoostClock() <= cpu.getBoostClock();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof CPU cpu)) return false;
        return Objects.equals(getManufacture(), cpu.getManufacture())
                && Objects.equals(getModel(), cpu.getModel())
                && Objects.equals(getTotalCores(), cpu.getTotalCores())
                && Objects.equals(getTotalThreats(), cpu.getTotalThreats())
                && Objects.equals(getBaseClock(), cpu.getBaseClock())
                && Objects.equals(getBoostClock(), cpu.getBoostClock());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getManufacture(),
                            getModel(),
                            getTotalCores(),
                            getTotalThreats(),
                            getBaseClock(),
                            getBoostClock()
                            );
    }

    @Override
    public String toString() {
        return String.format("%s %s %d ядер, %d потоков, %d Hz, boost %d Hz",
                             manufacture, model, totalCores, totalThreats, baseClock, boostClock);
    }
}
