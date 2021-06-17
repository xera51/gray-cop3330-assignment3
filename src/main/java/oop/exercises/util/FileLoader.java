package oop.exercises.util;

import java.io.*;

public class FileLoader {

    private final File searchDir;

    public FileLoader() {
        this(new File(System.getProperty("user.dir")));
    }

    public FileLoader(String dir) {
        this(new File(dir));
    }

    public FileLoader(File dir) {
        this.searchDir = dir;
    }

    public File getSearchDir() {
        return searchDir;
    }

    public File getFile(String fileName) {
        return new File(searchDir, fileName);
    }

    public File getFile(File file) {
        return new File(searchDir, file.toString());
    }

    public BufferedReader getBufferedReader(String fileName)
            throws IOException {
        return new BufferedReader(new FileReader(getFile(fileName)));
    }

    public BufferedReader getBufferedReader(File file)
            throws IOException {
        return new BufferedReader(new FileReader(getFile(file)));
    }

    public BufferedWriter getBufferedWriter(String fileName)
            throws IOException {
        return new BufferedWriter(new FileWriter(getFile(fileName)));
    }

    public BufferedWriter getBufferedWriter(File file)
            throws IOException {
        return new BufferedWriter(new FileWriter(getFile(file)));
    }

    public BufferedWriter getBufferedWriter(String fileName, boolean append)
            throws IOException {
        return new BufferedWriter(new FileWriter(getFile(fileName), append));
    }

    public BufferedWriter getBufferedWriter(File file, boolean append)
            throws IOException {
        return new BufferedWriter(new FileWriter(getFile(file), append));
    }
}
