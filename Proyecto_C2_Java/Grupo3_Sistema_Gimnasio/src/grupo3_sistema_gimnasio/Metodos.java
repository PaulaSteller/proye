/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3_sistema_gimnasio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author ashle
 */
public class Metodos {

    // creamos arrgelo de actividades 
    private Actividad[] actividades = new Actividad[20];   // creamos arrgelo de actividades 
    private int totalDeActividades; // para recorrer el arreglo 

    // arreglo clases de dia 
    private Actividad[] actividadesDia = new Actividad[20];
    private int totalDeActividadesDia; // para recorrer el arreglo 

    // arreglo clases de noche
    private Actividad[] actividadesNoche = new Actividad[20];
    private int totalDeActividadesNoche; // para recorrer el arreglo 

    // sala pesas, auditorio, salas insonorisada, espacios recreativos
    private espaciosRecreativos[] espaciosRecreacion = new espaciosRecreativos[4];

    // objetosSocio es para poder hacer get al array de socios de la clase socio 
    Socio objetosSocio = new Socio();
    Socio[] socios = objetosSocio.getSocio();

    // inicilizar la sala de pesas 
    Pesas salaDePesas = new Pesas(50, 0);

    // Arreglo de cabinas insonorizadas
    cabinasInsonorizadas[] cabinas = new cabinasInsonorizadas[3];
    public static final int duracionMaxima = 30; // 30 minutos cada secion  

    // INCIALIZAR CLASES DE ACTIVIDADES 
    /**
     * THIS METHOD FILLS OUT RANDOMLY THE INITIAL DATA OF THE PREDITERMINATED
     * ACTIVITIES FOR THE GYM
     */
    public void generarDataInicialActividaddes() {

        String[] nombres = {"Yoga", "Crossfit", "Zumba", "Pilates", "funcionales", "Boxeo"}; // que tenga seis nombres de clases para escoger ojo se pueden repetir no hay problema

        Random rand = new Random(); // para usar de manera aleatoria  
        String momento = "";
        int minuto = 0;
        int hora = 0;
        LocalTime horario = LocalTime.of(0, 0); // inicializamos  horario

        for (int i = 0; i < 6; i++) { // ponemos 6 ya que aunque el espacio del array este predeterminado aun esta en 0 sin data entonces el for debe hacer el recorrido 

            String nombreActividad = nombres[rand.nextInt(nombres.length)]; // el siguiente nombre random del arreglo 
            // asignamos horario random 
            if (i <= 2) {
                /// de las 5 am a las 17 en caso de ser clase de dia 
                hora = 5 + rand.nextInt(13);

                minuto = rand.nextInt(60);  // de 0 a 59 minutos
                horario = LocalTime.of(hora, minuto);

                momento = "Dia";
            }

            if (i > 2) {
                /// de las 18 horas  a las 21 horas en caso de ser clase de noche  
                hora = 18 + rand.nextInt(4);

                minuto = rand.nextInt(60);  // de 0 a 59 minutos
                horario = LocalTime.of(hora, minuto);
                momento = "Noche";
            }

            int capacidadActividad = 5 + rand.nextInt(51); //de 5 personas a 50 personas
            int cantidadActual = 0; // 0 en todas ya que nadie esta inscrito aun 
            int numeroUnico = rand.nextInt(((500 - 100) + 1) + 100); // de 100 a 500

            Actividad actividad = new Actividad(nombreActividad, momento, horario, numeroUnico, capacidadActividad, cantidadActual); // asignamos los valores a las nuevas clases 

            actividades[totalDeActividades] = actividad; // anade 
            totalDeActividades++; //suma 

        
    

    /// anade al array de objetos

        }


    }

    /// METODOS RETULIZABLES 
    
     /**
     * THIS METHOD IS CREATED BECAUSE REPEATLY THROUGHTOUT THE CODE IS NEEDED TO
     * SEE THE LIST AGAIIN
     */
    public void verListaClases() {
        // por si requiere ver la lista de nuevo

        int opcion1 = JOptionPane.showConfirmDialog(null, "¿Necesita ver la lista de Actividades de nuevo? Nota: debe ingresa el numero de unico.");
        boolean verLista = (opcion1 == JOptionPane.YES_OPTION);

        if (verLista) {

            //creamos string builder para que se vea mas organizado 
            StringBuilder mostrar = new StringBuilder();

            for (int i = 0; i < totalDeActividades; i++) {  // este for recorre todas las actividades "a" del arreglo actividades

                Actividad a = actividades[i];
                mostrar.append(a.toString()).append("\n"); // recorre y agrega saltyo de linea entre cada participante

            }

            JOptionPane.showInternalMessageDialog(null, "LAS ACTIVIDADES SON: \n"
                    + mostrar);

        }
    }

