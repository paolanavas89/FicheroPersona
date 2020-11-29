import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Persona> personas= new ArrayList<>();

		
		Scanner S= new Scanner (System.in);
		S.useDelimiter("\r\n");
		
		
		try {
			BufferedReader br= new BufferedReader(new FileReader("fichero.txt"));
			String linea="";
			while((linea=br.readLine()) !=null) {
				Persona p1=new Persona();
				p1.setNombre(linea);
				p1.setApellido(br.readLine());
				p1.setEdad(Integer.parseInt(br.readLine()));
				personas.add(p1);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
			
		//System.out.println("Ingresar Datos: ");
		//pedirDatos(personas);
		float media=mediaEdad(personas);
		System.out.println("La media de la edad de las personas es: "+media);
		System.out.println("Mostramos los datos de las personas: ");
		imprimirDatos(personas);
	}
	
	public static void pedirDatos(ArrayList<Persona> personas) {
		String nombre = "";
		String apellido = "";
		int edad = 0;
		int numPersonas=0;
		@SuppressWarnings("resource")
		Scanner S = new Scanner(System.in);
		S.useDelimiter("\r\n");

		do {
			System.out.println("Introduzca el número de Personas que va ingresar: ");
			numPersonas = S.nextInt();

		} while (numPersonas < 0);

		for (int i = 1; i <= numPersonas; i++) {
			Persona auxPersona = new Persona();
			System.out.println("Ingrese el nombre de la persona nº " + i);
			nombre = S.next();
			System.out.println("Ingrese el apellido de la persona nº " + i);
			apellido = S.next();
			System.out.println("Ingrese la edad de la persona nº " + i);
			edad = S.nextInt();

			auxPersona.setNombre(nombre);
			auxPersona.setApellido(apellido);
			auxPersona.setEdad(edad);

			personas.add(auxPersona);
		}
		
				

	}
	
	public static float mediaEdad(ArrayList<Persona>personas) {
		int cont=0;
		int suma=0;
		float media=0;
		for(Persona p: personas) {
			suma+=p.getEdad();
			cont++;
		}
		media=(float)suma/cont;
		
		return media;
		
	}
	public static void imprimirDatos(ArrayList<Persona>personas) {
		for(Persona p: personas) {
			
			System.out.println(p);
		}
	}

}
