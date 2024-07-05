import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Inventario inventario = new Inventario("inventario.txt");
        AgendaClientes agendaClientes = new AgendaClientes("clientes.txt");
        AgendaProveedores agendaProveedores = new AgendaProveedores("proveedores.txt");
        ControlAcceso controlAcceso = new ControlAcceso("usuarios.txt");
        Scanner scanner = new Scanner(System.in);

        // Si no hay usuarios, registrar uno nuevo
        if (controlAcceso.usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados. Registre un nuevo usuario administrador.");
            System.out.print("Nombre de usuario: ");
            String nombreUsuario = scanner.nextLine();
            System.out.print("Contraseña: ");
            String contraseña = scanner.nextLine();
            Usuario admin = new Usuario(nombreUsuario, contraseña, contraseña);
            controlAcceso.agregarUsuario(admin);
            System.out.println("Usuario administrador registrado exitosamente.");
        }

        boolean autenticado = false;

        // Control de acceso
        while (!autenticado) {
            System.out.println("Inicie sesión para acceder al inventario:");
            System.out.print("Nombre de usuario: ");
            String nombreUsuario = scanner.nextLine();
            System.out.print("Contraseña: ");
            String contraseña = scanner.nextLine();

            if (controlAcceso.autenticarUsuario(nombreUsuario, contraseña)) {
                autenticado = true;
                System.out.println("Inicio de sesión exitoso.");
            } else {
                System.out.println("Nombre de usuario o contraseña incorrectos.");
            }
        }

        while (true) {
            System.out.println("Seleccione una opción");
            System.out.println("1. Control de Inventario");
            System.out.println("2. Agenda de Clientes");
            System.out.println("3. Agenda de Proveedores");
            System.out.println("4. Salir");
            int opcionprin = scanner.nextInt();
            switch (opcionprin) {
                case 1:
                    // Control de Inventario
                    while (true) {
                        System.out.println("Seleccione una opción");
                        System.out.println("1. Agregar producto");
                        System.out.println("2. Eliminar producto");
                        System.out.println("3. Buscar producto");
                        System.out.println("4. Mostrar inventario");
                        System.out.println("5. Salir");
                        int opcioninv = scanner.nextInt();
                        scanner.nextLine(); // scanear la sig.linea
                        switch (opcioninv) {
                            case 1 -> {
                                System.out.print("Ingrese nombre del producto: ");
                                String nombre = scanner.nextLine();
                                System.out.print("Ingrese cantidad: ");
                                int cantidad = scanner.nextInt();
                                System.out.print("Ingrese precio: ");
                                double precio = scanner.nextDouble();
                                Producto producto = new Producto(nombre, cantidad, precio);
                                inventario.agregarProducto(producto);
                            }
                            case 2 -> {
                                System.out.print("Ingrese nombre del producto a eliminar: ");
                                String nombre = scanner.nextLine();
                                inventario.eliminarProducto(nombre);
                            }
                            case 3 -> {
                                System.out.print("Ingrese nombre del producto a buscar: ");
                                String nombre = scanner.nextLine();
                                Producto encontrado = inventario.buscarProducto(nombre);
                                if (encontrado != null) {
                                    System.out.println("Producto encontrado: " + encontrado);
                                } else {
                                    System.out.println("Producto no encontrado.");
                                }
                            }
                            case 4 -> {
                                System.out.println("Inventario:");
                                inventario.mostrarInventario();
                            }
                            case 5 -> {
                                System.out.println("Saliendo...");
                                inventario.guardarInventario();
                                agendaClientes.guardarAgenda();
                                agendaProveedores.guardarAgenda();
                                controlAcceso.guardarUsuarios();
                                scanner.close();
                                System.exit(0);
                            }
                            default -> System.out.println("Opción no válida.");
                        }
                        System.out.println();
                    }
                case 2:
                    // Agenda de clientes
                    while (true) {
                        System.out.println("Seleccione una opción");
                        System.out.println("1. Agregar Cliente");
                        System.out.println("2. Eliminar Cliente");
                        System.out.println("3. Buscar Cliente");
                        System.out.println("4. Mostrar Agenda de Clientes");
                        System.out.println("5. Salir");
                        int opcionclien = scanner.nextInt();
                        scanner.nextLine(); // escanear el sig.caso
                        switch (opcionclien) {
                            case 1 -> {
                                System.out.print("Ingrese nombre del Cliente: ");
                                String nombre = scanner.nextLine();
                                System.out.print("Ingrese Telefono: ");
                                String telefono = scanner.nextLine();
                                System.out.print("Ingrese Email: ");
                                String email = scanner.nextLine();
                                System.out.println("Ingrese Número de cuenta");
                                String ndecuenta = scanner.nextLine();
                                Clientes clientes = new Clientes(nombre, telefono, email, ndecuenta);
                                agendaClientes.agregarClientes(clientes);
                            }
                            case 2 -> {
                                System.out.print("Ingrese nombre del Cliente a eliminar: ");
                                String nombre = scanner.nextLine();
                                agendaClientes.eliminarClientes(nombre);
                            }
                            case 3 -> {
                                System.out.print("Ingrese nombre del Cliente a buscar: ");
                                String nombre = scanner.nextLine();
                                Clientes encontrado = agendaClientes.buscarClientes(nombre);
                                if (encontrado != null) {
                                    System.out.println("Cliente encontrado: " + encontrado);
                                } else {
                                    System.out.println("Cliente no encontrado.");
                                }
                            }
                            case 4 -> {
                                System.out.println("Agenda de Clientes:");
                                agendaClientes.mostrarAgendaClientes();
                            }
                            case 5 -> {
                                System.out.println("Saliendo...");
                                inventario.guardarInventario();
                                agendaClientes.guardarAgenda();
                                agendaProveedores.guardarAgenda();
                                controlAcceso.guardarUsuarios();
                                scanner.close();
                                System.exit(0);
                            }
                            default -> System.out.println("Opción no válida.");
                        }
                        System.out.println();
                    }
                case 3:
                    // Agenda Proveedores
                    while (true) {
                        System.out.println("Seleccione una opción");
                        System.out.println("1. Agregar Proveedor");
                        System.out.println("2. Eliminar Proveedor");
                        System.out.println("3. Buscar Proveedor");
                        System.out.println("4. Mostrar Agenda de Proveedores");
                        System.out.println("5. Salir");
                        int opcionprov = scanner.nextInt();
                        scanner.nextLine(); // escanear la sig.linea
                        switch (opcionprov) {
                            case 1 -> {
                                System.out.print("Ingrese nombre del Proveedor: ");
                                String nombre = scanner.nextLine();
                                System.out.print("Ingrese Telefono: ");
                                String telefono = scanner.nextLine();
                                Proveedores proveedores = new Proveedores(nombre, telefono);
                                agendaProveedores.agregarProveedores(proveedores);
                            }
                            case 2 -> {
                                System.out.print("Ingrese nombre del Proveedor a eliminar: ");
                                String nombre = scanner.nextLine();
                                agendaProveedores.eliminarProveedores(nombre);
                            }
                            case 3 -> {
                                System.out.print("Ingrese nombre del Proveedor a buscar: ");
                                String nombre = scanner.nextLine();
                                Proveedores encontrado = agendaProveedores.buscarProveedores(nombre);
                                if (encontrado != null) {
                                    System.out.println("Proveedor encontrado: " + encontrado);
                                } else {
                                    System.out.println("Proveedor no encontrado.");
                                }
                            }
                            case 4 -> {
                                System.out.println("Agenda de Proveedores:");
                                agendaProveedores.mostrarAgendaProveedores();
                            }
                            case 5 -> {
                                System.out.println("Saliendo...");
                                inventario.guardarInventario();
                                agendaClientes.guardarAgenda();
                                agendaProveedores.guardarAgenda();
                                controlAcceso.guardarUsuarios();
                                scanner.close();
                                System.exit(0);
                            }
                            default -> System.out.println("Opción no válida.");
                        }
                        System.out.println();
                    }
                    
                    case 4:
                    System.out.println("Saliendo...");
                    inventario.guardarInventario();
                    agendaClientes.guardarAgenda();
                    agendaProveedores.guardarAgenda();
                    controlAcceso.guardarUsuarios();
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}