    /**
     * THIS METHOD ALLOWS TO VIEW ALL MEMBER OF THE GYM AND THEIR DATA
     */
    public void visualizarListaSocios() {
        int opcion2 = JOptionPane.showConfirmDialog(null, "¿Necesita ver la lista de Socios? Nota: Para registrar al socio se necesita su ID unico");

        boolean verLista1 = (opcion2 == JOptionPane.YES_OPTION);

        if (verLista1) {

            //creamos string builder para que se vea mas organizado 
            StringBuilder mostrar = new StringBuilder();

            for (Socio s : socios) {

                mostrar.append(s.toString()).append("\n"); // recorre y agrega saltyo de linea entre cada participante

            }

            JOptionPane.showInternalMessageDialog(null, "LOS SOCIOS DE GYM NOVA SON: \n"
                    + mostrar);

        }

    }

    /**
     * THIS METHOD ALLOWS TO SEARCH FOR A MEMBER
     */
    public Socio buscarSocios() { // public socio para poder return el socio encontrado 

        visualizarListaSocios();

        int idSocioIngresado = -1; // para validar que el usuario no ingrese un dato negativo 

        while (idSocioIngresado < 0) {  // mientras sea menor a 0 que 

            try {
                String inputClase = JOptionPane.showInputDialog("Digite el ID del socio que desea inscribir: ");
                if (inputClase == null) {
                    break; // cancelamos en caso de que el usuario cerrara la ventana 
                }
                idSocioIngresado = Integer.parseInt(inputClase); // asignamos si el valor 

                if (idSocioIngresado < 0) {
                    JOptionPane.showInternalMessageDialog(null, "El numero de la clase no puede ser negativo");
                }
            } catch (NumberFormatException e) { // que no sea un numero entero 
                JOptionPane.showInternalMessageDialog(null, "El numero debe ser entero ");
            }
        }
        Socio socioEncontrado = null; // vamos a usarlo al validar

        // BUSCAMOS EL SOCIO 
        for (int i = 0; i < socios.length; i++) { // por cada socio de socios 

            Socio s = socios[i];
            if (s.getIdSocio() == idSocioIngresado && s.isMembresiaSocio() == true) { // si existe y su membresia es valida
                socioEncontrado = s; // si el ID del socio es igual el socio encontrado es ese 
            }

        }
        if (socioEncontrado == null) {
            JOptionPane.showMessageDialog(null, "Socio no encontrado. O su membresia esta vencida");

        }

        return socioEncontrado; // para que se pueda usar la variable en otras clases 
    }

    /// METODOS DE OBJETO ACTIVIDAD
    
    /**
     * THIS METHOD ALLOWS TO DIVIDE THE CLASES IN  MNORNING CLASES AND NIGHT CLASES 
     */
    
    public void dividirClases() {

        //limpiamos ya que este metodo se retilizar para actualizar los arreglos 
        for (int i = 0; i < totalDeActividadesDia; i++) {
            actividadesDia[i] = null;
        }
        {
            totalDeActividadesDia = 0;
        }

        for (int i = 0; i < totalDeActividadesNoche; i++) {
            actividadesNoche[i] = null;
        }
        {
            totalDeActividadesNoche = 0;
        }

        for (int i = 0; i < totalDeActividades; i++) {  // este for recorre todas las actividades "a" del arreglo actividades

            Actividad a = actividades[i];  // asignamos temporalmente para anadir a sus arreglos respectivo 
            if (a.getMomento().equalsIgnoreCase("dia")) { // que si el momento es igual a dia 

                actividadesDia[totalDeActividadesDia] = a; // se anade el objeto a las clases de dia 
                totalDeActividadesDia++; // sumamos 
            }
            if (a.getMomento().equalsIgnoreCase("noche")) {

                actividadesNoche[totalDeActividadesNoche] = a; // se anade el objeto a las clases de noche 
                totalDeActividadesNoche++; // sumamos 
            }

        }

    }

