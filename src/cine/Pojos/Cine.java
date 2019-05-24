package cine.Pojos;

import cine.Interfaces.ListarObjeto.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;

public class Cine implements ListarCine {

    private static final String NOMBRE = "Cinestres_D";
    private static final String HORARIO_DE_ATENCION = "9:00-21:00";
    private static Boleteria[] boleteria;
    private static Tienda[] tienda;
    private static int numeroDeSalas = 10;
    private static Cliente[] clientes;
    private static int numeroDeCliente;
    private static Empleado[] empleados;
    private static int numeroDeEmpleado;
    private static int codigoDeEmpleado;
    private static int codigoDeCliente;
    private static Persona[] persona;

    static {

        tienda = new Tienda[2];
        clientes = new Cliente[500];
        empleados = new Empleado[10];
        boleteria = new Boleteria[2];
        numeroDeCliente = numeroDeEmpleado = 0;
        persona = new Persona[numeroDeCliente + numeroDeEmpleado + 1];

    }

    public static void registrar(Object obj) {

        if ((obj != null) && (obj instanceof Empleado)) {
            if (numeroDeEmpleado == empleados.length) {
                System.out.println("Se contrataran empleados extras");
                Empleado empleadosExtras[] = empleados;
                empleados = new Empleado[numeroDeEmpleado + 1];
                System.arraycopy(empleadosExtras, 0, empleados, 0, numeroDeEmpleado);
            }
            empleados[numeroDeEmpleado] = (Empleado) obj;
            codigoDeEmpleado = numeroDeEmpleado;
            numeroDeEmpleado++;
        } else if ((obj != null) && (obj instanceof Cliente)) {
            clientes[numeroDeCliente] = (Cliente) obj;
            codigoDeCliente = numeroDeCliente;
            numeroDeCliente++;
        }
        Persona personasm[] = persona;
        persona = new Persona[numeroDeEmpleado + numeroDeCliente + 1];
        System.arraycopy(personasm, 0, persona, 0, numeroDeEmpleado + numeroDeCliente);
    }

    public static void mostrarTodos() {
        System.out.println("Los Personas que entraron al cine el dia de hoy son:");
        for (int i = 0; i < numeroDeCliente + numeroDeEmpleado; i++) {
            System.out.println("Persona " + (i + 1) + " :");
            if (i < numeroDeEmpleado) {
                persona[i] = empleados[i];
                System.out.print("   Empleado:");
            } else {
                persona[i] = clientes[i - numeroDeEmpleado];
                System.out.print("   Cliente:");
            }
            System.out.println(persona[i].toString());

        }

    }

    public static boolean validacionEmpleado() {
        for (int i = 0; i < numeroDeEmpleado - 1; i++) {
            if (empleados[i].equals(empleados[codigoDeEmpleado])) {
                return true;
            }
        }
        return false;
    }

    public static boolean validacionCliente() {
        for (int i = 0; i < numeroDeCliente - 1; i++) {
            if (clientes[i].equals(clientes[codigoDeCliente])) {
                return true;
            }
        }
        return false;
    }

    public static boolean editarCliente(String nombre, String apellido, long identificacion,
            long telefono, boolean esSocio,
            boolean realizaFacturacion) {
        if (nombre == null) {
            nombre = clientes[codigoDeCliente].getNombre();
        }
        if (apellido == null) {
            apellido = clientes[codigoDeCliente].getApellido();
        }
        if (telefono == 0) {
            telefono = clientes[codigoDeCliente].getTelefono();
        }
        if (identificacion == 0) {
            identificacion = clientes[codigoDeCliente].getIdentificacion();
        }
        for (int i = 0; i < numeroDeCliente; i++) {
            if (i != codigoDeCliente) {
                if (identificacion == clientes[i].getIdentificacion()) {
                    return true;
                }
            }

        }

        Cliente[] cliente1 = clientes;
        clientes[codigoDeCliente] = new Cliente(nombre, apellido, identificacion, telefono, esSocio);
        clientes = new Cliente[numeroDeCliente];
        if ((codigoDeCliente + 1) != (numeroDeCliente)) {
            System.arraycopy(cliente1, 0, clientes, 0, numeroDeCliente);
        }
        return false;

    }

