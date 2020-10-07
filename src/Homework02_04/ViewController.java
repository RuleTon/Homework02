package Homework02_04;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


import java.awt.*;

public class ViewController {

    @FXML
    private ListView userLists;

    @FXML
    private Button sendButton;

    @FXML
    private TextArea chatLog;

    @FXML
    private TextField textField;



    @FXML
    public void initialize () {
        userLists.setItems(FXCollections.observableArrayList(Homework02_04.USER_TEST_DATA));

        sendButton.setOnAction(event -> sendMessage());
        textField.setOnAction(event -> sendMessage());


    }

    private void sendMessage () {
        chatLog.appendText(textField.getText());
        chatLog.appendText(System.lineSeparator());
        textField.clear();
    }


}
