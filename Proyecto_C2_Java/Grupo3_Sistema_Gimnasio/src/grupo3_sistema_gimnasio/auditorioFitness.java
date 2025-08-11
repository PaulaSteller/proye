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
public class auditorioFitness {
    
     private int capacidadMaxima = 30;
    private int capacidadActual = 0;

    public boolean registrarEntrada(Socio socio) {
        if (!socio.isMembresiaSocio()) {
            JOptionPane.showMessageDialog(null, "Membresía no válida. Acceso denegado.");
            return false;
        }
        if (capacidadActual >= capacidadMaxima) {
            JOptionPane.showMessageDialog(null, "El auditorio está lleno.");
            return false;
        }
        capacidadActual++;
        JOptionPane.showMessageDialog(null, "Entrada registrada. Asistentes: " + capacidadActual);
        return true;
    }

    public boolean registrarSalida(Socio socio) {
        if (capacidadActual <= 0) {
            JOptionPane.showMessageDialog(null, "No hay asistentes en el auditorio.");
            return false;
        }
        capacidadActual--;
        JOptionPane.showMessageDialog(null, "Salida registrada. Asistentes restantes: " + capacidadActual);
        return true;
    }

    public void verAsistencia() {
        JOptionPane.showMessageDialog(null, "Asistencia actual: " + capacidadActual + " / " + capacidadMaxima);
    }
}

