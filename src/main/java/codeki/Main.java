package codeki;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    // Variables
    private static Scanner scanner = new Scanner(System.in);
    private static HashMap<String, Double> productosLista = new HashMap<>();
    private static String nombreProducto;
    private static Double precioProducto;
    private static int resp = -1;

    // Función que ejecuta el menú en bucle
    private static void menu() {

        do {

            System.out.println("**********************************");
            System.out.println("            MENU                  ");
            System.out.println("    1. Agregar producto           ");
            System.out.println("    2. Modificar precio producto  ");
            System.out.println("    3. Eliminar producto          ");
            System.out.println("    4. Mostrar productos          ");
            System.out.println("    0. Salir                      ");
            System.out.println("**********************************");

            // Manejo de excepción en caso de que el usuario no ingrese un número
            try {
                resp = Integer.parseInt(scanner.nextLine());

                // Según la respuesta del usuario se ejecuta la función correspondiente
                switch (resp) {
                    case 1:
                        agregarProducto();
                        break;
                    case 2:
                        modificarProducto();
                        break;
                    case 3:
                        eliminarProducto();
                        break;
                    case 4:
                        mostrarProductos();
                        break;
                    default:
                        if (resp != 0)
                            System.out.println("Opción inválida");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Error, el dato ingresado es inválido");
            }

        } while (resp != 0);

        System.out.println("Usted ha salido del programa");
    }

    // Función para agregar un producto al HashMap
    private static void agregarProducto() {

        System.out.print("Ingrese el nombre del producto: ");
        nombreProducto = scanner.nextLine();

        // Manejo de excepción en caso de que el usuario no ingrese un número
        try {
            System.out.print("Ingrese el precio del producto: ");
            precioProducto = Double.parseDouble(scanner.nextLine());

            // Se agrega el producto al HashMap
            productosLista.put(nombreProducto, precioProducto);
            System.out.println("El producto ha sido ingresado con éxito");

        } catch (NumberFormatException e) {
            System.out.println("Error, el dato ingresado es inválido");
        }
    }

    // Función para modificar el precio de un producto
    private static void modificarProducto() {

        System.out.print("Ingrese el nombre del producto al que desea modificar su precio: ");
        nombreProducto = scanner.nextLine();

        // Se busca el producto por su key (nombreProducto)
        if (productosLista.containsKey(nombreProducto)) {

            // Manejo de excepción en caso de que el usuario no ingrese un número
            try {
                System.out.print("Ingrese el nuevo precio del producto: ");
                precioProducto = Double.parseDouble(scanner.nextLine());

                // Se actualiza el producto en el HashMap, al tratarse de una key existente reemplaza su value
                productosLista.put(nombreProducto, precioProducto);
                System.out.println("El precio del producto " + nombreProducto + " fue actualizado exitosamente");

            } catch (NumberFormatException e) {
                System.out.println("Error, el dato ingresado es inválido");
            }
        } else {
            System.out.println("El producto " + nombreProducto + " no existe");
        }
    }

    // Función para eliminar un producto del HashMap
    private static void eliminarProducto() {

        System.out.print("Ingrese el nombre del producto que desea eliminar: ");
        nombreProducto = scanner.nextLine();

        // Se busca el producto por su key (nombreProducto) y se elimina si existe
        if (productosLista.containsKey(nombreProducto)) {
            productosLista.remove(nombreProducto);
            System.out.println("El producto " + nombreProducto + " fue eliminado exitosamente");
        } else {
            System.out.println("El producto " + nombreProducto + " no existe");
        }
    }

    // Función para mostrar todos los productos del HashMap
    private static void mostrarProductos() {

        // Se recorre el HashMap y se va imprimiendo por consola cada producto con su key/value
        System.out.println("La lista de productos es: ");
        productosLista.forEach((producto, precio) ->
                System.out.println(producto + ": $" + precio));
    }

    // Se llama a la función 'menu' para la ejecución del programa
    public static void main(String[] args) {

        menu();

    }

}