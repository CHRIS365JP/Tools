package work.tools;

import java.io.IOException;

public class StartH2Server {
    public static void main(String[] args) {
        String classpath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        classpath = classpath.substring(1, classpath.length() - 1);
        classpath = classpath.substring(0, classpath.lastIndexOf("/"));
        classpath += "/lib/";
        System.out.println(classpath);
//        String h2 = "java -cp " + classpath + "\\h2-1.4.196.jar org.h2.tools.Server -webAllowOthers";
        String h2 = "java -cp " + classpath + "\\h2-1.4.196.jar org.h2.tools.Server -tcpAllowOthers -baseDir " + classpath;
        // Webコントローラ表示
        // http://<H2DB-IP>:8082/
        // DBに接続
        // 組み込み(Embedded)モードの場合 jdbc:h2:./<DBファイル名>
        // サーバーモードの場合 jdbc:h2:tcp://<H2DB-IP>:/~/<DBファイル名>
        String[] Command = { "cmd", "/c", h2}; // 起動コマンドを指定する
        Runtime runtime = Runtime.getRuntime(); // ランタイムオブジェクトを取得する
            try {
                runtime.exec(Command); // 指定したコマンドを実行する
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
