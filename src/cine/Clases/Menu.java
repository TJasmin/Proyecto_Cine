/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cine.Clases;

import cine.Archivos.Archivo;
import cine.Excepciones.MisExcepciones;
import cine.Pojos.*;
import java.util.Scanner;
import cine.Enumeraciones.*;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author andres1994
 */
public class Menu {

    Scanner scanner = new Scanner(System.in);
    EntradaDatos entradaDatos = new EntradaDatos();
    MisExcepciones misExcepciones = new MisExcepciones();
    Archivo file = new Archivo();
    Cine cine = new Cine();
    Empleado empleado = new Empleado();
    Boleteria boleta = new Boleteria();
    Facturacion f;
    Tienda tien = new Tienda();
    Producto p = new Producto();
    Factura fac = new Factura();
    ItemRecibo ir = new ItemRecibo();
    File archivo;
    Sueldo sueldo;
    Socio socio;
    private boolean errores;

   public void menuPersonas(String a) throws MisExcepciones, NumberFormatException {
        int a1 = Integer.parseInt(a);
        switch (a1) {
            case 1:
             //   MenuEmpleadoGUI menuEmpleado = new MenuEmpleadoGUI();
                break;
            case 2:
              //  MenuClienteGUI menuClienteGUI = new MenuClienteGUI();
                break;
            default:
                throw new MisExcepciones(misExcepciones.numerosFueraDelIntervalo());

        }

    }

    public void menuEmpleado() throws NumberFormatException, MisExcepciones {
        String usuario, contraseña, usuarioC = null, contraseñaC = null, nombre, apellido;
        double sueldoD = 0;
        int edad;
        long identificacion;
        System.out.println("Indique una opcion:\n"
                + "\n"
                + " 1. Borrar Cuenta  \n"
                + " 2. Registrarse    \n"
                + " 3. Iniciar sesion \n"
                + " 4. Regresar       \n"
                + "");
        String validacion = scanner.next();
        int validacion1 = Integer.parseInt(validacion);
        switch (validacion1) {
            case 1:
                System.out.println("Ha elegido Borrar Cuenta");
                usuario = entradaDatos.IngresarUsuario();
                contraseña = entradaDatos.IngresarContraseña();
                if (!Cine.validarUsuario(usuario, contraseña)) {
                    System.out.println("No es posible borrar su cuenta");
                    throw new MisExcepciones(misExcepciones.personaNoEncontrada());
                } else {
                    System.out.println("Esta seguro de borrar su cuenta");
                    errores = true;
                    while (errores) {
                        try {
                            errores = false;
                            if (this.menuSiNo() == 1) {
                                Cine.eliminarEmpleado();
                                System.out.println("Su cuenta ha sido eliminada");
                            } else {
                                System.out.println("Su cuenta no ha sido eliminada");
                            }
                        } catch (MisExcepciones e) {
                            System.out.println(e.getMessage());
                            errores = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Por favor inserte un numero");
                            errores = true;
                        }
                    }
                }
                menuEmpleado();
                break;
            case 2:
                System.out.println("Se procedera a registrar el empleado");
                usuario = entradaDatos.IngresarUsuario();
                contraseña = entradaDatos.IngresarContraseña();
                while (!usuario.equals(usuarioC) || !contraseña.equals(contraseñaC) || usuario == null
                        || contraseña == null) {
                    System.out.println("Por favor vuelva a ingresar los siguientes datos");
                    usuarioC = entradaDatos.IngresarUsuario();
                    contraseñaC = entradaDatos.IngresarContraseña();
                }
                errores = true;
                while (errores) {
                    try {
                        sueldoD = menuAreaLabor();
                        errores = false;
                    } catch (MisExcepciones e) {
                        System.out.println(e.getMessage());
                        errores = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Por favor inserte un numero");
                        errores = true;
                    }
                }

                nombre = entradaDatos.IngresarNombre();
                apellido = entradaDatos.IngresarApellido();
                edad = entradaDatos.IngresarEdad();
                identificacion = entradaDatos.IngresarIdentificacion();
                Cine.registrar(new Empleado(nombre, apellido, edad, identificacion, sueldoD, usuario, contraseña));
                archivo = new File("Empleados.txt");
                file.escrituraArhivo(cine.getEmpleado(Cine.getNumeroDeEmpleado() - 1).toString(), archivo);
                if (Cine.validacionEmpleado()) {
                    Cine.eliminarEmpleado();
                    throw new MisExcepciones(misExcepciones.dobleRegistro());
                } else {
                    System.out.println("El empleado ha sido registrado con exito");
                    menuEmpleado();
                }

                break;

            case 3:
                System.out.println("Ha elegido Iniciar Sesion");
                usuario = entradaDatos.IngresarUsuario();
                contraseña = entradaDatos.IngresarContraseña();
                if (!Cine.validarUsuario(usuario, contraseña)) {
                    System.out.println("No es posible iniciar sesion");
                    menuEmpleado();
                    throw new MisExcepciones(misExcepciones.personaNoEncontrada());
                } else {
                    errores = true;
                    while (errores) {
                        try {
                            this.menuEmpleado1();
                        } catch (MisExcepciones e) {
                            System.out.println(e.getMessage());
                            errores = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Por favor inserte un numero");
                            errores = true;
                        }
                    }

                }
                break;
            case 4:
                menuPrincipal();
                break;
            default:
                throw new MisExcepciones(misExcepciones.numerosFueraDelIntervalo());

        }
    }

