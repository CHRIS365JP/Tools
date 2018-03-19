package work.tools;

import java.io.File;

public class SearchFiles {

    static boolean foundFlag = false;
    
    public static void main(String[] args) {
        String rootFolder = "C:\\Users\\zzhang\\Desktop\\Temp\\";
        String fileName = "SYSD040FADQCSVFileFormat";
        searchFolders(rootFolder, fileName);
        System.out.println("The end");
    }
    
    private static String searchFolders(String rootFolder, String fileName) {
        if(foundFlag) {
            return rootFolder;
        }
        File dir = new File(rootFolder);
        // FOLDER
        if(dir.isDirectory()) {
            String[] children = dir.list();
            if(!rootFolder.endsWith("\\")) {
                rootFolder += "\\";
            }
            for(String name : children) {
                File dir2 = new File(rootFolder + name);
                if(name.contains(fileName) && !dir2.isDirectory()) {
                    System.out.println("File found!");
                    System.out.println(name);
                    foundFlag = true;
                    return rootFolder;
                }
            }
            if(children == null) {
                System.out.println("not exist");
                return "";
            } else {
                for(String subDir : children) {
                    searchFolders(rootFolder + subDir, fileName);
                    if(foundFlag) return rootFolder;
                }
            }
        } else {
            if(rootFolder.contains(fileName)) {
                return rootFolder;
            }
            System.out.println("This is not a dir");
            return "";
        }
        return rootFolder;
    }
}
