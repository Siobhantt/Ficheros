package ejerciciosficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej8Main {
	static Scanner lee = new Scanner(System.in);
	static BufferedWriter in;// escritor
	static BufferedReader br;// lector

	public static void main(String[] args) {
		int opcionU = 0;// opcion del usuario
		System.out.println("Registro de temperaturas.");
		do {
			menu();
			System.out.println("Por favor introduzca una opcion:");
			opcionU = lee.nextInt();
			switch (opcionU) {
			case 1:
				registrar();
				break;
			case 2:
				mostrarHistorial();
				break;
			case 3:
				adiu();
				break;
			default:
				System.out.println("Opcion no contemplada.");
				break;
			}

		} while (opcionU != 3);

	}// fin del main

	public static void menu() {
		System.out.println("1.Registrar nueva temperatura.");
		System.out.println("2.Mostrar historial de registros.");
		System.out.println("3.Salir.");
	}

	public static void registrar() {
		int año = 0;
		int mes = 0;
		int dia = 0;
		String fecha = "";
		int tminima = 0;
		int tmaxima;
		System.out.println("Ha escogido registrar una nueva temperatura.");
		System.out.println("Por favor introduzca el año:");
		año = lee.nextInt();

		System.out.println("Por favor introduzca el mes:");
		mes = lee.nextInt();

		System.out.println("Por favor introduzca el dia:");
		dia = lee.nextInt();

		fecha = año + "-" + mes + "-" + dia;// concatenamos toda la informacion es el formato solicitado
		System.out.println("Por favor introduzca la temperatura minima: ");
		tminima = lee.nextInt();
		System.out.println("Por favor introduzca la temperatura maxima: ");
		tmaxima = lee.nextInt();
		try {
			in = new BufferedWriter(new FileWriter("Temperaturas.txt", true));// en el try iniciamos el escritor
			in.write(fecha + "," + tmaxima + "," + tminima);// escribimos los datos con el formato
			in.newLine();// bajamos a la linea siguiente
			in.flush();// lo guadamos
		} catch (IOException e) {
			System.out.println("Error al escribir en el fichero.");
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero.");
			}
		}
	}

	public static void mostrarHistorial() {
		int tmin = 0;// para la temperatura minima total
		int tmax = 0;// para l temperatura maxima total
		int tmintotal = Integer.MAX_VALUE;
		int tmaxtotal = Integer.MIN_VALUE;
		String[] lineaSplit;
		String linea = ""; // declaramos la variable linea
		try {// en el try creamos el lector del fichero temperatura
			br = new BufferedReader(new FileReader("Temperaturas.txt"));

			linea = br.readLine();// leemos una linea
			while (linea != null) {// mientras la linea no sea nula(no este vacia)
				System.out.println("========================================");
				System.out.println(linea);// la imprimimos
				// Sacar el maximo y el minimo
				// dividimos la linea en tres posiciones, dividiendo por la coma, lineaSplit es
				// un array de String
				lineaSplit = linea.split(",");
				// convertimos la cadena guardada en un entero en el minimo y el maximo
				tmax = Integer.parseInt(lineaSplit[1]);
				tmin = Integer.parseInt(lineaSplit[2]);
				// si el maximo de la linea es mayor que el maximototal declarado, el maximo de
				// la linea es el nuevo maximo total
				if (tmax > tmaxtotal) {
					tmaxtotal = tmax;
				}
				// si el minimo de la linea es menor que el minimo total declarado, el minimo de
				// la linea es el nuevo minimo total
				if (tmin < tmintotal) {
					tmintotal = tmin;
				}
				linea = br.readLine();// LEEMOS LA SIGUIENTE LINEA
			} // fin del while
			System.out.println("La temperatura maxima registrada es: " + tmaxtotal);
			System.out.println("La temperatura minima registrada es: " + tmintotal);
		} catch (IOException e) {
			System.out.println("Error al leer el fichero.");
		}
	}

	public static void adiu() {
		System.out.println("Cerrando el programa.");
	}
}
