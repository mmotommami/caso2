
package sistemapaneles;

/**
 *
 * @author Mariangel Alfaro Diaz
 */
public class PanelSolar extends FuenteDeEnergia {
    /**
     * Constructor de la clase
     * @param capacidadMaxima 
     */
    public PanelSolar(double capacidadMaxima, Historial historial) {
        this.capacidadMaxima = capacidadMaxima;
        this.energiaDisponible = 0.0;
        this.historial = historial;
    }
    
    /**
     * Metodo para suministrar energia a un panel
     * Recibe una cantidad de energia a agregar y un identificador de panel
     * @param extra
     * @param numPanel 
     */
    public void recargar(double extra, int numPanel){
        int aux = numPanel+1;
        if(getCapacidadMaxima() == energiaDisponible){  //Verifica si es necesaria la carga
            System.out.println("El panel " + aux + " esta cargado completamente");
            historial.agregarTextoAlHistorial("El panel " + aux + " esta cargado completamente");
        }else{
            if (getCapacidadMaxima() < energiaDisponible + extra){ // Verifica si recibe mas energia de la que puede almacenar
                this.energiaDisponible = getCapacidadMaxima();
                System.out.println("El panel " + aux + " esta cargado completamente");
                historial.agregarTextoAlHistorial("El panel " + aux + " esta cargado completamente");
            }else{
               this.energiaDisponible += extra;
               System.out.println("Energia disponible en el panel " + aux + ": " + this.energiaDisponible );
               historial.agregarTextoAlHistorial("Energia disponible en el panel " + aux + ": " + this.energiaDisponible );
            }
        }
    }
    
}
