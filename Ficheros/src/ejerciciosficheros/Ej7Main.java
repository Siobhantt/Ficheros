package ejerciciosficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class Ej7Main {
	// Declaramos el scanner estatico porque lo vamos a necesitar en los metodos
	static Scanner lee = new Scanner(System.in);
	// declaramos el writer para escribir en el ficherp
	static BufferedWriter in;
	// el mapa que usaremos para guardar los contactos
	static TreeMap<String, Long> contactos = new TreeMap<>();

	public static void main(String[] args) {
		// opcion del usuario
		int opcionU = 0;
		do {// en un dowhile hacemos un switch
			menu();
			opcionU = lee.nextInt();
			switch (opcionU) {
			case 1:
				añadirContacto();
				break;
			case 2:
				buscarNombre();
				break;
			case 3:
				mostrar();
				break;
			case 4:
				guardarDatos();
				adios();
				break;
			default:
				System.out.println("Opcion no contemplada :/");
				break;
			}
		} while (opcionU != 4);
		lee.close();// cerramos el scanner
	}// fin del main
		// =======================================ESTO ES
		// IMPORTANTE====================================

	public static void guardarDatos() {
		String nombre = "";// para guardar el nombre que esta en el conjunto
		long numero = 1000L;// el numero de telefono que esta en el conjunto
		try {// EN EL TRY TENGO QUE METER EL BUFFERED WRITER
				// el true en el buffered writer es para que respete lo que habia anteriormente
				// y no lo borre
			in = new BufferedWriter(new FileWriter("Agenda.txt", true));
			// Recorremos el mapa
			for (String nom : contactos.keySet()) {
				nombre = nom;// el nombre será igual a lo que este guardado en la iteracion del bucle
				numero = contactos.get(nombre); // de esa clave sacaremos el valor asociado
				in.write(nombre + " " + numero); // y escribiremos tal cual en el fichero
				in.newLine();// un salto de linea
			}
			in.flush();// EL FLUSH FUERA DEL BUCLE
		} catch (IOException e) {
			System.out.println("Error");
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero.");
			}
		}
	}

	public static void menu() {
		System.out.println("Bienvenido a su agenda de contactos!");
		System.out.println("Por favor seleccione una de las opciones disponibles.");
		System.out.println("1.Añadir un nuevo contacto.");
		System.out.println("2.Buscar por nombre.");
		System.out.println("3.Mostrar todos los contactos guardados.");
		System.out.println("4.Salir");
	}

	public static void añadirContacto() {
		String nombre = "";
		Long numero = 1000L;
		System.out.println("Ha seleccionado la opcion de agregar un contacto.");
		System.out.println("Por favor introduzca el nombre.");
		nombre = lee.next();
		System.out.println("Por favor introduzca el numero.");
		numero = lee.nextLong();
		lee.nextLine();
		if (contactos.containsKey(nombre) && contactos.size() < 20) {
			System.out.println("El nombre introducido ya existe en la agenda.");
		} else {
			contactos.put(nombre, numero);
			System.out.println("Se ha guardado un nuevo contacto.");
		}

	}

	public static void buscarNombre() {
		String nombre = "";
		System.out.println("Ha seleccionado la opcion de buscar un contacto");
		System.out.println("Por favor introduzca el nombre del numero al que desea acceder.");
		nombre = lee.next();
		if (contactos.containsKey(nombre)) {
			System.out.println(nombre + "-->" + contactos.get(nombre));
		} else {
			System.out.println("El nombre que buscar no tiene ningun numero registrado.");
		}

	}

	public static void mostrar() {
		String linea; // declaro la variable linea, aqui voy a guardar la linea leida del fichero
		BufferedReader br = null; // declaro el buffered reader fuera para poder cerrarlo, siempre inicializado a
									// null
		try {// en un try catch
			br = new BufferedReader(new FileReader("C:\\Users\\Luisa\\git\\ficheros\\Ficheros\\Agenda.txt")); // el
																												// buffer
																												// de
																												// escritura,
																												// aqui
																												// lo
																												// estamos
																												// inicializamos
			linea = br.readLine(); // en linea guardo una linea de lectura
			while (linea != null) {// mientras la linea sea distinta de null
				// imprimimos la linea
				System.out.println("============================================");
				System.out.println(linea);
				// una vez impresa la linea volvemos a leer la siguiente
				linea = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo");
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
			}
		}
		System.out.println();
	}

	public static void adios() {
		System.out.println("Cerrando programa...");
		System.out.println("Guardando datos...");
	}

}
