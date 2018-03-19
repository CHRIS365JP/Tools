package work.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.commons.lang3.StringUtils;
import org.mozilla.universalchardet.UniversalDetector;

public class UTF8WIthBOMToUTF8Utils {

    // FEFF because this is the Unicode char represented by the UTF-8 byte order mark (EF BB BF).
    private static final String UTF8_BOM = "\uFEFF";
    private static final String FILE_CHAR_SET = "UTF8";
    private static final String OUT_PUT_CHARSET = "UTF8";
    private static boolean foundFlag = false;
    
    public static void main(String args[]) {
        String rootFolder ="src";
        String fileName = "";
        String fileFolder = searchFolders(rootFolder, fileName);
        if(!StringUtils.endsWith(fileFolder, "\\")) fileFolder += "\\";
        updateFile(fileFolder + fileName);
    }

    private static void updateFile(String fileName) {
        try {
//          if (args.length != 2) {
//              System.out.println("Usage : java UTF8ToAnsiUtils utf8file ansifile");
//              System.exit(1);
//          }
          String file = "C:\\Users\\zzhang\\Desktop\\Temp\\20180316\\SYSD040FADQCSVFileFormat.java";
          String file2 = "C:\\Users\\zzhang\\Desktop\\Temp\\20180316\\SYSD040FADQCSVFileFormat2.java";
          boolean firstLine = true;
//          FileInputStream fis = new FileInputStream(args[0]);
          FileInputStream fis = new FileInputStream(file);
          BufferedReader r = new BufferedReader(new InputStreamReader(fis, FILE_CHAR_SET));
          FileOutputStream fos = new FileOutputStream(file2);
          Writer w = new BufferedWriter(new OutputStreamWriter(fos, OUT_PUT_CHARSET));
          for (String output = ""; (output = r.readLine()) != null;) {
              if (firstLine) {
                  output = UTF8WIthBOMToUTF8Utils.removeUTF8BOM(output);
                  firstLine = false;
              }
//              w.write(output + System.getProperty("line.separator"));
              w.write(output + System.getProperty("line.separator"));
              w.flush();
          }
          System.out.println(detector(file));
          w.close();
          r.close();
          System.out.println("RESET ENCODE FINISHED : " + file2.substring(StringUtils.lastIndexOf(file2, "\\") + 1));
          System.exit(0);
      }

      catch (Exception e) {
          e.printStackTrace();
          System.exit(1);
      }
    }
    
    private static String removeUTF8BOM(String s) {
        if (s.startsWith(UTF8_BOM)) {
            s = s.substring(1);
        }
        return s;
    }
    
    /**
     * 文字コードを判定するメソッド.
     * @param ファイルパス
     * @return 文字コード
     */
    private static String detector(String fileName) throws IOException {
      byte[] buf = new byte[4096];
//      String fileName = "";
      FileInputStream fis = new FileInputStream(fileName);
//      
   
      // 文字コード判定ライブラリの実装
      UniversalDetector detector = new UniversalDetector(null);
   
      // 判定開始
      int nread;
      while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
        detector.handleData(buf, 0, nread);
      }
      // 判定終了
      detector.dataEnd();
   
      // 文字コード判定
      String encType = detector.getDetectedCharset();
      if (encType != null) {
        System.out.println("文字コード = " + encType);
      } else {
        System.out.println("文字コードを判定できませんでした");
      }
   
      // 判定の初期化
      detector.reset();
      fis.close();
      return encType;
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