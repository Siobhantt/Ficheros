package ejerciciosficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej5Main {
	/*
	 * Diseña una aplicación que pida al usuario su nombre y edad. Estos datos deben
	 * guardarse en el fichero datos.txt. Si este fichero existe, deben añadirse al
	 * final en una nueva línea, y en caso de no existir, debe crearse.
	 */
	/*
	 * Hola profe, he comprobado en la carpeta del proyecto y si se crea el fichero
	 * pero en el eclipse no me aparece, no se por que.
	 */
	public static void main(String[] args) {
		Scanner lee = new Scanner(System.in);
		String nombre = "";
		int edad = 0;
		String opcion = "";
		BufferedWriter in;
		// Creacion de un fichero
		File fichero; // declaramos un objeto de tipo fichero
		try {
			fichero = new File("src\\ficherostxt\\datos.txt"); // le damos como valor la ruta
			if (!fichero.exists()) {// en caso de que no exista lo creamos
				fichero.createNewFile();
			}
			in = new BufferedWriter(new FileWriter(fichero, true));// Escribimos en el fichero a partir de lo que ya
																	// estaba escrito(append=true)
			System.out.println("Desea introducir datos? s/n");
			opcion = lee.next();
			while (!opcion.equalsIgnoreCase("n")) {// mientras la opcion no sea n
				System.out.println("Por favor introduzca su nombre: ");
				nombre = lee.next();// leemos nombre
				System.out.println("Por favor introduzca su edad: ");
				edad = lee.nextInt();// leemos edad
				in.write(nombre + " " + edad);// escribimos el nombre y la edad separados por un espacio
				in.newLine();// pasamos a la siguiente linea
				System.out.println("Desea introducir datos? s/n");// VOLVEMOS A PREGUNTAR
				opcion = lee.next();// VOLVEMOS A PREGUNTAR
			}
			in.flush();// FLUSHEAMOS
		} catch (IOException e) {
			System.out.println("Error al acceder al fichero.");
			e.printStackTrace();
		}
		lee.close();// cerramos el scanner
	}// fin del main

}
