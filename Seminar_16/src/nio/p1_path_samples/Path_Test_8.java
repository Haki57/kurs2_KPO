package nio.p1_path_samples;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Path_Test_8 {
    public static void main(String[] args) {
        Path path = Paths.get("user/.././root","../kodiacbear.txt");
        System.out.println(path);
        path = path.normalize(); //.relativize(Paths.get("/lion"));
        System.out.println(path);
        path = path.relativize(Paths.get("user"));
        System.out.println(path);

        Path p = Paths.get("/a/b/");
        System.out.println(p);
        p = p.relativize(Paths.get("/a/b/c/d"));
        System.out.println(p);

        // testing parents...
        System.out.println();
        printPathInfo(Paths.get("/zoo/armadillo/shells.txt"));
        System.out.println();
        printPathInfo(Paths.get("armadillo/shells.txt"));
        System.out.println();
        printPathInfo(Paths.get("C:\\birds\\condor.txt"));
        System.out.println();
        printPathInfo(Paths.get("home/birds/condor.txt"));


    }

    //TODO: compare results on MAC and Windows: results are FileSystem dependent (note of the Absolute path differs)...
    public static void printPathInfo(Path path) {
        System.out.println("path = " + path + ": isAbsolute() -> " + path.isAbsolute());
        System.out.println("fileName = " + path.getFileName());
        System.out.println("root = " + path.getRoot());
        Path currentParent = path;
        while ((currentParent = currentParent.getParent()) != null) {
            System.out.println("   current parent = " + currentParent);
        }
    }
}
