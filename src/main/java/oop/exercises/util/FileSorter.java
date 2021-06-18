package oop.exercises.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class for sorting content within files
 * <p>All methods search for files using {@code FileLoader loader}
 * <p>Therefore, absolute file names are not handled
 * @see FileLoader
 */
public class FileSorter {

    /**
     * Files are loaded using the {@code FileLoader}
     */
    private final FileLoader loader;

    /**
     * Constructs a {@code FileSorter}
     *
     * <p>{@code loader.dir} defaults to {@code System.getProperty("user.dir")}
     *
     * @see #FileSorter(FileLoader)
     */
    public FileSorter() {
        this(System.getProperty("user.dir"));
    }

    /**
     * Constructs a {@code FileSorter}
     *
     * @param dir directory that the {@code FileLoader} will search from
     *
     * @see #FileSorter(FileLoader)
     */
    public FileSorter(String dir) {
        this(new File(dir));
    }

    /**
     * Constructs a {@code FileSorter}
     *
     * @param dir directory that the {@code FileLoader} will search from
     *
     * @see #FileSorter(FileLoader)
     */
    public FileSorter(File dir) {
        this(new FileLoader(dir));
    }

    /**
     * Constructs a {@code FileSorter}
     *
     * @param loader {@code FileLoader} that the {@code FileSorter} will use
     */
    public FileSorter(FileLoader loader) {
        this.loader = loader;
    }

    /**
     * Accessor for the {@code FileLoader}
     *
     * @return This {@code FileSorter}'s {@code FileLoader}
     */
    public FileLoader getLoader() {
        return loader;
    }

    /**
     * Accessor for the {@code FileSorter}'s search directory
     *
     * @return This {@code FileSorter}'s search directory
     */
    public File getSearchDir() {
        return loader.getSearchDir();
    }

    /**
     * Sorts a file by its lines lexicographically
     *
     * @param fileName path to the file, relative to the search directory
     * @throws IOException if the file cannot be found
     */
    public void sortByLines(String fileName)
            throws IOException {
        sortByLines(getLinesSorted(fileName), loader.getBufferedWriter(fileName));
    }

    /**
     * Sorts a file by its lines lexicographically
     *
     * @param file path to the file, relative to the search directory
     * @throws IOException if the file cannot be found
     */
    public void sortByLines(File file)
            throws IOException{
        sortByLines(getLinesSorted(file), loader.getBufferedWriter(file));
    }

    /**
     * Sorts the input file by its lines lexicographically,
     * putting the results in the output file
     *
     * @param inFileName path to the input file, relative to the search directory
     * @param outFileName path to the output file, relative to the search directory
     * @throws IOException if the input file cannot be
     * found or the output file could not be found or created
     */
    public void sortByLines(String inFileName, String outFileName)
            throws IOException {
        sortByLines(getLinesSorted(inFileName), loader.getBufferedWriter(outFileName));
    }

    /**
     * Sorts the input file by its lines lexicographically,
     * putting the results in the output file
     *
     * @param inFile path to the input file, relative to the search directory
     * @param outFile path to the output file, relative to the search directory
     * @throws IOException if the input file cannot be
     * found or the output file could not be found or created
     */
    public void sortByLines(File inFile, File outFile)
            throws IOException {
        sortByLines(getLinesSorted(inFile), loader.getBufferedWriter(outFile));
    }

    /**
     * Implementation of {@code sortByLines}
     *
     * @param in file to read from
     * @param out file to write to
     * @throws IOException if a file could not be found or created
     *
     * @see #sortByLines(String)
     * @see #sortByLines(File)
     * @see #sortByLines(String, String)
     * @see #sortByLines(File, File)
     */
    private void sortByLines(Stream<String> in, BufferedWriter out)
            throws IOException{
        out.write(linesToString(in));
        out.close();
    }

    /**
     * Returns the lines of file sorted as a {@code Stream<String>}
     *
     * @param fileName name of the file
     * @return the lines of file sorted
     * @throws IOException if the file cannot be found
     */
    public Stream<String> getLinesSorted(String fileName)
            throws IOException{
        return loader.getLines(fileName).sorted();
    }

    /**
     * Returns the lines of file sorted as a {@code Stream<String>}
     *
     * @param file name of the file
     * @return the lines of file sorted
     * @throws IOException if the file cannot be found
     */
    public Stream<String> getLinesSorted(File file)
            throws IOException{
        return loader.getLines(file).sorted();
    }

    /**
     * Converts a {@code Stream<String>} of lines into a {@code String}
     * separated by a platform-dependent line separator
     *
     * @param lines lines of a file
     * @return {@code String} of lines
     */
    public String linesToString(Stream<String> lines) {
        return lines.collect(Collectors.joining(System.lineSeparator()));
    }

    /**
     * Override for {@code Object toString()}
     *
     * @return A string representation of {@code FileSorter}
     */
    @Override
    public String toString() {
        return String.format("FileSorter searching from: %s", getSearchDir());
    }
}
