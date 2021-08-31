package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AnimalEditorWindowController {
    private Animal animal;
    private Stage editAnimalStage;

    @FXML
    private ComboBox<String> kindEdit;
    @FXML
    private TextField nameEdit;
    @FXML
    private TextField hostNameEdit;
    @FXML
    private Spinner<Integer> ageYearsEdit;
    @FXML
    private Spinner<Integer> ageMonthsEdit;

    private ButtonType result = ButtonType.CANCEL;

    private boolean isInputValid() {
        return hostNameEdit.getText().matches("^[A-Z][a-z]+") &&
                nameEdit.getText().matches("^[A-Z][a-z]+");
    }

    private void message(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Data entry error");
        alert.setHeaderText("Incorrect host name!");
        alert.setContentText("The name of host consists only letters " + "\n" +
                "and starts with a capital letter");
        alert.showAndWait();
    }

    @FXML
    private void confirmEditAction(ActionEvent event) {
        if (isInputValid()) {
            animal.setName(nameEdit.getText());
            animal.setHost(hostNameEdit.getText());
            animal.setAgeYears(ageYearsEdit.getValue());
            animal.setAgeMonths(ageMonthsEdit.getValue());
            animal.setKind(kindEdit.getValue());
            result = ButtonType.OK;
            editAnimalStage.close();
        }
        else
            message();
    }

    @FXML
    private void cancelAction() {
        result = ButtonType.CANCEL;
        editAnimalStage.close();
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;

        nameEdit.setText(animal.getName());
        hostNameEdit.setText(animal.getHost_name());
        kindEdit.getItems().addAll(
          "Cat",
              "Dog",
              "Fish",
              "Frog",
              "Bird"
        );
        kindEdit.setValue(animal.getKind());

        ageYearsEdit.getValueFactory().setValue(animal.getAgeYears());
        ageMonthsEdit.getValueFactory().setValue(animal.getAgeMonths());
    }

    public void setEditStage(Stage editStage) {
        this.editAnimalStage = editStage;
    }
}
