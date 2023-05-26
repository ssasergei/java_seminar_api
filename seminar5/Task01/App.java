package Task01;

/*
 *  Подсчитать количество искомого слова, через map 
 *  (наполнением значение, где искомое слово будет являться ключом), 
 *  вносить все слова не нужно
 */
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Task01
 */
public class App {
    public static void main(String[] args) {
        String source = Read("seminar5/Task01/source.txt");
        source = source.toLowerCase().replaceAll("\\p{Punct}", "").replaceAll( "[\\\t|\\\n|\\\r]"," ");
        Map<String, Integer> dictionary = CreateMap(source);
        String request = GetRequest();
        System.out.println(request + " -> " + Find(dictionary, request));
    }

    /**
     * Ищет слово в словаре
     * 
     * @param dictionary
     * @param request
     * @return
     */
    private static Integer Find(Map<String, Integer> dictionary, String request) {
        if(dictionary.containsKey(request)) {
            return dictionary.get(request);
        }        
        return null;
    }

    /**
     * Формирует словарь слов
     * 
     * @param source
     * @return
     */
    private static Map<String, Integer> CreateMap(String source) {
        String[] words = source.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if(!map.containsKey(word)){
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        return map;
    }

    /**
     * Читаем запрос из консоли
     * 
     * @return
     */
    private static String GetRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter word for search: ");
        String request = scanner.next();
        scanner.close();
        return request.trim().toLowerCase();
    }

    /**
     * Читает данные из файла
     * 
     * @param path
     * @return
    */
    private static String Read(String path) {
        try {
            return Files.readString(Paths.get(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

/*
 * OUTPUT===========================
 * Enter word for search: horse
 * horse -> 4
 * 
 * OUTPUT===========================
 * Enter word for search: the
 * the -> 5164
 * 
 * OUTPUT===========================
 * Enter word for search: rider
 * rider -> null
 */