    /**
     * THIS METHOD ALLOWS TO SHOW THE AVILABLE CLASES
     *
     */
    public void mostrarclases() {

        //creamos string builder para que se vea mas organizado 
        StringBuilder mostrar = new StringBuilder();

        for (int i = 0; i < totalDeActividades; i++) {  // este for recorre todas las actividades "a" del arreglo actividades

            Actividad a = actividades[i];
            if (a != null) {
                mostrar.append(a.toString()).append("\n"); // recorre y agrega saltyo de linea entre cada participante OJO IF PARA QUE NO AGREGUE NULO
            }
        }

        JOptionPane.showInternalMessageDialog(null, "LAS ACTIVIDADES SON: \n"
                + mostrar);

        StringBuilder dia = new StringBuilder(); // para las de dia 

        for (int i = 0; i < totalDeActividadesDia; i++) {  // pasa por todo el arreglo de dia 

            Actividad a = actividadesDia[i];

            if (a != null) {
                dia.append(a.toString()).append("\n"); // salto de linea por objetos   
            }
        }
        JOptionPane.showInternalMessageDialog(null, "Las clases de dia son: \n"
                + dia);

        StringBuilder noche = new StringBuilder(); // para las de noche 

        for (int i = 0; i < totalDeActividadesNoche; i++) {  // pasa por todo el arreglo de noche 

            Actividad a = actividadesNoche[i];

            if (a != null) {
                noche.append(a.toString()).append("\n"); // salto de linea por objetos 
            }
        }
        JOptionPane.showInternalMessageDialog(null, "Las clases de noche son: \n"
                + noche);

    }

