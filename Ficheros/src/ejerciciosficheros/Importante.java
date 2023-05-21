package ejerciciosficheros;

public class Importante {

	public static void main(String[] args) {
		int numentero=0;
		String numcadena="0";
		
		//de cadena a entero
		numentero = Integer.parseInt(numcadena);
		
		//de entero a cadena
		
		int numero = 10;
		String cadena = Integer.toString(numero);
		//Ó
		numcadena = String.valueOf(numentero);
		
		//de cadena a double
		String cadena1 = "3.14";
		double numero1 = Double.parseDouble(cadena);
		// También puedes utilizar Double.valueOf(cadena);

		//de entero a doble
		int numero2 = 5;
		double decimal = (double) numero;
		// También puedes utilizar la clase Double: Double.valueOf(numero);

		//de double a entero
		double decimal1 = 3.7;
		int numero3 = (int) decimal;
		// También puedes utilizar la clase Integer: Integer.valueOf((int) decimal);

		//de char a string
		char caracter = 'A';
		String cadena3 = Character.toString(caracter);
		// También puedes utilizar String.valueOf(caracter);

		// de string a arreglo de char
		String cadena4 = "Hola";
		char[] arregloCaracteres = cadena.toCharArray();

		//obtener x caracter de una cadena y pasarlo a char
		String cadena5 = "Hola";
		char primerCaracter = cadena.charAt(0);
		/*Conversión de String a char (usando el método toCharArray() y seleccionando un carácter específico):*/
		String cadena6 = "Hola";
		char[] arregloCaractere7 = cadena.toCharArray();
		char tercerCaracter = arregloCaracteres[2];

		//de entero a long
		int numero4 = 100;
		long largo = (long) numero;
		// También puedes utilizar la clase Long: Long.valueOf(numero);
		
	}

}
