package work.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.mozilla.universalchardet.UniversalDetector;

public class ChangeEncode {
    
    private FileInputStream fis;


    public static void main(String[] args) {
        String rootFolder = "";
        searchFolders(rootFolder);
    }
    
    private static void searchFolders(String rootFolder) {
        
    }
    
    public static String[] getFileNames(String path, String word) {
        File[] files = new File(path).listFiles(pathName -> pathName.isFile() && pathName.getName().contains(word));
        String[] names = new String[files.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = files[i].getName();
        }
        return names;
    }
    
    
    /**
     * 文字コードを判定するメソッド.
     * @param ファイルパス
     * @return 文字コード
     */
    public String detector() throws IOException {
      byte[] buf = new byte[4096];
      String fileName = "";
      fis = new FileInputStream(fileName);
   
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
      
      return encType;
    }
    
    public static String excludeBOMString(String original_str) {
        if (original_str != null) {
            char c = original_str.charAt(0);
            if (Integer.toHexString(c).equals("feff")) {
                StringBuilder sb = new StringBuilder();
                for (int i=1; i < original_str.length(); i++) {
                    sb.append(original_str.charAt(i));
                }
                return sb.toString();
            } else {
                return original_str;
            }
        } else {
            return "";
        }
    }
    
//    private static void test() {
//        int rec = 0;
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("test.txt"),"UTF-8")));
//        while(br.ready()) {
//            String line = br.readLine();
//            // １行目ならBOM除去メソッドを呼び出す
//            if (rec == 0) {
//                line = excludeBOMString(line);
//            }
//            
//            rec++;
//        }
//    }
}
