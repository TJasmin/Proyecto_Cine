package cine.Pojos;

import java.util.Scanner;
import cine.Interfaces.ListarObjeto;

public class Tienda  {

    private static int numeroDeProducto;
    private static Producto[] productos;
    private static Cine cine;

    static {
        productos = new Producto[100];
        numeroDeProducto = numeroDeProducto;
        cine = cine;
    }

    public Tienda() {
        cine = cine;
    }

    public void registrarProducto(String nombre, String tamaño, float costo, int cantidad) {

        if (numeroDeProducto == productos.length) {
            Producto[] productoextra = productos;
            productos = new Producto[numeroDeProducto + 1];
            System.arraycopy(productoextra, 0, productos, 0, numeroDeProducto);
        }
        productos[numeroDeProducto] = new Producto(nombre, tamaño, costo, cantidad);
        numeroDeProducto++;
    }


    public void listarProductos() {
        Producto productoAux;
        for (int i = 0; i < numeroDeProducto; i++) {
            productoAux = this.getProducto(i);
            System.out.println("Producto: " + (i + 1) + "\n" + productoAux.toString());
        }
    }

    public boolean validacionProducto() {
        for (int i = 0; i < numeroDeProducto - 1; i++) {
            if (productos[i].equals(productos[numeroDeProducto])) {
                return true;
            }
        }
        return false;
    }

    public void buscarProducto(String nombre) {
        for (int i = 0; i < numeroDeProducto; i++) {
            Producto productoAux = this.getProducto(i);
            if (nombre.equals(productos[i].getNombre())) {
                System.out.println("Producto: " + (i + 1) + "\n" + productoAux.toString());
            } else {
                System.out.println("El producto no se ha encontrado");
            }
        }
    }

    public Producto getProducto(int indice) {
        return productos[indice];
    }

    public void editarProducto(int indice, String nombre, String tamaño, float costo, int cantidad) {
        Producto producto = this.getProducto(indice);
        this.productos[indice] = new Producto(nombre, tamaño, costo, cantidad);
    }

    public void eliminarProducto(String nombre) {

        for (int i = 0; i < numeroDeProducto; i++) {
            if (nombre.equals(productos[i].getNombre())) {
                {
                    Producto[] producto1 = productos;
                    productos = new Producto[numeroDeProducto - 1];
                    if (i == 0) {
                        System.arraycopy(producto1, 1, productos, 0, numeroDeProducto - 1);
                    } else if (i > 0 && i < numeroDeProducto) {
                        System.arraycopy(producto1, 0, productos, 0, i);
                        System.arraycopy(producto1, i + 1, productos, i, numeroDeProducto - (i + 1));
                    } else if ((i + 1) == numeroDeProducto) {
                        System.arraycopy(producto1, 0, productos, 0, numeroDeProducto - 1);
                    }
                    System.out.println("El producto ha sido eliminado");
                    numeroDeProducto--;
                }
            } else {

                System.out.println("El producto no se ha encontrado");
            }
        }
    }

    public int getNumeroDeProducto() {
        return numeroDeProducto;
    }

    public void setNumeroDeProducto(int numeroDeProducto) {
        this.numeroDeProducto = numeroDeProducto;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }

    public boolean verificarProducto() {

        return false;
    }

}
