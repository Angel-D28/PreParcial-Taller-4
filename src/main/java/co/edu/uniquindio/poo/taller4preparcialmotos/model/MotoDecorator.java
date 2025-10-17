package co.edu.uniquindio.poo.taller4preparcialmotos.model;

import java.time.Year;

public abstract class MotoDecorator implements IMoto{
    protected final IMoto motoDecorada;

    protected MotoDecorator(IMoto motoDecorada) {
        this.motoDecorada = motoDecorada;
    }

    @Override
    public String encender(){
        return motoDecorada.encender();
    }

    @Override
    public String getDescripcion() {
        return motoDecorada.getDescripcion();
    }

    public String getPlaca() {
        return motoDecorada.getPlaca();
    }

    public String getMarca() {
        return motoDecorada.getMarca();
    }


    public String getModeloString() {
        return motoDecorada.getModeloString();
    }


    public Tipo getTipo() {
        return motoDecorada.getTipo();
    }
}
