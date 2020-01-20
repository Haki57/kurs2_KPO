package io.p1_file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileDemo {

    static {
        System.out.println("On my System File name separator is: " + File.separator);
        System.out.println("On my System File path separator is: " + File.pathSeparator);
    }

    public static void main(String[] args) {
       File fp = new File("MyFile.txt");
        try{
            boolean res = fp.createNewFile();
            if (res)
                System.out.println("file created.");
            else
                System.out.println("file already exists.");
        }catch (Exception ce) {
            ce.printStackTrace();
        }
        if(fp.exists()) {
            System.out.println(fp.getName() + " exists");

            if(fp.isFile()) {// if fp is disk file
                System.out.println("Path to file:\t" + fp.getPath());
                System.out.println("Absolute path:\t" + fp.getAbsolutePath());
                System.out.println("File size:\t" + fp.length());
                System.out.println("Last modified :\t" + new Date(fp.lastModified()));
                System.out.println("File is readable:\t" + fp.canRead());
                System.out.println("File is writable:\t" + fp.canWrite());
                System.out.println("File deleted:\t" + fp.delete());
                System.out.println("Deleted file exists? " + fp.exists());
            }
        } else
            System.out.println("File " + fp.getName() + " does not exist");
        try{
            if(fp.createNewFile())
                System.out.println("File " + fp.getName() + " created");
        } catch(IOException e) {
            System.err.println("got exception: " + e);
        }
// in object of type File some directory object is placed
// in the project root some directory named com.learn must be created with some files in it
//        File dir = new File("com" + File.separator + "learn");
        File dir = new File("com");
        File currentDir = new File(".");
        System.out.println("current.isWritable() = " + currentDir.canWrite());
        if(!dir.mkdir()){
            System.out.println("could not create dir...");
        }
        if (dir.exists() && dir.isDirectory())
            System.out.println("directory " + dir.getName() + " exists");
        File[] files = dir.listFiles();
        if(files != null)
            for (File file : files) {
                Date date = new Date(file.lastModified());
                System.out.print("\n" + file.getPath() + " \t| " + file.length() + "\t| " + date.toString());
                //use toLocaleString() or toGMTString()
            }
// listRoots() returns all root directories:
        File root = File.listRoots()[0];
        System.out.printf("\n%s %,d from %,d is free.", root.getPath(), root.getUsableSpace(), root.getTotalSpace());

        // delete tmp dir and file:
        System.out.println();
        System.out.println("directory " + dir.getName() + " deleted: " + dir.delete());
        System.out.println("file " + fp.getName() + " deleted: " + fp.delete());
    }
}
