import java.io.File;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by gorshkov on 05.06.2018.
 */
public class Main {
    public static void main(String[] args) {
        long beginMillis = System.currentTimeMillis();
        String folder0Name = "D:\\Old_D — копия\\";
        String md5FileName0 = "graphics";
        String md5FileName1 = ".md5";
        String md5FileName = md5FileName0 + md5FileName1;
        String folderName = md5FileName0 + "\\";
        String pathname = folder0Name + folderName + md5FileName;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        long initialLinesCount = LineByLineFileReader.readFileLineByLine(pathname, hashMap);
        File newFolder = new File(folder0Name + "dest_" + md5FileName0);
        newFolder.mkdir();

        Collection<String> relativePaths = hashMap.values();
        for (String relativePath :
                relativePaths) {
            System.out.println(relativePath);

            File fileSrc = new File(folder0Name + folderName + relativePath);
            File fileDest = new File(folder0Name + "dest_" + folderName + relativePath);
            if (fileSrc.renameTo(fileDest)) {
                System.out.println("file moved successfully");
            } else {
                System.out.println("file have not been moved");
            }
        }
        long endMillis = System.currentTimeMillis();
        System.out.println(endMillis - beginMillis);
    }
}
