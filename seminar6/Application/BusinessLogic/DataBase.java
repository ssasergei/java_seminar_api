package Application.BusinessLogic;

import Application.Classes.HardwareAndSoftware.*;
import Application.Classes.Laptop;

import java.util.*;

public class DataBase {
    private Map<Laptop, Integer> selection;
    private Map<Laptop, Integer> dataBase;

    private CPU MIN_CPU;
    private CPU MAX_CPU;
    private GPU MIN_GPU;
    private GPU MAX_GPU;
    private RAM MIN_RAM;
    private RAM MAX_RAM;
    private ROM MIN_ROM;
    private ROM MAX_ROM;
    private Laptop MIN_LAPTOP;
    private Laptop MAX_LAPTOP;

    public DataBase(Integer dataBaseSize) {
        this.dataBase = new HashMap<>();
        this.selection = new HashMap<>();

        this.fillDataBase(dataBaseSize);

        this.MAX_LAPTOP = new Laptop(this.MAX_CPU, this.MAX_GPU, this.MAX_RAM, this.MAX_ROM, new OS("MAX", "SPEC"));
        this.MIN_LAPTOP = new Laptop(this.MIN_CPU, this.MIN_GPU, this.MIN_RAM, this.MIN_ROM, new OS("MIN", "SPEC"));
    }

    private void fillDataBase(Integer dbSize) {
        Map<CPU, Integer> cpus = getCPUs();
        List<CPU> cpuSet = new ArrayList<>(cpus.keySet());

        Map<GPU, Integer> gpus = getGPUs();
        List<GPU> gpuSet = new ArrayList<>(gpus.keySet());

        Map<RAM, Integer> rams = getRAMs();
        List<RAM> ramSet = new ArrayList<>(rams.keySet());

        Map<ROM, Integer> roms = getROMs();
        List<ROM> romSet = new ArrayList<>(roms.keySet());

        Map<OS, Integer> oss = getOS();
        List<OS> osSet = new ArrayList<>(oss.keySet());

        Random random = new Random();
        while (this.dataBase.size() < dbSize) {
            CPU tempCPU = cpuSet.get(random.nextInt(cpuSet.size()));
            GPU tempGPU = gpuSet.get(random.nextInt(gpuSet.size()));
            RAM tempRAM = ramSet.get(random.nextInt(ramSet.size()));
            ROM tempROM = romSet.get(random.nextInt(romSet.size()));
            OS tempOS = osSet.get(random.nextInt(osSet.size()));
            Laptop tempLaptop = new Laptop(tempCPU, tempGPU, tempRAM, tempROM, tempOS);
            if (this.dataBase.containsKey(tempLaptop)) {
                continue;
            }
            this.dataBase.put(tempLaptop,
                    cpus.get(tempCPU) + gpus.get(tempGPU) + rams.get(tempRAM) + roms.get(tempROM) + oss.get(tempOS));
            this.selection.put(tempLaptop,
                    cpus.get(tempCPU) + gpus.get(tempGPU) + rams.get(tempRAM) + roms.get(tempROM) + oss.get(tempOS));
        }
    }

