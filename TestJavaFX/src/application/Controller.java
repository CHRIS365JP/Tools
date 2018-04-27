package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/***********************************************
 * 画面のコントローラー
 * @author tarosa0001
 ***********************************************/
public class Controller implements Initializable {
    /** ドロップダウン */
    @FXML
    private ChoiceBox<String> dropDown;

    /** テキストフィールド */
    @FXML
    private TextField textBox;

    /** ボタン */
    @FXML
    private Button button;

    /** ************************************************************
     * 初期化処理
     * 画面表示時に行いたい処理を実装する。
     * @param location
     * @param resources
     * *************************************************************/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // 何もしない
    }

    /** ************************************************************
     * ボタン押下時のアクション
     * @param event イベント
     * *************************************************************/
    @FXML
    public void onClick(ActionEvent event) {
        // テキストボックスに文字列をセットする
        textBox.setText("ボタンを押しました。");
    }

    /** ************************************************************
     * ツールタイプ選択ドロップダウンを取得します。
     * @return ツールタイプ選択ドロップダウン
     * *************************************************************/
    public ChoiceBox<String> getToolType() {
        return dropDown;
    }

    /** ************************************************************
     * ツールタイプ選択ドロップダウンを設定します。
     * @param toolType ツールタイプ選択ドロップダウン
     * ************************************************************/
    public void setToolType(ChoiceBox<String> toolType) {
        this.dropDown = toolType;
    }

    /** ************************************************************
     * 入力ファイル名テキストフィールドを取得します。
     * @return 入力ファイル名テキストフィールド
     * ************************************************************/
    public TextField getInputFile() {
        return textBox;
    }

    /** ************************************************************
     * 入力ファイル名テキストフィールドを設定します。
     * @param inputFile 入力ファイル名テキストフィールド
     * ************************************************************/
    public void setInputFile(TextField textBox) {
        this.textBox = textBox;
    }

    /** ************************************************************
     * 参照ボタンを取得します。
     * @return 参照ボタン
     * ************************************************************/
    public Button getReference() {
        return button;
    }

    /** ************************************************************
     * 参照ボタンを設定します。
     * @param reference 参照ボタン
     * ************************************************************/
    public void setReference(Button button) {
        this.button = button;
    }
}