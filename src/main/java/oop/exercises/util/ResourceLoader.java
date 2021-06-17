package oop.exercises.util;

public class ResourceLoader {

    private static final String DIR = System.getProperty("user.dir") + "/src/main/resources";

    private ResourceLoader() {}

    public static FileLoader get() {
        return new FileLoader(DIR);
    }
}
