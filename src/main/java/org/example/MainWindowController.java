package org.example;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowController {
    @FXML
    private ListView<Animal> dataView;
    @FXML
    private Text viewAnimalText;

    @FXML
    private void aboutAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("About");
        alert.setContentText("About animal");
        alert.show();
    }

    @FXML
    private void exitAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void editAnimalAction(ActionEvent event) {
        Animal animal = dataView.getSelectionModel().getSelectedItem();

        if (animal != null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource("/org.example/AnimalEditorWindow.fxml"));
                Parent root = loader.load();
                AnimalEditorWindowController controller = loader.getController();

                Stage editStage = new Stage();
                Scene scene = new Scene(root);

                editStage.setTitle("Edit animal");
                editStage.setScene(scene);

                controller.setEditStage(editStage);
                controller.setAnimal(animal);

                editStage.showAndWait();
                dataView.refresh();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
            showMessage("Not selected animal!");
    }

    @FXML
    private void deleteAnimalAction(ActionEvent event) {
        int selectedIndex = dataView.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            dataView.getItems().remove(selectedIndex);
        } else {
            showMessage("No deleted item!");
        }
        dataView.refresh();
    }

    @FXML
    private void showAnimal(MouseEvent event) {
        Animal animal = dataView.getSelectionModel().getSelectedItem();
        viewAnimalText.setText(
                "Kind: " + animal.getKind() + "\n" +
                "Nickname: " + animal.getName() + "\n" +
                "Age: " + animal.getAgeYears() + "." + animal.getAgeMonths() + "\n" +
                "Host name: " + animal.getHost_name());
    }

    private void showMessage(String message) {
        Alert messageAlert = new Alert(Alert.AlertType.WARNING, message, ButtonType.OK);
        messageAlert.showAndWait();
    }

    public void initialize(ObservableList<Animal> data) {
        dataView.getItems().addAll(data);
    }
}
