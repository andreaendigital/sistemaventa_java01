/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaventa;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Andrea
 */
public class SistemaVenta {
        public static Scanner scanner = new Scanner(System.in);
        static final String[] sectores = {"VIP", "Palco", "Platea Baja", "Platea Alta", "Galeria"};
        static final String nombreTeatro = "TEATRO MORO";

        static ArrayList <Reserva> reservas = new ArrayList<>();
        static ArrayList <Venta> ventas = new ArrayList<>();
        static ArrayList <Cliente> clientes = new ArrayList<>();
        static ArrayList <Venta> ventasAnuladas = new ArrayList<>();
        static ArrayList <Ticket> ticketsVendidos = new ArrayList<>();

        
        static int capacidadSala = 50;
        static int totalIngresos = 0; 
        static int contadorAsientosOcupados = 0;
        static int entradasDisponibles = (capacidadSala - contadorAsientosOcupados);

    
       
    public static void main(String[] args) {
        Asiento[][] mapa = MapaTeatro.crearMapa(sectores);
        Reserva reserva = null;
        ejecutarMenu(mapa, reserva);   
                
    } //Cierre void main
    
  
    
    
    
    // 🔹 MÉTODOS PRINCIPALES DEL SISTEMA
    
    public static void ejecutarMenu(Asiento[][] mapa, Reserva reserva){
        int opcion;

        do{ //ciclo principal que genera iteración del menú
            FuncionesAuxiliares.mostrarMenu();
            opcion = FuncionesAuxiliares.validarInt(scanner);
            scanner.nextLine(); //Limpia el buffer, con esta línea al incorporar el if antes del while, el programa se detiene hasta que el usuario presione Enter
   
            switch(opcion){
                case 1:
                    FuncionesAuxiliares.mostrarPromociones();
                    break;
                case 2:
                    Titulos.tituloMapa();
                    MapaTeatro.mostrarMapa(mapa, sectores);
                    break;
                case 3:
                    Titulos.tituloReservas();
                    reserva = reservarEntradas(mapa, sectores, scanner);
                    break;
                case 4:
                    Titulos.tituloModificarReservas();
                    if (reservas.isEmpty()){
                       System.out.println("\n----------------------------------");
                        System.out.println("Para modificar una reserva, realice una primero.");
                    }else{
                        System.out.print("Ingrese el ID de la reserva que desea eliminar: ");
                        int idBuscado = FuncionesAuxiliares.validarInt(scanner);
                        scanner.nextLine(); // limpiar buffer
         
                        boolean encontrada = false;
                            for (Reserva r : reservas) {
                                if (r.getIdReserva() == idBuscado) {
                                    modificarReserva(scanner, r);
                                    MapaTeatro.mostrarMapa(mapa, sectores);
                                    encontrada = true;
                                    break;
                                }
                            }
                    
                        
                            if (!encontrada) {
                                System.out.println("No se encontro una reserva con ese ID.");
                            }
                    }           
                    break;
                case 5:
                    Titulos.tituloEliminarReservas();
                    if (reservas.isEmpty()){
                       System.out.println("\n----------------------------------");
                        System.out.println("Para eliminar una reserva, realice una primero.");
                    }else{
                        System.out.print("Ingrese el ID de la reserva que desea eliminar: ");
                        int idBuscado = FuncionesAuxiliares.validarInt(scanner);
                        scanner.nextLine(); // limpiar buffer
         
                        boolean encontrada = false;
                            for (Reserva r : reservas) {
                                if (r.getIdReserva() == idBuscado) {
                                    eliminarReserva(r, scanner);
                                    MapaTeatro.mostrarMapa(mapa, sectores);                    
                                    encontrada = true;
                                    break;
                                }
                            }
                    
                        
                            if (!encontrada) {
                                System.out.println("No se encontro una reserva con ese ID.");
                            }
                    }
                    break;
                    
                case 6:
                    //Comprar la entrada
                    Titulos.tituloCompras();
                    if (reservas.isEmpty()){
                       System.out.println("\n----------------------------------");
                        System.out.println("Para realizar/confirmar una compra, realice una reserva primero.");
                    }else{
                        System.out.print("Ingrese el ID de la reserva que desea confirmar como compra: ");
                        int idBuscado = FuncionesAuxiliares.validarInt(scanner);
                        scanner.nextLine(); // limpiar buffer
         
                        boolean encontrada = false;
                            for (Reserva r : reservas) {
                                if (r.getIdReserva() == idBuscado) {
                                        // Validar si TODOS los asientos siguen estando en estado "R"
                                        boolean reservaValida = true;
                                        for (Asiento a : r.getAsientos()) {
                                            if (a.getEstado().equals("L")) {
                                                reservaValida = false;
                                                break;
                                            }
                                        }

                                        if (reservaValida) {
                                            confirmarCompra(r, scanner);
                                            MapaTeatro.mostrarMapa(mapa, sectores);
                                        } else {
                                            System.out.println("No existe una reserva valida con ese ID. Verificar quizas fue eliminada.");
                                        }

                                        encontrada = true;
                                        break;
                                    }
                                }    
                            if (!encontrada) {
                                System.out.println("No se encontro una reserva con ese ID.");
                            }
                    }
                    break;
                case 7:
                    Titulos.tituloAnulacionVenta();
                    if(ventas.isEmpty()){
                       System.out.println("\n----------------------------------");
                        System.out.println("No hay ventas para anular.");
                    }else{
                        System.out.print("Ingrese el ID de la venta que desea anular: ");
                        int idBuscado = FuncionesAuxiliares.validarInt(scanner);
                        scanner.nextLine(); // limpiar buffer
         
                        boolean encontrada = false;
                            for (Venta venta : ventas) {
                                if (venta.getIdVenta() == idBuscado) {
                                    anularVenta(venta, ventas, ventasAnuladas);
                                    MapaTeatro.mostrarMapa(mapa, sectores);
                                    encontrada = true;
                                break;
                                }
                            }   
                        
                            if (!encontrada) {
                                System.out.println("No se encontro una venta con ese ID.");
                            }
                    }
        
                    break;
                case 8:
                    Titulos.tituloBoleta();
                    if(ventas.isEmpty()){
                       System.out.println("\n----------------------------------");
                        System.out.println("No hay ventas para imprimir boleta respectiva.");
                    }else{
                        System.out.print("Ingrese el ID de la venta para imprimir la boleta: ");
                        int idBuscado = FuncionesAuxiliares.validarInt(scanner);

                        boolean encontrada = false;
                        for (Venta venta : ventas) {
                            if (venta.getIdVenta() == idBuscado) {
                                
                                Ticket primerTicket = venta.getTicketsVendidos().get(0);
                                imprimirBoleta(venta, venta.getCliente().getNombre(), primerTicket.getSector(), (int) primerTicket.getPrecioBase());
                                encontrada = true;
                                break;
                            }
                        }

                        if (!encontrada) {
                            System.out.println("No se encontro una venta con ese ID.");
                        }
                        
                    }

                    break;
               case 9:
                   Titulos.tituloTicket();
                   mostrarTickets(ventas, scanner);
                   break;
                 
                
                case 10:
                    estadisticasGenerales();
                    MapaTeatro.mostrarMapa(mapa, sectores);
                    break;
                case 11:
                    Listar.listarClientes();
                    break;
                case 12:
                    Listar.listarReservas();
                    break;
                case 13:
                    Listar.listarVentas();
                    break;
                case 14:
                    Listar.listarVentasAnuladas();
                    break;
                case 15:
                    Listar.listarTicketsVendidos();
                    break;
                case 16:
                    FuncionesAuxiliares.mensajeCierreSistema();
                    break;
                default:
                    System.out.println("Opcion no valida intente nuevamente");
            }
            
            if (opcion != 16) {
                System.out.println("\n Presiona Enter para volver al menu...");
                scanner.nextLine(); //Esperar Enter del usuario
            }            
            
            
        } while( 16 != opcion);
    
        scanner.close();        
        
        
    }//Cierre ejecutarMenu
      
