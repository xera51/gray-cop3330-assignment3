package oop.exercises.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileSorter {

    private FileSorter() {}

    public static void sortFileByLines(Path infile, Path outfile)
            throws IOException {
        System.out.println(infile);
        System.out.println(outfile);
        String output = linesSorted(infile)
                .collect(Collectors.joining(System.lineSeparator()));
        BufferedWriter out = Files.newBufferedWriter(outfile);
        out.write(output);
        out.close();
    }

    public static void sortFileByLines(Path file)
            throws IOException {
        sortFileByLines(file, file);
    }

    public static void sortFileByLines(String inFilename, String outFilename)
            throws IOException, URISyntaxException{
        sortFileByLines(getPathByName(inFilename), getPathByName(outFilename));
    }

    public static void sortFileByLines(String filename)
            throws IOException, URISyntaxException {
        sortFileByLines(getPathByName(filename));
    }

    public static Stream<String> linesSorted(Path file)
            throws IOException{
        return Files.lines(file).sorted();
    }

    public static Stream<String> linesSorted(String filename)
            throws IOException, URISyntaxException{
        return linesSorted(getPathByName(filename));
    }

    private static Path getPathByName(String filename)
            throws URISyntaxException {
        return FileLoader.getPath(filename);
    }

    private static Path getResource(String fileName) throws URISyntaxException {
        return FileLoader.getResource(fileName);
    }
}
