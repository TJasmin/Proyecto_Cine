package cine.Principal;

import cine.Clases.Menu;
import cine.Enumeraciones.Socio;
import cine.Enumeraciones.Sueldo;
import cine.Excepciones.MisExcepciones;
import cine.Pojos.Boleteria;
import cine.Pojos.Cine;
import cine.Pojos.Cliente;
import cine.Pojos.Empleado;
import cine.Pojos.Tienda;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TestProyecto {

    Sueldo sueldo;
    Socio socio;

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        JOptionPane.showMessageDialog(null, Cine.bienvenida());
        Menu menu = new Menu();
        Tienda tienda = new Tienda();
        //Empleados
        Cine.registrar(new Empleado("admin", "admin", 0, 999999999, Sueldo.ADMINISTRACION.getSueldo(), "admin", "admin"));
        Cine.registrar(new Empleado("Andres", "Veliz", 19, 1726030081, Sueldo.ADMINISTRACION.getSueldo(), "Andres1994", "1994"));
        Cine.registrar(new Empleado("Juan", "Veliz", 23, 1721255386, Sueldo.ADMINISTRACION.getSueldo(), "JuanCarlos", "juanca"));
        Cine.registrar(new Empleado("Julio", "Cortazar", 30, 1987654321, Sueldo.ADMINISTRACION.getSueldo(), "XXX", "incognita"));
        Cine.registrar(new Empleado("Roberto", "Cuero", 69, 1234567890, Sueldo.ADMINISTRACION.getSueldo(), "IselaCreyo", "isela"));
        
        //Nuevo empleado registrado
        Cine.registrar(new Empleado("Tania", "Rea", 25, 1726475961, Sueldo.ADMINISTRACION.getSueldo(), "Tany", "abc"));
        
        //Clientes
        Cine.registrar(new Cliente("Elena", "Perez", 1726745715, 985018531, Socio.ES_SOCIO.isSocio()));
        Cine.registrar(new Cliente("Laura", "Torres", 1789654123, 987456321, Socio.NO_ES_SOCIO.isSocio()));
        //Peliculas
        Boleteria.registrarPelicula("Malefica", 2014, "Elena Hernandez", "Hernan Salazar", "Monica Mena", true);
        Boleteria.registrarPelicula("Troya", 2010, "John Fernandez", "Camilo Perez", "Mzrio Steven", false);
        //Productos
        tienda.registrarProducto("Cola", "mediana", 20, 100);
        tienda.registrarProducto("Snaks", "grande", 1, 50);
        System.out.println("Inicio de programa:");
        System.out.println("Indique una opcion:\n"
                + "\n"
                + " 1. Consola            \n"
                + " 2. Interfaz Gráfica   \n"
                + " 3. Salir              \n"
                + "\n");
        String inicio = scanner.next();
        int validacion1 = Integer.parseInt(inicio);
        switch (validacion1) {
            case 1:
                try {
                    menu.menuPrincipal();
 //                  MenuPersonasGUI menuPersonasGui = new MenuPersonasGUI();
                } catch (MisExcepciones ex) {
                    Logger.getLogger(TestProyecto.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 2:
  //              VentanaPrincipalGUI ventanaPrincipal = new VentanaPrincipalGUI();
                break;
            case 3:

                System.exit(0);
                break;
            default:
                System.out.println("Opcion no valida");
        }
        System.out.println("Indique una opcion:\n"
                + "\n"
                + " 1. Consola            \n"
                + " 2. Interfaz Gráfica   \n"
                + " 3. Salir              \n"
                + "\n");
        inicio = scanner.next();
        validacion1 = Integer.parseInt(inicio);
    }
}