    public double menuAreaLabor() throws NumberFormatException, MisExcepciones {
        double sueld;
        System.out.println("Indique en que area va a laborar:\n"
                + "\n"
                + " 1.-Tienda         \n"
                + " 2.-Boleteria      \n"
                + " 3.-Administracion \n"
                + "");
        String areaLabor = scanner.next();
        int areaLabor1 = Integer.parseInt(areaLabor);
        switch (areaLabor1) {
            case 1:
                sueld = sueldo.TIENDA.getSueldo();
                break;
            case 2:
                sueld = sueldo.BOLETERIA.getSueldo();
                break;
            case 3:
                sueld = sueldo.ADMINISTRACION.getSueldo();
                break;
            default:
                throw new MisExcepciones(misExcepciones.numerosFueraDelIntervalo());
        }
        return sueld;
    }

    public void menuEmpleado1() throws MisExcepciones, NumberFormatException {
        long identificacion;
        System.out.println("Indique una opcion:\n"
                + "\n"
                + " 1. Mostrar Datos Personales \n"
                + " 2. Buscar Empleado          \n"
                + " 3. Editar Datos Personales  \n"
                + " 4. Mostrar Empleados        \n"
                + " 5. Laborar                  \n"
                + " 6. Cerrar sesion            \n"
                + "");
        String validacion = scanner.next();
        int validacion1 = Integer.parseInt(validacion);
        switch (validacion1) {
            case 1:
                System.out.println("Ha elegido Mostrar Datos");
                Cine.mostrarEmpleado();
                menuEmpleado1();
                break;
            case 2:
                System.out.println("Ha elegido Buscar Empleado");
                identificacion = entradaDatos.IngresarIdentificacion();
                if (!Cine.buscar(identificacion)) {
                    throw new MisExcepciones(misExcepciones.personaNoEncontrada());
                }
                menuEmpleado1();
                break;
            case 3:
                System.out.println("Ha elegido Editar Empleado");
                errores = true;
                while (errores) {
                    try {
                        menuEditar(null, null, null, null, 0, 0);
                    } catch (MisExcepciones e) {
                        System.out.println(e.getMessage());
                        errores = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Por favor inserte un numero");
                        errores = true;

                    }
                }
                menuEmpleado1();
                break;

            case 4:
                System.out.println("Ha elegido Mostrar Empleado");
                cine.listarEmpleados();
                menuEmpleado1();
                break;
            case 5:
                System.out.println("Ha elegido Laborar");
                int diasTrabajados = empleado.asistir();
                System.out.println("Usted tiene " + diasTrabajados + " dia(s) trabajado(s)");

                menuEmpleado1();
                break;
            case 6:
                System.out.println("Ha cerrado sesion");
                menuEmpleado();
                break;
            default:
                throw new MisExcepciones(misExcepciones.numerosFueraDelIntervalo());
        }

    }