    /**
     * THIS METHOD ALLOWS TO EDIT PREXISTEN CLASES
     */
    public void editarClases() {

        JOptionPane.showInternalMessageDialog(null, "BIENVENIDO A LA EDICION DE CLASES");

        verListaClases();    // por si requiere ver la lista de nuevo

        boolean editarDatos = true;  // creamos este dato booleano para que se pueda volver a preguntar si desea cambiar algo + y salir del while

        while (editarDatos) {
            int clase = -1; // para validar que el usuario no ingrese un dato negativo 

            while (clase < 0) {  // mientras sea menor a 0 que 

                try {
                    String inputClase = JOptionPane.showInputDialog("Digite el numero de la clase a editar: ");
                    if (inputClase == null) {
                        break; // cancelamos en caso de que el usuario cerrara la ventana 
                    }
                    clase = Integer.parseInt(inputClase); // asignamos si el valor 

                    if (clase < 0) {
                        JOptionPane.showInternalMessageDialog(null, "El numero de la clase no puede ser negativo");
                    }
                } catch (NumberFormatException e) { // que no sea un numero entero 
                    JOptionPane.showInternalMessageDialog(null, "El numero debe ser entero ");
                }
            }

            //fin del while de validacion 
            // editar la clase
            boolean encontrado = false;
            boolean editarDatos2 = true;

            while (editarDatos2) {
                for (int i = 0; i < totalDeActividades; i++) {  // este for recorre todas las actividades "a" del arreglo actividades

                    Actividad a = actividades[i];

                    if (a.getNumeroUnico() == clase) { // que si la actividad a numero unico es igual al que digito el usuario 
                        encontrado = true; // EN CASO DE QUE NO EXISTA LA CLASE

                        // inicio while editar datos 
                        int option2 = Integer.parseInt(JOptionPane.showInputDialog("¿Que Deseas Editar?\n"  /// CREAMOS LA VARIABLE PARA EL SWITCH 
                    + "1. Nombre de la activdad\n"
                                + "2. Horario de la activdad\n"
                                + "3. Capacidad Maxima \n"
                                + "4. Cantidad de inscritos  \n"
                                + "5. Salir"));
                        switch (option2) {

                            case 1:

                                // INCIO LOGICA INGRESO DE NOMBRE CON VALIDACION 
                                String nombre;
                                boolean correcto = false;

                                do {
                                    nombre = JOptionPane.showInputDialog("Digite el nombre de la actividad"); //pide el nombre 

                                    if (nombre != null && nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                                        /// esta validacion dice a-z, minusculas. A-Z mayusculas, ZáéíóúÁÉÍÓÚñÑ acentos
                    /// y " " espacio en casos como Maria Jose  
                                correcto = true;
                                    } else {
                                        JOptionPane.showInternalMessageDialog(null, "Digite unicamente letras por favor");
                                    }
                                } while (!correcto); // mientras no sea el valor defaultr de false que continue 

                                a.setNombreActividad(nombre); // asignamos el nuevo nombre 

                                // FIN  LOGICA INGRESO DE NOMBRE CON VALIDACION
                                break;
                            case 2:
                                // inicio validacion horario
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                                while (true) {
                                    try {  // usamos try y catch para detectar error 
                                        String input = JOptionPane.showInputDialog("Digite el Horario de la clase en formato militar HH:mm");
                                        LocalTime horario = LocalTime.parse(input, formatter); // cambiamos el valor del input 
                                        a.setHorario(horario);
                                        // validacion momento 
                                        if (horario.isBefore(LocalTime.of(17, 59))) { // si el horario es a las 17:59 o antes 
                                            a.setMomento("Dia");

                                        } else { // si es despues de las 12 
                                            a.setMomento("Noche");
                                        }
                                        break; // salir de algun error
                                    } catch (DateTimeParseException e) {
                                        JOptionPane.showMessageDialog(null, "El formato de la fecha ingresada no es el correcto, se necesita ej 14:30");
                                    }

                                }
                                break; // del while 

                            case 3:

                                /// VALIDAMOS QUE LA NUEVA CAPACIDAD MÁXIMA NO SEA MENOR A LAS PERSONAS ACTUALES
                    
                    int inputcapacidadActividad1 = Integer.parseInt(JOptionPane.showInputDialog("Digite la capacidad maxima de personas que se pueden inscribir SOLO SE PERMITEN NUMEROS:"));
                                if (inputcapacidadActividad1 < a.getCantidadActual() || inputcapacidadActividad1 < 0 || inputcapacidadActividad1 < 5) {
                                    JOptionPane.showMessageDialog(null, "Error: ya hay más personas inscritas que esa capacidad. O el valor no puede ser negativo. O menor a 5");
                                } else {
                                    a.setCapacidadActividad(inputcapacidadActividad1);
                                }  // fin validacion
                                break;
                            case 4:
                                int inputCantidad1 = -1;

                                while (inputCantidad1 < 0) {  // mientras sea menor a 0 que 

                                    try {
                                        String input = JOptionPane.showInputDialog("Digite la cantidad correcta de personas inscritas ");

                                        if (input == null) {
                                            break; // cancelamos en caso de que el usuario cerrara la ventana 
                                        }
                                        inputCantidad1 = Integer.parseInt(input); // asignamos si el valor 

                                        if (inputCantidad1 < 0) {
                                            JOptionPane.showInternalMessageDialog(null, "El numero de inscritos no puede ser negativo");
                                        } else {
                                            a.setCantidadActual(inputCantidad1);

                                        }
                                    } catch (NumberFormatException e) { // que no sea un numero entero 
                                        JOptionPane.showInternalMessageDialog(null, "El numero debe ser entero ");
                                    }
                                }

                                break;
                            case 5:
                                editarDatos = false;
                                continue; //continua con el codigo  
                            default:
                                JOptionPane.showMessageDialog(null, "La opcion no es valida");
                                continue;
                        }

                    }

                }

                if (!encontrado) { // si no se encontro
                    JOptionPane.showInternalMessageDialog(null, "El numero de clase no existe");
                }

                // agregar llave
                /// PREGUNTAMOS SI DESEA EDITAR ALGO MAS DE LA MISMA CLASE 
            
                  
                        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea cambiar algo mas de la MISMA clase?");
                editarDatos2 = (respuesta == JOptionPane.YES_OPTION);

            }

            /// PREGUNTAMOS SI DESEA EDITAR OTRA CLASE MAS
            
                  
                        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea cambiar otra clase?");
            editarDatos = (respuesta == JOptionPane.YES_OPTION);
        }

// fin while editar clases
        // por si requiere ver la lista actualizada
        int opcion2 = JOptionPane.showConfirmDialog(null, "¿Desea ver la lista actualizada?");
        boolean verLista1 = (opcion2 == JOptionPane.YES_OPTION);

        if (verLista1) {

            //creamos string builder para que se vea mas organizado 
            StringBuilder mostrar = new StringBuilder();

            for (int i = 0; i < totalDeActividades; i++) {  // este for recorre todas las actividades "a" del arreglo actividades

                Actividad a = actividades[i];
                mostrar.append(a.toString()).append("\n"); // recorre y agrega saltyo de linea entre cada participante

            }

            JOptionPane.showInternalMessageDialog(null, "LAS ACTIVIDADES SON: \n"
                    + mostrar);

        }
    }