    public static boolean editarEmpleado(String usuario, String contraseña, String nombre,
            String apellido, int edad, long identificacion, double sueldoDiario) {
        if (nombre == null) {
            nombre = empleados[codigoDeEmpleado].getNombre();
        }

        if (usuario == null) {
            usuario = empleados[codigoDeEmpleado].getUsuario();
        }
        if (contraseña == null) {
            contraseña = empleados[codigoDeEmpleado].getContraseña();
        }
        if (apellido == null) {
            apellido = empleados[codigoDeEmpleado].getApellido();
        }
        if (edad == 0) {
            edad = empleados[codigoDeEmpleado].getEdad();
        }
        if (identificacion == 0) {
            identificacion = empleados[codigoDeEmpleado].getIdentificacion();
        }
        for (int i = 0; i < numeroDeEmpleado; i++) {
            if (i != codigoDeEmpleado) {
                if (usuario.equals(empleados[i].getUsuario()) || identificacion == empleados[i]
                        .getIdentificacion()) {
                    return true;
                }
            }

        }

        Empleado[] empleado1 = empleados;
        empleados[codigoDeEmpleado] = new Empleado(nombre, apellido, edad, identificacion, edad,
                usuario, contraseña);
        empleados = new Empleado[numeroDeEmpleado];
        if ((codigoDeEmpleado + 1) != (numeroDeEmpleado)) {
            System.arraycopy(empleado1, 0, empleados, 0, numeroDeEmpleado);
        }
        return false;

    }

    public static void eliminarEmpleado() {

        Empleado[] empleado1 = empleados;
        empleados = new Empleado[numeroDeEmpleado - 1];
        if (codigoDeEmpleado == 0) {
            System.arraycopy(empleado1, 1, empleados, 0, numeroDeEmpleado - 1);
        } else if (codigoDeEmpleado > 0 && codigoDeEmpleado < numeroDeEmpleado) {
            System.arraycopy(empleado1, 0, empleados, 0, codigoDeEmpleado);
            System.arraycopy(empleado1, codigoDeEmpleado + 1, empleados, codigoDeEmpleado,
                    numeroDeEmpleado - (codigoDeEmpleado + 1));
        } else if ((codigoDeEmpleado + 1) == numeroDeEmpleado) {
            System.arraycopy(empleado1, 0, empleados, 0, numeroDeEmpleado - 1);
        }
        numeroDeEmpleado--;

    }

    public static void eliminarCliente() {
        Cliente[] cliente1 = clientes;
        clientes = new Cliente[numeroDeCliente - 1];
        if (codigoDeCliente == 0) {
            System.arraycopy(cliente1, 1, clientes, 0, numeroDeCliente - 1);
        } else if (codigoDeCliente > 0 && codigoDeCliente < numeroDeCliente) {
            System.arraycopy(cliente1, 0, clientes, 0, codigoDeCliente);
            System.arraycopy(cliente1, codigoDeCliente + 1, clientes, codigoDeCliente,
                    numeroDeCliente - (codigoDeCliente + 1));
        } else if ((codigoDeCliente + 1) == numeroDeCliente) {
            System.arraycopy(cliente1, 0, clientes, 0, numeroDeCliente - 1);
        }
        numeroDeCliente--;
    }

    public static boolean buscar(long buscar) {
        for (int i = 0; i < numeroDeEmpleado + numeroDeCliente; i++) {
            if (buscar == empleados[i].getIdentificacion()) {
                JOptionPane.showMessageDialog(null, "El Empleado " + (i + 1) + " es: "
                        + empleados[i].toString(), "Encontrado", PLAIN_MESSAGE);
                return true;
            }
            if (buscar == clientes[i].getIdentificacion()) {
                JOptionPane.showMessageDialog(null, "El Cliente " + (i + 1) + " es: "
                        + clientes[i].toString(), "Encontrado", PLAIN_MESSAGE);
                return true;
            }

        }
        return false;
    }

    public static String mostrarEmpleado() {
        return "El empleado es:" + empleados[codigoDeEmpleado].getNombre() + " "
                + empleados[codigoDeEmpleado].getApellido() + "\n"
                + "Tiene " + empleados[codigoDeEmpleado].getEdad() + " años de edad\n"
                + "Su identificacion es:" + empleados[codigoDeEmpleado].getIdentificacion() + "\n"
                + "Su sueldo diario es: $" + empleados[codigoDeEmpleado].getSueldoDiario() + "\n"
                + "Su usuario es: " + empleados[codigoDeEmpleado].getUsuario() + "\n"
                + "Su contraseña es: " + empleados[codigoDeEmpleado].getContraseña() + "\n\n";

    }

