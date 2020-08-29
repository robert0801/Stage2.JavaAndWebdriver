package IO.MainTask.services;

import java.io.File;

public class PathCreator {
    public static String pathFile;

    public static void getPath() {
        pathFile = new File("").getAbsolutePath();
        int placeOfAppearanceInPath = pathFile.lastIndexOf("Java");
        pathFile = pathFile.substring(0, placeOfAppearanceInPath) + "Java\\src\\main\\resources\\MainTaskOutput";
    }
}
