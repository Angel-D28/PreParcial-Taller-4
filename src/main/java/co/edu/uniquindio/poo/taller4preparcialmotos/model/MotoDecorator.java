package co.edu.uniquindio.poo.taller4preparcialmotos.model;

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
}
