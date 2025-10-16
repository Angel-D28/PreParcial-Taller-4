package co.edu.uniquindio.poo.taller4preparcialmotos.controllers;

import co.edu.uniquindio.poo.taller4preparcialmotos.model.DataBaseFacade;
import co.edu.uniquindio.poo.taller4preparcialmotos.model.IMoto;
import co.edu.uniquindio.poo.taller4preparcialmotos.model.Moto;
import co.edu.uniquindio.poo.taller4preparcialmotos.model.Tipo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Year;

public class ListadoMotosController {

    @FXML
    private TableColumn<IMoto, String> colMarca;

    @FXML
    private TableColumn<IMoto , String> colDescripcion;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableColumn<Tipo, Tipo> colTipo;

    @FXML
    private TableView<IMoto> tablaMotos;

    @FXML
    private TableColumn<IMoto, Year> colModelo;

    @FXML
    private VBox contenedorPrincipal;

    @FXML
    private Button btnCrearMoto;

    @FXML
    private TableColumn<IMoto , String> colPlaca;


    private final ObservableList<IMoto> listaMotos = FXCollections.observableArrayList();
    private final DataBaseFacade dbFacade = new DataBaseFacade();

    @FXML
    public void initialize() {
        colPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modeloString"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));

        tablaMotos.setItems(listaMotos);
        cargarMotos();
    }


    private void cargarMotos() {
        listaMotos.setAll(dbFacade.obtenerMotos());
    }



    @FXML
    void onCrearMoto(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/taller4preparcialmotos/FormularioMoto.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Registrar nueva moto");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load()));
            stage.showAndWait();

            // Recargar la lista después de cerrar el formulario
            cargarMotos();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void onDecorarMoto(ActionEvent event) {
        IMoto seleccionada = tablaMotos.getSelectionModel().getSelectedItem();

        if (seleccionada == null) {
            mostrarAlerta("Debe seleccionar una moto base para decorarla.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/taller4preparcialmotos/DecorarMoto.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Decorar Moto");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load()));

            // Pasar la moto seleccionada al controlador
            DecorarMotoController controller = loader.getController();
            controller.setMotoBase(seleccionada);

            stage.showAndWait();

            // Recargar lista después de decorar
            cargarMotos();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onEliminarMoto(ActionEvent event) {
        IMoto seleccionada = tablaMotos.getSelectionModel().getSelectedItem();

        if (seleccionada != null) {
            dbFacade.eliminarMoto((IMoto) seleccionada);
            cargarMotos();
            mostrarAlerta("Moto eliminada correctamente.");
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
