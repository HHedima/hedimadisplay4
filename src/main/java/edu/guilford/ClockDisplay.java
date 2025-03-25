package edu.guilford;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class ClockDisplay extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        // create clock object
        Clock clock = new Clock();
        clock.setTime();

        // create clock controller
        FXMLLoader loader = new FXMLLoader(getClass().getResource("clockControl.fxml"));
        Parent root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        // create digital clock pane
        DigitalClockPane digitalClockPane = new DigitalClockPane(clock);
        Scene scene2 = new Scene(digitalClockPane);
        stage.setScene(scene2);
        // stage.show();




    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ClockDisplay.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}