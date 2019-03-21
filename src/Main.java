import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;


public class Main {

	public static void main(String[] args){

		//Se crea el scanner 
		Scanner s = new Scanner(System.in);
		//Variable que valida lo ingresado por el usuario
		Boolean validado = false;
		//Variable 	que almacena la opcion del menu seleccionada
		int menu = 0;
		//Se crea el binary Tree
		BinaryTreeAssociation RootBinaryTree = new BinaryTreeAssociation();
		
		//Se lee el archivo txt con las palabras traducidas que tendra el diccionario
		try {
			Stream<String> lines = Files.lines(Paths.get("diccionario.txt"),StandardCharsets.UTF_8);
			lines.forEach(i->{
				String english = i.substring(i.indexOf("(")+1, i.indexOf(","));
				String spanish = i.substring(i.indexOf(",")+1, i.indexOf(")"));
				Association<String, String> association = new Association(english,spanish);
				BinaryTreeAssociation SubTree = new BinaryTreeAssociation(association);
				RootBinaryTree.newTranslation(SubTree);
			});
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		do {
			System.out.println("Ingresa el número de una opcion del menu:\n1.Mostrar la colección ordenada por ingles\n2.Traducir archivo texto.txt\n3.Salir");
			do{
				//Se setea validado falso
				validado = false;
				String menuStr = s.nextLine();
				try {
					menu = Integer.parseInt(menuStr);
					if((menu>=1)&&(menu<=3)) {
						validado = true;
					}else {
						System.out.println("Ingrese una opción correcta");
						validado = false;
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Ingrese una opción correcta");
					validado = false;
				}
			}while(validado==false);
					
			//Funcion 1
			if(menu==1) {
				RootBinaryTree.inOrderAssociation();
			}
			
			//Funcion 2
			if(menu==2) {
				
			}
		} while (menu!=3);
	}
}
