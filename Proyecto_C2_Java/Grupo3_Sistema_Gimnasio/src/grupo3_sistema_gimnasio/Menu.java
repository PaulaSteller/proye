/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3_sistema_gimnasio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame {

    private Metodos gymnova;

    public Menu() {
        gymnova = new Metodos();
        gymnova.generarDataInicialActividaddes();
        gymnova.dividirClases();
        gymnova.llenarCabinas();

        setTitle("Sistema Gimnasio - Menú");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal con GridLayout para botones
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 1, 5, 5)); // 11 opciones + 1 para salir

        // Crear botones para cada opción
        JButton btnClasesDisponibles = new JButton("1. Clases Disponibles");
        JButton btnEditarClases = new JButton("2. Editar Clases");
        JButton btnCrearClase = new JButton("3. Crear Clase");
        JButton btnRegistrarSocio = new JButton("4. Registrar Socio en Clase");
        JButton btnEliminarClase = new JButton("5. Eliminar Clase");
        JButton btnEliminarSocio = new JButton("6. Eliminar Socio de Clase");
        JButton btnSalaPesas = new JButton("7. Sala de Pesas");
        JButton btnCabinas = new JButton("8. Cabinas Insonorizadas");
        JButton btnAuditorio = new JButton("9. Auditorio Fitness");
        JButton btnParqueo = new JButton("10. Parqueo");
        JButton btnSalir = new JButton("11. Salir");

        // Añadir botones al panel
        panel.add(btnClasesDisponibles);
        panel.add(btnEditarClases);
        panel.add(btnCrearClase);
        panel.add(btnRegistrarSocio);
        panel.add(btnEliminarClase);
        panel.add(btnEliminarSocio);
        panel.add(btnSalaPesas);
        panel.add(btnCabinas);
        panel.add(btnAuditorio);
        panel.add(btnParqueo);
        panel.add(btnSalir);

        add(panel);

        // Acción botones
        btnClasesDisponibles.addActionListener(e -> gymnova.mostrarclases());

        btnEditarClases.addActionListener(e -> {
            gymnova.editarClases();
            gymnova.dividirClases();
        });

        btnCrearClase.addActionListener(e -> {
            gymnova.crearClases();
            gymnova.dividirClases();
        });

        btnRegistrarSocio.addActionListener(e -> gymnova.registrarSocioClase());

        btnEliminarClase.addActionListener(e -> gymnova.eliminarClase());
        /*
        btnEliminarSocio.addActionListener(e -> gymnova.eliminarSocioDeClase());
         */
        btnSalaPesas.addActionListener(e -> gymnova.salaPesas());

        btnCabinas.addActionListener(e -> mostrarMenuCabinas());

        btnAuditorio.addActionListener(e -> mostrarMenuAuditorio());

        btnParqueo.addActionListener(e -> {
            // Aquí asumí que deberías llamar a un método de parqueo,
            // pero en tu código llamabas salaPesas() para opción 10, probablemente error
            // Si tienes método de parqueo, cámbialo aquí:
            // gymnova.parqueo();
            JOptionPane.showMessageDialog(this, "Funcionalidad de Parqueo no implementada.");
        });

        btnSalir.addActionListener(e -> {
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
    }

    private void mostrarMenuCabinas() {
        String[] opciones = {
            "1. Reservar a un Socio en una Cabina",
            "2. Ver horarios Reservados",
            "3. Eliminar una reserva",
            "Cancelar"
        };
        int seleccion = JOptionPane.showOptionDialog(
                this,
                "Seleccione una opción de Cabinas:",
                "Cabinas Insonorizadas",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]);
        /*
        switch (seleccion) {
            case 0:
                gymnova.reservarCabina();
                break;
            case 1:
                gymnova.mostrarReservarCabinas();
                break;
            case 2:
                gymnova.eliminarReservaDecabina();
                break;
            default:
                // Cancelar o cerrar
                break;
        }
         */
    }

    private void mostrarMenuAuditorio() {
        String[] opciones = {
            "1. Ver programación del Auditorio Fitness",
            "2. Inscribir a Socio a un Evento",
            "3. Mostrar inscritos",
            "4. Eliminar Socio de un Evento",
            "Cancelar"
        };
        int seleccion = JOptionPane.showOptionDialog(
                this,
                "Seleccione una opción de Auditorio:",
                "Auditorio Fitness",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]);
        /*
        switch (seleccion) {
            case 0:
                gymnova.mostrarHorarioAuditorio();
                break;
            case 1:
                gymnova.inscribirSocioAuditorio();
                break;
            case 2:
                gymnova.mostrarInscritosAuditorio();
                break;
            case 3:
                gymnova.eliminarSocioInscripcion();
                break;
            default:
                // Cancelar o cerrar
                break;
         */
    }
}


