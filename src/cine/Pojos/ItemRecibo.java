package cine.Pojos;

import cine.Pojos.Producto;

public class ItemRecibo {

    private Producto productos;
    private double ventaProducto;
    private double ventaBoleta;

    public ItemRecibo(Producto producto) {
        this.productos = producto;
    }

    public ItemRecibo() {

    }

    public Producto getProductos() {
        return productos;
    }

    public void setProductos(Producto newProductos) {
        productos = newProductos;
    }

    public void venderProducto(int cantidad, float costo) {
        ventaProducto = (cantidad * costo);
        System.out.println("Precio a pagar por producto: " + ventaProducto);
    }

    public void venderBoleta(int cantidad) {
        ventaBoleta = (cantidad * 3.00);
        System.out.println("Precio a pagar por la(s) boleta(s): " + ventaBoleta);
    }

    public double generarCobro() {
        double total;
        total = (this.ventaProducto + this.ventaBoleta);
        return total;
    }
}
