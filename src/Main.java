import clases.Articulo;
import clases.Laptop;
import clases.Telefono;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean flag = true, flag2 = true;
        Scanner sc = new Scanner(System.in);
        Articulo articuloBuscar;
        List<Articulo> listaArticulos = new ArrayList<>();
        int opc = 0, opc2 = 0;
        long numArticulo = 0;
        while(flag){
            System.out.println("\tMenu Principal\n" +
                    "1. Agregar un Articulo\n"+
                    "2. Modificar un Articulo\n"+
                    "3. Consultar el listado de Articulos\n"+
                    "4. Salir"
            );
            try{
                opc = sc.nextInt();
                switch (opc){
                    case 1:
                        flag2 = true;
                        while(flag2){
                            try{
                                System.out.println("\t¿Que tipo de articulo desea agregar?\n" +
                                        "1. Laptop\n"+
                                        "2. Telefono\n"+
                                        "3. Menu Principal"
                                );
                                opc2 = sc.nextInt();
                                switch (opc2){
                                    case 1:
                                        Laptop laptopAgregar = new Laptop();
                                        System.out.println("Porfavor, Ingrese los siguientes datos de la laptop: ");
                                        registrarDatosComunes(laptopAgregar);
                                        sc.nextLine();
                                        System.out.println("Tarjeta Grafica: ");
                                        laptopAgregar.setTarjetaGrafica(sc.nextLine());
                                        System.out.println("Sistema Operativo (Linux, Windows, MacOS): ");
                                        laptopAgregar.setSistemaOperativo(sc.nextLine());
                                        listaArticulos.add(laptopAgregar);
                                        System.out.println("** Laptop Agregada, el ID es: " + laptopAgregar.getIdArticulo() + " **");
                                        flag2 = false;
                                        break;
                                    case 2:
                                        Telefono telefonoAgregar = new Telefono();
                                        System.out.println("Porfavor, Ingrese los siguientes datos del telefono: ");
                                        registrarDatosComunes(telefonoAgregar);
                                        sc.nextLine();
                                        System.out.println("Tamaño de la Bateria (en mAh): ");
                                        telefonoAgregar.setTamanioBateria(sc.nextLine());
                                        System.out.println("Capacidad de Carga (en voltios): ");
                                        telefonoAgregar.setCapacidadCarga(sc.nextLine());
                                        listaArticulos.add(telefonoAgregar);
                                        System.out.println("** Telefono Agregado, el ID es: " + telefonoAgregar.getIdArticulo() + " **");
                                        flag2 = false;
                                        break;
                                    case 3:
                                        flag2 = false;
                                        break;
                                    default:
                                        System.out.println("Ingrese una opcion valida (1, 2, 3)");
                                        break;
                                }
                            } catch (Exception e) {
                                System.out.println("Ingrese una opcion valida (1, 2, 3)");
                                sc.nextLine();
                            }
                        }
                        flag = confirmarVolverAlMenu();
                        break;
                    case 2:
                        System.out.println("Ingrese el ID del Articulo que desea modificar: ");
                        numArticulo = sc.nextLong();
                        articuloBuscar = buscarArticulo(numArticulo, listaArticulos);
                        if(articuloBuscar != null){
                            modificarArticulo(articuloBuscar);
                        } else {
                            System.out.println("**Articulo no Encontrado, Intente de Nuevo (Puede consultar la lista de articulos disponibles)**");
                        }
                        confirmarVolverAlMenu();
                        break;
                    case 3:
                        if(listaArticulos.size() != 0){
                            mostrarArticulos(listaArticulos);
                        } else {
                            System.out.println("**Lista de Articulos Vacia (Puede agregar articulos usando la opcion 1 del menu Principal)**");
                        }
                        flag = confirmarVolverAlMenu();
                        break;
                    case 4:
                        flag = false;
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ingrese una opcion valida (1, 2, 3, 4)");
                sc.nextLine();
            }
        }
    }

    public static Articulo buscarArticulo(long numIdArticulo, List<Articulo> articuloList){
        for(Articulo articulo : articuloList){
            if(articulo.getIdArticulo() == numIdArticulo){
                return articulo;
            }
        }
        return null;
    }

    public static void modificarArticulo(Articulo articulo){
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        boolean flag = true;
        mostrarUnArticulo(articulo);
        while(flag){
            System.out.println("¿Que le gustaria Modificar de este Articulo?");
            System.out.println("1. Nombre\n"+
                    "2. Modelo\n"+
                    "3. Descripcion\n"+
                    "4. Precio");
            // Intente hacer que se pudieran modificar los demas atributos
            // Pero no me alcanzo el tiempo para lograrlo
            /*if(articulo instanceof Laptop){
                System.out.println("5. Tarjeta Grafica\n"+
                        "6. Sistema Operativo");
            } else if (articulo instanceof Telefono) {
                System.out.println("5. Tamaño Bateria\n"+
                        "6. Capacidad Carga");
            }*/
            try {
                opc = sc.nextInt();
                sc.nextLine();
                switch (opc){
                    case 1:
                        System.out.println("Ingrese el nuevo Nombre: ");
                        articulo.setNombre(sc.nextLine());
                        flag = false;
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo Modelo: ");
                        articulo.setModelo(sc.nextLine());
                        flag = false;
                        break;
                    case 3:
                        System.out.println("Ingrese la nueva Descripcion: ");
                        articulo.setDescripcion(sc.nextLine());
                        flag = false;
                        break;
                    case 4:
                        System.out.println("Ingrese el nuevo Precio Base: ");
                        articulo.setPrecio(sc.nextDouble());
                        flag = false;
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Seleccione una opcion valida, intentelo de nuevo");
                sc.nextLine();
            }
        }
        System.out.println("Propiedad Actualizada con exito");

    }

    public static boolean confirmarVolverAlMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Volver al Menu Principal?\n1. Si\nPara salir del sistema, Ingrese cualquier opcion del menu");
        try {
            int opc = sc.nextInt();
            return opc == 1;
        } catch (Exception e) {
            return false;
        }
    }

    public static void registrarDatosComunes(Articulo articulo){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        // rand.nextLong(100) permite asignar un id aleatorio hasta 99, si se desea
        // agregar mas de 99 productos se puede incrementar este valor.
        // Por cuestiones de simplicidad lo deje en un valor bajo para que no fuera
        // dificil la busqueda de un Articulo
        articulo.setIdArticulo(rand.nextLong(100));
        System.out.println("Nombre: ");
        articulo.setNombre(sc.nextLine());
        System.out.println("Modelo: ");
        articulo.setModelo(sc.nextLine());
        System.out.println("Descripcion: ");
        articulo.setDescripcion(sc.nextLine());
        System.out.println("Precio Base: ");
        articulo.setPrecio(sc.nextDouble());
    }
    public static void mostrarArticulos(List<Articulo> articuloList){
        int count = 1;
        System.out.println("\tLista de Articulos");
        StringBuilder sb = new StringBuilder();
        for(Articulo articulo : articuloList){
            sb.append("Articulo N°").append(count).append(": ");
            sb.append("\nTipo Articulo: ");
            if(articulo instanceof Laptop){
                sb.append("Laptop");
            } else if (articulo instanceof Telefono) {
                sb.append("Telefono");
            } else {
                sb.append("Desconocido");
            }
            sb.append("\n-Detalles-\n");
            sb.append(articulo.toString());
            sb.append("\n*********************");
            ++count;
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }

    public static void mostrarUnArticulo(Articulo articulo){
        StringBuilder sb = new StringBuilder();
        sb.append("\tDetalles de ");
        if(articulo instanceof Laptop){
            sb.append("la Laptop");
        } else if (articulo instanceof Telefono) {
            sb.append("el Telefono");
        }
        sb.append("\n");
        sb.append(articulo.toString());
        sb.append("\n");
        System.out.println(sb.toString());
    }
}