package structural.p2_composite.demo2_filesystem;

public class File implements AbstractFile {

    private String name;
    private Indentation indentation;

    public File(String name, Indentation indentation) {
        this.name = name;
        this.indentation = indentation;
    }

    public void ls() {
        System.out.println(indentation.getIndentation() + name);
    }
}
