package co.edu.uniquindio.poo.taller4preparcialmotos.model;


public interface IMoto {
    String encender();
    String getDescripcion();
    String getPlaca();
    String getMarca();
    String getModeloString(); // Lo usaremos para mostrar el Year
    Tipo getTipo();
}
