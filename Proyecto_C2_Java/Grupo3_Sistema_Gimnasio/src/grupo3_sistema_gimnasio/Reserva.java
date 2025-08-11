/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3_sistema_gimnasio;

import java.time.LocalTime;

/**
 *
 * @author ashle
 * this class is to create an array to control the schedule of reservation of cabins and ping pong 
 */
public class Reserva {
    

    private LocalTime hora; 
    private int idSocio; // id se guarda en la reserva pero no se muestra 
    private String nombreSocio; // se muestra el nombre 

    public Reserva(LocalTime hora, int idSocio, String nombreSocio) {
        this.hora = hora;
        this.idSocio = idSocio;
        this.nombreSocio = nombreSocio;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    @Override
    public String toString() {
        return  "Reserva de: " + nombreSocio + " " + "Horario: " + hora ;
    }
    
    
    
}
