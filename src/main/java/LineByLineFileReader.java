import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gorshkov on 05.06.2018.
 */
public class LineByLineFileReader {

    public static long readFileLineByLine(String pathname, HashMap<String, String> hashMap) {
        long initialLinesCount = 0;
        try {
            File file = new File(pathname);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            String hashCode;
            String relativePath;
            while (line != null) {
                initialLinesCount++;
                createHashMap(hashMap, line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return initialLinesCount;
    }

    private static void createHashMap(Map<String, String> hashMap, String line) {
        String hashCode;
        String relativePath;
        hashCode = line.substring(0, 32);
        relativePath = line.substring(34, line.length());
        String put = hashMap.put(hashCode, relativePath);
    }

}