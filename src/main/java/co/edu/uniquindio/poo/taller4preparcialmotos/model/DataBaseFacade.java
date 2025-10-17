package co.edu.uniquindio.poo.taller4preparcialmotos.model;

import java.time.Year;
import java.util.Collections;
import java.util.List;

public class DataBaseFacade {
    private final DataBase db;

    public DataBaseFacade() {
        db = DataBase.getInstance();
    }

    public Moto crearMoto(String placa, String marca, Year modelo) {
        Moto moto =new Moto
                .Builder()
                .placa(placa)
                .marca(marca)
                .modelo(modelo)
                .build();
        //db.agregarMoto(moto);
        return moto;
    }

    public String obtenerDescripcion(Moto moto) {
        if (moto == null) {
            return "La moto no existe o es nula.";
        }
        return moto.getDescripcion();
    }

    public List<IMoto> getListaMotos() {
        return db.getListaMotos();
    }

    public List<IMoto> obtenerMotos() {
        return db.getListaMotos();
    }

    public void eliminarMoto(IMoto moto) {
        db.eliminarMoto(moto);
    }

    public DataBase getDb() {
        return db;
    }

    // Buscar moto por algún criterio (opcional)
    /*public IMoto buscarPorModelo(Year modelo) {
        for (IMoto moto : db.getListaMotos()) {
            if (moto.getModelo().equals(modelo)) {
                return moto;
            }
        }
        return null;
    }*/
}
