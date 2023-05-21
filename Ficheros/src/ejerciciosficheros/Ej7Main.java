package ejerciciosficheros;

import java.io.BufferedWriter;
import java.util.Scanner;
import java.util.TreeMap;

public class Ej7Main {
	static Scanner lee = new Scanner(System.in);
static BufferedWriter in;
static TreeMap<String,Integer> contactos =  new TreeMap<>();
	public static void main(String[] args) {
		int opcionU=0;
		do {
			menu();
			opcionU = lee.nextInt();
			switch(opcionU){
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
				
				adios();
				break;
				default:
					System.out.println("Opcion no contemplada :/");
					break;
			}
		}while(opcionU!=4);
	}//fin del main
	public static void menu() {
		System.out.println("Bienvenido a su agenda de contactos!");
		System.out.println("Por favor seleccione una de las opciones disponibles.");
		System.out.println("1.Añadir un nuevo contacto.");
		System.out.println("2.Buscar por nombre.");
		System.out.println("3.Mostrar todos los conatctos guardados.");
		System.out.println("4.Salir");
	}
public static void añadirContacto() {
	String nombre="";
	int numero=0;
	System.out.println("Ha seleccionado la opcion de agregar un contacto.");
	System.out.println("Por favor introduzca el nombre.");
	nombre = lee.next();
	System.out.println("Por favor introduzca el numero.");
	numero = lee.nextInt();
	if(contactos.containsKey(nombre)&&contactos.size()<20) {
		System.out.println("El nombre introducido ya existe en la agenda.");
	}else{
		contactos.put(nombre, numero);
		System.out.println("Se ha guardado un nuevo contacto.");
	}
}
public static void buscarNombre() {
	String nombre="";
	System.out.println("Ha seleccionado la opcion de buscar un contacto");
	System.out.println("Por favor introduzca el nombre del numero al que desea acceder.");
	nombre = lee.next();
	if(contactos.containsKey(nombre)){
		System.out.println(nombre + "-->"+ contactos.get(nombre));
	}else {
		System.out.println("El nombre que buscar no tiene ningun numero registrado.");
	}
}
public static void mostrar() {
	System.out.println(contactos);
}
public static void adios() {
	System.out.println("Cerrando programa...");
}
}
