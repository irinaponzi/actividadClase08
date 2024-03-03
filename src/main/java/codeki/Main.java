package codeki;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> razasPerrosLista = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int respuesta = 0;

        // Ejercicio 1
        // Se pide el ingreso de las razas de perros
        do {

            System.out.print("Ingrese una raza de perros: ");
            razasPerrosLista.add(scanner.nextLine());

            try {
                System.out.print("¿Quiere continuar con el ingreso? Presione 0 para SALIR o cualquier número para CONTINUAR: ");
                respuesta = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.println("Error! Ha ingresado un dato inválido");
            }

        } while (respuesta != 0);

        // Se muestra por consola la lista con las razas de perros
        System.out.println("La lista de razas de perros es: ");
        razasPerrosLista.forEach(System.out::println);


        // ejercicio 2
        // Se pide una raza de perros para eliminar
        System.out.print("Ingrese la raza de perros que desea eliminar: ");
        String razaEliminar = scanner.nextLine();

        // Se elimina la raza de perros en caso de haber sido encontrada en la lista, incluso si aparece repetida.
        boolean encontrado = razasPerrosLista.removeIf(r -> r.equalsIgnoreCase(razaEliminar));

        // Se informa al usuario si la raza de perros fue eliminada o si no se encontró
        if (encontrado)
            System.out.println("La raza de perros " + razaEliminar + " fue eliminada");
        else
            System.out.println("La raza de perros no fue encontrada");

        // Se ordena la lista en orden alfabético
        Collections.sort(razasPerrosLista);
        // razasPerrosLista.stream().sorted().forEach(System.out::println); // Ordenada y mostrada por consola con Stream

        // Se muestra por consola la lista ordenada
        System.out.println("La lista de razas de perros ordenada es: ");
        razasPerrosLista.forEach(System.out::println);

    }
}