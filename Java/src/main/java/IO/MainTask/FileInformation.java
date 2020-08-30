package IO.MainTask;

import IO.MainTask.services.PathCreator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileInformation {
    private File file;
    private File parentDir;
    private int countDirectories = 0;
    private int countFiles = 0;
    private double middleLengthNamesOfFiles;

    public FileInformation(File file) {
        this.file = file;
    }

    public void getInformationAboutFile() {
        parentDir = new File(file.getParent());
        try (FileWriter writer = new FileWriter(PathCreator.pathFile)) {
            if (getFileExtension(file).equals(".txt")) {
                getCountDirectoryAndFiles(parentDir);
                writer.write("Count of directories " + countDirectories + "\n" +
                        "Count of files " + countFiles + "\n" +
                        "Middle count files in directory " + (double) countFiles / countDirectories + "\n" +
                        "Middle length name of file " + getMiddleLengthNamesOfFiles(parentDir));
            } else System.out.println("The specified file does't have a .txt extension.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFileExtension(File file) {
        String nameFile = file.getName();
        int index = nameFile.lastIndexOf('.');
        return nameFile.substring(index);
    }

    private void getCountDirectoryAndFiles(File dir) {
        try (Stream<Path> walkFileCount = Files.walk(dir.toPath());
             Stream<Path> walkDirectoryCount = Files.walk(dir.toPath())) {
            countFiles = (int) walkFileCount
                    .filter(Files::isRegularFile)
                    .count();

            countDirectories = (int) walkDirectoryCount
                    .filter(Files::isDirectory)
                    .count() - 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private double getMiddleLengthNamesOfFiles(File dir) {
        try (Stream<Path> walkForGetMiddleLengthNamesOfFiles = Files.walk(dir.toPath())) {
            middleLengthNamesOfFiles = walkForGetMiddleLengthNamesOfFiles
                    .filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toList()).stream()
                    .mapToInt(e -> e.length())
                    .average()
                    .orElse(0.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return middleLengthNamesOfFiles;
    }
}

