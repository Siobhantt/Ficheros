package ejerciciosficheros;

import java.io.*;
import java.util.Scanner;

public class Ej1Main {

	public static void main(String[] args) {
		double num = 0;//aqui se va a guardar cada numero porque el scanner al parecer lee un solo numero
		int vuelta = 0;//se cuenta cada lectura para saber cuantos numeros son para la media
		double media = 0;//la media xd
		
		try {//se mete en un try catch por si acaso no encuentre el fichero no explote 
			Scanner lee = new Scanner(new FileReader("NumerosReales.txt")); //utilizamos el escanner para leer el archivo(Aqui me doy cuenta porque lee uno a uno, por el FileReader)
			num = lee.nextDouble();//lee el primer numero que pilla
			while (lee.hasNextDouble()) {//mientras siga habiendo numeros en el fichero
				num += lee.nextDouble();//al numero le va a sumar lo siguiente que encuentre
				vuelta++;//aumenta el contador para cada numero que pille
			}
			media = num / vuelta;//el numero total dividido entre la cantidad de numeros encontrados
		} catch (FileNotFoundException e1) {//por sin no lo pilla
			System.out.println("Fichero no encontrado");
		}
		System.out.println("La suma de todos los numeros del fichero es: " + num);
		System.out.println("La media de los numeros del fichero es: " + media);
	}

}
