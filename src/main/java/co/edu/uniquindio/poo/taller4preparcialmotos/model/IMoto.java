package co.edu.uniquindio.poo.taller4preparcialmotos.model;

import java.time.Year;

public interface IMoto {
    String encender();
    String getDescripcion();
    String getPlaca();
    String getMarca();
    Year getModelo();
    String getModeloString(); // Lo usaremos para mostrar el Year
    Tipo getTipo();
}
