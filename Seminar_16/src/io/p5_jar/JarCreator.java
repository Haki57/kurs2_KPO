package io.p5_jar;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.Deflater;

public class JarCreator {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String jarFileName;
    private List<String> fileNames = new ArrayList<>();
    private Manifest mf = new Manifest();

    /**
     * fileNames should be in form: com/grinkrug/io/xxx.class
     * mainClassName should be in form com.grinkrug.io.JarCreator
     *  command line:
     *  java -jar AAA.jar
     */
     private JarCreator(){
        try{
            writeString("Creating executable jar...");
            writeString("Enter jarFileName:");
            jarFileName = readString();

            String fileName;
            do{
                writeString("Enter file name to put in jar or just press Enter:");
                fileName = readString();
                if(checkFile(fileName)){
                    fileNames.add(fileName);
                }
            }while (fileName != null && fileName.length() > 0);

            writeString("Enter main class name:");
            String mainClassName = readString();

            mf.getMainAttributes().putValue("Manifest-Version", "1.0");
            mf.getMainAttributes().putValue("Created-By", "1.9"); // TODO: how and where to get it automatically?
            mf.getMainAttributes().putValue("Main-Class", mainClassName);

        }catch(IOException ie){
            System.err.println("Exception: " + ie);
        }
    }

    /**
     *
     * @param fileName the name of the file to check.
     * @return  true - if file does exist, otherwise returns false;
     */
    private boolean checkFile(String fileName){
        return  new File(fileName).isFile();
    }

    private void createJar(){

        byte[] buffer = new byte[1024];
        String[] filesToJar = fileNames.toArray(new String[fileNames.size()]);  //TODO: just use List...
        try {
            JarOutputStream jos = new JarOutputStream(new FileOutputStream(jarFileName), mf);
            // compression method:
            jos.setLevel(Deflater.DEFAULT_COMPRESSION);
            for (int i = 0; i < filesToJar.length; i++) {
                System.out.println(i);
                jos.putNextEntry(new JarEntry(filesToJar[i]));

                FileInputStream in = new FileInputStream(filesToJar[i]);
                int len;
                while ((len = in.read(buffer)) > 0)
                    jos.write(buffer, 0, len);
                jos.closeEntry();
                in.close();
            }
            jos.close();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.err.println("incorrect document");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("file not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("access error");
        }
    }

    private void writeString(String s){
        System.out.println(s);
    }
    private String readString() throws IOException {
        return br.readLine();
    }

    public static void main(String[] args){
        new JarCreator().createJar();
    }
}
