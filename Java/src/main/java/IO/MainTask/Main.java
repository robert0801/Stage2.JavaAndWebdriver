package IO.MainTask;

import java.io.File;

import static IO.MainTask.services.CleanResources.cleanDirResources;
import static IO.MainTask.services.PathCreator.getPath;
import static IO.MainTask.services.PathCreator.pathFile;

public class Main {

    public static void main(String[] args) {
        cleanDirResources();
        getPath();
        final String DEFAULT_PATH = pathFile;

        for (int i = 0; i < args.length; i++) {
            File workingDirectory = new File(args[i]);
            pathFile += i + ".txt";
            if (new File(args[i]).isFile()) {
                new FileInformation(workingDirectory).getInformationAboutFile();
            } else {
                new DirectoryStructure().getTreeDirectory(workingDirectory);
            }
            pathFile = DEFAULT_PATH;
        }
    }
}

