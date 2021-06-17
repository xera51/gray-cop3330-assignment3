package oop.exercises.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.ClassLoader.getSystemClassLoader;

public class FileLoader {

    private static String parent = System.getProperty("user.dir") + "\\src\\main\\resources";

    private FileLoader() {}

    public static Path getPath(String filename) {
        return new File(parent, filename).toPath();
    }

    public static Path getResource(String fileName) throws URISyntaxException{
        return Paths.get(getSystemClassLoader().getResource(fileName).toURI());
    }

    public static File getFile(String filename) {
        return new File(parent, filename);
    }

    public static void setParent(String filePath) {
        parent = System.getProperty("user.dir") + filePath;
    }

    public static String getParent() {
        return parent;
    }
}
