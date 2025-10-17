package co.edu.uniquindio.poo.taller4preparcialmotos.controllers;

import co.edu.uniquindio.poo.taller4preparcialmotos.model.DataBaseFacade;
import co.edu.uniquindio.poo.taller4preparcialmotos.model.IMoto;
import co.edu.uniquindio.poo.taller4preparcialmotos.model.Tipo;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.Year;

public class ListadoMotoController {

    @FXML
    private Button btnDeseleccionar;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableColumn<IMoto, String> colDescripcion;

    @FXML
    private TableColumn<IMoto, String> colMarca;

    @FXML
    private TableColumn<IMoto, Year> colModelo;

    @FXML
    private TableColumn<IMoto, String> colPlaca;

    @FXML
    private TableView<IMoto> tablaMotos;

    @FXML
    void deseleccionar(ActionEvent event) {
        tablaMotos.getSelectionModel().clearSelection();
    }

    private final ObservableList<IMoto> listaMotos = FXCollections.observableArrayList();
    private final DataBaseFacade dbFacade = new DataBaseFacade();

    @FXML
    public void initialize() {
        colPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modeloString"));
        colDescripcion.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDescripcion()));

        //colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));

        tablaMotos.setItems(listaMotos);
        cargarMotos();
    }

    private void cargarMotos() {
        listaMotos.setAll(dbFacade.obtenerMotos());
    }

    @FXML
    void eliminar(ActionEvent event) {
        IMoto seleccionada = tablaMotos.getSelectionModel().getSelectedItem();

        if (seleccionada != null) {
            dbFacade.eliminarMoto((IMoto) seleccionada);
            cargarMotos();
            mostrarAlerta("Se ha eliminado correctamente.");
        } else {
            mostrarAlerta("Debe seleccionar una moto para eliminar.");
        }
    }


    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Atención");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

}
