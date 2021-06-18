package oop.exercises.util;

/**
 * Factory for {@code FileLoader} for resources directory
 */
public class ResourceLoader {

    private static final String DIR = System.getProperty("user.dir") + "/src/main/resources";

    private ResourceLoader() {}

    public static FileLoader get() {
        return new FileLoader(DIR);
    }
}
