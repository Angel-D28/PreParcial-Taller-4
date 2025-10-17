package co.edu.uniquindio.poo.taller4preparcialmotos.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class DashboardController {

    @FXML
    private Button buttonSlide;

    @FXML
    private AnchorPane buttonsContainer;

    @FXML
    private Button listadoMotos;

    @FXML
    private AnchorPane mainContent;

    @FXML
    private Button registrarMoto;

    @FXML
    private HBox root;

    @FXML
    private VBox slideMenu;

    private boolean menuVisible = true;


    private void loadView(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/taller4preparcialmotos/" + fxmlPath));
            Node view = loader.load();

            mainContent.getChildren().setAll(view);

            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void listadoMotos(ActionEvent event) {
        loadView("listadoMoto.fxml");
    }

    @FXML
    void registrarMoto(ActionEvent event) {
        loadView("registrarMoto.fxml");
    }

    @FXML
    void visibleMenu(ActionEvent event) {
        if (menuVisible) {
            slideMenu.setVisible(false);
            slideMenu.setManaged(false);
        } else {
            slideMenu.setVisible(true);
            slideMenu.setManaged(true);
        }
        menuVisible = !menuVisible;
    }

}