    /**
     * THIS METHOD ALLOWS TO CREATE NEW CLASES
     */
    public void crearClases() {

        JOptionPane.showInternalMessageDialog(null, "BIENVENIDO AL SISTEMA DE CREACION DE CLASES GRUPALES");

        String momento = " "; // momento desde afuera para validar adentro 
        LocalTime horario = LocalTime.of(0, 0); // inicializamos  horario

        // INCIO LOGICA INGRESO DE NOMBRE CON VALIDACION 
        String nombre;
        boolean correcto = false;

        do {
            nombre = JOptionPane.showInputDialog("Digite el nombre de la actividad"); //pide el nombre 

            if (nombre != null && nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                /// esta validacion dice a-z, minusculas. A-Z mayusculas, ZáéíóúÁÉÍÓÚñÑ acentos
                    /// y " " espacio en casos como Maria Jose  
                                correcto = true;
            } else {
                JOptionPane.showInternalMessageDialog(null, "Digite unicamente letras por favor");
            }
        } while (!correcto); // mientras no sea el valor defaultr de false que continue 

        // inicio validacion horario
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        while (true) {
            try {  // usamos try y catch para detectar error 
                String input = JOptionPane.showInputDialog("Digite el Horario de la clase en formato militar HH:mm");
                horario = LocalTime.parse(input, formatter); // cambiamos el valor del input 
                // validacion momento 
                if (horario.isBefore(LocalTime.of(17, 59))) { // si el horario es a las 17:59 o antes 
                    momento = "Dia";

                } else { // si es despues de las 12 
                    momento = "Noche";
                }
                break; // salir de algun error
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "El formato de la fecha ingresada no es el correcto, se necesita ej 14:30");
            }

        }

        /// VALIDAMOS QUE LA CAPACIDAD MAXIMA
                    
                              int inputcapacidadActividad1 = -1;

        while (inputcapacidadActividad1 < 0 || inputcapacidadActividad1 < 5) {
            try {
                String inputCan = JOptionPane.showInputDialog("Digite la capacidad de la clase *MINIMO 5 PERSONAS*: ");
                if (inputCan == null) {
                    break; // cancelamos en caso de que el usuario cerrara la ventana 
                }
                inputcapacidadActividad1 = Integer.parseInt(inputCan); // asignamos si el valor 

                if (inputcapacidadActividad1 < 0 || inputcapacidadActividad1 < 5) {
                    JOptionPane.showInternalMessageDialog(null, "El numero de la clase no puede ser negativo. O es menor que el minimo de 5");
                }
            } catch (NumberFormatException e) { // que no sea un numero entero 
                JOptionPane.showInternalMessageDialog(null, "El numero debe ser entero ");
            }
        }

        int inputActual = -1;

        while (inputActual < 0) {  // mientras sea menor a 0 que 

            try {
                String input = JOptionPane.showInputDialog("Digite la cantidad de personas inscritas ");

                if (input == null) {
                    break; // cancelamos en caso de que el usuario cerrara la ventana 
                }
                inputActual = Integer.parseInt(input); // asignamos si el valor 

                if (inputActual < 0 || inputActual > inputcapacidadActividad1) {
                    JOptionPane.showInternalMessageDialog(null, "El numero de inscritos no puede ser negativo. O mayor a la capacidad de la clase");
                }
            } catch (NumberFormatException e) { // que no sea un numero entero 
                JOptionPane.showInternalMessageDialog(null, "El numero debe ser entero ");
            }
        }
        Random rand = new Random();

        int numeroUnico = rand.nextInt(((500 - 100) + 1) + 100); // de 100 a 500

