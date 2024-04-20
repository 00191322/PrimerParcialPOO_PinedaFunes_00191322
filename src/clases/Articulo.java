package clases;

public abstract class Articulo {
    private long idArticulo;
    private String nombre;
    private String modelo;
    private String descripcion;
    private Double precio;

    public Articulo() {
    }

    public Articulo(String nombre, String modelo, String descripcion, Double precio) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Articulo(long idArticulo, String nombre, String modelo, String descripcion, Double precio) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public long getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(long idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return  "Id: " + idArticulo +
                "\nNombre: " + nombre +
                "\nModelo: " + modelo +
                "\nDescripcion: " + descripcion;
    }
}
