import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        AgendaClientes agendaClientes = new AgendaClientes();
        AgendaProveedores agendaProveedores = new AgendaProveedores();
        Scanner scanner = new Scanner(System.in);
        ControlAcceso controlAcceso = new ControlAcceso();

        boolean autenticado = false;

        //Control de acceso
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

        while (true) 
        {
            System.out.println("Seleccione una opción");
            System.out.println("1. Control de Inventario");
            System.out.println("2. Agenda de Clientes");
            System.out.println("3. Agenda de Proveedores");
            int opcionprin = scanner.nextInt();
            switch (opcionprin) 
            {
                case 1:
                // Control de Inventario
                while (true) 
                    {
                        System.out.println("Seleccione una opción");
                        System.out.println("1. Agregar producto");
                        System.out.println("2. Eliminar producto");
                        System.out.println("3. Buscar producto");
                        System.out.println("4. Mostrar inventario");
                        System.out.println("5. Salir");
                        int opcioninv = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        switch (opcioninv) 
                        {
                            case 1:
                                System.out.print("Ingrese nombre del producto: ");
                                String nombre = scanner.nextLine();
                                System.out.print("Ingrese cantidad: ");
                                int cantidad = scanner.nextInt();
                                System.out.print("Ingrese precio: ");
                                double precio = scanner.nextDouble();
                                Producto producto = new Producto(nombre, cantidad, precio);
                                inventario.agregarProducto(producto);
                                break;
                            case 2:
                                System.out.print("Ingrese nombre del producto a eliminar: ");
                                nombre = scanner.nextLine();
                                inventario.eliminarProducto(nombre);
                                break;
                            case 3:
                                System.out.print("Ingrese nombre del producto a buscar: ");
                                nombre = scanner.nextLine();
                                Producto encontrado = inventario.buscarProducto(nombre);
                                if (encontrado != null) {
                                    System.out.println("Producto encontrado: " + encontrado);
                                } else {
                                    System.out.println("Producto no encontrado.");
                                }
                                break;
                            case 4:
                                System.out.println("Inventario:");
                                inventario.mostrarInventario();
                                break;
                            case 5:
                                System.out.println("Saliendo...");
                                scanner.close();
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                break;
                        } 
                        System.out.println();
                    }
                case 2:
                // Agenda de clientes
                while (true) 
                {
                    System.out.println("Seleccione una opción");
                    System.out.println("1. Agregar Cliente");
                    System.out.println("2. Eliminar Cliente");
                    System.out.println("3. Buscar Cliente");
                    System.out.println("4. Mostrar Agenda de Clientes");
                    System.out.println("5. Salir");
                    int opcionclien = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    switch (opcionclien) {
                        case 1:
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
                            break;

                        case 2:
                            System.out.print("Ingrese nombre del Cliente a eliminar: ");
                            nombre = scanner.nextLine();
                            agendaClientes.eliminarClientes(nombre);
                            break;
                        case 3:
                            System.out.print("Ingrese nombre del Cliente a buscar: ");
                            nombre = scanner.nextLine();
                            Clientes encontrado = agendaClientes.buscarClientes(nombre);
                            if (encontrado != null) {
                                System.out.println("Cliente encontrado: " + encontrado);
                            } else {
                                System.out.println("Cliente no encontrado.");
                            }
                            break;
                        case 4:
                            System.out.println("Agenda de Clientes:");
                            agendaClientes.mostrarAgendaClientes();
                            break;
                        case 5:
                            System.out.println("Saliendo...");
                            scanner.close();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    } System.out.println();
                }
                case 3:
                //Agenda Proveedores       
                while (true) 
                {
                    System.out.println("Seleccione una opción");
                    System.out.println("1. Agregar Proveedor");
                    System.out.println("2. Eliminar Proveedor");
                    System.out.println("3. Buscar Proveedor");
                    System.out.println("4. Mostrar Agenda de Proveedores");
                    System.out.println("5. Salir");
                    int opcionprov = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    switch (opcionprov) {
                        case 1:
                            System.out.print("Ingrese nombre del Proveedor: ");
                            String nombre = scanner.nextLine();
                            System.out.print("Ingrese Telefono: ");
                            String telefono = scanner.nextLine();
                            Proveedores proveedores = new Proveedores(nombre, telefono);
                            agendaProveedores.agregarProveedores(proveedores);
                            break;

                        case 2:
                            System.out.print("Ingrese nombre del Proveedor a eliminar: ");
                            nombre = scanner.nextLine();
                            agendaProveedores.eliminarProveedores(nombre);
                            break;
                        case 3:
                            System.out.print("Ingrese nombre del Proveedor a buscar: ");
                            nombre = scanner.nextLine();
                            Proveedores encontrado = agendaProveedores.buscarProveedores(nombre);
                            if (encontrado != null) {
                                System.out.println("Proveedor encontrado: " + encontrado);
                            } else {
                                System.out.println("Proveedor no encontrado.");
                            }
                            break;
                        case 4:
                            System.out.println("Agenda de Proveedores:");
                            agendaProveedores.mostrarAgendaProveedores();
                            break;
                        case 5:
                            System.out.println("Saliendo...");
                            scanner.close();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    } System.out.println();
                }
            }
        }
    }
}