    private Map<CPU, Integer> getCPUs() {
        CPU cpu7950X3D = new CPU("AMD", "Ryzen™ 9 7950X3D", 16, 32, 4200, 5700);
        CPU cpu7950X = new CPU("AMD", "Ryzen™ 9 7950X", 16, 32, 4500, 5700);
        CPU cpu7900X3D = new CPU("AMD", "Ryzen™ 9 7900X3D", 12, 24, 4400, 5600);
        CPU cpu7900X = new CPU("AMD", "Ryzen™ 9 7900X", 12, 24, 4700, 5600);
        CPU cpu7900 = new CPU("AMD", "Ryzen™ 9 7900", 12, 24, 3700, 5400);
        CPU cpu7800X3D = new CPU("AMD", "Ryzen™ 7 7800X3D", 8, 16, 4200, 5000);
        CPU cpu7700X = new CPU("AMD", "Ryzen™ 7 7700X", 8, 16, 4500, 5400);
        CPU cpu7700 = new CPU("AMD", "Ryzen™ 7 7700", 8, 16, 3800, 5300);
        CPU cpu7600X = new CPU("AMD", "Ryzen™ 5 7600X", 6, 12, 4700, 5300);
        CPU cpu7600 = new CPU("AMD", "Ryzen™ 5 7600", 6, 12, 3800, 5100);
        CPU cpu13905H = new CPU("Intel®", "Core™ i9-13905H", 14, 20, 4100, 5400);
        CPU cpu13900H = new CPU("Intel®", "Core™ i9-13900H", 14, 20, 4100, 5400);
        CPU cpu13980HX = new CPU("Intel®", "Core™ i9-13980HX", 24, 32, 4000, 5600);
        CPU cpu13700HX = new CPU("Intel®", "Core™ i7-13700HX", 16, 24, 3700, 5000);
        CPU cpu1360P = new CPU("Intel®", "Core™ i7-1360P", 12, 16, 3700, 5000);
        CPU cpu1355U = new CPU("Intel®", "Core™ i7-1355U", 10, 12, 3700, 5000);
        CPU cpu13400 = new CPU("Intel®", "Core™ i5-13400", 10, 16, 1800, 4600);
        CPU cpu1340PE = new CPU("Intel®", "Core™ i5-1340PE", 12, 16, 1800, 4500);
        CPU cpu1334U = new CPU("Intel®", "Core™ i5-1334U", 10, 12, 3400, 4600);
        CPU cpu1315U = new CPU("Intel®", "Core™ i3-1315U", 6, 8, 3300, 4500);
        CPU cpu1305U = new CPU("Intel®", "Core™ i3-1305U", 5, 6, 3300, 4500);

        Map<CPU, Integer> cpus = new HashMap<>();
        cpus.put(cpu7950X3D, 0);
        cpus.put(cpu7950X, 0);
        cpus.put(cpu7900X3D, 0);
        cpus.put(cpu7900X, 0);
        cpus.put(cpu7900, 0);
        cpus.put(cpu7800X3D, 0);
        cpus.put(cpu7700X, 0);
        cpus.put(cpu7700, 0);
        cpus.put(cpu7600X, 0);
        cpus.put(cpu7600, 0);
        cpus.put(cpu13905H, 0);
        cpus.put(cpu13900H, 0);
        cpus.put(cpu13980HX, 0);
        cpus.put(cpu13700HX, 0);
        cpus.put(cpu1360P, 0);
        cpus.put(cpu1355U, 0);
        cpus.put(cpu13400, 0);
        cpus.put(cpu1340PE, 0);
        cpus.put(cpu1334U, 0);
        cpus.put(cpu1315U, 0);
        cpus.put(cpu1305U, 0);

        int maxTotalCores = Integer.MIN_VALUE;
        int maxTotalThreats = Integer.MIN_VALUE;
        int maxBaseClock = Integer.MIN_VALUE;
        int maxBoostClock = Integer.MIN_VALUE;

        int minTotalCores = Integer.MAX_VALUE;
        int minTotalThreats = Integer.MAX_VALUE;
        int minBaseClock = Integer.MAX_VALUE;
        int minBoostClock = Integer.MAX_VALUE;

        for (CPU cpu :
                cpus.keySet()) {
            int tempTotalCores = cpu.getTotalCores();
            int tempTotalThreats = cpu.getTotalThreats();
            int tempBaseClock = cpu.getBaseClock();
            int tempBoostClock = cpu.getBoostClock();

            if (tempTotalCores > maxTotalCores) maxTotalCores = tempTotalCores;
            if (tempTotalThreats > maxTotalThreats) maxTotalThreats = tempTotalThreats;
            if (tempBaseClock > maxBaseClock) maxBaseClock = tempBaseClock;
            if (tempBoostClock > maxBoostClock) maxBoostClock = tempBoostClock;

            if (tempTotalCores < minTotalCores) minTotalCores = tempTotalCores;
            if (tempTotalThreats < minTotalThreats) minTotalThreats = tempTotalThreats;
            if (tempBaseClock < minBaseClock) minBaseClock = tempBaseClock;
            if (tempBoostClock < minBoostClock) minBoostClock = tempBoostClock;
        }
        this.MAX_CPU = new CPU("MAX", "SPEC", maxTotalCores, maxTotalThreats, maxBaseClock, maxBoostClock);
        this.MIN_CPU = new CPU("MIN", "SPEC", minTotalCores, minTotalThreats, minBaseClock, minBoostClock);

        return cpus;
    }

