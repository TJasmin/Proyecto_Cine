
package cine.Pojos;

public class RolDePago {
    
   private String codigo;
   private String fecha;
   public Empleado []empleado;
   
   public RolDePago(String codigo, String fecha, Empleado[] empleado ) 
   {
       this.codigo = codigo;
       this.fecha = fecha;
       this.empleado = empleado;
   }


   
   public Empleado [] getEmpleado() {
        return empleado;
    }
    
   public void setEmpleado(Empleado[] empleado) {
        this.empleado = empleado;
    }
    
   public int operation11() {
      return 0;
   }
   
   public String getCodigo() {
      return codigo;
   }
   
   public void setCodigo(String newCodigo) {
      codigo = newCodigo;
   }
   
   public String getFecha() {
      return fecha;
   }
   
   public void setFecha(String newFecha) {
      fecha = newFecha;
   }
}

