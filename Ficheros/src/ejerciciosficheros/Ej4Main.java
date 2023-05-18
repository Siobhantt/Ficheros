package ejerciciosficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej4Main {

	public static void main(String[] args) {
		BufferedWriter in;
		String lineas="";
		Scanner lee= new Scanner(System.in);
		try {
			in = new BufferedWriter(new FileWriter("Prueba.txt"));//Llamamos al lector
			System.out.println("Por favor escriba lo que desee.");
			System.out.println("Cuando quiera detenerse escriba fin.");
			while(!lineas.equalsIgnoreCase("fin")) {//mientras no se escriba fin
				in.write(lineas = lee.nextLine());//.write guarda un caracter en el fichero, entonces si como parametro le pasamo una variable que almacena
				//los datos de un scanner va a ir guardando eso en el fichero
				in.newLine();//hacemos un newLine para que haga salto de linea
				in.flush();//y lo guardamos todo en el fichero con el flush
			}
			in.close();//Una vez terminado cerramos el fichero.
		}catch(IOException e) {
			System.out.println("Error");
		}
	}

}