    public void menuCliente() throws NumberFormatException, MisExcepciones {
        String nombre, apellido, email, direccion;
        double sueldoD = 0;
        int edad;
        long identificacion, celular;

        boolean soc = true;
        System.out.println("Indique una opcion:\n"
                + "\n"
                + " 1. Borrar Cliente           \n"
                + " 2. Registrar Cliente        \n"
                + " 3. Mostrar Datos Personales \n"
                + " 4. Editar Datos Personales  \n"
                + " 5. Buscar Cliente           \n"
                + " 6. Regresar                 \n"
                + "");
        String validacion = scanner.next();
        int validacion1 = Integer.parseInt(validacion);
        switch (validacion1) {
            case 1:
                System.out.println("Ha elegido Borrar Cliente");
                identificacion = entradaDatos.IngresarIdentificacion();
                if (!Cine.validarCedula(identificacion)) {
                    System.out.println("No es posible borrar el cliente");
                    System.out.println("Esta seguro de borrar el cliente");
                    errores = true;
                    while (errores) {
                        try {
                            errores = false;
                            if (this.menuSiNo() == 1) {
                                Cine.eliminarCliente();
                                System.out.println("El cliente ha sido eliminado");
                            } else {
                                System.out.println("El cliente no ha sido eliminado");
                            }
                        } catch (MisExcepciones e) {
                            System.out.println(e.getMessage());
                            errores = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Por favor inserte un numero");
                            errores = true;
                        }
                    }
                }
                menuCliente();
                break;
            case 2:
                System.out.println("Se procedera a registrar el cliente");
                nombre = entradaDatos.IngresarNombre();
                apellido = entradaDatos.IngresarApellido();
                identificacion = entradaDatos.IngresarIdentificacion();
                celular = entradaDatos.IngresarCelular();
                System.out.println("Indique si es socio");
                while (errores) {
                    try {
                        errores = false;

                        menuSiNo();
                        if (menuSiNo() == 1) {
                            soc = Socio.ES_SOCIO.isSocio();
                        } else {
                            soc = Socio.NO_ES_SOCIO.isSocio();
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Error: Por favor inserte un numero");
                        errores = true;
                    } catch (MisExcepciones e) {
                        System.out.println(e.getMessage());
                        errores = true;
                    }
                }
                Cine.registrar(new Cliente(nombre, apellido, identificacion, celular, soc));
                archivo = new File("Clientes.txt");
                file.escrituraArhivo(cine.getCliente(Cine.getNumeroDeCliente() - 1).toString(), archivo);
                if (Cine.validacionCliente()) {
                    Cine.eliminarCliente();
                    throw new MisExcepciones(misExcepciones.dobleRegistro());
                } else {
                    System.out.println("El cliente ha sido registrado con exito");
                    menuCliente();
                }

                break;
            case 3:
                System.out.println("Ha elegido Mostrar Datos del Cliente");
                cine.listarCliente();
                break;
            case 4:
                System.out.println("Ha elejido Editar Datos del Cliente  ");
                identificacion = entradaDatos.IngresarIdentificacion();
                if (!Cine.validarCedula(identificacion)) {
                    System.out.println("No es posible editar el cliente");
                    throw new MisExcepciones(misExcepciones.personaNoEncontrada());
                } else {
                    System.out.println("Esta seguro de editar el cliente");
                    errores = true;
                    while (errores) {
                        try {
                            errores = false;
                            if (this.menuSiNo() == 1) {
                                nombre = entradaDatos.IngresarNombre();
                                apellido = entradaDatos.IngresarApellido();
                                celular = entradaDatos.IngresarCelular();
                                Cine.editarCliente(0, identificacion, nombre, apellido, identificacion, celular, soc);
                                System.out.println("El cliente ha sido editado");
                            } else {
                                System.out.println("El cliente no ha sido editado");
                            }
                        } catch (MisExcepciones e) {
                            System.out.println(e.getMessage());
                            errores = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Por favor inserte un numero");
                            errores = true;
                        }
                    }

                    menuCliente();
                }
                break;
            case 5:
                System.out.println("Ha eljido buscar Cliente");
                identificacion = entradaDatos.IngresarIdentificacion();
                Cine.buscar(identificacion);
                break;
            case 6:
                menuPrincipal();
                break;
            default:
                throw new MisExcepciones(misExcepciones.numerosFueraDelIntervalo());
        }
        menuCliente();
    }

    public int menuSiNo() throws NumberFormatException, MisExcepciones {
        System.out.println("1. Si\n"
                + "2. No");
        String verificacion = scanner.next();
        int verificacion1 = Integer.parseInt(verificacion);
        if (verificacion1 == 1 || verificacion1 == 2) {
            return verificacion1;
        } else {
            throw new MisExcepciones(misExcepciones.numerosFueraDelIntervalo());
        }

    }

    public void menuEditar(String usuario, String contraseña, String nombre,
            String apellido, int edad, long identificacion) throws NumberFormatException, MisExcepciones {
        System.out.println("Por favor digite sus datos nuevos\n\n"
                + "Por favor elija una opcion:\n"
                + "\n"
                + " 1. Editar nombre         \n"
                + " 2. Editar apellido       \n"
                + " 3. Editar edad           \n"
                + " 4. Editar identificacion \n"
                + " 5. Editar usuario        \n"
                + " 6. Editar Contraseña     \n"
                + " 7. No editar mas         \n"
                + "");
        String validacion = scanner.next();
        int validacion1 = Integer.parseInt(validacion);
        switch (validacion1) {
            case 1:
                nombre = entradaDatos.IngresarNombre();
                break;

            case 2:
                apellido = entradaDatos.IngresarApellido();
                break;
            case 3:
                edad = entradaDatos.IngresarEdad();
                break;
            case 4:
                identificacion = entradaDatos.IngresarIdentificacion();
                break;
            case 5:
                usuario = entradaDatos.IngresarUsuario();
                break;
            case 6:
                contraseña = entradaDatos.IngresarContraseña();
                break;
            case 7:
                menuEmpleado1();
            default:
                throw new MisExcepciones(misExcepciones.numerosFueraDelIntervalo());
        }
        if (Cine.editarEmpleado(usuario, contraseña, nombre, apellido, edad, identificacion, 0)) {
            throw new MisExcepciones(misExcepciones.dobleRegistro());
        } else {
            System.out.println("El empleado ha sido editado con exito");
        }
        menuEditar(usuario, contraseña, nombre, apellido, edad, identificacion);

    }

    public void menuBoleteria() throws MisExcepciones {

        System.out.println("Elija una opcion:\n"
                + "1. Película\n"
                + "2. Boleta\n"
                + "3. Regresar");
        String validacion = scanner.next();
        int validacion1 = Integer.parseInt(validacion);
        while (validacion1 != 6) {
            switch (validacion1) {
                case 1:
                    System.out.println("Ha elejido Pelicula");
                    try {
                        menuPelicula();
                    } catch (MisExcepciones e) {
                        System.out.println(e.getMessage());
                        menuPelicula();
                    }

                    break;
                case 2:
                    System.out.println("Ha elejido Boleta");
                    menuBoleta();

                    break;
                case 3:
                    System.out.println("Ha elejido regresar");
                    menuPrincipal();

                default:
                    System.out.println("Ingrese una opcion");

            }
            menuBoleteria();
        }
    }

    public void menuBoleta() throws NumberFormatException, MisExcepciones {
        int sala, asiento;
        String nombre, horario;
        System.out.println("Por favor elija una opción:\n"
                + "<<<<<  1. Registrar Boleta  >>>>>\n"
                + "<<<<<  2. Imprimir Boleta   >>>>>\n"
                + "<<<<<  3. No ingresar mas   >>>>>\n");

        String validacion = scanner.next();
        int validacion1 = Integer.parseInt(validacion);
        while (validacion1 != 6) {
            switch (validacion1) {
                case 1:
                    System.out.println("Ha elejido registrar boleta");
                    sala = entradaDatos.Sala();
                    asiento = entradaDatos.Asiento();
                    nombre = entradaDatos.Pelicula();
                    Pelicula peli = new Pelicula();
                    peli.setNombre(nombre);
                    horario = entradaDatos.Horario();
                    Boleteria.registrarBoleta(sala, asiento, peli, horario);
                    archivo = new File("Boletas.txt");
                    file.escrituraArhivo(Boleteria.getBoleta(Boleteria.getNumeroDeBoleta() - 1).toString(), archivo);
                    break;
                case 2:
                    System.out.println("Ha elegido Listar Boleta");
                    System.out.println("**************************");
                    boleta.listarBoleta();
                    System.out.println("**************************");
                    break;
                case 3:
                    menuBoleteria();
                    break;

                default:
                    throw new MisExcepciones(misExcepciones.numerosFueraDelIntervalo());
            }
            menuBoleta();
        }
    }

    public void menuPelicula() throws MisExcepciones {
        String nombre, actor, director, productor;
        boolean disponibilidad;
        int año, codigo;
        System.out.println("Ha elegido Película");
        Boleteria pelicula = new Boleteria();
        Pelicula peli = new Pelicula();
        System.out.println("Por favor elija una opcion:\n"
                + "\n"
                + " 1. Registrar Pelicula    \n"
                + " 2. Listar Pelicula       \n"
                + " 3. Buscar Pelicula       \n"
                + " 4. Borrar Pelicula       \n"
                + " 5. Editar Pelicula       \n"
                + " 6. No ingresar mas       \n"
                + "");
        String validacion = scanner.next();
        int validacion1 = Integer.parseInt(validacion);
        while (validacion1 != 6) {
            switch (validacion1) {
                case 1:
                    System.out.println("Ha elegido Registrar Pelicula");
                    nombre = entradaDatos.Pelicula();
                    año = entradaDatos.IngresarAño();
                    actor = entradaDatos.Actor();
                    director = entradaDatos.Director();
                    productor = entradaDatos.Productor();
                    disponibilidad = entradaDatos.Disponibilidad();
                    Boleteria.registrarPelicula(nombre, año, actor, director, productor, disponibilidad);
                    archivo = new File("Peliculas.txt");
                    file.escrituraArhivo(Boleteria.getPelicula(Boleteria.getNumeroDePelicula() - 1).toString(), archivo);
                    if (Boleteria.validacionPelicula()) {
                        Boleteria.eliminarPelicula(nombre);
                        throw new MisExcepciones(misExcepciones.dobleRegistroPeli());
                    }

                    break;

                case 2:
                    System.out.println("Ha elegido Listar Pelicula");
                    pelicula.listarPelicula();
                    break;

                case 3:
                    System.out.println("Ha elegido Buscar Pelicula");
                    nombre = entradaDatos.Pelicula();
                    Boleteria.buscarPelicula(nombre);
                    break;

                case 4:
                    System.out.println("Ha elegido Borrar Pelicula");
                    nombre = entradaDatos.Pelicula();
                    Boleteria.eliminarPelicula(nombre);
                    break;
                case 5:
                    System.out.println("Ha elegido Editar Pelicula ingrese nuevos datos");
                    codigo = entradaDatos.codigo();
                    System.out.println(Boleteria.getPelicula(codigo).toString());
                    nombre = entradaDatos.Pelicula();
                    año = entradaDatos.IngresarAño();
                    actor = entradaDatos.Actor();
                    director = entradaDatos.Director();
                    productor = entradaDatos.Productor();
                    disponibilidad = entradaDatos.Disponibilidad();
                    Boleteria.editarPelicula(codigo, nombre, año, actor, director, productor, disponibilidad);
                    break;
                case 6:
                    menuBoleteria();
                    break;
                default:
                    System.out.println("Su opcion es invalida");
                    throw new MisExcepciones(misExcepciones.numerosFueraDelIntervalo());
            }
            menuPelicula();
        }
    }

    public void menuProducto() throws MisExcepciones {
        String nombre, tamaño;
        float costo;
        int cantidad, codigo;
        Tienda tienda = new Tienda();
        System.out.println("Por favor elija una opcion:\n"
                + "\n"
                + " 1. Registrar Producto    \n"
                + " 2. Listar Producto       \n"
                + " 3. Buscar Producto       \n"
                + " 4. Borrar Producto       \n"
                + " 5. Editar Producto       \n"
                + " 6. No ingresar mas       \n"
                + "");
        String validacion = scanner.next();
        int validacion1 = Integer.parseInt(validacion);
        while (validacion1 != 6) {
            switch (validacion1) {
                case 1:
                    System.out.println("Ha elegido Registrar Producto");
                    nombre = entradaDatos.IngresarNombre();
                    tamaño = entradaDatos.Tamaño();
                    costo = entradaDatos.Costo();
                    cantidad = entradaDatos.Cantidad();
                    tienda.registrarProducto(nombre, tamaño, costo, cantidad);
                    archivo = new File("Productos.txt");
                    file.escrituraArhivo(tienda.getProducto(tienda.getNumeroDeProducto() - 1).toString(), archivo);
                    if (tienda.validacionProducto()) {
                        tienda.eliminarProducto(nombre);
                        throw new MisExcepciones(misExcepciones.dobleRegistroPro());
                    }
                    break;
                case 2:
                    System.out.println("Ha elegido Listar Producto");
                    tienda.listarProductos();
                    break;

                case 3:
                    System.out.println("Ha elegido Buscar Producto");
                    nombre = entradaDatos.IngresarNombre();
                    tienda.buscarProducto(nombre);
                    break;

                case 4:
                    System.out.println("Ha elegido Borrar Producto");
                    nombre = entradaDatos.IngresarNombre();
                    tienda.eliminarProducto(nombre);
                    break;
                case 5:
                    System.out.println("Ha elegido Editar Producto");
                    codigo = entradaDatos.codigo();
                    nombre = entradaDatos.IngresarNombre();
                    tamaño = entradaDatos.Tamaño();
                    costo = entradaDatos.Costo();
                    cantidad = entradaDatos.Cantidad();
                    tienda.editarProducto(codigo, nombre, tamaño, costo, cantidad);
                    break;
                case 6:
                    System.out.println("Ha elejido no ingresar mas");
                    int a = 0;
                    System.out.println("Por favor elija una opción:\n"
                            + "\n"
                            + " 1. Empleado       \n"
                            + " 2. Cliente        \n"
                            + " 3. Boletería      \n"
                            + " 4. Tienda         \n"
                            + " 5. Factura        \n"
                            + " 6. Salir          \n"
                            + "");

                    a = scanner.nextInt();
                    break;
                default:
                    throw new MisExcepciones(misExcepciones.numerosFueraDelIntervalo());
            }
            menuProducto();
        }
    }

    public void menuFactura() throws MisExcepciones {
        String fecha;
        int codigo;
        long identificacion;
        int cantidad;
        float costo;
        boolean facturacion = false;
        System.out.println("Por favor elija una opcion:\n"
                + "\n"
                + " 1. Registrar Factura     \n"
                + " 2. Regresar              \n"
                + "");
        String validacion = scanner.next();
        int validacion1 = Integer.parseInt(validacion);
        while (validacion1 != 2) {
            switch (validacion1) {
                case 1:
                    System.out.println("El cliente realiza factura");
                    menuSiNo();
                    if (menuSiNo() == 1) {
                        facturacion = f.SI_FACTURA.isRespuesta();
                        System.out.println("\t\tCINESTRES_D\n\t Sistema de Facturacion\n"
                                + "\tProductos Y Boletas");
                        System.out.println(fac.toString());
                        System.out.println("Ingrese el cliente");
                        identificacion = entradaDatos.IngresarIdentificacion();
                        System.out.println("Ingrese el codigo del producto");
                        codigo = entradaDatos.codigo();
                        System.out.println("Producto");
                        System.out.println(tien.getProducto(codigo).toString());
                        System.out.println("Ingrese numero de productos a vender");
                        cantidad = entradaDatos.Cantidad();
                        System.out.println("Ingrese el costo");
                        costo = entradaDatos.Costo();
                        ir.venderProducto(cantidad, costo);
                        System.out.println("Ingrese numero de boleta(s) a vender");
                        cantidad = entradaDatos.Cantidad();
                        ir.venderBoleta(cantidad);
                        System.out.println("Total a pagar: " + ir.generarCobro());
                        System.out.println("Ingrese empleado");
                        identificacion = entradaDatos.IngresarIdentificacion();
                        System.out.println("Usted fue atentido por: " + Cine.getEmpleado((int) empleado.getIdentificacion()).getNombre());
                        System.out.println("**************Gracias por Preferirnos**************");
                    } else if (menuSiNo() == 2) {
                        System.out.println("Ha elejido no realizar");
                        facturacion = f.NO_FACTURA.isRespuesta();
                    }

                    break;
                case 2:
                    System.out.println("Ha elejido regresar");
                    menuPrincipal();
                    break;
                default:
                    throw new MisExcepciones(misExcepciones.numerosFueraDelIntervalo());
            }

            menuFactura();
        }
    }

    public void menuPrincipal() throws MisExcepciones {
        System.out.println("Por favor elija una opción:\n"
                + "\n"
                + " 1. Empleado       \n"
                + " 2. Cliente        \n"
                + " 3. Boletería      \n"
                + " 4. Tienda         \n"
                + " 5. Factura        \n"
                + " 6. Salir          \n"
                + "");

        int a = scanner.nextInt();
        switch (a) {
            case 1:
                try {
                    menuEmpleado();
                } catch (MisExcepciones e) {
                    System.out.println(e.getMessage());
                    menuEmpleado();
                }

                break;
            case 2:
                try {
                    menuCliente();
                } catch (MisExcepciones e) {
                    System.out.println(e.getMessage());
                    menuCliente();
                }
                break;
            case 3:
                menuBoleteria();
                break;
            case 4:
                try {
                    menuProducto();
                } catch (Exception e) {
                    System.out.println(e.getMessage());

                    menuProducto();
                }

                break;
            case 5:
                menuFactura();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("El numero elegido es incorrecto");
        }
        System.out.println("Por favor elija una opción:\n"
                + "\n"
                + " 1. Empleado       \n"
                + " 2. Cliente        \n"
                + " 3. Boletería      \n"
                + " 4. Tienda         \n"
                + " 5. Factura        \n"
                + " 6. Salir          \n"
                + "");
        a = scanner.nextInt();
    }
}
