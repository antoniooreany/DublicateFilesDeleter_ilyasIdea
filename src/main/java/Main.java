import java.io.File;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by gorshkov on 05.06.2018.
 */
public class Main {
    public static void main(String[] args) {
        String md5FileName = "docs.md5";
        String folder0Name = "D:\\Old_D — копия\\";
        String folderName = "docs\\";
        String pathname = folder0Name + folderName + md5FileName;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        long initialLinesCount = LineByLineFileReader.readFileLineByLine(pathname, hashMap);

        Collection<String> relativePaths = hashMap.values();
        for (String relativePath :
                relativePaths) {
            System.out.println(relativePath);
            
            File fileSrc = new File(folder0Name + folderName + relativePath);
            if (fileSrc.renameTo(new File(folder0Name + "new_" + folderName + fileSrc.getName()))) {
                System.out.println("file moved successfully");
            } else {
                System.out.println("file have not been moved");
            }
        }
    }
}
