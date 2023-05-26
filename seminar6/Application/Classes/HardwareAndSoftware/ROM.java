package Application.Classes.HardwareAndSoftware;

import java.util.Objects;

public class ROM {
    private Integer density;
    private String driveInterface;
    private String driveType;

    public ROM(Integer density, String driveInterface, String driveType) {
        this.density = density;
        this.driveInterface = driveInterface;
        this.driveType = driveType;
    }

    public ROM getCopy() {
        return new ROM(this.density, this.driveInterface, this.driveType);
    }

    public Integer getDensity() {
        return density;
    }

    public void setDensity(Integer density) {
        this.density = density;
    }

    public String getDriveInterface() {
        return driveInterface;
    }

    public void setDriveInterface(String driveInterface) {
        this.driveInterface = driveInterface;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public boolean moreOrEqual(Object object){
        if (this == object) return true;
        if (!(object instanceof ROM rom)) return false;
        return this.getDensity() >= rom.getDensity();
    }

    public boolean lessOrEqual(Object object) {
        if (this == object) return true;
        if (!(object instanceof ROM rom)) return false;
        return this.getDensity() <= rom.getDensity();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ROM rom)) return false;
        return Objects.equals(getDensity(), rom.getDensity())
                && Objects.equals(getDriveInterface(), rom.getDriveInterface())
                && Objects.equals(getDriveType(), rom.getDriveType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDensity(),
                            getDriveInterface(),
                            getDriveType()
                            );
    }

    @Override
    public String toString() {
        return String.format("%d Gb (%s, %s)", density, driveType, driveInterface);
    }
}
