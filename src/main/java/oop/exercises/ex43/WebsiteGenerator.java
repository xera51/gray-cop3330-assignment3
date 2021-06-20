package oop.exercises.ex43;

import oop.exercises.util.ConsoleDataReader;
import oop.exercises.util.FileLoader;

import java.io.BufferedWriter;
import java.io.IOException;

public class WebsiteGenerator {

    private static final ConsoleDataReader reader = new ConsoleDataReader();
    private static final FileLoader loader = new FileLoader();

    private String siteName;
    private String authorName;
    private boolean jsDirectory;
    private boolean cssDirectory;

    public WebsiteGenerator() {
        this("", "", false, false);
    }

    public WebsiteGenerator(String siteName, String authorName,
                            boolean jsDirectory, boolean cssDirectory) {
        this.siteName = siteName;
        this.authorName = authorName;
        this.jsDirectory = jsDirectory;
        this.cssDirectory = cssDirectory;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean getJsSetting() {
        return jsDirectory;
    }

    public void setJsSetting(boolean jsFile) {
        this.jsDirectory = jsFile;
    }

    public boolean getCssSetting() {
        return cssDirectory;
    }

    public void setCssSetting(boolean cssFile) {
        this.cssDirectory = cssFile;
    }

    public void setSettingsThroughConsole() {
        try {
            String siteName = promptSiteName();
            this.authorName = promptAuthorName();
            this.siteName = siteName;
            this.jsDirectory = promptJsFolder();
            this.cssDirectory = promptCssFolder();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private String promptSiteName() {
        String output = reader.readString("Site name: ");
        if(output.isEmpty()) throw new IllegalArgumentException(
                "Site name cannot be blank");
        else return output;
    }

    private String promptAuthorName() {
        String output = reader.readString("Author: ");
        if(output.isEmpty()) throw new IllegalArgumentException(
                "Author name cannot be blank");
        else return output;
    }

    private boolean promptJsFolder() {
        return reader
                .readString("Do you want a folder for JavaScript? ")
                .matches("[Yy]([Ee][Ss])?");
    }

    private boolean promptCssFolder() {
        return reader
                .readString("Do you want a folder for CSS? ")
                .matches("[Yy]([Ee][Ss])?");
    }

    public String generate(){
        if(siteName.isEmpty()) throw new IllegalArgumentException(
                "Site name cannot be blank");
        if(authorName.isEmpty()) throw new IllegalArgumentException(
                "Author name cannot be blank");
        String output = makeWebsiteDirectory() +
               makeSiteNameDirectory() + makeHtmlFile();
        if(jsDirectory) output += makeJsDirectory();
        if(cssDirectory) output += makeCssDirectory();
        return output;
    }

    private String makeWebsiteDirectory() {
        if(loader.getFile("website").mkdir()) {
            return "";
        } else {
            return String.format("Failed to create ./website%n");
        }
    }

    private String makeSiteNameDirectory() {
        if(loader.getFile("website/" + siteName).mkdir()) {
            return String.format("Created ./website/%s%n", siteName);
        } else {
            return String.format("Failed to create ./website/%s%n", siteName);
        }
    }

    private String makeHtmlFile() {
        try(BufferedWriter html = loader
                .getBufferedWriter("website/" + siteName + "/index.html")) {
            html.write(buildHtmlString());
            return String.format("Created ./website/%s/index.html%n", siteName);
        } catch(IOException e) {
            return String.format("Failed to create ./website/%s/index.html%n", siteName);
        }
    }

    private String makeJsDirectory() {
        if(loader.getFile("website/" + siteName + "/js").mkdir()) {
            return String.format("Created ./website/%s/js/%n", siteName);
        } else {
            return String.format("Failed to create ./website/%s/js/%n", siteName);
        }
    }

    private String makeCssDirectory() {
        if(loader.getFile("website/" + siteName + "/css").mkdir()) {
            return String.format("Created ./website/%s/css/%n", siteName);
        } else {
            return String.format("Failed to create ./website/%s/css/%n", siteName);
        }
    }

    private String buildHtmlString() {
        return String.format("<!DOCTYPE html>%n<html>%n<head>%n" +
                "    <title>%s</title>%n" +
                "    <meta name=\"author\" content=\"%s\">%n" +
                "</head>%n<body>%n%n</body>%n</html>%n",
                siteName, authorName);
    }
}
