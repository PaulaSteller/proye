/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3_sistema_gimnasio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ashle
 */
public class Socio {

    // DEFINIMOS VARIABLES 
    private String nombreSocio;
    private int idSocio;
    private boolean membresiaSocio;

    /// INICIALIZAMOS

    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public boolean isMembresiaSocio() {
        return membresiaSocio;
    }

    public void setMembresiaSocio(boolean membresiaSocio) {
        this.membresiaSocio = membresiaSocio;
    }

    public Socio(String nombreSocio, int idSocio, boolean membresiaSocio) {
        this.nombreSocio = nombreSocio;
        this.idSocio = idSocio;
        this.membresiaSocio = membresiaSocio;
    }

    public Socio() {
    }

    @Override
    public String toString() {
        return "Nombre Socio: " + nombreSocio + " " + "ID Socio: " + idSocio + " " + "Membresia Socio: " + membresiaSocio;
    }

    public Socio[] getSocio() {

        Socio[] socios = new Socio[2];
        socios[0] = new Socio("Juan", 1252, true);
        socios[1] = new Socio("Matias", 3828, false);

        return socios;

    }

}
