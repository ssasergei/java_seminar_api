package Application.UI;

import Application.BusinessLogic.Catalogue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class FilterHandlers {
    private Catalogue catalogue;
    private LinkedList<Map<Integer, String>> stack;
    private Map<String, Integer> filters;
    private Map<Integer, String> mainMenu;
    private Map<Integer, String> cpuMenu;
    private Map<Integer, String> gpuMenu;
    private Map<Integer, String> ramMenu;
    private Map<Integer, String> romMenu;

    public FilterHandlers(Catalogue catalogue) {
        this.catalogue = catalogue;
        this.stack = new LinkedList<>();
        this.filters = new HashMap<>();

        this.setMainMenu();
        this.setCpuMenu();
        this.setGpuMenu();
        this.setRamMenu();
        this.setRomMenu();

    }

    public Integer handler() {
        int exitCode = 400;

        this.stack.add(this.mainMenu);
        while (!this.stack.isEmpty()) {
            Map<Integer, String> currentMenu = this.stack.getLast();
            if (currentMenu == this.mainMenu) {
                this.showMenu(currentMenu);
                exitCode = this.mainMenuHandler();
            } else if (currentMenu == this.cpuMenu) {
                this.showMenu(currentMenu);
                this.cpuMenuHandler();
            } else if (currentMenu == this.gpuMenu) {
                this.showMenu(currentMenu);
                this.gpuMenuHandler();
            } else if (currentMenu == this.ramMenu) {
                this.showMenu(currentMenu);
                this.ramMenuHandler();
            } else if (currentMenu == this.romMenu) {
                this.showMenu(currentMenu);
                this.romMenuHandler();
            } else {
                System.out.println("No such handler exception...");
                exitCode = 404;
                break;
            }

            if (exitCode == 100 || exitCode == 200) {
                this.stack.clear();
            }
        }
        return exitCode;
    }

    private void showMenu(Map<Integer, String> menu) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, String> row :
                menu.entrySet()) {
            stringBuilder.append(String.format("\n%d. %s", row.getKey(), row.getValue()));
        }
        System.out.println(stringBuilder);
    }

    private void setMainMenu() {
        this.mainMenu = new HashMap<>();
        this.mainMenu.put(1, "Apply filters");
        this.mainMenu.put(2, "Filter by CPU");
        this.mainMenu.put(3, "Filter by GPU");
        this.mainMenu.put(4, "Filter by RAM");
        this.mainMenu.put(5, "Filter by ROM");
        this.mainMenu.put(6, "Reset filters");
        this.mainMenu.put(7, "Go back");
        this.mainMenu.put(8, "Exit");
    }

    private Integer mainMenuHandler() {
        int exitCode = 400;

        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        switch (scanner.nextInt()) {
            // Apply filters
            case 1: {
                System.out.println("\nCase: ...Apply filters...");
                this.catalogue.setUpDataFiltering(this.filters);
                break;
            }
            // Filter by CPU:
            case 2: {
                System.out.println("\nCase: ...Filter by CPU...");
                this.stack.add(this.cpuMenu);
                break;
            }
            // Filter by GPU:
            case 3:{
                System.out.println("\nCase: ...Filter by GPU...");
                this.stack.add(this.gpuMenu);
                break;
            }
            // Filter by RAM:
            case 4:{
                System.out.println("\nCase: ...Filter by RAM...");
                this.stack.add(this.ramMenu);
                break;
            }
            // Filter by ROM:
            case 5:{
                System.out.println("\nCase: ...Filter by ROM...");
                this.stack.add(this.romMenu);
                break;
            }
            // Reset filters:
            case 6:{
                System.out.println("\nCase: ...Reset filters...");
                this.filters.clear();
                this.catalogue.resetDataFiltering();
                break;
            }
            // Go back:
            case 7:{
                exitCode = 100;
                break;
            }
            // Exit without Exception:
            case 8:{
                exitCode = 200;
                break;
            }
            // Exit with Exception:
            default:{
                System.out.println("\nCase: ...Exception...");
                exitCode = 404;
                break;
            }
        }
        return exitCode;
    }

    private void setCpuMenu() {
        this.cpuMenu = new HashMap<>();
        this.cpuMenu.put(1, "Set max total cores (...)");
        this.cpuMenu.put(2, "Reset max total cores");
        this.cpuMenu.put(3, "Set min total cores (...)");
        this.cpuMenu.put(4, "Reset min total cores");
        this.cpuMenu.put(5, "Set max total threats (...)");
        this.cpuMenu.put(6, "Reset max total threats");
        this.cpuMenu.put(7, "Set min total threats (...)");
        this.cpuMenu.put(8, "Reset min total threats");
        this.cpuMenu.put(9, "Set max base clock (...)");
        this.cpuMenu.put(10, "Reset max base clock");
        this.cpuMenu.put(11, "Set min base clock (...)");
        this.cpuMenu.put(12, "Reset min base clock");
        this.cpuMenu.put(13, "Set max boost clock (...)");
        this.cpuMenu.put(14, "Reset max boost clock");
        this.cpuMenu.put(15, "Set min boost clock (...)");
        this.cpuMenu.put(16, "Reset min boost clock");
        this.cpuMenu.put(17, "Go back");
    }

    private void cpuMenuHandler() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        switch (scanner.nextInt()) {
            case 1: {
                System.out.println("\nCase: ...Set filter CpuMaxTotalCores...");
                this.setFilterCpuMaxTotalCores();
                break;
            }
            case 2: {
                System.out.println("\nCase: ...Reset filter CpuMaxTotalCores...");
                this.resetFilterCpuMaxTotalCores();
                break;
            }
            case 3: {
                System.out.println("\nCase: ...Set filter CpuMinTotalCores...");
                this.setFilterCpuMinTotalCores();
                break;
            }
            case 4: {
                System.out.println("\nCase: ...Reset filter CpuMinTotalCores...");
                this.resetFilterCpuMinTotalCores();
                break;
            }
            case 5: {
                System.out.println("\nCase: ...Set filter CpuMaxTotalThreats...");
                this.setFilterCpuMaxTotalThreats();
                break;
            }
            case 6: {
                System.out.println("\nCase: ...Reset filter CpuMaxTotalThreats...");
                this.resetFilterCpuMaxTotalThreats();
                break;
            }
            case 7: {
                System.out.println("\nCase: ...Set filter CpuMinTotalThreats...");
                this.setFilterCpuMinTotalThreats();
                break;
            }
            case 8: {
                System.out.println("\nCase: ...Reset filter CpuMinTotalThreats...");
                this.resetFilterCpuMinTotalThreats();
                break;
            }
            case 9: {
                System.out.println("\nCase: ...Set filter CpuMaxBaseClock...");
                this.setFilterCpuMaxBaseClock();
                break;
            }
            case 10: {
                System.out.println("\nCase: ...Reset filter CpuMaxBaseClock...");
                this.resetFilterCpuMaxBaseClock();
                break;
            }
            case 11: {
                System.out.println("\nCase: ...Set filter CpuMinBaseClock...");
                this.setFilterCpuMinBaseClock();
                break;
            }
            case 12: {
                System.out.println("\nCase: ...Reset filter CpuMinBaseClock...");
                this.resetFilterCpuMinBaseClock();
                break;
            }
            case 13: {
                System.out.println("\nCase: ...Set filter CpuMaxBoostClock...");
                this.setFilterCpuMaxBoostClock();
                break;
            }
            case 14: {
                System.out.println("\nCase: ...Reset filter CpuMaxBoostClock...");
                this.resetFilterCpuMaxBoostClock();
                break;
            }
            case 15: {
                System.out.println("\nCase: ...Set filter CpuMinBoostClock...");
                this.setFilterCpuMinBoostClock();
                break;
            }
            case 16: {
                System.out.println("\nCase: ...Reset filter CpuMinBoostClock...");
                this.resetFilterCpuMinBoostClock();
                break;
            }
            case 17: {
                this.stack.removeLast();
                break;
            }
            default: {
                System.out.println("\nDefault: ...No such handler exception...");
            }
        }
    }

    private void setGpuMenu() {
        this.gpuMenu = new HashMap<>();
        this.gpuMenu.put(1, "Set max base clock (...)");
        this.gpuMenu.put(2, "Reset max base clock");
        this.gpuMenu.put(3, "Set min base clock (...)");
        this.gpuMenu.put(4, "Reset min base clock");
        this.gpuMenu.put(5, "Set max max memory size (...)");
        this.gpuMenu.put(6, "Reset max max memory size");
        this.gpuMenu.put(7, "Set min max memory size (...)");
        this.gpuMenu.put(8, "Reset min max memory size");
        this.gpuMenu.put(9, "Go back");
    }

    private void gpuMenuHandler() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        switch (scanner.nextInt()) {
            case 1: {
                System.out.println("\nCase: ...Set filter GpuMaxBaseClock...");
                this.setFilterGpuMaxBaseClock();
                break;
            }
            case 2: {
                System.out.println("\nCase: ...Reset filter GpuMaxBaseClock...");
                this.resetFilterGpuMaxBaseClock();
                break;
            }
            case 3: {
                System.out.println("\nCase: ...Set filter GpuMinBaseClock...");
                this.setFilterGpuMinBaseClock();
                break;
            }
            case 4: {
                System.out.println("\nCase: ...Reset filter GpuMinBaseClock...");
                this.resetFilterGpuMinBaseClock();
            }
            case 5: {
                System.out.println("\nCase: ...Set filter GpuMaxMaxMemorySize...");
                this.setFilterGpuMaxMaxMemorySize();
                break;
            }
            case 6: {
                System.out.println("\nCase: ...Reset filter GpuMaxMaxMemorySize...");
                this.resetFilterGpuMaxMaxMemorySize();
                break;
            }
            case 7: {
                System.out.println("\nCase: ...Set filter GpuMinMaxMemorySize...");
                this.setFilterGpuMinMaxMemorySize();
                break;
            }
            case 8: {
                System.out.println("\nCase: ...Reset filter GpuMinMaxMemorySize...");
                this.resetFilterGpuMinMaxMemorySize();
                break;
            }
            case 9: {
                System.out.println("\nCase: ...Go back...");
                this.stack.removeLast();
                break;
            }
            default: {
                System.out.println("\nDefault: ...No such handler exception...");
            }
        }
    }

    private void setRamMenu() {
        this.ramMenu = new HashMap<>();
        this.ramMenu.put(1, "Set max density");
        this.ramMenu.put(2, "Reset max density");
        this.ramMenu.put(3, "Set min density");
        this.ramMenu.put(4, "Reset min density");
        this.ramMenu.put(5, "Set max speed");
        this.ramMenu.put(6, "Reset max speed");
        this.ramMenu.put(7, "Set min speed");
        this.ramMenu.put(8, "Reset min speed");
        this.ramMenu.put(9, "Go back");
    }

    private void ramMenuHandler() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        switch (scanner.nextInt()) {
            case 1: {
                System.out.println("\nCase: ...Set filter RamMaxDensity...");
                this.setFilterRamMaxDensity();
                break;
            }
            case 2: {
                System.out.println("\nCase: ...Reset filter RamMaxDensity...");
                this.resetFilterRamMaxDensity();
                break;
            }
            case 3: {
                System.out.println("\nCase: ...Set filter RamMinDensity...");
                this.setFilterRamMinDensity();
                break;
            }
            case 4: {
                System.out.println("\nCase: ...Reset filter RamMinDensity...");
                this.resetFilterRamMinDensity();
                break;
            }
            case 5: {
                System.out.println("\nCase: ...Set filter RamMaxSpeed...");
                this.setFilterRamMaxSpeed();
                break;
            }
            case 6: {
                System.out.println("\nCase: ...Reset filter RamMaxSpeed...");
                this.resetFilterRamMaxSpeed();
                break;
            }
            case 7: {
                System.out.println("\nCase: ...Set filter RamMinSpeed...");
                this.setFilterRamMinSpeed();
                break;
            }
            case 8: {
                System.out.println("\nCase: ...Reset filter RamMinSpeed...");
                this.resetFilterRamMinSpeed();
                break;
            }
            case 9: {
                System.out.println("\nCase: ...Go back...");
                this.stack.removeLast();
                break;
            }
            default: {
                System.out.println("Default: ...No such handler exception...");
            }
        }
    }

    private void setRomMenu() {
        this.romMenu = new HashMap<>();
        this.romMenu.put(1, "Set max density");
        this.romMenu.put(2, "Reset max density");
        this.romMenu.put(3, "Set min density");
        this.romMenu.put(4, "Reset min density");
        this.romMenu.put(5, "Go back");
    }

    private void romMenuHandler() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        switch (scanner.nextInt()) {
            case 1: {
                System.out.println("Case: ...Set filter RomMaxDensity...");
                this.setFilterRomMaxDensity();
                break;
            }
            case 2: {
                System.out.println("Case: ...Reset filter RomMaxDensity...");
                this.resetFilterRomMaxDensity();
                break;
            }
            case 3: {
                System.out.println("Case: ...Set filter RomMinDensity...");
                this.setFilterRomMinDensity();
                break;
            }
            case 4: {
                System.out.println("Case: ...Reset filter RomMinDensity...");
                this.resetFilterRomMinDensity();
                break;
            }
            case 5: {
                System.out.println("\nCase: ...Go back...");
                this.stack.removeLast();
                break;
            }
            default: {
                System.out.println("Default: ...No such handler exception...");
            }
        }
    }

    private void setFilterRomMinDensity() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        this.filters.put("ROM_MIN_DENSITY", scanner.nextInt());
    }

    private void resetFilterRomMinDensity() {
        this.filters.remove("ROM_MIN_DENSITY");
    }

    private void setFilterRomMaxDensity() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        this.filters.put("ROM_MAX_DENSITY", scanner.nextInt());
    }

    private void resetFilterRomMaxDensity() {
        this.filters.remove("ROM_MAX_DENSITY");
    }

    private void setFilterRamMinSpeed() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        this.filters.put("RAM_MIN_SPEED", scanner.nextInt());
    }

    private void resetFilterRamMinSpeed() {
        this.filters.remove("RAM_MIN_SPEED");
    }

    private void setFilterRamMinDensity() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        this.filters.put("RAM_MIN_DENSITY", scanner.nextInt());
    }

    private void resetFilterRamMinDensity() {
        this.filters.remove("RAM_MIN_DENSITY");
    }

    private void setFilterRamMaxSpeed() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        this.filters.put("RAM_MAX_SPEED", scanner.nextInt());
    }

    private void resetFilterRamMaxSpeed() {
        this.filters.remove("RAM_MAX_SPEED");
    }

    private void setFilterRamMaxDensity() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        this.filters.put("RAM_MAX_DENSITY", scanner.nextInt());
    }

    private void resetFilterRamMaxDensity() {
        this.filters.remove("RAM_MAX_DENSITY");
    }

    private void setFilterGpuMinMaxMemorySize() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        this.filters.put("GPU_MIN_MAX_MEMORY_SIZE", scanner.nextInt());
    }

    private void resetFilterGpuMinMaxMemorySize() {
        this.filters.remove("GPU_MIN_MAX_MEMORY_SIZE");
    }

    private void setFilterGpuMinBaseClock() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        this.filters.put("GPU_MIN_BASE_CLOCK", scanner.nextInt());
    }

    private void resetFilterGpuMinBaseClock() {
        this.filters.remove("GPU_MIN_BASE_CLOCK");
    }

    private void setFilterGpuMaxMaxMemorySize() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        this.filters.put("GPU_MAX_MAX_MEMORY_SIZE", scanner.nextInt());
    }

    private void resetFilterGpuMaxMaxMemorySize() {
        this.filters.remove("GPU_MAX_MAX_MEMORY_SIZE");
    }

    private void setFilterGpuMaxBaseClock() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        this.filters.put("GPU_MAX_BASE_CLOCK", scanner.nextInt());
    }

    private void resetFilterGpuMaxBaseClock() {
        this.filters.remove("GPU_MAX_BASE_CLOCK");
    }

    private void setFilterCpuMinBoostClock() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        this.filters.put("CPU_MIN_BOOST_CLOCK", scanner.nextInt());
    }

    private void resetFilterCpuMinBoostClock() {
        this.filters.remove("CPU_MIN_BOOST_CLOCK");
    }

    private void setFilterCpuMinBaseClock() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        this.filters.put("CPU_MIN_BASE_CLOCK", scanner.nextInt());
    }

    private void resetFilterCpuMinBaseClock() {
        this.filters.remove("CPU_MIN_BASE_CLOCK");
    }

    private void setFilterCpuMinTotalThreats() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        this.filters.put("CPU_MIN_TOTAL_THREATS", scanner.nextInt());
    }

    private void resetFilterCpuMinTotalThreats() {
        this.filters.remove("CPU_MIN_TOTAL_THREATS");
    }

    private void setFilterCpuMinTotalCores() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        this.filters.put("CPU_MIN_TOTAL_CORES", scanner.nextInt());
    }

    private void resetFilterCpuMinTotalCores() {
        this.filters.remove("CPU_MIN_TOTAL_CORES");
    }

    private void setFilterCpuMaxBoostClock() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        this.filters.put("CPU_MAX_BOOST_CLOCK", scanner.nextInt());
    }

    private void resetFilterCpuMaxBoostClock() {
        this.filters.remove("CPU_MAX_BOOST_CLOCK");
    }

    private void setFilterCpuMaxBaseClock() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        this.filters.put("CPU_MAX_BASE_CLOCK", scanner.nextInt());
    }

    private void resetFilterCpuMaxBaseClock() {
        this.filters.remove("CPU_MAX_BASE_CLOCK");
    }

    private void setFilterCpuMaxTotalThreats() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        this.filters.put("CPU_MAX_TOTAL_THREATS", scanner.nextInt());
    }

    private void resetFilterCpuMaxTotalThreats() {
        this.filters.remove("CPU_MAX_TOTAL_THREATS");
    }

    private void setFilterCpuMaxTotalCores() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n%s", ">>> ");
        this.filters.put("CPU_MAX_TOTAL_CORES", scanner.nextInt());
    }

    private void resetFilterCpuMaxTotalCores() {
        this.filters.remove("CPU_MAX_TOTAL_CORES");
    }
}
