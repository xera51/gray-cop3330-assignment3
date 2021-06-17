package oop.exercises.util;

import java.io.*;

public class FileLoader {

    private final File searchDir;

    /**
     * Constructs a FileLoader
     *
     * <p>{@code dir} defaults to {@code System.getProperty("user.dir")}
     * @see #FileLoader(File)
     * @see #FileLoader(String)
     */
    public FileLoader() {
        this(new File(System.getProperty("user.dir")));
    }

    /**
     * Constructs a FileLoader
     *
     * @param dir directory that the FileLoader will search from
     *
     * @throws IllegalArgumentException if {@code dir} is not a directory
     */
    public FileLoader(String dir) {
        this(new File(dir));
    }

    /**
     * Constructs a FileLoader
     *
     * @param dir directory that the FileLoader will search from
     *
     * @throws IllegalArgumentException if {@code dir} is not a directory
     */
    public FileLoader(File dir) {
        if(!dir.isDirectory()) throw new IllegalArgumentException("not a directory");
        this.searchDir = dir;
    }

    /**
     * Accessor for {@code searchDir}
     *
     * @return The search directory for the {@code FileLoader}
     */
    public File getSearchDir() {
        return searchDir;
    }

    /**
     * Creates a {@code File} using {@code FileLoader}s {@code searchDir} as
     * the parent and {@code String fileName} as the child
     *
     * @param fileName name of the file
     * @return {@code File} that is in the {@code FileLoader}s search directory
     */
    public File getFile(String fileName) {
        return new File(searchDir, fileName);
    }

    /**
     * Creates a {@code File} using {@code FileLoader}s {@code searchDir} as
     * the parent and {@code File file} as the child
     *
     * @param file path of the file
     * @return {@code File} that is in the {@code FileLoader}s search directory
     */
    public File getFile(File file) {
        return new File(searchDir, file.toString());
    }

    /**
     * Creates a {@code BufferedReader} using {@code FileLoader}s {@code searchDir} as
     * the parent and {@code String fileName} as the child
     *
     * @param fileName name of the file
     * @return a {@code BufferedReader} with the file specified in {@code fileName}
     * @throws IOException if the file does not exist
     */
    public BufferedReader getBufferedReader(String fileName)
            throws IOException {
        return new BufferedReader(new FileReader(getFile(fileName)));
    }

    /**
     * Creates a {@code BufferedReader} using {@code FileLoader}s {@code searchDir} as
     * the parent and {@code File file} as the child
     *
     *
     * @param file path of the file
     * @return a {@code BufferedReader} with the file specified in {@code file}
     * @throws IOException if the file does not exist
     */
    public BufferedReader getBufferedReader(File file)
            throws IOException {
        return new BufferedReader(new FileReader(getFile(file)));
    }

    /**
     * Creates a {@code BufferedWriter} using {@code FileLoader}s {@code searchDir} as
     * the parent and {@code String fileName} as the child
     *
     * @param fileName the name of the file
     * @return a {@code BufferedWriter} with the file specified in {@code fileName}
     * @throws IOException if the file can not be found or created
     */
    public BufferedWriter getBufferedWriter(String fileName)
            throws IOException {
        return new BufferedWriter(new FileWriter(getFile(fileName)));
    }

    /**
     * Creates a {@code BufferedWriter} using {@code FileLoader}s {@code searchDir} as
     * the parent and {@code File file} as the child
     *
     * @param file the path of the file
     * @return a {@code BufferedWriter} with the file specified in {@code file}
     * @throws IOException if the file can not be found or created
     */
    public BufferedWriter getBufferedWriter(File file)
            throws IOException {
        return new BufferedWriter(new FileWriter(getFile(file)));
    }

    /**
     * Creates a {@code BufferedWriter} using {@code FileLoader}s {@code searchDir} as
     * the parent and {@code String fileName} as the child
     *
     * @param fileName the name of the file
     * @param append if {@code true}, append to the file instead of overwrite
     * @return a {@code BufferedWriter} with the file specified in {@code fileName}
     * @throws IOException if the file can not be found or created
     */
    public BufferedWriter getBufferedWriter(String fileName, boolean append)
            throws IOException {
        return new BufferedWriter(new FileWriter(getFile(fileName), append));
    }

    /**
     * Creates a {@code BufferedWriter} using {@code FileLoader}s {@code searchDir} as
     * the parent and {@code File file} as the child
     * @param file the path of the file
     * @param append if {@code true}, append to the file instead of overwrite
     * @return a {@code BufferedWriter} with the file specified in {@code file}
     * @throws IOException if the file can not be found or created
     */
    public BufferedWriter getBufferedWriter(File file, boolean append)
            throws IOException {
        return new BufferedWriter(new FileWriter(getFile(file), append));
    }
}