    public static Reserva reservarEntradas(Asiento[][] mapa, String[] sectores, Scanner scanner){
        
        MapaTeatro.mostrarMapa(mapa, sectores);
        String ubicacionElegida = solicitarUbicacion(scanner);
        int precioBase = precioSegunUbicacion(ubicacionElegida);
        int cantidadEntradas = solicitarCantidadEntradas(scanner, mapa, ubicacionElegida);
        int idCliente; String nombre; int edad; String genero; double precioFinal; 
        
        if(cantidadEntradas == 0 ){
             System.out.println("\n*****************************************");
            System.out.println(" Volviendo al Menu Principal...");
            System.out.println("*****************************************");
            return null;
            
        }

   
        ArrayList<Asiento> asientosReservados = new ArrayList<>();  //lista para almacenar los asientos a reservar 
        ArrayList<Ticket> tickets = new ArrayList<>(); // lista para los tickets en caso de que se confirme la compra
        double totalPagar = 0; //variable para acumular el total a pagar considerando descuentos.
        
        //************************************************************
        //BLUCLE DE RESERVA ---- UNO Para cada entrada.... 
        for(int contador = 0; contador < cantidadEntradas; contador ++){
                System.out.println("\n*************************************************************");
        
                System.out.println("A continuacion ingresaremos la informacion para la entrada N# " + (contador+1) + " : ");
            
            //******ELIGE ASIENTO
            Asiento asiento = null;
            while(true){
                mostrarAsientosDisponiblesPorUbicacion(mapa, ubicacionElegida);
                System.out.println("");
                System.out.println("Ingrese el numero del asiento (ejemplo: A1) de la entrada " + (contador+1) + " : ");
                String codigoAsiento = scanner.nextLine().trim().toUpperCase();
        
                asiento = buscarAsiento(mapa, codigoAsiento);
            
                if(asiento != null && asiento.getTipo().equalsIgnoreCase(ubicacionElegida)){
                    if(asiento.getEstado().equals("L")){
                        asiento.reservar(); //el asiento se marca como reservado
                        asientosReservados.add(asiento); // se guarda en la lista de asientos reservados
                        break; //asiento correcto, sale del bucle
                    }else{
                        System.out.println("El asiento " + codigoAsiento + " no esta disponible.");
                  
                    }
                } else{
                    System.out.println("El asiento no existe o no pertenece a la ubicacion seleccionada.");
                 
                }
            }
                
            //*** DATOS DE CLIENTE PARA ESTA ENTRADA
            
            // Validar RUT
            while (true) {
                System.out.print("Ingrese Rut Cliente (sin puntos ni digito verificador): ");
                idCliente = FuncionesAuxiliares.validarInt(scanner);
                 scanner.nextLine();//Limpia el buffer

                if (idCliente>0) {
                    break;
                } else {
                    System.out.println("El RUT no es valido. Intentelo nuevamente.");
                }
            }
            
            // Validar Nombre
            while (true) {
                System.out.print("Ingrese Nombre: ");
                nombre = scanner.nextLine().trim();

                if (!nombre.isEmpty()) { 
                   break;
                } else {
                    System.out.println("El nombre no puede estar vacio. Intentelo nuevamente.");
                }
            }

            edad = solicitarEdad(scanner);
            scanner.nextLine(); // limpiar buffer

            
            while (true) {
                System.out.print("Ingrese Genero ( M si es masculino / F si es Femenino ) : ");
                genero = scanner.nextLine().trim().toUpperCase();

                if (genero.equals("M") || genero.equals("F")) {
                    break; // válido, salimos del bucle
                } else {
                    System.out.println("Entrada inválida. Debe ingresar solo 'M' o 'F'. Inténtelo nuevamente.");
                }
            }

            Cliente clienteAsistente = new Cliente(idCliente, nombre, edad, genero, "Asistente");
            Cliente clienteExistente = buscarClientePorId(idCliente);
            
            if (clienteExistente == null) {
                clienteAsistente = clienteAsistente;
                clientes.add(clienteAsistente);
            } else if (clienteExistente.getRol().equals("Asistente") ||clienteExistente.getRol().equals("Comprador") ) {
                System.out.println("Cliente ya existe en los registros.");
            } // Si ya existe y tiene otro rol, tampoco se hace nada


            precioFinal = precioBase * clienteAsistente.getDescuentoFactor();
        
            System.out.println("-----------------------------------------------");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("");        
            System.out.println("         Resumen de la Entrada N# " + (contador+1)   );
            System.out.println("");
            System.out.println(clienteAsistente.getDetalleCliente());
            System.out.println("");            
            System.out.println("Valor normal de la entrada: $ " + precioBase);
            System.out.println("Total con descuento: $ " + precioFinal);
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("-----------------------------------------------");
            
            totalPagar += precioFinal; //suma el valor de cada entrada para el valor total de la boleta
            
            //CREA UN TICKET POR CADA ENTRADA
            Ticket ticket = new Ticket( ubicacionElegida, asiento, precioBase, precioFinal, clienteAsistente);
            tickets.add(ticket);
        }
        
        System.out.println("\n-----------------------------------------------");
        System.out.println("Usted ha reservado los siguientes asientos:");
        
        for(Asiento a : asientosReservados){
            System.out.println(a.getCodigo()+" ");
        }
        
        System.out.println("\n");
        
        MapaTeatro.mostrarMapa(mapa, sectores);
        
        //hasta aquí llega el proceso de reserva propiamente tal.
        
        
        //CLIENTE PRINCIPAL QUE PAGA 
        System.out.println("\n--------------------------------------------------");
         System.out.println("AHORA INGRESE SU INFORMACION (quien paga, responsable de la reserva) : ");

               
       //totalPagar = calcularValorEntradas (scanner, precioBase, descuento, cantidadEntradas);

        System.out.println("\nIngrese su nombre: ");
        nombre = scanner.next().trim().toLowerCase();
  
        System.out.print("Ingrese Rut Cliente (sin puntos ni digito verificador): ");
        idCliente = FuncionesAuxiliares.validarInt(scanner);
        
        
        edad = solicitarEdad(scanner);
        scanner.nextLine(); // <-- limpia el buffer del Enter que queda
        
        System.out.print("Ingrese Genero (M/F): ");
        genero = scanner.nextLine().trim().toUpperCase();
            
        
        //Crear cliente y agregarlo a la lista
        Cliente clienteExistente = buscarClientePorId(idCliente);
        Cliente clientePrincipal = new Cliente(idCliente, nombre, edad, genero, "Comprador");
        
        if (clienteExistente == null) {
            clientePrincipal = clientePrincipal;
            clientes.add(clientePrincipal);
        } else if (clienteExistente.getRol().equals("Asistente")) {
            clienteExistente.setRol("Comprador"); // Se actualiza el rol si era Asistente
            System.out.println("Cliente identificado en los registros");
        }  


        //Crear reservar y agregarla a la lista.  Se crea el objeto Reserva final y se guarda en la lista global de reservas.
        Reserva nuevaReserva = new Reserva(clientePrincipal, asientosReservados, (int) totalPagar, cantidadEntradas, tickets);
        reservas.add(nuevaReserva);
        
         // crear nueveo resumen reservar  --- >   
        mostrarResumenReserva(nuevaReserva, nombre, ubicacionElegida, precioBase);

        
        System.out.println("\n-------------------------------------------");
        System.out.println("Su reserva ha sido creada con exito. El ID de su reserva es: " + nuevaReserva.getIdReserva());
        System.out.println("Para confirmar la compra, modificar o eliminar su reserva \nlo enviaremos de vuelta al menu principal");
        
        return nuevaReserva;

        // --------------------------------------------------------------------------
        // Aqui da la opcion de compra desde dentro de la reserva sin salir del menú: 
        //confirmarCompra(asientosReservados, scanner); //llamar confirmacion de compra
        
        //System.out.println("\nMapa actualizado: ");
        //mostrarMapa(mapa, tipos);
        
        //deberia retornar una reserva.
        
    }//Cierre reservarEntradas
    
