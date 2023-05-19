package ejerciciosficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej5Main {

	public static void main(String[] args) {
		Scanner lee = new Scanner(System.in);
		String nombre = "";
		int edad = 0;
		String opcion = "";
		/*
		 * Diseña una aplicación que pida al usuario su nombre y edad. Estos datos deben
		 * guardarse en el fichero datos.txt. Si este fichero existe, deben añadirse al
		 * final en una nueva línea, y en caso de no existir, debe crearse.
		 */
		BufferedWriter in;
		try {
			in = new BufferedWriter(new FileWriter("datos.txt", true));
			System.out.println("Desea introducir datos? s/n");
			opcion = lee.next();
			while (!opcion.equalsIgnoreCase("n")) {
				System.out.println("Por favor introduzca su nombre: ");
				nombre = lee.next();
				System.out.println("Por favor introduzca su edad: ");
				edad = lee.nextInt();
				in.write(nombre + " "+ edad);
				in.newLine();
				System.out.println("Desea introducir datos? s/n");
				opcion = lee.next();
			}
			in.flush();
			in.close();
		} catch (IOException e) {
			System.out.println("Error al acceder al fichero.");
			e.printStackTrace();
		}
	}

}
