package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private ObservableList<Animal> data = FXCollections.observableArrayList(
            new Animal("Cat","Bosya",2, 11,"Lisa"),
            new Animal("Dog","Boby",3, 10,"Vasya"),
            new Animal("Bird","Kesha",1, 1,"Dima"),
            new Animal("Fish","Clown",4, 3,"Kate"));

    @Override
    public void start(Stage stage){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/org.example/MainWindow.fxml"));
            Parent root = loader.load();

            MainWindowController controller = loader.getController();
            controller.initialize(data);

            Scene scene = new Scene(root);
            stage.setTitle("Animals");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loader error");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
