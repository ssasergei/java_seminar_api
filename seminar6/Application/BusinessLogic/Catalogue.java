package Application.BusinessLogic;

import Application.Classes.Laptop;

import java.util.Map;
import java.util.Set;

public class Catalogue {
    private Map<Laptop, Integer> catalogue;
    private DataBase dataBase;

    public Catalogue(Integer dataBaseSize) {
        this.dataBase = new DataBase(dataBaseSize);
        this.catalogue = this.dataBase.getSelection();
    }

    public Map<Laptop, Integer> getCatalogue() {
        return catalogue;
    }

    public Set<Laptop> getArticles() {
        return this.catalogue.keySet();
    }

    public void setUpDataFiltering(Map<String, Integer> filter) {

        // maxFilter
        Laptop maxFilter = this.dataBase.getMAX_LAPTOP().getCopy();
        maxFilter.getCpu().setTotalCores(filter.getOrDefault("CPU_MAX_TOTAL_CORES", maxFilter.getCpu().getTotalCores()));
        maxFilter.getCpu().setTotalThreats(filter.getOrDefault("CPU_MAX_TOTAL_THREATS", maxFilter.getCpu().getTotalThreats()));
        maxFilter.getCpu().setBaseClock(filter.getOrDefault("CPU_MAX_BASE_CLOCK", maxFilter.getCpu().getBaseClock()));
        maxFilter.getCpu().setBoostClock(filter.getOrDefault("CPU_MAX_BOOST_CLOCK", maxFilter.getCpu().getBoostClock()));

        maxFilter.getGpu().setBaseClock(filter.getOrDefault("GPU_MAX_BASE_CLOCK", maxFilter.getGpu().getBaseClock()));
        maxFilter.getGpu().setMaxMemorySize(filter.getOrDefault("GPU_MAX_MAX_MEMORY_SIZE", maxFilter.getGpu().getMaxMemorySize()));

        maxFilter.getRam().setDensity(filter.getOrDefault("RAM_MAX_DENSITY", maxFilter.getRam().getDensity()));
        maxFilter.getRam().setSpeed(filter.getOrDefault("RAM_MAX_SPEED", maxFilter.getRam().getSpeed()));

        maxFilter.getRom().setDensity(filter.getOrDefault("ROM_MAX_DENSITY", maxFilter.getRom().getDensity()));

        // minFilter
        Laptop minFilter = this.dataBase.getMIN_LAPTOP().getCopy();
        minFilter.getCpu().setTotalCores(filter.getOrDefault("CPU_MIN_TOTAL_CORES", minFilter.getCpu().getTotalCores()));
        minFilter.getCpu().setTotalThreats(filter.getOrDefault("CPU_MIN_TOTAL_THREATS", minFilter.getCpu().getTotalThreats()));
        minFilter.getCpu().setBaseClock(filter.getOrDefault("CPU_MIN_BASE_CLOCK", minFilter.getCpu().getBaseClock()));
        minFilter.getCpu().setBoostClock(filter.getOrDefault("CPU_MIN_BOOST_CLOCK", minFilter.getCpu().getBoostClock()));

        minFilter.getGpu().setBaseClock(filter.getOrDefault("GPU_MIN_BASE_CLOCK", minFilter.getGpu().getBaseClock()));
        minFilter.getGpu().setMaxMemorySize(filter.getOrDefault("GPU_MIN_MAX_MEMORY_SIZE", minFilter.getGpu().getMaxMemorySize()));

        minFilter.getRam().setDensity(filter.getOrDefault("RAM_MIN_DENSITY", minFilter.getRam().getDensity()));
        minFilter.getRam().setSpeed(filter.getOrDefault("RAM_MIN_SPEED", minFilter.getRam().getSpeed()));

        minFilter.getRom().setDensity(filter.getOrDefault("ROM_MIN_DENSITY", minFilter.getRom().getDensity()));

        this.dataBase.select(minFilter, maxFilter);
        this.catalogue = this.dataBase.getSelection();
    }

    public void resetDataFiltering() {
        this.dataBase.resetSelection();
        this.catalogue = this.dataBase.getSelection();
    }

}
