package Task02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        List<String> employees = Read("seminar5/Task02/employees.txt");
        Map<String, Integer> names = GetMap(employees);
        print(names);
    }

    /**
     * Печать словаря
     * 
     * @param names
     */
    private static void print(Map<String, Integer> names) {
        names.forEach((key, value) -> System.out.println(
                "Name: " + key + "\t\t" + "Count: " + value));
    }

    /**
     * Формирует словарь имен работников
     * 
     * @param employees
     * @return
     */
    private static Map<String, Integer> GetMap(List<String> employees) {
        Map<String, Integer> names = new HashMap<>();
        for (String fullname : employees) {
            String name = fullname.split(" ")[0];
            if (!names.containsKey(name)) {
                names.put(name, 1);
            } else {
                names.replace(name, names.get(name) + 1);
            }
        }
        return sortDesc(names);
    }

    /**
     * Сортирует словарь по значению
     * 
     * @param names
     * @return
     */
    private static Map<String, Integer> sortDesc(Map<String, Integer> names) {
        Map<String, Integer> sortedMapDesc = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                int comp = names.get(str2) - names.get(str1);
                return comp == 0 ? 1 : comp;
            }
        });
        sortedMapDesc.putAll(names);
        return sortedMapDesc;
    }

    /**
     * Читает данные из файла
     * 
     * @param path
     * @return
     */
    private static List<String> Read(String path) {
        try {
            return Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

/*
 * OUTPUT ===========================
 * Name: Ivan Count: 4
 * Name: Maria Count: 3
 * Name: Anna Count: 3
 * Name: Petr Count: 2
 * Name: Marina Count: 2
 * Name: Svetlana Count: 1
 * Name: Pavel Count: 1
 * Name: Peter Count: 1
 * Name: Christina Count: 1
 */