/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3_sistema_gimnasio;

import javax.swing.JOptionPane;
import java.time.LocalTime; 
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author ashle
 */
public class Actividad {

    /// DEFINIMOS LAS VARIABLES
    
    private String nombreActividad;
    private String momento; 
    private LocalTime horario; // Usamos Java Date\
    private int numeroUnico; 
    private int capacidadActividad;
    private int cantidadActual;
    
    

  

    /// INICIALIZAMOS
    /// @return  

    public String getNombreActividad() {
        return nombreActividad;
    }

    public int getNumeroUnico() {
        return numeroUnico;
    }

    public void setNumeroUnico(int numeroUnico) {
        this.numeroUnico = numeroUnico;
    }
    
    

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public int getCapacidadActividad() {
        return capacidadActividad;
    }

    public String getMomento() {
        return momento;
    }

    public void setMomento(String momento) {
        this.momento = momento;
    }
    

    public void setCapacidadActividad(int capacidadActividad) {
        this.capacidadActividad = capacidadActividad;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    
    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public Actividad(String nombreActividad, String momento, LocalTime horario, int numeroUnico, int capacidadActividad, int cantidadActual) {
        this.nombreActividad = nombreActividad;
        this.momento = momento;
        this.horario = horario;
        this.numeroUnico = numeroUnico;
        this.capacidadActividad = capacidadActividad;
        this.cantidadActual = cantidadActual;
    }


    

    public Actividad() {
    }
    
   

    @Override
    public String toString() {
        return "Nombre Actividad: " + nombreActividad + " " + "El numero unico: "+ numeroUnico + " "+ "Capacidad Maxima: " + capacidadActividad + " " + "Cantidad actual: " + cantidadActual + "  " + "En el transcurso de "+ momento +"  "+ "El horario de la clase es  " + horario;
    }

}
