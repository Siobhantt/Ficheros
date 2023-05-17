package ejerciciosficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ej2Main {

	public static void main(String[] args) {
		int suma=0;
		double media=0;
		int vuelta=0;
		try {
			Scanner lee = new Scanner (new BufferedReader(new FileReader("Enteros.txt")));
			suma = lee.nextInt();
			while(lee.hasNextInt()) {
				suma+=lee.nextInt();
				vuelta++;
			}
			media = suma/vuelta;
			
			System.out.println("La suma " + suma);
			System.out.println("La media " + media);
		}catch(FileNotFoundException e){
			System.out.println("Fichero no encontrado.");
		}

	}

}
