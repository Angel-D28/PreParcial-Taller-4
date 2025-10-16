package co.edu.uniquindio.poo.taller4preparcialmotos.model;

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
        // Extiende la descripción de la moto decorada
        return motoDecorada.getDescripcion()
                + "\nTipo: " + tipo
                + "\nTransmisión: Manual (con clutch)";
    }

    @Override
    public Tipo getTipo() {
        return tipo;
    }
}

