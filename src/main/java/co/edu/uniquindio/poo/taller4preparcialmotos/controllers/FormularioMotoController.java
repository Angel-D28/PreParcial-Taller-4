package co.edu.uniquindio.poo.taller4preparcialmotos.controllers;

import co.edu.uniquindio.poo.taller4preparcialmotos.model.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.Year;

public class FormularioMotoController {

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtModelo;

    @FXML
    private ChoiceBox<String> choiceTransmision;

    @FXML
    private ChoiceBox<Tipo> choiceTipo;

    private final DataBaseFacade dbFacade = new DataBaseFacade();

    @FXML
    void onRegistrarMoto() {
        try {
            String placa = txtPlaca.getText();
            String marca = txtMarca.getText();
            Year modelo = Year.of(Integer.parseInt(txtModelo.getText()));

            Moto motoBase = dbFacade.crearMoto(placa, marca, modelo);

            mostrarMensaje("Éxito", "Moto base registrada correctamente", Alert.AlertType.INFORMATION);
            limpiarCampos();

        } catch (Exception e) {
            mostrarMensaje("Error", "No se pudo registrar la moto: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void limpiarCampos() {
        txtPlaca.clear();
        txtMarca.clear();
        txtModelo.clear();
    }

    private void mostrarMensaje(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
