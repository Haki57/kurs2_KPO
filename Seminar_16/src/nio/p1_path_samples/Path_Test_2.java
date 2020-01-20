package nio.p1_path_samples;

import java.io.File;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * TODO: have a file test.txt in the working dir...
 */
public class Path_Test_2 {
    public static void main(String[] args) throws IOException {
        //Пример строки пути для запуска в Windows
//        Path testFilePath = Paths.get(".\\test.txt");
        Path testFilePath = Paths.get("." + File.separator + "test.txt");

        System.out.println("The file name is: " + testFilePath.getFileName());
        System.out.println("It's URI is: " + testFilePath.toUri());
        System.out.println("It's absolute path is: " + testFilePath.toAbsolutePath());
        System.out.println("It's normalized path is: " + testFilePath.normalize());

        //Получение другого объекта строки по нормализованному относительному пути
        Path testPathNormalized = Paths.get(testFilePath.normalize().toString());
        System.out.println("It's normalized absolute path is: " + testPathNormalized.toAbsolutePath());

        try {
            System.out.println("It's normalized real path is: " + testFilePath.toRealPath(LinkOption.NOFOLLOW_LINKS));
        } catch (Exception ex) {
            System.out.println("got exception: " + ex);
        }
    }
}
