package IO.MainTask;

import IO.MainTask.services.PathCreator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileInformation {
    private File file;
    private File parentDir;
    private int countDirectories = 0;
    private int countFiles = 0;
    private ArrayList<String> listWithNameFiles = new ArrayList<>();
    private int totalLengthNamesOfFiles;

    public FileInformation(File file) {
        this.file = file;
    }

    public void getInformationAboutFile() {
        parentDir = new File(file.getParent());
        if (getFileExtension(this.file).equals(".txt")) {
            try (FileWriter writer = new FileWriter(PathCreator.pathFile)) {
                {
                    getCountDirectoryAndFiles(parentDir);
                    try {
                        writer.write("Count of directories " + countDirectories + "\n" +
                                "Count of files " + countFiles + "\n" +
                                "Middle count files in directory " + (double) countFiles / countDirectories + "\n" +
                                "Middle length name of file " + getMiddleLengthNamesOfFiles(parentDir));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else System.out.println("The specified file does't have a .txt extension.");
    }

    private String getFileExtension(File file) {
        String nameFile = file.getName();
        int index = nameFile.lastIndexOf('.');
        return nameFile.substring(index);
    }

    private void getCountDirectoryAndFiles(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isFile()) countFiles++;
            else if (file.isDirectory()) {
                countDirectories++;
                getCountDirectoryAndFiles(file);
            }
        }
    }

    private double getMiddleLengthNamesOfFiles(File dir) {
        getListWithLengthNamesOfFiles(dir);
        for (String lengthFiles : listWithNameFiles) {
            totalLengthNamesOfFiles += lengthFiles.length();
        }
        return (double) totalLengthNamesOfFiles / listWithNameFiles.size();
    }

    private void getListWithLengthNamesOfFiles(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                listWithNameFiles.add(file.getName());
            } else if (file.isDirectory()) {
                getListWithLengthNamesOfFiles(file);
            }
        }
    }
}
