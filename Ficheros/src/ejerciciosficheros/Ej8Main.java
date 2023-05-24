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
	static BufferedWriter in;//escritor
static BufferedReader br;//lector
	public static void main(String[] args) {
		int tminima = 0;
		int tmaxima = 0;
		int fecha = 0;
		int opcionU = 0;
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
		int año=0;
		int mes=0;
		int dia=0;
		String fecha = "";
		int tminima = 0;
		int tmaxima;
		System.out.println("Ha escogido registrar una nueva temperatura.");
		System.out.println("Por favor introduzca el año:");
		año=lee.nextInt();
		
		System.out.println("Por favor introduzca el mes:");
		mes=lee.nextInt();
	
		System.out.println("Por favor introduzca el dia:");
		dia=lee.nextInt();
	
		fecha = año+ "-" +mes+ "-" + dia;//concatenamos toda la informacion es el formato solicitado
		System.out.println("Por favor introduzca la temperatura minima: " );
		tminima = lee.nextInt();
		System.out.println("Por favor introduzca la temperatura maxima: ");
		tmaxima = lee.nextInt();
		try {
			in = new BufferedWriter(new FileWriter("Temperaturas.txt",true));//en el try iniciamos el escritor
			in.write(fecha+","+tmaxima+","+tminima);//escribimos los datos con el formato
			in.newLine();//bajamos a la linea siguiente
			in.flush();//lo guadamos
		} catch (IOException e) {
			System.out.println("Error al escribir en el fichero.");
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero.");
			}
		}
	}
	public static void mostrarHistorial() {
		String linea=""; //declaramos la variable linea
		try {//en el try creamos el lector del fichero temperatura
			br = new BufferedReader(new FileReader("Temperaturas.txt"));
			linea = br.readLine();//leemos una linea
			while(linea!=null) {//mientras la linea no sea nula(no este vacia)
				System.out.println(linea);//la imprimimos
				linea = br.readLine();//LEEMOS LA SIGUIENTE LINEA
			}
		} catch (IOException e) {
			System.out.println("Error al leer el fichero.");
		}
	}
	public static void adiu() {
		System.out.println("Cerrando el programa.");
	}
}
