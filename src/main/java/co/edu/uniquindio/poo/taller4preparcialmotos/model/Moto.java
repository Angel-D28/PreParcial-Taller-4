package co.edu.uniquindio.poo.taller4preparcialmotos.model;

import java.time.Year;

public class Moto implements IMoto{
    private String placa;
    private String marca;
    private Year modelo;

    //Builder
    private Moto(Builder builder) {
        this.placa = builder.placa;
        this.marca = builder.marca;
        this.modelo = builder.modelo;
    }

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
    public String encender(){
        return "Enciende oprimiendo el clutch";
    }

    @Override
    public String getDescripcion(){
        return"Placa: "+placa+"\nMarca: "+marca+"\nModelo: "+modelo
                +" Moto Manual(con Clutch)";
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


    @Override
    public String toString() {
        return "Moto{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo=" + modelo +
                '}';
    }
}
