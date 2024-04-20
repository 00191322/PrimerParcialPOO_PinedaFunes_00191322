package clases;

public class Telefono extends Articulo implements Detallable{
    // 3000 mAh, 6000 mAh
    private String tamanioBateria;
    // 30V, 60V
    private String capacidadCarga;

    public Telefono() {
        super();
    }

    public Telefono(String nombre, String modelo, String descripcion, Double precio, String tamanioBateria, String capacidadCarga) {
        super(nombre, modelo, descripcion, precio);
        this.tamanioBateria = tamanioBateria;
        this.capacidadCarga = capacidadCarga;
    }

    public Telefono(long idArticulo, String nombre, String modelo, String descripcion, Double precio, String tamanioBateria, String capacidadCarga) {
        super(idArticulo, nombre, modelo, descripcion, precio);
        this.tamanioBateria = tamanioBateria;
        this.capacidadCarga = capacidadCarga;
    }

    public String getTamanioBateria() {
        return tamanioBateria;
    }

    public void setTamanioBateria(String tamanioBateria) {
        this.tamanioBateria = tamanioBateria;
    }

    public String getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(String capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public double obtenerPrecio() {
        // A Los telefonos se les suma el 10% del valor real
        return  getPrecio() + (getPrecio() * 0.10);
    }

    @Override
    public String obtenerDescripcion() {
        return super.toString() +
                "\nTamaño Bateria: " + tamanioBateria +
                "\nCapacidad Carga: " + capacidadCarga +
                "\nPrecio: " + obtenerPrecio();
    }

    @Override
    public String toString() {
        return obtenerDescripcion();
    }
}
