/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3_sistema_gimnasio;

import javax.swing.JOptionPane;

/**
 *
 * @author isaacherrera
 */
public class espaciosRecreativos {
     private int capacidadMaxima = 20;
    private int capacidadActual = 0;

    public boolean registrarEntrada(Socio socio) {
        if (!socio.isMembresiaSocio()) {
            JOptionPane.showMessageDialog(null, "Debe tener membresía activa para ingresar.");
            return false;
        }
        if (capacidadActual >= capacidadMaxima) {
            JOptionPane.showMessageDialog(null, "Espacio recreativo lleno.");
            return false;
        }
        capacidadActual++;
        JOptionPane.showMessageDialog(null, "Ingreso registrado. Personas dentro: " + capacidadActual);
        return true;
    }

    public boolean registrarSalida(Socio socio) {
        if (capacidadActual <= 0) {
            JOptionPane.showMessageDialog(null, "El área está vacía.");
            return false;
        }
        capacidadActual--;
        JOptionPane.showMessageDialog(null, "Salida registrada. Personas restantes: " + capacidadActual);
        return true;
    }

    public void verCapacidad() {
        JOptionPane.showMessageDialog(null, "Personas en espacios recreativos: " + capacidadActual + " / " + capacidadMaxima);
    }
}

