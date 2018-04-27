package application;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class JavaFxWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        /** フレーム生成 */
        primaryStage.setTitle("JavaFX Window");
        BorderPane bordPane = new BorderPane();
        bordPane.setPrefSize(300, 100);

        /** メニューバー */
        MenuBar menuBar = new MenuBar();
        menuBar.setUseSystemMenuBar(true);
        menuBar.setPrefSize(300, 25);
        Menu menu1 = new Menu("ファイル(F)");
        MenuItem menuItem1 = new MenuItem("終了");
        menu1.getItems().add(menuItem1);
        Menu menu2 = new Menu("ヘルプ(H)");
        MenuItem menuItem2 = new MenuItem("作成情報");
        menu2.getItems().add(menuItem2);
        menuBar.getMenus().add(menu1);
        menuBar.getMenus().add(menu2);

        /** ボディ部 */
        FlowPane flowPane = new FlowPane();
        flowPane.setPrefSize(300, 100);
        flowPane.setOrientation(Orientation.VERTICAL);

        // メッセージ
        flowPane.getChildren().add(new Label("好きな文字を入力してください"));
        flowPane.getChildren().add(new Label(""));

        // inputテキスト
        HBox hbox = new HBox(20d);
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.getChildren().add(new Label("Input"));
        TextField textField = new TextField();
        hbox.getChildren().add(textField);
        flowPane.getChildren().add(hbox);
        flowPane.getChildren().add(new Label(""));

        // 表示ボタン
        Button btnDisp = new Button("表示");
        flowPane.getChildren().add(btnDisp);

        /** アクションイベント設定 */
        menuItem1.setOnAction(e -> System.exit(0));
        menuItem2.setOnAction(e -> dispModalDialog(primaryStage, "作成情報", "Version:1.0.0", "Date:2015-07-01"));
        btnDisp.setOnAction(e -> dispModalDialog(primaryStage, "Text", textField.getText()));

        /** 画面表示設定 */
        bordPane.setTop(menuBar);
        bordPane.setCenter(flowPane);
        Scene scene = new Scene(bordPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /** ダイアログ表示 */
    private void dispModalDialog(Window parentWindow, String title, String... msg) {
        /** ダイアログ生成 */
        Stage dialog = new Stage();
        dialog.setTitle(title);
        dialog.initModality(Modality.WINDOW_MODAL);
        if (parentWindow != null)
            dialog.initOwner(parentWindow);

        // ダイアログ内容
        final StackPane pane = new StackPane();
        {
            final VBox vbox = new VBox();
            pane.getChildren().add(vbox);

            vbox.setAlignment(Pos.CENTER);
            vbox.setMinWidth(150);
            vbox.getChildren().add(new Label(""));// 空行
            for (String s : msg) {
                vbox.getChildren().add(new Label(s));
            }
            vbox.getChildren().add(new Label(""));// 空行

            Button btnOk = new Button();
            btnOk.setText("close");
            btnOk.setOnAction((ActionEvent) -> {
                dialog.close();
            });

            vbox.getChildren().add(btnOk);
            vbox.getChildren().add(new Label(""));// 空行
        }

        /** ダイアログ表示設定 */
        dialog.setScene(new Scene(pane));
        dialog.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