    private Map<GPU, Integer> getGPUs() {
        GPU gpu7600MXT = new GPU("AMD", "AMD Radeon™ RX 7600M XT", 2300, 8, "GDDR6");
        GPU gpu7600M = new GPU("AMD", "Radeon™ RX 7600M", 2070, 8, "GDDR6");
        GPU gpu6850MXT = new GPU("AMD", "Radeon™ RX 6850M XT", 2463, 12, "GDDR6");
        GPU gpu6800M = new GPU("AMD", "Radeon™ RX 6800M", 2300, 12, "GDDR6");
        GPU gpu6700M = new GPU("AMD", "Radeon™ RX 6700M", 2300, 10, "GDDR6");
        GPU gpu6650MXT = new GPU("AMD", "Radeon™ RX 6650M XT", 2162, 8, "GDDR6");
        GPU gpu6650M = new GPU("AMD", "Radeon™ RX 6650M", 2222, 8, "GDDR6");
        GPU gpu6600M = new GPU("AMD", "Radeon™ RX 6600M", 2177, 8, "GDDR6");
        GPU gpu6550M = new GPU("AMD", "Radeon™ RX 6550M", 2560, 4, "GDDR6");
        GPU gpu6500M = new GPU("AMD", "Radeon™ RX 6500M", 2191, 4, "GDDR6");
        GPU gpu6450M = new GPU("AMD", "Radeon™ RX 6450M", 2220, 4, "GDDR6");
        GPU gpu6300M = new GPU("AMD", "Radeon™ RX 6300M", 1512, 2, "GDDR6");
        GPU gpu4090 = new GPU("NVIDIA", "GeForce RTX 4090", 2520, 24, "GDDR6X");
        GPU gpu4080 = new GPU("NVIDIA", "GeForce RTX 4080", 2510, 16, "GDDR6X");
        GPU gpu4070Ti = new GPU("NVIDIA", "GeForce RTX 4070 Ti", 2610, 12, "GDDR6X");
        GPU gpu4070 = new GPU("NVIDIA", "GeForce RTX 4070", 2480, 12, "GDDR6X");
        GPU gpu4060Ti = new GPU("NVIDIA", "GeForce RTX 4060 Ti", 2540, 16, "GDDR6");
        GPU gpu4060 = new GPU("NVIDIA", "GeForce RTX 4060", 2460, 8, "GDDR6");
        GPU gpu3090Ti = new GPU("NVIDIA", "GeForce RTX 3090 Ti", 1860, 24, "GDDR6X");
        GPU gpu3090 = new GPU("NVIDIA", "GeForce RTX 3090", 1700, 24, "GDDR6X");
        GPU gpu3080Ti = new GPU("NVIDIA", "GeForce RTX 3080 Ti", 1670, 12, "GDDR6X");
        GPU gpu3080 = new GPU("NVIDIA", "GeForce RTX 3080", 1710, 12, "GDDR6X");
        GPU gpu3070Ti = new GPU("NVIDIA", "GeForce RTX 3070 Ti", 1770, 8, "GDDR6X");
        GPU gpu3070 = new GPU("NVIDIA", "GeForce RTX 3070", 1730, 8, "GDDR6");
        GPU gpu3060Ti = new GPU("NVIDIA", "GeForce RTX 3060 Ti", 1670, 8, "GDDR6");
        GPU gpu3060 = new GPU("NVIDIA", "GeForce RTX 3060", 1780, 12, "GDDR6");
        GPU gpu3050 = new GPU("NVIDIA", "GeForce RTX 3050", 1760, 8, "GDDR6");

        Map<GPU, Integer> gpus = new HashMap<>();
        gpus.put(gpu7600MXT, 0);
        gpus.put(gpu7600M, 0);
        gpus.put(gpu6850MXT, 0);
        gpus.put(gpu6800M, 0);
        gpus.put(gpu6700M, 0);
        gpus.put(gpu6650MXT, 0);
        gpus.put(gpu6650M, 0);
        gpus.put(gpu6600M, 0);
        gpus.put(gpu6550M, 0);
        gpus.put(gpu6500M, 0);
        gpus.put(gpu6450M, 0);
        gpus.put(gpu6300M, 0);
        gpus.put(gpu4090, 0);
        gpus.put(gpu4080, 0);
        gpus.put(gpu4070Ti, 0);
        gpus.put(gpu4070, 0);
        gpus.put(gpu4060Ti, 0);
        gpus.put(gpu4060, 0);
        gpus.put(gpu3090Ti, 0);
        gpus.put(gpu3090, 0);
        gpus.put(gpu3080Ti, 0);
        gpus.put(gpu3080, 0);
        gpus.put(gpu3070Ti, 0);
        gpus.put(gpu3070, 0);
        gpus.put(gpu3060Ti, 0);
        gpus.put(gpu3060, 0);
        gpus.put(gpu3050, 0);

        int maxBaseClock = Integer.MIN_VALUE;
        int maxMaxMemorySize = Integer.MIN_VALUE;

        int minBaseClock = Integer.MAX_VALUE;
        int minMaxMemorySize = Integer.MAX_VALUE;

        for (GPU gpu :
                gpus.keySet()) {
            int tempBaseClock = gpu.getBaseClock();
            int tempMaxMemorySize = gpu.getMaxMemorySize();

            if (tempBaseClock > maxBaseClock) maxBaseClock = tempBaseClock;
            if (tempMaxMemorySize > maxMaxMemorySize) maxMaxMemorySize = tempMaxMemorySize;

            if (tempBaseClock < minBaseClock) minBaseClock = tempBaseClock;
            if (tempMaxMemorySize < minMaxMemorySize) minMaxMemorySize = tempMaxMemorySize;
        }
        this.MAX_GPU = new GPU("MAX", "SPEC", maxBaseClock, maxMaxMemorySize, "NoMatter");
        this.MIN_GPU = new GPU("MIN", "SPEC", minBaseClock, minMaxMemorySize, "NoMatter");

        return gpus;
    }

