package co.edu.uniquindio.poo.taller4preparcialmotos.model;

import java.util.ArrayList;
import java.util.List;

//Implementacion del singleton
public class DataBase {
    private static DataBase db;
    private final List<IMoto> listaMotos;

    private DataBase() {
        listaMotos = new ArrayList<>();
    }

    public static DataBase getInstance() {
        if (db == null) {
            db = new DataBase();
        }
        return db;
    }

    public void agregarMoto(IMoto moto) {
        listaMotos.add(moto);
    }

    public static DataBase getDb() {
        return db;
    }

    public List<IMoto> getListaMotos() {
        return listaMotos;
    }
}
