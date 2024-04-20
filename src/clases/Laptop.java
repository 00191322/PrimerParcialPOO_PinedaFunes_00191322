package clases;

public class Laptop extends Articulo implements Detallable{
    // Nvidia RTX 2060, Radeon RX 8700
    private String tarjetaGrafica;
    // windows, linux, macos
    private String sistemaOperativo;

    public Laptop() {
        super();
    }

    public Laptop(String nombre, String modelo, String descripcion, Double precio, String tarjetaGrafica, String sistemaOperativo) {
        super(nombre, modelo, descripcion, precio);
        this.tarjetaGrafica = tarjetaGrafica;
        this.sistemaOperativo = sistemaOperativo;
    }

    public Laptop(long idArticulo, String nombre, String modelo, String descripcion, Double precio, String tarjetaGrafica, String sistemaOperativo) {
        super(idArticulo, nombre, modelo, descripcion, precio);
        this.tarjetaGrafica = tarjetaGrafica;
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getTarjetaGrafica() {
        return tarjetaGrafica;
    }

    public void setTarjetaGrafica(String tarjetaGrafica) {
        this.tarjetaGrafica = tarjetaGrafica;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public double obtenerPrecio() {
        // A las laptop se les suma el 20% del valor real y $10
        return getPrecio() + (getPrecio() * 0.20) + 10;
    }

    @Override
    public String obtenerDescripcion() {
        return super.toString() +
                "\nTarjeta Grafica: " + tarjetaGrafica +
                "\nSistema Operativo: " + sistemaOperativo +
                "\nPrecio: " + obtenerPrecio();
    }

    @Override
    public String toString() {
        return obtenerDescripcion();
    }
}
