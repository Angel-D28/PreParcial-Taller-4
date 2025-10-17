package co.edu.uniquindio.poo.taller4preparcialmotos.controllers;

import co.edu.uniquindio.poo.taller4preparcialmotos.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.time.Year;

public class RegistrarMotoController {

    @FXML
    private Button btnDeseleccionar;

    @FXML
    private Button btnGuardar;

    @FXML
    private ComboBox<Year> comboAnio;

    @FXML
    private ComboBox<String> comboTipoMoto;

    @FXML
    private ComboBox<String> comboTransmision;

    @FXML
    private TextField textMarca;

    @FXML
    private TextField textPlaca;

    private final DataBaseFacade dbFacade = new DataBaseFacade();


    @FXML
    public void initialize() {
        //Llenar la caja "Modelo (año)" de la moto desde el 2000 a la fecha actúal
        int actual = Year.now().getValue();
        ObservableList<Year> anios = FXCollections.observableArrayList();
        for (int i = 2000; i <= actual+1; i++) {
            anios.add(Year.of(i));
        }
        comboAnio.setItems(anios);
        //Llenamos la caja con el contenido del ENUM (Tipo)
        ObservableList<String> tipoCombustion = FXCollections.observableArrayList();
        for (Tipo tipo : Tipo.values()) {
            tipoCombustion.add(tipo.getDisplayName());
        }
        comboTipoMoto.setItems(tipoCombustion);


        ObservableList<String> tipoTransmision = FXCollections.observableArrayList(
                "Manual", "Automática"
        );
        comboTransmision.setItems(tipoTransmision);
    }


    @FXML
    void guardarMoto(ActionEvent event) {
        try {
            String placa = textPlaca.getText();
            String marca = textMarca.getText();
            Year modelo = comboAnio.getValue();
            String tipoMoto = comboTipoMoto.getValue();
            String transmision = comboTransmision.getValue();

            Tipo tipo = Tipo.valueOf(tipoMoto.toUpperCase());
            Moto motoBase = dbFacade.crearMoto(placa, marca, modelo);

            IMoto motoDecorada;
            if(transmision.equalsIgnoreCase("Manual")){
                motoDecorada = new MotoManual(motoBase, tipo);
            }else{
                motoDecorada = new MotoAutomatica(motoBase, tipo);
            }

            dbFacade.getListaMotos().add(motoDecorada);


            mostrarMensaje("Éxito", "Se ha registrado correctamente", Alert.AlertType.INFORMATION);
            limpiarCompletarRegistro();

        } catch (Exception e) {
            mostrarMensaje("Error", "No se pudo registrar la moto: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void limpiarCampos(ActionEvent event) {
        textPlaca.clear();
        textMarca.clear();
        comboAnio.getSelectionModel().clearSelection();
        comboTipoMoto.getSelectionModel().clearSelection();
        comboTransmision.getSelectionModel().clearSelection();
    }

    private void mostrarMensaje(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void limpiarCompletarRegistro(){
        textPlaca.clear();
        textMarca.clear();
        comboAnio.getSelectionModel().clearSelection();
        comboTipoMoto.getSelectionModel().clearSelection();
        comboTransmision.getSelectionModel().clearSelection();
    }
}
