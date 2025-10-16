package co.edu.uniquindio.poo.taller4preparcialmotos.controllers;

import co.edu.uniquindio.poo.taller4preparcialmotos.model.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class DecorarMotoController {

    @FXML
    private ChoiceBox<String> choiceTransmision;

    @FXML
    private ChoiceBox<Tipo> choiceTipo;

    private IMoto motoBase;
    private final DataBaseFacade dbFacade = new DataBaseFacade();

    @FXML
    public void initialize() {
        choiceTransmision.setItems(FXCollections.observableArrayList("Manual", "Automática"));
        choiceTransmision.getSelectionModel().selectFirst();

        choiceTipo.setItems(FXCollections.observableArrayList(Tipo.values()));
        choiceTipo.getSelectionModel().selectFirst();
    }

    public void setMotoBase(IMoto motoBase) {
        this.motoBase = motoBase;
    }

    @FXML
    void onAplicarDecorador() {
        if (motoBase == null) {
            mostrarMensaje("Error", "No hay moto base seleccionada.", Alert.AlertType.ERROR);
            return;
        }

        try {
            Tipo tipo = choiceTipo.getValue();
            String transmision = choiceTransmision.getValue();

            IMoto motoDecorada;

            if ("Automática".equalsIgnoreCase(transmision)) {
                motoDecorada = new MotoAutomatica(motoBase, tipo);
            } else {
                motoDecorada = new MotoManual(motoBase, tipo);
            }

            dbFacade.getDb().reemplazarMoto(motoBase, motoDecorada);

            mostrarMensaje("Éxito", "Moto decorada correctamente.", Alert.AlertType.INFORMATION);
            cerrarVentana();

        } catch (Exception e) {
            mostrarMensaje("Error", "No se pudo decorar la moto: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void mostrarMensaje(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) choiceTipo.getScene().getWindow();
        stage.close();
    }
}
