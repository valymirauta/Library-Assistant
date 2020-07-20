package library.assistant.ui.addbook;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import library.assistant.database.DatabaseHandler;

import java.net.URL;
import java.util.ResourceBundle;

public class BookAddController implements Initializable {

    private  DatabaseHandler databaseHandler;
    @FXML
    private JFXTextField title;
    @FXML
    private JFXTextField id;
    @FXML
    private JFXTextField author;
    @FXML
    private JFXTextField publisher;
    @FXML
    private JFXButton saveButton;
    @FXML
    private JFXButton cancelButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        databaseHandler = new DatabaseHandler();
    }


    @FXML
    private void addBook(ActionEvent event) {
    }

    @FXML
    private void cancel(ActionEvent event) {
    }
}
