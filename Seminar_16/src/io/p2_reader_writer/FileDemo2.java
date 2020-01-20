package io.p2_reader_writer;

import java.io.*;
import java.util.Date;

public class FileDemo2 {

    static {
        System.out.println("separator: " + File.separator);
        System.out.println("pathSeparator: " + File.pathSeparator);
        System.out.println();
    }

    public static void main(String[] args){
        boolean result;
        File dir = new File("./MySubdir/");
        if(!dir.exists()){
            result = dir.mkdir();
            printResult(result, "subdirectory");
        }
        File file = new File("./MySubdir/MyFile.txt");
        try {
            result = file.createNewFile();
            printResult(result, "io/p1_file");
        } catch (IOException ioe){
            System.out.print("Got exception: " + ioe);
        }
        writeTextToFile(file);

        Date lastModifiedTime = new Date(file.lastModified());
        System.out.println("last modified: " + lastModifiedTime);
        System.out.println("text from file: " + readTextFromFile(file));

        //delete tmp file and dir ... to be deleted dir must be empty...
        System.out.println("file " + file.getName() + " deleted: " + file.delete());
        System.out.println("directory " + dir.getName() + " deleted: " + dir.delete());
    }

    private static void printResult(boolean result, String name){
        if (result)
            System.out.println("new " + name + " was created.");
        else
            System.out.println("new " + name + " was NOT created.");
    }

    private static void writeTextToFile(File file){
        String text = new Date().toString();
        try {
//            Writer writer = new FileWriter(file, true);   //todo:  see - how parameter true is used ?
            Writer writer = new FileWriter(file);
            writer.write(text);
//            writer.flush();
            writer.close(); // todo: read java docs (close does flush first)...
        } catch (IOException ioe){
            System.out.print("Got exception: " + ioe);
        }
    }

    private static String readTextFromFile(File file){
        String text = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            text = reader.readLine();
            reader.close();
        } catch (IOException ioe) {
            System.out.print("Got exception: " + ioe);
        }
        return text;
    }
}
