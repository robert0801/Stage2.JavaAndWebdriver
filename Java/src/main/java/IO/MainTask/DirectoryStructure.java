package IO.MainTask;

import IO.MainTask.services.PathCreator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DirectoryStructure {

    private int numberOfHyphensBeforeName = 1;
    private int numberOfSpacesBeforeName = 0;

    public DirectoryStructure() {
    }

    public void getTreeDirectory(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                printStructureDirectory(file);
                numberOfHyphensBeforeName++;
                numberOfSpacesBeforeName++;
                getTreeDirectory(file);
            } else if (file.isFile()) {
                printStructureDirectory(file);
            }
        }
        numberOfHyphensBeforeName--;
        numberOfSpacesBeforeName--;
    }

    private void printStructureDirectory(File file) {
        try (FileWriter writer = new FileWriter(PathCreator.pathFile, true)) {
            if (file.isFile()) {
                for (int i = 0; i < numberOfSpacesBeforeName; i++) {
                    writer.write(" ");
                }
                for (int i = 0; i < numberOfHyphensBeforeName; i++) {
                    writer.write("-");
                }
                writer.write(" " + file.getName() + "\n");
            } else if (file.isDirectory()) {
                for (int i = 0; i < numberOfSpacesBeforeName; i++) {
                    writer.write(" ");
                }
                writer.write("|");
                for (int i = 0; i < numberOfHyphensBeforeName; i++) {
                    writer.write("-");
                }
                writer.write(" " + file.getName() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
