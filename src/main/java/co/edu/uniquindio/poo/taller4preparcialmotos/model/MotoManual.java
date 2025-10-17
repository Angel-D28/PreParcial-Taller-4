package co.edu.uniquindio.poo.taller4preparcialmotos.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.Year;

public class MotoManual extends MotoDecorator {

    private final Tipo tipo;

    public MotoManual(IMoto motoDecorada, Tipo tipo) {
        super(motoDecorada);
        this.tipo = tipo;
    }

    @Override
    public String encender() {
        String msj ="Enciende oprimiendo el freno." ;
        System.out.println(msj);
        return msj;
    }

    @Override
    public String getDescripcion() {
        return motoDecorada.getDescripcion()
                + "\nTipo: " + tipo
                + "\nTransmisión: Manual (con clutch)";
    }

    @Override
    public String getMarca() {
        return motoDecorada.getMarca();
    }

    @Override
    public Year getModelo() {
        return motoDecorada.getModelo();
    }

    @Override
    public String getPlaca() {
        return motoDecorada.getPlaca();
    }

    /*public StringProperty descripcionProperty() {
        return new SimpleStringProperty(getDescripcion());
    }*/

}

