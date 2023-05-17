package ejerciciosficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej3Main {

	public static void main(String[] args) {
		BufferedReader in;
		String linea="";
		double estaturas=0;
		double mediaEstatura=0;
		int mediaEdad=0; 
		int sumaEdad=0;
		int vuelta=0;
		try {
			Scanner lee = new Scanner(new BufferedReader(new FileReader("Alumnos.txt")));
			while(lee.hasNextLine()) {
				linea = lee.nextLine();
				System.out.println(linea);
				//sumaEdad =+ lee.nextInt();
				//estaturas =+ lee.nextDouble();
				//vuelta++;
			}
			//mediaEdad = sumaEdad/vuelta;
			//mediaEstatura = estaturas/vuelta;
			//System.out.println("La suma de las edades es: " + sumaEdad +"\nLa media de las edades es: " + mediaEdad);
			//System.out.println("La suma de las estaturas es: " + estaturas + "\nLa media de estaturas es " + mediaEstatura);
		}catch (IOException e) {
			System.out.println("Error al abrir el archivo.");
		}catch(InputMismatchException e) {
			System.out.println("InputMismatchException");
		}

	}

}