    public void listarCliente() {
        Cliente clien;
        for (int i = 0; i < this.numeroDeCliente; i++) {
            clien = this.getCliente(i);
            System.out.println("Cliente " + (i + 1) + "\n" + clien.toString());
        }
    }

    public static void asistenciaDeEmpleados() {
        JOptionPane.showMessageDialog(null, "Usted tiene " + empleados[codigoDeEmpleado].asistir()
                + " dia(s) "
                + "trabajado(s) en el mes", "Laborar", INFORMATION_MESSAGE);
    }

    public static boolean validarUsuario(String digitarUsuario, String digitarContraseña) {

        for (int i = 0; i < numeroDeEmpleado; i++) {
            while (digitarUsuario.equals(empleados[i].getUsuario()) && digitarContraseña.equals(empleados[i]
                    .getContraseña())) {
                codigoDeEmpleado = i;
                return true;
            }
        }
        return false;

    }

    public static boolean validarCedula(long identificacion) {
        for (int i = 0; i < numeroDeCliente; i++) {
            while (identificacion == clientes[i].getIdentificacion()) {
                codigoDeCliente = i;
                return true;
            }

        }
        return false;
    }

    @Override
    public void listarEmpleados() {
        for (int i = 0; i < numeroDeEmpleado; i++) {
            JOptionPane.showMessageDialog(null, "\t\tEl Empleado " + (i + 1) + " es: "
                    + empleados[i].toString(), "Lista de empleados", PLAIN_MESSAGE);

        }

    }

    public static void listarClientes() {
        for (int i = 0; i < numeroDeEmpleado; i++) {
            JOptionPane.showMessageDialog(null, "\t\tEl Cliente " + (i + 1) + " es: "
                    + clientes[i].toString(), "Lista de clientes", PLAIN_MESSAGE);

        }
    }

    public static void editarCliente(int indice, long editarCliente, String nombre, String apellido, long identificacion, long telefono, boolean esSocio) {
        for (int i = 0; i < numeroDeCliente; i++) {
            if (editarCliente == clientes[i].getIdentificacion()) {
                Cliente cliente = Cine.getCliente(indice);
                Cine.clientes[indice] = new Cliente(nombre, apellido, identificacion, telefono, esSocio);
            } else {
                if (editarCliente != clientes[i].getIdentificacion()) {
                    System.out.println("Cliente no encontrado");
                }
            }

        }
    }

    public static String bienvenida() {
        return "\t\t\t\t\t\t\t\tBienvenido al cine \"" + NOMBRE + "\" \n\n"
                + "    Atendemos todos los dias en los horarios de \"" + HORARIO_DE_ATENCION + "\"\n"
                + "    Contamos con " + tienda.length + " tiendas , " + boleteria.length + " boleterias y "
                + numeroDeSalas + " salas, teniendo  \n    una capacidad para " + clientes.length + " client"
                + "es.\n\n";
    }

    public static Cliente getCliente(int indice) {
        return clientes[indice];
    }

    public static Empleado getEmpleado(int indice) {
        return empleados[indice];
    }

    public static int getNumeroDeCliente() {
        return numeroDeCliente;
    }

    public static int getNumeroDeEmpleado() {
        return numeroDeEmpleado;
    }

    public static Persona[] getPersona() {
        return persona;
    }

    public static Boleteria[] getBoleteria() {
        return boleteria;
    }

    public static void setBoleteria(Boleteria[] newBoleteria) {
        boleteria = newBoleteria;
    }

    public static Cliente[] getCliente() {
        return clientes;
    }

    public static void setCliente(Cliente[] newCliente) {
        clientes = newCliente;
    }

    public static int getNumeroDeSalas() {
        return numeroDeSalas;
    }

    public static void setNumeroDeSalas(int newNumeroDeSalas) {
        numeroDeSalas = newNumeroDeSalas;
    }

    public static Tienda[] getTienda() {
        return tienda;
    }

    public static void setTienda(Tienda[] newTienda) {
        Cine.tienda = newTienda;
    }

    public static Empleado[] getEmpleado() {
        return empleados;
    }

    public static void setEmpleado(Empleado[] empleado) {
        Cine.empleados = empleado;
    }

}
