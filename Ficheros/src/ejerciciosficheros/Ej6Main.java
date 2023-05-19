package ejerciciosficheros;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Ej6Main {

	public static void main(String[] args) {
		TreeSet <Integer> lista = new TreeSet();
		int numero=0;
		try {
			Scanner lee = new Scanner(new FileReader("Numeros.txt"));
			while(lee.hasNextInt()) {
				numero = lee.nextInt();
				lista.add(numero);
			}
			
			
		}catch (IOException e) {
			System.out.println("Error");
		}

	}

}
