package ejerciciosficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej3Main {

	public static void main(String[] args) {
		String[] array = new String[0];
		BufferedReader in;
		String linea="";
		double sumaEstaturas=0;//Aqui guardo las sumas de todas las estaturas
		double mediaEstatura=0;//Aqui se almacina la media final de las estaturas
		int mediaEdad=0; //La media de todas las edades
		int sumaEdad=0;//la suma de todas las edades
		int vuelta=0;//Se cuentan las vueltas para poder hacer las medias
		try {//metemos en un try catch porque hay varias cosas que explotan
			Scanner lee = new Scanner(new BufferedReader(new FileReader("Alumnos.txt")));//leemos el fichero
			while(lee.hasNextLine()) {//mientras aun hayan lineas
				linea = lee.nextLine(); //leemos la linea
				array = linea.split(" "); //en un array dividimos la linea en 3, porque la 1era posicion es el nombre, la segunda la edad y la tercera la estatura
					sumaEdad += Integer.parseInt(array[1]);//convertiremos la parte de la linea donde esta la edad en entero con el parse int
					//y lo sumaremos a la variable
					sumaEstaturas += Double.parseDouble(array[2]);//hacemos lo mismo con las estaturas, en este caso es la ultima posicion
				vuelta++;//incrementamos la vuelta para llevar la cuenta de los alumnos que hay
			}
			mediaEdad = sumaEdad/vuelta; //realizamos la media dividiendo la suma 
			mediaEstatura = sumaEstaturas/vuelta;
			System.out.println("La suma de las edades es: " + sumaEdad +"\nLa media de las edades es: " + mediaEdad);
			System.out.println("La suma de las estaturas es: " + sumaEstaturas + "\nLa media de estaturas es " + mediaEstatura);
		}catch (IOException e) {
			System.out.println("Error al abrir el archivo.");
		}catch(InputMismatchException e) {
			System.out.println("InputMismatchException");
		}catch(NumberFormatException e) {
			System.out.println("ERROR: Los decimales deben expresarse con un punto en el fichero.");
		}

	}

}