    public static void confirmarCompra(Reserva reserva, Scanner scanner){
        ArrayList<Asiento> reservados = reserva.getAsientos();
        
        System.out.println("\n-Desea confirmar la compra y ocupar estos asientos? (s/n) :");
        String confirmacion = scanner.nextLine().toLowerCase();
   
        if(confirmacion.equalsIgnoreCase("s")){
            for(Asiento a: reservados){
                a.ocupar(); //Cambia el estado de los asientos a OO ocupados
            }

             // Recorre los tickets de la reserva y los marcas como vendidos
            for (Ticket t : reserva.getTickets()) {
                t.ticketVendido(); // Cambias el estado del ticket a "vendido"
            }
            
            Cliente clientePrincipal = reserva.getClientePrincipal();
            Venta nuevaVenta = new Venta(clientePrincipal, reservados, reserva.getTotalPagar(), reserva.getCantidadEntradas() , reserva.getTickets() );
            ventas.add(nuevaVenta);

            //Agrega los tickets reservados a la lista de vendidos
            ticketsVendidos.addAll(reserva.getTickets());

            //Sumo el total de ingresos, estadistica global
            totalIngresos += reserva.getTotalPagar();
            
            System.out.println("----------------------------------------");
            System.out.println("\nCompra confirmada. \nVenta Registrada. \nAsientos Ocupados. \nTickets Generados \nBoleta Generada.\nVuelva al Menu Principal para Imprimir su Boleta");
            System.out.println("El id de su compra es :" + nuevaVenta.getIdVenta() );
            System.out.println("");
            
        }else if (confirmacion.equalsIgnoreCase("n")){

            for(Asiento a : reservados){
                a.estado="L"; //libera las reservas
            }
            
            // Recorre los tickets de la reserva y los marcas como eliminados
            for (Ticket t : reserva.getTickets()) {
                t.cancelarTicket(); // Cambias el estado del ticket a "eliminado"
            }
            
            System.out.println("-----------------------------------------");
            System.out.println("\nCompra cancelada. \nVenta no realizada. \nAsientos Liberados. \nTickets Reservados Eliminados");
        } else {
            //No hacemos nada, quedan reservados. 
            //salimos del metodo y volvemos al menu principal
            System.out.println("-----------------------------------------");
            System.out.println("Opcion no valida. Los asientos quedan reservados temporalmente. \nElija una opcion del menu principal para seguir.");
        }
        
    }//Cierre confirmarCompra    
    
    public static void modificarReserva(Scanner scanner, Reserva reserva){
       int entradasDevueltas;
        
        System.out.println("\n------------------------------\n****** MODIFICAR RESERVA ********");
     
        System.out.println("Usted ha reservado " + reserva.getCantidadEntradas() + " entradas.");
       
        do{
            System.out.println("-Cuantas desea devolver?");
            entradasDevueltas = FuncionesAuxiliares.validarInt(scanner);
            scanner.nextLine();// Limpiar buffer

            if(entradasDevueltas>reserva.getCantidadEntradas()){
                System.out.println("No puede devolver mas entradas que las compradas, intente nuevamente");
            } else if (entradasDevueltas <=0){
                System.out.println("Opcion no valida."); 
            }else{
                break;
            }    

        }while(true);
        

        System.out.println("\nUsted reservo los siguientes asientos: " );
        
        for (Asiento a : reserva.getAsientos()){
            System.out.println(" Ubicacion: " + a.getTipo() + " | Asiento: " + a.getCodigo());
        }    
        
        ArrayList<Asiento> asientosDevueltos = new ArrayList<>();

        for (int i = 1; i <= entradasDevueltas; i++){
            System.out.println("Ingrese el codigo del asiento # " + i + " que desea devolver:");
            String codigo = scanner.nextLine().trim().toUpperCase();

            Asiento asientoEncontrado = null;
            
            for(Asiento a : reserva.getAsientos()){
                if(a.getCodigo().equalsIgnoreCase(codigo)){
                    asientoEncontrado = a;
                    break;
                }
            }

            if(asientoEncontrado != null){
                asientosDevueltos.add(asientoEncontrado);
            }else{
                System.out.println("El asiento ingresado no esta en su reserva. Intente nuevamente");
                i--;//repetir intento
            }
        }

        //libera los asientos reservados de la lista donde almacenó los asientos devueltos
        for(Asiento a : asientosDevueltos){
            a.estado="L"; //libera las reservas
        }
            System.out.println("Se ha liberado la reserva del asiento indicado. Revise el mapa para confirmar.");
    //reserva.cantidadEntradas = reserva.getAsientos().size();
reserva.getAsientos().removeAll(asientosDevueltos);

              
    }//Cierre modificarReserva    
        
    public static void eliminarReserva(Reserva reserva, Scanner scanner){
        ArrayList<Asiento> reservados = reserva.getAsientos();
        
        System.out.println("\n-Desea eliminar la reserva vigente? (s/n) :");
        String confirmacion = scanner.nextLine().toLowerCase();
   
        if(confirmacion.equalsIgnoreCase("s")){
            for(Asiento a : reservados){
                a.estado="L"; //libera las reservas
            }
            System.out.println("-----------------------------------------");
            System.out.println("Reserva Eliminada. Asientos Liberados.");
           //¿ nuevaReserva.. clean? dejo null su información ?
            
        }else if (confirmacion.equalsIgnoreCase("n")){
           System.out.println("-----------------------------------------");
            System.out.println("Los asientos continuan reservados. \nElija una opcion del menu principal para seguir.");
             
        } else {
            //No hacemos nada, quedan reservados. 
            //salimos del metodo y volvemos al menu principal
            System.out.println("-----------------------------------------");
            System.out.println("Opcion no valida. Los asientos quedan reservados temporalmente. \nElija una opcion del menu principal para seguir.");
        }
        
    }//Cierre eliminarReserva
    
    
    
    
    // 🔹 MÉTODOS AUXILIARES (subfunciones que ayudan a los principales)
    
    public static Cliente buscarClientePorId(int idCliente) {
        for (Cliente c : clientes) {
            if (c.getIdCliente() == idCliente) {
                return c;
            }
        }
        return null;
    }

    public static String solicitarUbicacion(Scanner scanner){
     
        String ubicacionElegida;

        // Manejo de error con ciclo do-while para validar la entrada
        do {
            System.out.println("\n---------------------------------");
            System.out.println("-En que tipo de ubicacion desea comprar? (VIP, Palco, Platea Baja, Platea Alta, Galeria): ");
            ubicacionElegida = scanner.nextLine().trim().toLowerCase();
            //System.out.println("ubicacion elegida input: " + ubicacionElegida); //comprobacion de input
            // Validar que la ubicación sea una opción válida
            if (!ubicacionElegida.equals("vip") && 
                !ubicacionElegida.equals("palco") && 
                !ubicacionElegida.equals("platea baja") && 
                !ubicacionElegida.equals("platea alta") && 
                !ubicacionElegida.equals("galeria")) {
                System.out.println("Ubicacion no valida, por favor ingrese VIP, Palco, Platea Baja, Platea Alta, Galeria.");
            }

        } while (!ubicacionElegida.equals("vip") && 
                 !ubicacionElegida.equals("palco") && 
                !ubicacionElegida.equals("platea baja") && 
                !ubicacionElegida.equals("platea alta") && 
                 !ubicacionElegida.equals("galeria"));

       return ubicacionElegida;
    } //Cierre solicitarUbicacion  
   
