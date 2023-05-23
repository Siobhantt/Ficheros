package ejerciciosficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej8Main {
	static Scanner lee = new Scanner(System.in);
	static BufferedWriter in;
static BufferedReader br;
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
				break;
			case 3:
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
	
		fecha = Integer.toString(año)+ "-" + Integer.toString(mes)+ "-" + Integer.toString(dia);
		System.out.println("Por favor introduzca la temperatura minima: " );
		tminima = lee.nextInt();
		System.out.println("Por favor introduzca la temperatura maxima: ");
		tmaxima = lee.nextInt();
		try {
			in = new BufferedWriter(new FileWriter("Temperaturas.txt"));
			in.write(fecha+","+tmaxima+","+tminima);
		} catch (IOException e) {
			System.out.println("Hay un error con el fichero.");
			e.printStackTrace();
		}
	}
	public static void mostrarHistorial() {
		
	}
}
