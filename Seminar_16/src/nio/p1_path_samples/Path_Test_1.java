package nio.p1_path_samples;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * TODO: к реальной файловой системе это не имеет отношения: у меня вообще нет диска D:
 */
public class Path_Test_1 {
    public static void main(String[] args) {

        //Пример строки создания объекта Path пути для запуска в Windows
//        Path testFilePath = Paths.get("D:\\test\\testFile.txt");
        Path testFilePath = Paths.get("D:"+ File.separator + "test" + File.separator+ "testFile.txt");

        //Вывод инормации о файле
        System.out.println("Printing file information: ");
        System.out.println("\t file name: " + testFilePath.getFileName());
        System.out.println("\t root of the path: " + testFilePath.getRoot());
        System.out.println("\t parent of the target: " + testFilePath.getParent());

        //Вывод элементов пути
        System.out.println("Printing elements of the path: ");
        for (Path element : testFilePath) {
            System.out.println("\t path element: " + element);
        }
    }
}
