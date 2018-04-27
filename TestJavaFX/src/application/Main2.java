package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*******************************************
 * 画面
 * @author tarosa0001
 *******************************************/
public class Main2 extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // FXMLのレイアウトをロード
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

            // タイトルセット
            primaryStage.setTitle("JavaFXSample");

            // シーン生成
            Scene scene = new Scene(root);

            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
