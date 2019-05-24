
package cine.Interfaces;

import static cine.Interfaces.ListarObjeto.*;

/**
 *
 * @author Tania 
 */
public interface ListarObjeto {

    interface ListarBoleteria {

        public void listarBoleta();

        public void listarPelicula();
    }

    static interface ListarCine {

        public void listarEmpleados();
    }

    interface ListarTienda {

        public void listarProductos();

    }
}