    private Map<RAM, Integer> getRAMs() {
        RAM ram643200 = new RAM(64, 3200, "DDR4");
        RAM ram642666 = new RAM(64, 2666, "DDR4");
        RAM ram642400 = new RAM(64, 2400, "DDR4");
        RAM ram642133 = new RAM(64, 2133, "DDR4");
        RAM ram323200 = new RAM(32, 3200, "DDR4");
        RAM ram322666 = new RAM(32, 2666, "DDR4");
        RAM ram322400 = new RAM(32, 2400, "DDR4");
        RAM ram322133 = new RAM(32, 2133, "DDR4");
        RAM ram163200 = new RAM(16, 3200, "DDR4");
        RAM ram162666 = new RAM(16, 2666, "DDR4");
        RAM ram162400 = new RAM(16, 2400, "DDR4");
        RAM ram162133 = new RAM(16, 2133, "DDR4");
        RAM ram123200 = new RAM(12, 3200, "DDR4");
        RAM ram122666 = new RAM(12, 2666, "DDR4");
        RAM ram122400 = new RAM(12, 2400, "DDR4");
        RAM ram122133 = new RAM(12, 2133, "DDR4");
        RAM ram83200 = new RAM(8, 3200, "DDR4");
        RAM ram82666 = new RAM(8, 2666, "DDR4");
        RAM ram82400 = new RAM(8, 2400, "DDR4");
        RAM ram82133 = new RAM(8, 2133, "DDR4");

        Map<RAM, Integer> rams = new HashMap<>();
        rams.put(ram643200, 0);
        rams.put(ram642666, 0);
        rams.put(ram642400, 0);
        rams.put(ram642133, 0);
        rams.put(ram323200, 0);
        rams.put(ram322666, 0);
        rams.put(ram322400, 0);
        rams.put(ram322133, 0);
        rams.put(ram163200, 0);
        rams.put(ram162666, 0);
        rams.put(ram162400, 0);
        rams.put(ram162133, 0);
        rams.put(ram123200, 0);
        rams.put(ram122666, 0);
        rams.put(ram122400, 0);
        rams.put(ram122133, 0);
        rams.put(ram83200, 0);
        rams.put(ram82666, 0);
        rams.put(ram82400, 0);
        rams.put(ram82133, 0);

        int maxDensity = Integer.MIN_VALUE;
        int maxSpeed = Integer.MIN_VALUE;

        int minDensity = Integer.MAX_VALUE;
        int minSpeed = Integer.MAX_VALUE;

        for (RAM ram :
                rams.keySet()) {
            int tempDensity = ram.getDensity();
            int tempSpeed = ram.getSpeed();

            if (tempDensity > maxDensity) maxDensity = tempDensity;
            if (tempSpeed > maxSpeed) maxSpeed = tempSpeed;

            if (tempDensity < minDensity) minDensity = tempDensity;
            if (tempSpeed < minSpeed) minSpeed = tempSpeed;
        }
        this.MAX_RAM = new RAM(maxDensity, maxSpeed, "MAX SPEC");
        this.MIN_RAM = new RAM(minDensity, minSpeed, "MIN SPEC");

        return rams;
    }

