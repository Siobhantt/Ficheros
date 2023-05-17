package ej1;

import java.io.*;
import java.util.Scanner;

public class Ej1Main {

	public static void main(String[] args) {
		int num = 0;
		int vuelta = 0;
		int media = 0;
		try {
			Scanner lee = new Scanner(new FileReader("NumerosReales.txt"));
			num = lee.nextInt();
			while (lee.hasNextInt()) {
				num += lee.nextInt();
				vuelta++;
			}
			media = num / vuelta;
		} catch (FileNotFoundException e1) {
			System.out.println("Fichero no encontrado");
		}
		System.out.println("La suma de todos los numeros del fichero es: " + num);
		System.out.println("La media de los numeros del fichero es: " + media);
	}

}
