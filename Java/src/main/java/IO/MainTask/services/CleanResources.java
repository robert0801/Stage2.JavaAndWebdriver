package IO.MainTask.services;

import java.io.File;

public class CleanResources {
    public static String pathResources;

    public static void cleanDirResources() {
        pathResources = new File("").getAbsolutePath();
        int placeOfAppearanceInPath = pathResources.lastIndexOf("Java");
        pathResources = pathResources.substring(0, placeOfAppearanceInPath) + "Java\\src\\main\\resources";
        File dirResources = new File(pathResources);
        if (dirResources.listFiles().length != 0) {
            for (File file : dirResources.listFiles()) {
                file.delete();
            }
        }
    }
}