    public static void mostrarTickets(ArrayList<Venta> ventas, Scanner scanner) {
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas aun.");
            return;
        }

        System.out.print("Ingrese el ID de la venta: ");
        int idVentaBuscada = FuncionesAuxiliares.validarInt(scanner);

        boolean encontrada = false;
        for (Venta venta : ventas) {
            if (venta.getIdVenta() == idVentaBuscada) {
                System.out.println("\n---------------------------------------------");
                System.out.println("Tickets vendidos para la Venta ID: " + idVentaBuscada);
                System.out.println("---------------------------------------------");

                for (Ticket ticket : venta.getTicketsVendidos()) {
                    ticket.mostrarDetalleTickets();
                   
                }

                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("No se encontro una venta con ese ID.");
        }
        
    }

    public static void mostrarAsientosDisponiblesPorUbicacion(Asiento[][] mapa, String ubicacionElegida) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("\nAsientos disponibles en la ubicacion: " + ubicacionElegida.toUpperCase());
        
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                Asiento asiento = mapa[i][j];
             
                // Solo mostrar asientos disponibles y que coincidan con la ubicación seleccionada
                if (asiento.getTipo().equalsIgnoreCase(ubicacionElegida) ) {
                        System.out.print(mapa[i][j].mostrar());
                         if (j < mapa[i].length - 1) System.out.print(", ");
             
                }
            }
           // System.out.println();
        }
    }
    
    public static int solicitarCantidadEntradas(Scanner scanner, Asiento[][] mapa, String ubicacionElegida){
        int cantidad =0;    
        
        //Verificar entradas disponibles en la ubicación elegida
        int disponiblesEnUbicacion = 0;
        
        for(int i=0; i<mapa.length; i++){
            for(int j=0; j<mapa[i].length; j++){
                Asiento asiento = mapa[i][j];
                if(asiento.getTipo().equalsIgnoreCase(ubicacionElegida)&& asiento.getEstado().equals("L") ){
                    disponiblesEnUbicacion++;
                }
            }
        }
        
        if(disponiblesEnUbicacion <= 0){
            System.out.println("\n*****************************************");
            System.out.println("No hay entradas disponibles en la ubicacion selecionada.");
            System.out.println("*****************************************");
            return 0;
        }
        
        if(entradasDisponibles <=0){

            System.out.println("\n*****************************************");
            System.out.println("No hay entradas disponibles para la venta");
            System.out.println("*****************************************");
            return 0;
        }

        do{

            System.out.println("\n---------------------------------");
            System.out.println("-Cuantas entradas desea comprar?");
                cantidad = FuncionesAuxiliares.validarInt(scanner);
                scanner.nextLine(); //Limpia el buffer

                if(cantidad > entradasDisponibles){
                    System.out.println("Hay solo " + entradasDisponibles + " entradas disponibles en total.");
                    System.out.println("10 maximo por ubicacion. \nRevise el mapa para confirmar las entradas disponibles.");
                    System.out.println("En esta ubicacion " + ubicacionElegida.toUpperCase() + " hay solo " + disponiblesEnUbicacion + " asientos disponibles. " );

                }else if(cantidad>10){
                    System.out.println("No puede comprar mas de 10 entradas por ubicacion");
                    System.out.println("En esta ubicacion " + ubicacionElegida.toUpperCase() + " hay solo " + disponiblesEnUbicacion + " asientos disponibles. " );
                }else if(cantidad> disponiblesEnUbicacion){
                    System.out.println("En esta ubicacion " + ubicacionElegida.toUpperCase() + " hay solo " + disponiblesEnUbicacion + " asientos disponibles. " );
                }else if(cantidad <=0){
                    System.out.println("No valido. Ingrese un numero de entradas valido.");
                    System.out.println("En esta ubicacion " + ubicacionElegida.toUpperCase() + " hay solo " + disponiblesEnUbicacion + " asientos disponibles. " );
                }

        }while(cantidad<=0 || cantidad > 10 ||cantidad > disponiblesEnUbicacion);


        return cantidad;
    }//Cierre solicitarCantidadEntradas    
   
    public static Asiento buscarAsiento(Asiento[][] mapa, String codigo){
        for(int i= 0; i<mapa.length;i++){
            for(int j=0; j<mapa[i].length; j++){
                if(mapa[i][j].getCodigo().equalsIgnoreCase(codigo)){
                    return mapa[i][j];
                }
            }
        }
        return null;
    } //Cierre buscarAsiento
    
    public static int solicitarEdad(Scanner scanner){
        int edad;
        System.out.println("Ingrese edad:");
        edad = FuncionesAuxiliares.validarInt(scanner);
        return edad;
    }//Cierre solicitarEdad  
    
    public static int precioSegunUbicacion(String ubicacionElegida){
            
        int precioBase = 0;
            
        //Uso switch para asignar el precio Base de cada entrada según la ubicación elegida.
        switch (ubicacionElegida){
            case "vip":
                precioBase = 25000;
                    System.out.println("");  
                    System.out.println("-----------------------------------------------");
                    System.out.println("--///////////////////////////////////////////--");
                    System.out.println(" ");        
                    System.out.println("El valor de las entradas VIP es de $" + precioBase+ " cada una.");
                    System.out.println(" ");        
                    System.out.println("--///////////////////////////////////////////--");
                    System.out.println("-----------------------------------------------");

                break;
            case "palco":
                precioBase = 18000;
                    System.out.println("");  
                    System.out.println("-----------------------------------------------");
                    System.out.println("--///////////////////////////////////////////--");
                    System.out.println(" ");        
                    System.out.println("El valor de las entradas PALCO es de $" + precioBase + " cada una.");
                    System.out.println(" ");        
                    System.out.println("--///////////////////////////////////////////--");
                    System.out.println("-----------------------------------------------");
                break;
            case "platea baja":
                precioBase = 15000;
                    System.out.println("");  
                    System.out.println("-----------------------------------------------");
                    System.out.println("--///////////////////////////////////////////--");
                    System.out.println(" ");        
                    System.out.println("El valor de las entradas PLATEA BAJA es de $" + precioBase + " cada una.");
                    System.out.println(" ");        
                    System.out.println("--///////////////////////////////////////////--");
                    System.out.println("-----------------------------------------------");
                break;
            case "platea alta":
                precioBase = 12500;
                    System.out.println("");  
                    System.out.println("-----------------------------------------------");
                    System.out.println("--///////////////////////////////////////////--");
                    System.out.println(" ");        
                    System.out.println("El valor de las entradas PLATEA ALTA es de $" + precioBase + " cada una.");
                    System.out.println(" ");        
                    System.out.println("--///////////////////////////////////////////--");
                    System.out.println("-----------------------------------------------");
                break;
            case "galeria":
                precioBase = 10000;
                    System.out.println("");  
                    System.out.println("-----------------------------------------------");
                    System.out.println("--///////////////////////////////////////////--");
                    System.out.println(" ");        
                    System.out.println("El valor de las entradas GALERIA es de $" + precioBase+ " cada una.");
                    System.out.println(" ");        
                    System.out.println("--///////////////////////////////////////////--");
                    System.out.println("-----------------------------------------------");
                break;
        }
        
        return precioBase;
        
    }//Cierre precioSegunUbicacion  
 
    public static int calcularValorEntradas(Scanner scanner, int precioBase, double descuento, int cantidadEntradas){
      
        int totalPagar;
        int precio_descuento_edad;
        int precio_descuento_grupal;
        
        if(descuento == 0){
           precio_descuento_edad = precioBase*cantidadEntradas;
        } else{
           precio_descuento_edad = (int) ((precioBase*descuento)*cantidadEntradas);  
        }
        
         if(4 == cantidadEntradas){

                        //descuento = precioBase/2;
                        precio_descuento_grupal = ((precioBase * 3) + (precioBase/2));
                        //tipoEntrada = "4ta al 50%";

            } else{
                precio_descuento_grupal = precio_descuento_edad ;  
            }
         
        //Seleccionar el menor precio
        //Compara el precio del descuento de edad con el descuento grupal
        //Se aplica el descuento mayor, se cobra el menor valor a pagar
        
            if(precio_descuento_grupal < precio_descuento_edad){
             totalPagar = precio_descuento_grupal;
             //tipoDescuento = "Grupal";
            } else {
                totalPagar = precio_descuento_edad;

            }
            
            
        return totalPagar;
        
    }//Cierre calcularValorEntradas

    public static void imprimirBoleta (Venta ventas, String nombreCliente, String ubicacionElegida, int precioBase ){
        //Resumen de la compra
        System.out.println("");
        System.out.println("---------------------------------------------------------");
        System.out.println("--/////////////////////////////////////////////////////--");
        System.out.println("||                                                     ||");        
        System.out.println("||                      " +nombreTeatro +"                      ||");
        System.out.println("||                  BOLETA ELECTRONICA                 ||");
        System.out.println("||                                                     ||");        
        System.out.println("---------------------------------------------------------");
        System.out.println("--/////////////////////////////////////////////////////--");
        System.out.println("||                                                     ||");        
        System.out.println("|| A nombre de : " + nombreCliente+ "                                ||");
        System.out.println("|| ID Venta : "+ ventas.getIdVenta() + "                                        ||");
        System.out.println("|| Cantidad de entradas compradas: " + ventas.getCantidadEntradas() + "                   ||" );
        System.out.println("|| Ubicacion de las entradas: " +  ubicacionElegida  + "                      ||");
        System.out.println("|| Valor Entrada sin descuento: " + precioBase +"                    ||");
        System.out.println("||                                                     ||");
   
        ventas.getTicketsVendidos().forEach(ticketVendido -> {
            System.out.println(ticketVendido.getResumenVenta());
            });
        
        System.out.println("||                                                     ||");
        System.out.println("||*****************************************************||"); 
        System.out.println("|| Total a pagar: " + ventas.getTotalPagar() + "                                ||");
        System.out.println("||                                                     ||");
        System.out.println("||                                                     ||");
        System.out.println("--/////////////////////////////////////////////////////--");
        System.out.println("---------------------------------------------------------");


    }//Cierre mostrarResumenReserva
    
    public static void mostrarResumenReserva (Reserva reserva, String nombreCliente, String ubicacionElegida, int precioBase ){
        //Resumen de la compra
        System.out.println(" ");
        System.out.println("---------------------------------------------------------");
        System.out.println("--/////////////////////////////////////////////////////--");
        System.out.println("||                                                     ||");        
        System.out.println("||                RESUMEN DE LA RESERVA                ||");
        System.out.println("||                                                     ||");
        System.out.println("|| A nombre de : " + nombreCliente+ "                                ||");
        System.out.println("|| ID Reserva : " + reserva.getIdReserva() + "                                      ||");
        System.out.println("|| Cantidad de entradas compradas: " + reserva.getCantidadEntradas()  + "                   ||" );
        System.out.println("|| Ubicacion de las entradas: " +  ubicacionElegida  + "                      ||");
        System.out.println("|| Valor Entrada sin descuento: " + precioBase +"                        ||");
        System.out.println("||                                                     ||");
   
        for (Ticket ticketReservado : reserva.getTickets()) {
            System.out.println(ticketReservado.getResumenReserva());
        }
        
        /*
        for(Ticket ticket : reserva.getTickets()){
         //   System.out.println("Entrada N# " + ticket.getIdTicket() + "   Asiento : " + ticket.getAsiento().getCodigo() + "  Tipo de Descuento: " + cliente.getTipoCliente() + "  Valor del Ticket : " + ticket.getPrecioFinal() + "     ||"); 
           System.out.println("|| Ticket N# " + ticket.getIdTicket() + "   Asiento : " + ticket.getAsiento().getCodigo()  + "  Valor del Ticket : " + ticket.getPrecioFinal() + "     ||"); 
        }
*/
        System.out.println("||                                                     ||");
        System.out.println("||*****************************************************||"); 
        System.out.println("|| Total a pagar: " + reserva.getTotalPagar() + "                                ||");
        System.out.println("||                                                     ||");
        System.out.println("||                                                     ||");
        System.out.println("--/////////////////////////////////////////////////////--");
        System.out.println("---------------------------------------------------------");


    }//Cierre mostrarResumenReserva
    