        Actividad actividad = new Actividad(nombre, momento, horario, numeroUnico, inputcapacidadActividad1, inputActual);
        actividades[totalDeActividades] = actividad; // anade 
        totalDeActividades++; //suma 
    }

    /**
     * This method allows the receptionist to delete a class
     */
    public void eliminarClase() {

        JOptionPane.showInternalMessageDialog(null, "BIVENIDO AL ESPACIO PARA ELIMINAR UNA CLASE");

        verListaClases(); // por si requiere ver la lista de nuevo

        boolean encontrado = false;

        boolean eliminar = true;

        while (eliminar) {

            int clase = -1; // para validar que el usuario no ingrese un dato negativo 

            while (clase < 0) {  // mientras sea menor a 0 que 

                try {
                    String inputClase = JOptionPane.showInputDialog("Digite el numero de la clase a eliminar: ");
                    if (inputClase == null) {
                        break; // cancelamos en caso de que el usuario cerrara la ventana 
                    }
                    clase = Integer.parseInt(inputClase); // asignamos si el valor 

                    if (clase < 0) {
                        JOptionPane.showInternalMessageDialog(null, "El numero de la clase no puede ser negativo");
                    }
                } catch (NumberFormatException e) { // que no sea un numero entero 
                    JOptionPane.showInternalMessageDialog(null, "El numero debe ser entero ");
                }
            }

            // buscar la actividad 
            Actividad claseEliminar = null; // para tener encontrar y eliminar separados 

            for (int i = 0; i < totalDeActividades; i++) {  // este for recorre todas las actividades "a" del arreglo actividades

                Actividad a = actividades[i];
                if (a.getNumeroUnico() == clase) {
                    claseEliminar = a; // asignamos la clase corrrecta 
                    encontrado = true;
                    break;
                }
            }

            // logica para eliminar 
            final int claseFinal = clase;
            /// hay que crearlo final para poder usar el numero ingresado del usuario en la expresion lamba de eliminar
            /// esto debido a que la variable clase tiene la posibilidad de cambiarse en la validacion y java no permite eso un una accion lamba
            
            if (claseEliminar != null) {

                int idx = -1;
                for (int i = 0; i < totalDeActividades; i++) {
                    if (actividades[i].getNumeroUnico() == claseFinal) {
                        idx = i;
                        break;
                    } // asiganmos el idx para hacer la eliminacion de la actividad por aparte 
                }

                if (idx != -1) {
                    for (int j = idx; j < totalDeActividades - 1; j++) { // para buscar
                        actividades[j] = actividades[j + 1];
                    }
                    actividades[totalDeActividades - 1] = null; // igualamos a null para "eliminar"    
                    totalDeActividades--; // restamos 
                }

            }

            JOptionPane.showMessageDialog(null, "Clase eliminada con exito");
            /// PREGUNTAMOS SI DESEA EDITAR ALGO MAS
           int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea eliminar otra clase?");
            eliminar = (respuesta == JOptionPane.YES_OPTION);
        }
        if (!encontrado) { // si no se encontro
            JOptionPane.showInternalMessageDialog(null, "El numero de clase no existe");
        }

    }

    /**
     * THIS METHOD ALLOWS THE RECEPCIONIST TO REGISTER A MEMBER TO ANY CLASS
     */
    public void registrarSocioClase() {
        JOptionPane.showMessageDialog(null, "BIENVENIDO AL REGISTRO DE SOCIOS A CLASES");

        visualizarListaSocios(); // llamamos en caso de que necesite ver que so

        boolean editarDatos = true;  // creamos este dato booleano para que se pueda volver a preguntar si desea cambiar algo + y salir del while

        while (editarDatos) {

            Socio socioEncontrado = buscarSocios();

            if (socioEncontrado != null) {
                verListaClases(); // por si necesita recordad el numero unico de la clase 

                int clase = -1; // para validar que el usuario no ingrese un dato negativo 

                while (clase < 0) {  // mientras sea menor a 0 que 

                    try {
                        String inputClase = JOptionPane.showInputDialog("Digite el numero de la clase a la que va a inscribir al socio: ");
                        if (inputClase == null) {
                            break; // cancelamos en caso de que el usuario cerrara la ventana 
                        }
                        clase = Integer.parseInt(inputClase); // asignamos si el valor 

                        if (clase < 0) {
                            JOptionPane.showInternalMessageDialog(null, "El numero de la clase no puede ser negativo");
                        }
                    } catch (NumberFormatException e) { // que no sea un numero entero 
                        JOptionPane.showInternalMessageDialog(null, "El numero debe ser entero ");
                    }
                }

                //fin del while de validacion 
                // editar la clase
                boolean encontrado = false;

                for (int i = 0; i < totalDeActividades; i++) {  // este for recorre todas las actividades "a" del arreglo actividades

                    Actividad a = actividades[i];
                    if (a.getNumeroUnico() == clase) { // que si la actividad a numero unico es igual al que digito el usuario 
                        encontrado = true;

                        if (a.getCantidadActual() < a.getCapacidadActividad()) {  // if de si la clase esta llena 

                            a.setCantidadActual((a.getCantidadActual() + 1)); // setteamos la cantidad actual 
                        } else {
                            JOptionPane.showMessageDialog(null, "La clase ya esta llena");
                        }
                    }

                }
                if (!encontrado) { // si no se encontro
                    JOptionPane.showInternalMessageDialog(null, "El numero de clase no existe");
                }

                if (encontrado) {
                    JOptionPane.showMessageDialog(null, "EL SOCIO FUE REGISTRADO CON EXITO");

                }
            }
            /// PREGUNTAMOS SI DESEA EDITAR ALGO MAS
            
                  
                        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea registrar a otro Socio?");
            editarDatos = (respuesta == JOptionPane.YES_OPTION);

        }

        //fin while editar 
    }

    // FIN METODOS CLASE ACTIVIDAD
    // METODOS SALA DE PESAS
    /**
     * This method allows to register any member on the available gym spaces
     */
    public void registrarSocioEnEspacios() {

        if (salaDePesas.getCapacidadMaxima() > salaDePesas.getCapcacidadActual()) {  // if de si la clase esta llena 

            salaDePesas.setCapcacidadActual((salaDePesas.getCapcacidadActual() + 1)); // setteamos la cantidad actual 
            JOptionPane.showMessageDialog(null, "Socio registrado con exito al la sala de pesas");
        } else {
            JOptionPane.showMessageDialog(null, "La sala de pesas ya esta lleno");
        }

        return; //terminamos de procesar 

    }

    /**
     * THIS METHOD ALLOWS TO REGISTER WHEN A MEMBER LEAVES A SPACE
     *
     */
    public void registrarSalidaEspacio() {

        if (salaDePesas.getCapcacidadActual() > 0) {  // if sala no esta vacia

            salaDePesas.setCapcacidadActual(salaDePesas.getCapcacidadActual() - 1); // setteamos la cantidad actual 

            JOptionPane.showMessageDialog(null, "Se registro la salida del socio con exito");
        } else {
            JOptionPane.showMessageDialog(null, "El espacio ya vacio");
        }

        return; //terminamos de procesar 

    }

    /**
     * THIS METHOD MANAGES ALL THE ACTIVITY ON THE WEIGHTS ROOM
     */
    public void salaPesas() {

        // LOGICA PARA REGISTRAR A UN SOCIO A LA SALA DE PESAS 
        boolean seguir = true; // para poder salir del while

        while (seguir) {

            int option4 = Integer.parseInt(JOptionPane.showInputDialog(" BIENVENIDO A LA SALA DE PESAS \n"  /// CREAMOS LA VARIABLE PARA EL SWITCH 
                    + "1. Registrar Entrada \n"
                    + "2. Registrar Salida \n"
                    + "3. Ver Cantidad de personas dentro \n"
                    + "4. Salir"));
            switch (option4) {

                case 1:
                    Socio socioEncontrado = buscarSocios(); // para usar al socio 

                    if (socioEncontrado != null) { // si el socio es valido 
                        registrarSocioEnEspacios(); // instanceamos metodo reutilizable
                    }

                    break;
                case 2:
                    registrarSalidaEspacio();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "La capacidad actual de la sala de pesas de es: " + salaDePesas.getCapcacidadActual());
                    break;
                case 4:
                    seguir = false;
                    break;
                default:
                    JOptionPane.showInternalMessageDialog(null, "La opcion no es valida");
            }

        }

    }

    // METODOS DE CABINAS 
    /**
     * THIS METHOD IS TO FILL OUT THE 3 PREXISTING CABINS FOR SOCIOS
     */
    public void llenarCabinas() {

        cabinas[0] = new cabinasInsonorizadas(1, "Concentracion");
        cabinas[1] = new cabinasInsonorizadas(1, "Meditacion");
        cabinas[2] = new cabinasInsonorizadas(1, "Ejercicios personalizados");

    }

    /**
     * This method is to convert the hour reserved to the index of how many
     * reservations can be made
     *
     * @param hora
     * @return
     */
    public int horaIndice(LocalTime hora) {

        /// lo que calcula este metodo es, cuantos bloques de los 18 permitidos de 30 minutos, han pasado desde la hora que ingresa la recepcionista para la reserva
        /// ej: si el socio ingres 10:30, 1. hora de apertura es 9:00, calculamos la diferencia de minutos (10 - 9) * 60 = 60 minutos, 30min dura la reserva, entonces 90 minutos
        /// desde la apertura, dividimos entre 30, 90 / 30 = 3. entonces lo que devolvemos es ese 3 como indicador que la posicion 3 de las reservar esta ocupada
        
        LocalTime apertura = LocalTime.of(9, 0); // abre a las 9
        int minutosDiferencia = (hora.getHour() - apertura.getHour()) * 60 + hora.getMinute();
        int indice = minutosDiferencia / duracionMaxima;
        return indice; // de 0 a 17 

    }

    public void reservarCabina() {

        JOptionPane.showMessageDialog(null, "Bienvenido a la reserva de cabinas, primero debe buscar al socio");

        boolean continuar = true; // es para preguntar si quiere hacer otro registro 

        while (continuar) {
            Socio socio = buscarSocios(); // instanceamos el metodo 
            if (socio == null) { // si se cancelo
                return; //no se encontro el socio cancelamos 
            }

            // mensaje para luego ensenar en pantalla
            String mensaje = "Seleccione la cabina: \n"
                    + "1. Concentracion \n "
                    + "2. Meditacion \n"
                    + "3. Ejercicios Personalizado";

            String opcion = JOptionPane.showInputDialog(null, mensaje);

            if (opcion == null) {
                return; // si se cancelo 
            }
            int eleccion; // para validar lo que se ingreso 
            try {
                eleccion = Integer.parseInt(opcion) - 1; // -1 pq es para usar en un arreglo

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null, "Opcion no valida");
                return;
            }

            if (eleccion < 0 || eleccion >= cabinas.length) {
                JOptionPane.showMessageDialog(null, "Opcion no valida");
                return;
            }

            // Pedimos el horario de incio de la reserva 
            String hora = JOptionPane.showInputDialog("Digite la hora de incio (HH:mm): ");

            if (hora == null) {
                return; // lo cancelo 
            }
            LocalTime horarioSolicitado;
            try {
                horarioSolicitado = LocalTime.parse(hora);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Formnato invalido");
                return;

            }

            // validar el horario 
            LocalTime apertura = LocalTime.of(9, 0); //abre a las 9 
            LocalTime cierre = LocalTime.of(18, 0); //abre a las 6pm

            if (horarioSolicitado.isBefore(apertura) || horarioSolicitado.isAfter(cierre)) { // si no esta dentro de las horas permitidas
                JOptionPane.showMessageDialog(null, "Hora solicitada fuera de horario");
                return;

            }

            // calculamos el indice para poder reservar 
            int indice = horaIndice(horarioSolicitado);
            Reserva[] reservas = cabinas[eleccion].getReservas(); // asignamos el arreglo correcto de reservas de la cabina seleccionada 

            if (reservas[indice] != null) {
                JOptionPane.showMessageDialog(null, "Ya hay una reserva en ese horario en la cabina " + cabinas[eleccion].getNombreCabina());
            } else { // si no se cumple ninguna excepcion reservamos normal 

                reservas[indice] = new Reserva(horarioSolicitado, socio.getIdSocio(), socio.getNombreSocio());
                JOptionPane.showMessageDialog(null, "Reserva confirmada " + cabinas[eleccion].getNombreCabina() + "Para " + socio.getNombreSocio() + "A las " + horarioSolicitado);
            }

        }
        // preguntamos si desea continuar 
        
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea hacer otra reserva?", "confirmar", JOptionPane.YES_NO_OPTION); // confirmar para no hacer la conversion por aparte 
        if (respuesta != JOptionPane.YES_OPTION) {
         continuar = false; // sale del loop 
        }

    }
}
