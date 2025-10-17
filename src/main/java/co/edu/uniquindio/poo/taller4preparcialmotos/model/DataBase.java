package co.edu.uniquindio.poo.taller4preparcialmotos.model;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

//Implementacion del singleton
public class DataBase {
    private static DataBase db;
    private final List<IMoto> listaMotos = new ArrayList<>();

    private DataBase() {
        Moto moto1 = new Moto.Builder()
                .placa("ABC123")
                .marca("Yamaha")
                .modelo(Year.of(2020))
                .build();

        Moto moto2 = new Moto.Builder()
                .placa("XYZ789")
                .marca("Honda")
                .modelo(Year.of(2022))
                .build();

        IMoto moto3 = new MotoManual(moto1, Tipo.COMBUSTION);
        IMoto moto4 = new MotoAutomatica(moto2, Tipo.ELECTRICA);

        listaMotos.add(moto1);
        listaMotos.add(moto2);
        listaMotos.add(moto3);
        listaMotos.add(moto4);
    }

    public static DataBase getInstance() {
        if (db == null) {
            db = new DataBase();
        }
        return db;
    }

    public void reemplazarMoto(IMoto anterior, IMoto nueva) {
        int index = listaMotos.indexOf(anterior);
        if (index != -1) {
            listaMotos.set(index, nueva);
        }
    }

    public void agregarMoto(IMoto moto) {
        listaMotos.add(moto);
    }

    public void eliminarMoto(IMoto moto) {
        listaMotos.remove(moto);
    }

    public List<IMoto> getListaMotos() {
        return listaMotos;
    }
}
