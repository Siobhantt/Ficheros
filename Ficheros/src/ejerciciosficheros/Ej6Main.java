package ejerciciosficheros;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Ej6Main {

	public static void main(String[] args) {
		// la lista la usaremos de enteros para que se ordene, ya intente hacerlo de
		// string y no funcionó
		TreeSet<Integer> lista = new TreeSet<>();
		int numero = 0;// para almacenar un numero del fichero
		String numCa;// para escribir en el fichero como letra y no me ponga simbolos egipcios
		BufferedWriter in;// mi escritor mas mono

		try {
			in = new BufferedWriter(new FileWriter("src\\ficherostxt\\Ascendente.txt"));// para escribir en el fichero
																						// ascendente
			Scanner lee = new Scanner(new FileReader("src\\ficherostxt\\Numeros.txt"));// para leer del fichero numeros
																						// donde hay un
			// desorden montado
			while (lee.hasNextInt()) {// mientras aun queden enteros
				numero = lee.nextInt();// guardo un numero
				lista.add(numero);// lo añado a la lista
			}
			// una vez leidos todos los numeros y almacenados en la lista
			for (int num : lista) {// recorro la lista
				numCa = Integer.toString(num);// y voy pasando en orden(Poruqe la lista ya esta ordenada) los numeros a
												// cadena
				in.write(numCa);// los escribo en el fichero
				in.newLine();// hago un salto de lineo pa que se vea ordenado
			}
			in.flush();// el flush como el W.C
			System.out.println(lista);// esto era para probar si estaba ordenandose bien la lista
		} catch (IOException e) {
			System.out.println("Error");
		}

	}

}
