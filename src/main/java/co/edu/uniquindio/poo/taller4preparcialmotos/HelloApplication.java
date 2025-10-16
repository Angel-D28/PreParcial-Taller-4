package co.edu.uniquindio.poo.taller4preparcialmotos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Cargar la vista principal (puede ser listadoMotos.fxml o formularioMoto.fxml)
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/co/edu/uniquindio/poo/taller4preparcialmotos/ListadoMotos.fxml")
        );

        Scene scene = new Scene(loader.load());
        stage.setTitle("Gestión de Motos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}