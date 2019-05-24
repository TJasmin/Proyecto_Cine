package cine.Pojos;

import cine.Interfaces.ListarObjeto;

public class Boleteria implements ListarObjeto.ListarBoleteria {

    private static final String HORARIO_DE_PELÍCULAS = "15:00-21:00";
    private static Boleta[] boletas;
    private static int numeroDeBoleta;
    private static int numeroDePelicula;
    private static Pelicula[] peliculas;
    private static Cine cine;

    static {
        boletas = new Boleta[500];
        numeroDeBoleta = 0;
        peliculas = new Pelicula[500];
        numeroDePelicula = 0;
        cine = cine;
    }

    public static void registrarBoleta(int numeroDeSala, int numeroDeAsiento, Pelicula pelicula, String horaioDePelicula) {

        if (numeroDeBoleta == boletas.length) {
            Boleta[] boletaextra = boletas;
            boletas = new Boleta[numeroDeBoleta + 1];
            System.arraycopy(boletaextra, 0, boletas, 0, numeroDeBoleta);
        }
        boletas[numeroDeBoleta] = new Boleta(numeroDeSala, numeroDeAsiento, pelicula, horaioDePelicula);
        numeroDeBoleta++;
    }

    @Override
    public void listarBoleta() {
        Boleta boletaAux;
        for (int i = 0; i < numeroDeBoleta; i++) {
            boletaAux = this.getBoleta(i);
            System.out.println("\t\tCinestres_D" + "\n"
                    + "Boleta Nº " + (i + 1) + "\n" + boletaAux.toString());
        }
    }

    public static void registrarPelicula(String nombre, int año, String actor, String director, String productor, boolean disponibilidad) {

        if (numeroDePelicula == peliculas.length) {
            Pelicula[] peliculaextra = peliculas;
            peliculas = new Pelicula[numeroDePelicula + 1];
            System.arraycopy(peliculaextra, 0, peliculas, 0, numeroDePelicula);
        }
        peliculas[numeroDePelicula] = new Pelicula(nombre, año, actor, director, productor, disponibilidad);
        numeroDePelicula++;
    }

    public static Pelicula getPelicula(int indice) {
        return peliculas[indice];
    }

    @Override
    public void listarPelicula() {
        Pelicula peliculaAux;
        for (int i = 0; i < numeroDePelicula; i++) {
            peliculaAux = getPelicula(i);
            System.out.println("Pelicula\n" + "Codigo " + (i) + ":\n" + peliculaAux.toString());
        }
    }

    public static boolean validacionPelicula() {
        for (int i = 0; i < numeroDePelicula - 1; i++) {
            if (peliculas[i].equals(peliculas[numeroDePelicula])) {
                return true;
            }
        }
        return false;
    }

    public static void eliminarPelicula(String nombre) {

        for (int i = 0; i < numeroDePelicula; i++) {
            if (nombre.equals(peliculas[i].getNombre())) {
                Pelicula[] pelicula1 = peliculas;
                peliculas = new Pelicula[numeroDePelicula - 1];
                if (i == 0) {
                    System.arraycopy(pelicula1, 1, peliculas, 0, numeroDePelicula - 1);
                } else if (i > 0 && i < numeroDePelicula) {
                    System.arraycopy(pelicula1, 0, peliculas, 0, i);
                    System.arraycopy(pelicula1, i + 1, peliculas, i, numeroDePelicula - (i + 1));
                } else if ((i + 1) == numeroDePelicula) {
                    System.arraycopy(pelicula1, 0, peliculas, 0, numeroDePelicula - 1);
                }
                System.out.println("La Pelicula ha sido eliminada");
                numeroDePelicula--;
            } else {
                System.out.println("La Pelicula no se ha encontrado");
            }
        }
    }

    public static void buscarPelicula(String nombre) {
        for (int i = 0; i < numeroDePelicula; i++) {
            Pelicula peliculaAux = getPelicula(i);
            if (nombre.equals(peliculas[i].getNombre())) {
                System.out.println("Pelicula " + (i + 1) + " : " + "\n" + peliculaAux.toString());
            } else {
                System.out.println("La Pelicula no se ha encontrado");
            }
        }
    }

    public static void editarPelicula(int indice, String nombre, int año, String actor, String director, String productor, boolean disponibilidad) {

        Pelicula pelicula = peliculas[indice];
        peliculas[indice] = new Pelicula(nombre, año, actor, director, productor, disponibilidad);

    }

    public void listarBoletas() {
        Boleta boletaAux;
        for (int i = 0; i < numeroDeBoleta; i++) {
            boletaAux = this.getBoleta(i);
            System.out.println("\t\tCinestres_D" + "\n"
                    + "Boleta Nº " + (i + 1) + "\n" + boletaAux.toString());
        }
    }

    public static boolean verificarDePelicula() {
        boolean condicion = true;
        for (int i = 0; i < numeroDePelicula; i++) {
            if (peliculas[i].getNombre() != null) {
                return condicion;
            } else {
                return false;
            }
        }
        return condicion;
    }

    public static boolean verificarDisponibilidadDeAsientos() {
        boolean condicion = true;
        for (int i = 0; i < numeroDeBoleta; i++) {
            if (boletas[i].getNumeroDeAsiento() == boletas.length) {
                return condicion;
            } else {
                return false;
            }
        }
        return condicion;
    }

    public static int getNumeroDePelicula() {
        return numeroDePelicula;
    }

    public static int getNumeroDeBoleta() {
        return numeroDeBoleta;
    }

    public static Boleta getBoleta(int indice) {
        return boletas[indice];
    }

    public static void setBoleta(Boleta newBoleta) {
        numeroDeBoleta++;
        boletas[numeroDeBoleta] = newBoleta;
    }

    public static Cine getCine() {
        return cine;
    }

    public static void setCine(Cine cine) {
        cine = cine;
    }

}
