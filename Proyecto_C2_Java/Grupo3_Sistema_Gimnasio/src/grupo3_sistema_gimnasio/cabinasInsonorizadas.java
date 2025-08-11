/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3_sistema_gimnasio;

import java.time.LocalTime;
import javax.swing.JOptionPane;

/**
 *
 * @author isaacherrera
 */
public class cabinasInsonorizadas {
    
    // Atributos 
    
    private String nombreCabina; 
    private int idCabina; 
    private Reserva[] reservas; 
    private int cantidadReservar; 
    
    public static final int maxReservas = 18; // de las 9 a las 6pm hay 18 bloques de 30 minutos, static pq petenece a la clase final no debe cambiar, public lo necesitamos en otras 
   

    public cabinasInsonorizadas(int id, String nombre) { // int id de la cabina que desean reservar 
        this.nombreCabina = nombre; 
        this.idCabina = id;
        this.reservas = new Reserva[maxReservas]; // sea crea la reserva acorde con el maximo estipulado 
        this.cantidadReservar = 0;
    }   

    public String getNombreCabina() {
        return nombreCabina;
    }

    public void setNombreCabina(String nombreCabina) {
        this.nombreCabina = nombreCabina;
    }

    public int getIdCabina() {
        return idCabina;
    }

    public void setIdCabina(int idCabina) {
        this.idCabina = idCabina;
    }

    public Reserva[] getReservas() {
        return reservas;
    }

    public void setReservas(Reserva[] reservas) {
        this.reservas = reservas;
    }

    public int getCantidadReservar() {
        return cantidadReservar;
    }

    public void setCantidadReservar(int cantidadReservar) {
        this.cantidadReservar = cantidadReservar;
    }
    
    

    
}


