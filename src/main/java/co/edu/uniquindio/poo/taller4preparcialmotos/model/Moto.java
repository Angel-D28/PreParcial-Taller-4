package co.edu.uniquindio.poo.taller4preparcialmotos.model;

import java.time.Year;

public class Moto implements IMoto {

    private String placa;
    private String marca;
    private Year modelo;

    // Constructor privado tipo Builder
    protected Moto(Builder builder) {
        this.placa = builder.placa;
        this.marca = builder.marca;
        this.modelo = builder.modelo;
    }

    // Builder
    public static class Builder {
        private String placa;
        private String marca;
        private Year modelo;

        public Builder placa(String placa) {
            this.placa = placa;
            return this;
        }

        public Builder marca(String marca) {
            this.marca = marca;
            return this;
        }

        public Builder modelo(Year modelo) {
            this.modelo = modelo;
            return this;
        }
        public Moto build() {
            return new Moto(this);
        }
    }


    @Override
    public String encender() {
        return "Enciende oprimiendo el clutch.";
    }

    @Override
    public String getDescripcion() {
        return "Placa: " + placa + ", Marca: " + marca + ", Modelo: " + modelo ;
    }


    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public Year getModelo() {
        return modelo;
    }

    public String getModeloString() {
        return modelo != null ? modelo.toString() : "";
    }

    @Override
    public Tipo getTipo() {
        return null;
    }

    @Override
    public String toString() {
        return getDescripcion();
    }
}