    private Map<ROM, Integer> getROMs() {
        ROM rom8192NVMe = new ROM(8192, "NVMe", "SSD");
        ROM rom8192SATA = new ROM(8192, "SATA", "SSD");
        ROM rom4096NVMe = new ROM(4096, "NVMe", "SSD");
        ROM rom4096SATA = new ROM(4096, "SATA", "SSD");
        ROM rom2048NVMe = new ROM(2048, "NVMe", "SSD");
        ROM rom2048SATA = new ROM(2048, "SATA", "SSD");
        ROM rom512NVMe = new ROM(512, "NVMe", "SSD");
        ROM rom512SATA = new ROM(512, "SATA", "SSD");
        ROM rom500NVMe = new ROM(500, "NVMe", "SSD");
        ROM rom500SATA = new ROM(500, "SATA", "SSD");
        ROM rom256NVMe = new ROM(256, "NVMe", "SSD");
        ROM rom256SATA = new ROM(256, "SATA", "SSD");
        ROM rom250NVMe = new ROM(250, "NVMe", "SSD");
        ROM rom250SATA = new ROM(250, "SATA", "SSD");
        ROM rom128NVMe = new ROM(128, "NVMe", "SSD");
        ROM rom128SATA = new ROM(128, "SATA", "SSD");

        Map<ROM, Integer> roms = new HashMap<>();
        roms.put(rom8192NVMe, 0);
        roms.put(rom8192SATA, 0);
        roms.put(rom4096NVMe, 0);
        roms.put(rom4096SATA, 0);
        roms.put(rom2048NVMe, 0);
        roms.put(rom2048SATA, 0);
        roms.put(rom512NVMe, 0);
        roms.put(rom512SATA, 0);
        roms.put(rom500NVMe, 0);
        roms.put(rom500SATA, 0);
        roms.put(rom256NVMe, 0);
        roms.put(rom256SATA, 0);
        roms.put(rom250NVMe, 0);
        roms.put(rom250SATA, 0);
        roms.put(rom128NVMe, 0);
        roms.put(rom128SATA, 0);

        int maxDensity = Integer.MIN_VALUE;
        int minDensity = Integer.MAX_VALUE;

        for (ROM rom :
                roms.keySet()) {
            int tempDensity = rom.getDensity();

            if (tempDensity > maxDensity) maxDensity = tempDensity;

            if (tempDensity < minDensity) minDensity = tempDensity;
        }
        this.MAX_ROM = new ROM(maxDensity, "MAX", "SPEC");
        this.MIN_ROM = new ROM(minDensity, "MIN", "SPEC");

        return roms;
    }

    private Map<OS, Integer> getOS() {
        OS noOs = new OS("Without", "OS");
        OS DOS = new OS("Microsoft", "DOS");
        OS osWin10 = new OS("Microsoft", "Windows 10 Home");
        OS osWin10Prof = new OS("Microsoft", "Windows 10 Professional");
        OS osWin11 = new OS("Microsoft", "Windows 11 Home");
        OS osWin11Prof = new OS("Microsoft", "Windows 11 Professional");
        OS osMint = new OS("Linux", "Mint");
        OS osUbuntu = new OS("Linux", "Ubuntu");
        OS osDebian = new OS("Linux", "Debian");
        OS osMageia = new OS("Linux", "Mageia");
        OS osFedora = new OS("Linux", "Fedora");

        Map<OS, Integer> oss = new HashMap<>();
        oss.put(noOs, 0);
        oss.put(DOS, 0);
        oss.put(osWin10, 0);
        oss.put(osWin10Prof, 0);
        oss.put(osWin11, 0);
        oss.put(osWin11Prof, 0);
        oss.put(osMint, 0);
        oss.put(osUbuntu, 0);
        oss.put(osDebian, 0);
        oss.put(osMageia, 0);
        oss.put(osFedora, 0);

        return oss;
    }

    public Map<Laptop, Integer> getSelection() {
        return selection;
    }

    public void resetSelection() {
        this.selection = Map.copyOf(this.dataBase);
    }

    public void select(Laptop minValues, Laptop maxValues) {
        this.selection = new HashMap<>();
        for (Map.Entry<Laptop, Integer> laptop :
                this.dataBase.entrySet()) {
            if (laptop.getKey().moreOrEqual(minValues) && laptop.getKey().lessOrEqual(maxValues)) {
                this.selection.put(laptop.getKey(), laptop.getValue());
            }
        }
    }

    public CPU getMIN_CPU() {
        return MIN_CPU;
    }

    public CPU getMAX_CPU() {
        return MAX_CPU;
    }

    public GPU getMIN_GPU() {
        return MIN_GPU;
    }

    public GPU getMAX_GPU() {
        return MAX_GPU;
    }

    public RAM getMIN_RAM() {
        return MIN_RAM;
    }

    public RAM getMAX_RAM() {
        return MAX_RAM;
    }

    public ROM getMIN_ROM() {
        return MIN_ROM;
    }

    public ROM getMAX_ROM() {
        return MAX_ROM;
    }

    public Laptop getMIN_LAPTOP() {
        return MIN_LAPTOP;
    }

    public Laptop getMAX_LAPTOP() {
        return MAX_LAPTOP;
    }

}
