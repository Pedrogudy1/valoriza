import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
	
	
	
	
	public static boolean checarClienteCPF(String CPF) throws IOException {
		File usertxt = new File("database", "Clientes.txt");
		usertxt.createNewFile();
		
		Scanner scanPermissao = new Scanner (new File ("database/Clientes.txt"));
		scanPermissao.useDelimiter(";");
		while(scanPermissao.hasNext()) {
			scanPermissao.next();
			String per = scanPermissao.next();
			scanPermissao.next();
			scanPermissao.next();
			
			if (CPF.equals(per)) {
				scanPermissao.close();
				return true;
			}
		}
		scanPermissao.close();
		return false;}
	
	public static String nomeCliente(String CPF) throws IOException {
		File usertxt = new File("database", "Clientes.txt");
		usertxt.createNewFile();
		
		Scanner scanPermissao = new Scanner (new File ("database/Clientes.txt"));
		scanPermissao.useDelimiter(";");
		while(scanPermissao.hasNext()) {
			String nome = scanPermissao.next();
			String per = scanPermissao.next();
			if (CPF.equals(per)) {
				scanPermissao.close();
				return nome;
			}
		}
		
		return "Erro 10";
		}
	
	public static String endCliente(String CPF) throws IOException {
		File usertxt = new File("database", "Clientes.txt");
		usertxt.createNewFile();
		
		Scanner scanPermissao = new Scanner (new File ("database/Clientes.txt"));
		scanPermissao.useDelimiter(";");
		while(scanPermissao.hasNext()) {
			scanPermissao.next();
			String per = scanPermissao.next();
			String nome = scanPermissao.next();
			scanPermissao.next();
			if (CPF.equals(per)) {
				scanPermissao.close();
				return nome;
			}
		}
		
		return "Erro 10";
		}
	
	public static String[] EstoqueNome() throws IOException {
		File usertxt = new File("database", "Estoque.txt");
		usertxt.createNewFile();
		ArrayList al = new ArrayList();
		int counter = 0;
		Scanner scanPermissao = new Scanner (new File ("database/Estoque.txt"));
		while(scanPermissao.hasNextLine()) {
			counter++;
			scanPermissao.nextLine();
		}
		scanPermissao.close();
		
		Scanner scan = new Scanner (new File ("database/Estoque.txt"));
		scan.useDelimiter(";");
		for(int i = 0 ;i < counter; i++){
			scan.next();
			scan.next();
			scan.next();
			String per = scan.next();

			al.add(per);
		}
		scan.close();
		
	
		String lista [] = new String[al.size()];
	    for (int i = 0; i < al.size(); i++){
             lista[i] = (String) al.get(i);
          }
		return lista;
	}		
		
	public static int[] EstoqueQtd() throws IOException {
		File usertxt = new File("database", "Estoque.txt");
		usertxt.createNewFile();
		ArrayList al = new ArrayList();
		int counter = 0;
		Scanner scanPermissao = new Scanner (new File ("database/Estoque.txt"));
		while(scanPermissao.hasNextLine()) {
			counter++;
			scanPermissao.nextLine();
		}
		scanPermissao.close();
		
		Scanner scan = new Scanner (new File ("database/Estoque.txt"));
		scan.useDelimiter(";");
		for(int i = 0 ;i < counter; i++){
			scan.next();
			String per = scan.next();
			scan.next();
			scan.next();
			al.add(per);

		}
		scan.close();
		
	
		int lista [] = new int[al.size()];
	    for (int i = 0; i < al.size(); i++){
             lista[i] = Integer.parseInt((String) al.get(i));
          }
		return lista;
		
	}

	public static float[] EstoquePreco() throws IOException {
		File usertxt = new File("database", "Estoque.txt");
		usertxt.createNewFile();
		ArrayList al = new ArrayList();
		int counter = 0;
		Scanner scanPermissao = new Scanner (new File ("database/Estoque.txt"));
		while(scanPermissao.hasNextLine()) {
			counter++;
			scanPermissao.nextLine();
		}
		scanPermissao.close();
		
		Scanner scan = new Scanner (new File ("database/Estoque.txt"));
		scan.useDelimiter(";");
		for(int i = 0 ;i < counter; i++){
			scan.next();
			scan.next();
			String per = scan.next();
			scan.next();
			al.add(per);
		}
		scan.close();
		
	
		float lista [] = new float[al.size()];
	    for (int i = 0; i < al.size(); i++){
             lista[i] = Float.parseFloat((String) al.get(i));
          }
		return lista;
		
	}

	public static void checkIfValidInput(String input, String RegEx) {
		 String str;  	
		 //"[^a-z.0-9]"  < para os preços // "[^a-z_0-9]" para as senhas e usuarios 		
			Pattern p = Pattern.compile(RegEx, Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(input);
			boolean b = m.find();
			if (b)
			   System.out.println("There is a special character in my string");
	   }
	
	public static void abrirPdf(String path){
		   if (Desktop.isDesktopSupported()) {
			    try {
			        File myFile = new File(path);
			        Desktop.getDesktop().open(myFile);
			    } catch (IOException ex) {
			        // no application registered for PDFs
			    }
			}
	   }
	    
}
