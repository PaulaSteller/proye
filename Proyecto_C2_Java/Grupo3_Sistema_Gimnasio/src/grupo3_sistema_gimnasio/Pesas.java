/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3_sistema_gimnasio;

import javax.swing.JOptionPane;

/**
 *
 * @author ashle
 */
public class Pesas {
    
   private int capacidadMaxima;
   private int capcacidadActual; 

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getCapcacidadActual() {
        return capcacidadActual;
    }

    public void setCapcacidadActual(int capcacidadActual) {
        this.capcacidadActual = capcacidadActual;
    }

    public Pesas(int capacidadMaxima, int capcacidadActual) {
        this.capacidadMaxima = capacidadMaxima;
        this.capcacidadActual = capcacidadActual;
    }

    

}


   