public static void anularVenta(Venta venta, ArrayList<Venta> ventas, ArrayList<Venta> ventasAnuladas) {
    if (ventas.isEmpty()) {
        System.out.println("\n----------------------------------");
        System.out.println("No hay ventas para anular. Realice una compra primero.");
        return;
    }

    if (!ventas.contains(venta)) {
        System.out.println("La venta indicada no existe en el registro actual.");
        return;
    }

    ventas.remove(venta);
    totalIngresos -= venta.getTotalPagar();

    for (Asiento asiento : venta.getAsientos()) {
        asiento.desocupar(); // Liberar el asiento
        System.out.println("Asiento " + asiento.getCodigo() + " ha sido desocupado");
    }

    ventasAnuladas.add(venta);

    System.out.println("\n---------------------------------------");
    System.out.println("La venta ha sido anulada\n");
    System.out.println("Presiona ENTER para desplegar el mapa y confirmar la liberacion de los asientos");
    scanner.nextLine(); // Limpiar buffer
}
 //Cierre anularVenta
      
    public static void estadisticasGenerales(){
         
        System.out.println("--------------------------------------");
        System.out.println("--//////////////////////////////////--");
        System.out.println("======= ESTADISTICAS GENERALES =======");
        System.out.println("Capacidad de la Sala: " +capacidadSala + " asientos");
        System.out.println("Asientos disponibles actualmente: " + (capacidadSala - contadorAsientosOcupados));
        System.out.println("Asientos Ocupados: " + contadorAsientosOcupados);
        System.out.println("Total de ventas efectivas: " + ventas.size());
        System.out.println("Total de ventas anuladas: " + ventasAnuladas.size());
        System.out.println("Total de ventas realizadas: " + (ventas.size()+ventasAnuladas.size()));
        System.out.println("Ingresos acumulados: $" + totalIngresos);
        System.out.println("\nPlano con entradas disponibles actualmente: \n");
        System.out.println("=================================");
        System.out.println("--/////////////////////////////--");
        System.out.println("---------------------------------");
    }//Cierre estadisticasGenerales

 

  
      
    // 🔹 CLASES DEL MODELO

    public static class Reserva{
        private static int contadorReservas = 0;
        private int idReserva;
        private Cliente clientePrincipal;
        private ArrayList<Asiento> asientos;
        private int cantidadEntradas;
        private int totalPagar;
        String codigos = "";
        private ArrayList<Ticket> tickets;
        
        
        public Reserva(Cliente clientePrincipal, ArrayList<Asiento> asientos, int totalPagar, int cantidadEntradas, ArrayList<Ticket> tickets){
            this.idReserva = ++contadorReservas;
            this.clientePrincipal = clientePrincipal;
            this.asientos = asientos;
            this.totalPagar = totalPagar;
            this.cantidadEntradas = cantidadEntradas;
               this.tickets = tickets;
        }
     
        public int getIdReserva(){
            return idReserva;
        }

        public Cliente getClientePrincipal(){
            return clientePrincipal;
        }
        
        public ArrayList<Asiento> getAsientos(){
            return asientos;
        }
        public ArrayList<Ticket> getTickets() {
            return tickets;
        }
        
        public int getCantidadEntradas(){
            return cantidadEntradas;
        }
        
        public int getTotalPagar(){
            return totalPagar;
        }
           
        public String getDetalleReserva(){
            for (Asiento a: asientos){
                codigos += a.getCodigo() + " ";
            }   
            return "||  Num de Reserva: " + idReserva + " || idCliente : " + clientePrincipal.getIdCliente() + " || Asientos Reservados : "+ codigos +"   ||";
        } 
           
    } //Cierre Reserva
    
    public static class Venta{
        static int contadorVentas = 0;
        int idVenta; // id de la Boleta
        Cliente cliente;
        ArrayList <Asiento> asientos;
        int totalPagar; //valor total a pagar
        int cantidadEntradas; //Cantidad de entradas compradas
        private ArrayList<Ticket> ticketsVendidos;
        
            //Constructor
            public Venta(Cliente cliente, ArrayList<Asiento> asientos, int totalPagar, int cantidadEntradas, ArrayList<Ticket> ticketsVendidos){
                this.idVenta = ++contadorVentas;
                this.totalPagar = totalPagar;
                this.cantidadEntradas = cantidadEntradas;
                this.cliente = cliente;
                this.asientos = asientos;
                this.ticketsVendidos = ticketsVendidos;
                
            } //Cierre constructor Venta
            
        public int getIdVenta(){
            return idVenta;
        }
        
        public Cliente getCliente(){
            return cliente;
        }

        public int getCantidadEntradas(){
            return cantidadEntradas;
        }

        public int getTotalPagar(){
            return totalPagar;
        }
        
        public ArrayList<Asiento> getAsientos(){
            return asientos;
        }
             public ArrayList<Ticket> getTicketsVendidos() {
            return ticketsVendidos;
        }
             
        public String getDetalleVenta(){
            return "||  Num de Venta: " + idVenta + " || Cantidad de Entradas: " + cantidadEntradas + " || Total pagado: " + totalPagar + "   ||";
        } 
        
            
         
    }//Cierre clase Venta
        
    public static class Cliente {
        private int idCliente;
        private String nombre;
        private int edad;
        private String genero;
        private String tipoCliente;
        private double descuentoFactor;
        private String rol;
        
        public Cliente (int idCliente, String nombre, int edad, String genero, String rol){
            this.idCliente = idCliente;
            this.nombre = nombre;
            this.edad = edad;
            this.genero = genero;
            this.rol = rol; //"asistente" , "comprador"
            definirTipoClienteDescuento(); //lo obtengo desde función
        }

        private void definirTipoClienteDescuento(){
            if(edad >60){
                tipoCliente = "Tercera Edad. 25%";
                descuentoFactor = 0.75;
            }else if(genero.equalsIgnoreCase("F")){
                tipoCliente = "Mujer. 20%";
                descuentoFactor = 0.80;
            }else if(edad>=13 && edad<=25){
                tipoCliente = "Estudiante. 15%";
                descuentoFactor = 0.85;
            }else if(edad<13){
                tipoCliente = "Nino/a. 10%";
                descuentoFactor = 0.9;
            }else{
                tipoCliente = "Normal. Sin Descuento";
                descuentoFactor = 1.00;
            }
        }    
        
        public double getDescuentoFactor(){
            return descuentoFactor;
        }
        
        public String getTipoCliente(){
            return tipoCliente;
        }
        
        public String getRol(){
            return rol;
        }
        
        public void setRol(String rol) {
            this.rol = rol;
        }

        public int getIdCliente(){
            return idCliente;
        }        

        public String getNombre(){
            return nombre;
        }
        
        public int getEdad(){
            return edad;
        }        
        
        public String getGenero(){
            return genero;
        }
        
        @Override
        public String toString(){
            return nombre + "(" + tipoCliente + ")";
        }
        
        public String getDetalleCliente(){
            return "||  Rut Cliente: " + idCliente + " || Nombre: " + nombre + " || edad: " + edad + " || genero: " + genero + " || Tipo de Dscto que accede: " + tipoCliente + " || Rol: " + rol;
            //System.out.println("||  Rut Cliente: " + idCliente + " || Nombre: " + nombre + " || edad: " + edad + " || Tipo de Dscto que accede: " + tipoCliente);

        } 
        

    } //Cierre clase Cliente

    public static class Asiento {
        private final String tipo;
        private final String codigo;
        private String estado; // L = Libre, R = Reservado, O = Ocupado

        //contador de asientos ocupados
        //private static int contadorAsientosOcupados = 0;
        
        public Asiento(String tipo, String codigo) {
            this.tipo = tipo;
            this.codigo = codigo;
            this.estado = "L";
        }

        public String getTipo() {
            return tipo;
        }

        public String getCodigo() {
            return codigo;
        }
        
        public String getEstado() {
            return estado;
        }
        
        public static int getContadorAsientosOcupados(){
            return contadorAsientosOcupados;
        }
        
         public void reservar() {
            if (estado.equals("L")) {
                estado = "RR";
            }
        }

        public void ocupar() {
            if (estado.equals("RR")) {
                estado = "OO";
                contadorAsientosOcupados++;
            }
        }

        public void liberar() {
            if (estado.equals("RR")) {
                estado = "L";
            }
        }
        
        public void desocupar(){
            if(estado.equals("OO")){
                estado = "L";
                contadorAsientosOcupados--;
            }
        }

        public String mostrar() {
            switch (estado) {
                case "L": return codigo;
                case "RR": return "RR";
                case "OO": return "OO";
                default: return "?";
            }
        }
        
    } //Cierre clase Asiento

    public static class Ticket{
               
        private static int contadorTickets = 0;
        private int idTicket;
        private String sector;
        private Asiento asiento;
        private double precioBase; //precio entrada base del sector
        private double precioFinal; //valor entrada con descuento
        private Cliente cliente;
        private String estadoTicket; // Usaremos "reservado", "confirmado", "cancelado"
      
        //Constructor
        public Ticket(String sector, Asiento asiento, double precioBase, double precioFinal, Cliente cliente){
            this.idTicket = ++contadorTickets;
            this.sector = sector;
            this.asiento = asiento;
            this.precioBase = precioBase;
            this.precioFinal = precioFinal;
            this.cliente = cliente;
            this.estadoTicket = "Reservado";
        } //Cierre constructor Ticket

        //Metodo para mostrar info de la Entrada
        public void mostrarDetalleTickets(){
            
            System.out.println("");  
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("--///////////////////////////////////////////////////////////////////////////////--");
            System.out.println("||                                                                               ||");        
            System.out.println("||                       ------ TICKET DETALLE ENTRADA ------                    ||");
            System.out.println("||                                                                               ||");
            System.out.println("||  N# Ticket : " + idTicket);
            System.out.println("||  Sector: " + sector + "                           Asiento : " + asiento.getCodigo() +"     ||");                               
            System.out.println("||  A nombre de: " + cliente.getNombre().toUpperCase() + "                   Tipo de Descuento: " + cliente.getTipoCliente() +"   ||");
            System.out.println("||  Valor General Sector: " + precioBase + "         Valor Entrada con Descuento: " + precioFinal + "   ||"); 
            System.out.println("||                                                                               ||");
            System.out.println("||                                                                               ||");
            System.out.println("||          PUERTAS ABREN A LAS 6 PM  -- ENTRADA NO TRANSFERIBLE                 ||");
            System.out.println("||                                                                               ||");
            System.out.println("--///////////////////////////////////////////////////////////////////////////////--");
            System.out.println("-----------------------------------------------------------------------------------");
            
        }

        //Metodo Getter para acceder:
        public int getIdTicket(){
            return idTicket;
        }

        public String getSector() {
            return sector;
        }
        
        public Asiento getAsiento() {
            return asiento;
        }
        
        public Cliente getCliente() {
            return cliente;
        }
        
        public double getPrecioBase() {
            return precioBase;
        }
        
        public double getPrecioFinal() {
            return precioFinal;
        }
        
        public String getEstadoTicket(){
            return estadoTicket;
        }
        
        public void setEstadoTicket(String estadoTicket){
            this.estadoTicket = estadoTicket; 
        }
        
        public void cancelarTicket() {
            this.estadoTicket = "Eliminado";
        }
        

        public boolean ticketEstaCancelado() {
            return this.estadoTicket.equalsIgnoreCase("Eliminado");
        }
        public void ticketVendido() {
            this.estadoTicket = "Vendido";
        }
        public boolean ticketEstaActivo() {
            return this.estadoTicket.equalsIgnoreCase("Vendido");
        }

        public boolean ticketEstaReservado() {
            return this.estadoTicket.equalsIgnoreCase("Reservado");
        }    
        
        public String getResumenTicket(){
            return "||  Num de Ticket: " + idTicket + " || Estado: " + estadoTicket + " || Sector: " + sector + " || Asiento: " + asiento.getCodigo() + " || Descuento: " + cliente.getTipoCliente() + " || Precio Final: $" + precioFinal + "   ||";
        } 
        
        public String getResumenReserva(){
            return "||  Num de Ticket: " + idTicket + " || Asiento: " + asiento.getCodigo() + " || Descuento: " + cliente.getTipoCliente() + " || Precio Final: $" + precioFinal + "   ||";
        }  
        
        public String getResumenVenta(){
            return "||  Num de Ticket: " + idTicket + " || Asiento: " + asiento.getCodigo() + " || Descuento: " + cliente.getTipoCliente() + " || Precio Final: $" + precioFinal + "   ||";
        }  
        
        
    }//Cierre class Ticket
    
  
    
    // Clases Auxiliares
    
    public class Titulos{

        static void tituloMapa(){
            System.out.println("--------------------------------------------------------------");
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("||                                                          ||");        
            System.out.println("||                 MAPA DE " + nombreTeatro + "                      ||");
            System.out.println("||                                                          ||");
            System.out.println("--//////////////////////////////////////////////////////////--");
        }
        
        static void tituloReservas(){
            System.out.println("-----------------------------------------------");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("||                                           ||");        
            System.out.println("||            RESERVA DE ENTRADAS            ||");
            System.out.println("||                                           ||");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("-----------------------------------------------");
        }

        static void tituloCompras(){
            System.out.println("-----------------------------------------------");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("||                                           ||");        
            System.out.println("||             COMPRA DE ENTRADAS            ||");
            System.out.println("||                                           ||");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("-----------------------------------------------");
        }

        static void tituloModificarReservas(){
            System.out.println("-----------------------------------------------");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("||                                           ||");        
            System.out.println("||            MODIFICAR RESERVA              ||");
            System.out.println("||                                           ||");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("-----------------------------------------------");
        }    
    
        static void tituloEliminarReservas(){
            System.out.println("-----------------------------------------------");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("||                                           ||");        
            System.out.println("||             ELIMINAR RESERVAS             ||");
            System.out.println("||                                           ||");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("-----------------------------------------------");
        }
 
        static void tituloAnulacionVenta(){
            System.out.println("-----------------------------------------------");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("||                                           ||");        
            System.out.println("||            ANULACION DE VENTA             ||");
            System.out.println("||                                           ||");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("-----------------------------------------------");
        }  
        
        static void tituloBoleta(){
            System.out.println("-----------------------------------------------");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("||                                           ||");        
            System.out.println("||              IMPRIMIR BOLETA              ||");
            System.out.println("||                                           ||");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("-----------------------------------------------");
        }  
        
        static void tituloTicket(){
            System.out.println("-----------------------------------------------");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("||                                           ||");        
            System.out.println("||             IMPRIMIR TICKETS              ||");
            System.out.println("||                                           ||");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("-----------------------------------------------");
        }         
    } //Cierre class Titulos
    
    public class FuncionesAuxiliares{
        
        public static void mostrarMenu(){
            System.out.println("\n**************** " + nombreTeatro +  " ****************");
            System.out.println("**************** Bienvenido  ****************");
            System.out.println("");
            System.out.println("1.Ver promociones y descuentos activos");
            System.out.println("2.Ver Mapa de asientos");
            System.out.println("3.Reserva de Entradas");
            System.out.println("4.Modificar Reservar");
            System.out.println("5.Cancelar Reserva");
            System.out.println("6.Comprar Entradas");
            System.out.println("7.Anular Compra"); //liberar asiento
            System.out.println("8.Imprimir Boleta"); 
            System.out.println("9.Generar Tickets"); 
            System.out.println("");
            System.out.println("----------DATOS DE SISTEMA----------");
            System.out.println("10.Estadisticas Generales");  //Entradas vendidas , ingresos totales
            System.out.println("11.Lista de Clientes Registrados");
            System.out.println("12.Historico de Reservas Realizadas");
            System.out.println("13.Historico de Ventas Realizadas");  
            System.out.println("14.Historico de Ventas Anuladas");
            System.out.println("15.Historico Resumen de Tickets Vendidos");

            System.out.println("");
            System.out.println("16.Salir del Sistema");
            System.out.println("");
            System.out.println("Ingrese numero de la opcion que desea ejecutar:");            
            // Modificar datos de cliente
            // Ver lista de clientes registrados
        } //Cierre mostrarMenu   

        public static void mostrarPromociones(){
            System.out.println("\n****************PROMOCIONES DISPONIBLES******************");
            System.out.println("");
            System.out.println(" -> Ninos hasta 12 anos: 10% de descuento");
            System.out.println(" -> Estudiantes de 12 a 25 anos: 15% de descuento");
            System.out.println(" -> Mujeres: 20% de descuento");
            System.out.println(" -> Tercera Edad, Mayores de 60 anos: 25% de descuento");
            System.out.println("");
            System.out.println(" ************** Descuentos NO ACUMULATIVOS *************** ");
            System.out.println(" *** El sistema aplica el mayor beneficio para cada cliente *** ");
            System.out.println(" ********************************************************");
        }  
    
         public static int validarInt(Scanner scanner){
            int opcionBusqueda =-1;
            while(true){
                if(scanner.hasNextInt()){
                    opcionBusqueda = scanner.nextInt();
                    break;
                }else{
                    System.out.println("Opcion no valida. Ingrese un numero, por favor.");
                    scanner.next(); //Evita bucle y limpia la entrada
                }
            }
            return opcionBusqueda;
        }    //Cierre validarInt   
         
    
        public static void mensajeCierreSistema(){
            System.out.println("--------------------------------------------------------------");
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("||                                                          ||");        
            System.out.println("||      Cerrando el Sistema. Gracias por su compra.         ||");
            System.out.println("||                                                          ||");
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("--------------------------------------------------------------");
        }//Cierre mensajeCierreSistema
     
        
    } //Ciere clase FuncionesAuxiliares
    
    public class MapaTeatro {
  
        public static Asiento[][] crearMapa(String[] sectores){
            int filas = sectores.length;
            int columnas = 10;
            char[] letras = {'A', 'B', 'C', 'D', 'E'};
            Asiento [][] mapa = new Asiento [filas][columnas];

         // Creamos el mapa: Llenamos el mapa con tipos y códigos
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    //String tipo = tipos[i];
                    //System.out.print(tipos[i] + "Tipo :------");
                    String codigo = letras[i] + String.valueOf(j + 1);
                    //System.out.print(codigo + " codigo:------");
                    mapa[i][j] = new Asiento(sectores[i], codigo);
                }
            }
            return mapa;

        }  //Cierre crearMapa      
        
        public static void mostrarMapa(Asiento[][] mapa, String[] sectores){
        
            System.out.println("--------------------------------------------------------------");
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("||                                                          ||");        
            System.out.println("||                        ESCENARIO                         ||");
            System.out.println("||                                                          ||");

            for (int i = 0; i < mapa.length; i++) {
                    System.out.print("   ");
                    for (int j = 0; j < mapa[i].length; j++) {
                        System.out.print(mapa[i][j].mostrar());
                        if (j < mapa[i].length - 1) System.out.print(", ");

                    }
                  System.out.println(" ----> "+sectores[i] );  
                  //  System.out.println();
            }   

            System.out.println("||                                                          ||");        
            System.out.println("||     Referencias:                                         ||");        
            System.out.println("||       A1 -> codigo del asiento disponible                ||");        
            System.out.println("||       RR -> asiento reservado                            ||");        
            System.out.println("||       OO -> asiento ocupado, no disponible               ||");        
            System.out.println("||                                                          ||");        
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("--------------------------------------------------------------");
        
        } //Cierre de mostrarMapa 
            
            
            
    } //CIerre clase MapaTeatro
    
    public class Listar{
       
        public static void listarClientes(){

            if(clientes.isEmpty()){
                System.out.println("--------------------------------------------------------------");
                System.out.println("--//////////////////////////////////////////////////////////--");
                System.out.println("||                                                          ||");        
                System.out.println("||           Aun no hay clientes registrados                ||");
                System.out.println("||                                                          ||");
                System.out.println("--//////////////////////////////////////////////////////////--");
                System.out.println("--------------------------------------------------------------");
            }else{
                System.out.println("");  
                System.out.println("---------------------------------------------------------------------------------------------------");
                System.out.println("--///////////////////////////////////////////////////////////////////////////////////////////////--");
                System.out.println("||                                                                                               ||");        
                System.out.println("||                                 LISTA DE CLIENTES REGISTRADOS                                 ||");
                System.out.println("||                                                                                               ||");
                    for (Cliente cliente : clientes) {
                        System.out.println(cliente.getDetalleCliente());
                    }
                System.out.println("||                                                                                               ||"); 
                System.out.println("--///////////////////////////////////////////////////////////////////////////////////////////////--");
                System.out.println("---------------------------------------------------------------------------------------------------");
            }
        }//Cierre listarClientes   
        
        public static void listarReservas(){

            if(reservas.isEmpty()){
                System.out.println("--------------------------------------------------------------");
                System.out.println("--//////////////////////////////////////////////////////////--");
                System.out.println("||                                                          ||");        
                System.out.println("||             Aun no hay reservas realizadas               ||");
                System.out.println("||                                                          ||");
                System.out.println("--//////////////////////////////////////////////////////////--");
                System.out.println("--------------------------------------------------------------");
            }else{
                System.out.println("");  
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("--////////////////////////////////////////////////////////////////////////////////////--");
                System.out.println("||                                                                                    ||");        
                System.out.println("||                         HISTORICO DE RESERVAS REALIZADAS                           ||");
                System.out.println("||                                                                                    ||");
                    for (Reserva reserva : reservas) {
                        System.out.println(reserva.getDetalleReserva());
                    }
                System.out.println("||                                                                                    ||"); 
                System.out.println("--////////////////////////////////////////////////////////////////////////////////////--");
                System.out.println("----------------------------------------------------------------------------------------");
            }
        }//Cierre listarReservas    
    
        public static void listarVentas(){

            if(ventas.isEmpty()){
                System.out.println("--------------------------------------------------------------");
                System.out.println("--//////////////////////////////////////////////////////////--");
                System.out.println("||                                                          ||");        
                System.out.println("||             Aun no hay ventas realizadas                 ||");
                System.out.println("||                                                          ||");
                System.out.println("--//////////////////////////////////////////////////////////--");
                System.out.println("--------------------------------------------------------------");
            }else{
                System.out.println("");  
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("--//////////////////////////////////////////////////////////////////////--");
                System.out.println("||                                                                      ||");        
                System.out.println("||                     LISTADO DE VENTAS REALIZADAS                     ||");
                System.out.println("||                                                                      ||");
                    for (Venta venta : ventas) {
                        System.out.println(venta.getDetalleVenta());
                    }
                System.out.println("||                                                                      ||"); 
                System.out.println("--//////////////////////////////////////////////////////////////////////--");
                System.out.println("--------------------------------------------------------------------------");
            }
        }//Cierre listarVentas  
    
        public static void listarVentasAnuladas(){

            if(ventasAnuladas.isEmpty()){
                System.out.println("--------------------------------------------------------------");
                System.out.println("--//////////////////////////////////////////////////////////--");
                System.out.println("||                                                          ||");        
                System.out.println("||              Aun no hay ventas anuladas                  ||");
                System.out.println("||                                                          ||");
                System.out.println("--//////////////////////////////////////////////////////////--");
                System.out.println("--------------------------------------------------------------");
            }else{
                System.out.println("");  
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("--//////////////////////////////////////////////////////////////////////--");
                System.out.println("||                                                                      ||");        
                System.out.println("||                     LISTADO DE VENTAS ANULADAS                       ||");
                System.out.println("||                                                                      ||");
                    for (Venta ventaAnulada : ventasAnuladas) {
                        System.out.println(ventaAnulada.getDetalleVenta());
                    }
                System.out.println("||                                                                      ||"); 
                System.out.println("--//////////////////////////////////////////////////////////////////////--");
                System.out.println("--------------------------------------------------------------------------");
        }
    }//Cierre listarVentasAnuladas
 
        public static void listarTicketsVendidos(){

            if(ticketsVendidos.isEmpty()){
                System.out.println("--------------------------------------------------------------");
                System.out.println("--//////////////////////////////////////////////////////////--");
                System.out.println("||                                                          ||");        
                System.out.println("||              Aun no hay tickets vendidos                 ||");
                System.out.println("||                                                          ||");
                System.out.println("--//////////////////////////////////////////////////////////--");
                System.out.println("--------------------------------------------------------------");
            }else{
                System.out.println("");  
                System.out.println("-----------------------------------------------------------------------------------------------------------");
                System.out.println("--///////////////////////////////////////////////////////////////////////////////////////////////////////--");
                System.out.println("||                                                                                                       ||");        
                System.out.println("||                                LISTADO RESUMEN DE TICKETS VENDIDOS                                    ||");
                System.out.println("||                                                                                                       ||");
                    for (Ticket ticketVendido : ticketsVendidos) {
                        System.out.println(ticketVendido.getResumenTicket());
                    }
                System.out.println("||                                                                                                       ||");
                System.out.println("--///////////////////////////////////////////////////////////////////////////////////////////////////////--");
                System.out.println("-----------------------------------------------------------------------------------------------------------");
                
            }
         }//Cierre listarTicketsVendidos

 
   } //Cierre clase Listar
    
    
    

    
    
} //Cierre Sistema Venta
