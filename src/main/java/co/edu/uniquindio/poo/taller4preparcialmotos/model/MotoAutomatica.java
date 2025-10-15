package co.edu.uniquindio.poo.taller4preparcialmotos.model;

public class MotoAutomatica extends MotoDecorator {
    private final Tipo tipo; // Tipo de moto (por ejemplo, SCOOTER, ELECTRICA, etc.)

    public MotoAutomatica(IMoto motoDecorada, Tipo tipo) {
        super(motoDecorada);
        this.tipo = tipo;
    }

    @Override
    public String encender() {
        // Cambiamos el comportamiento del encendido
        return "Enciende oprimiendo el freno.";
    }

    @Override
    public String getDescripcion() {
        // Combinamos la descripción de la moto base con información adicional
        return motoDecorada.getDescripcion()
                + "\nTipo: " + tipo
                + "\nTransmisión: Automática";
    }
}
