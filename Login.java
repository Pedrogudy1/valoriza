import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Login {
	
	private static BufferedReader lerUser;
	private static BufferedReader lerPw;

	
	
	
	Login() throws IOException{
		this.check();
	}

	void check() throws IOException {
		File f = new File("database");
		if(!f.exists()) {
			new File("database").mkdir();
			File usertxt = new File("database", "User.txt");
			usertxt.createNewFile();
			File pwtxt = new File("database", "Pw.txt");
			pwtxt.createNewFile();
			FileWriter EscUser = new FileWriter("database/User.txt",true);
			FileWriter EscPw = new FileWriter("database/Pw.txt",true);
			BufferedWriter bw3 = new BufferedWriter(EscUser);
			BufferedWriter bw4 = new BufferedWriter(EscPw);
			bw3.write("admin");
			bw3.newLine();
			bw3.close();
			bw4.write("admin");
			bw4.newLine();
			bw4.close();
			File Arquivo = new File("database", "Funcionario.txt");
			Arquivo.createNewFile();
			FileWriter Escritor = new FileWriter("database/Funcionario.txt", true);
			BufferedWriter EscCliente = new BufferedWriter(Escritor);
			EscCliente.write("Novo Admin"+ ";");
			EscCliente.write("Gerado Automaticamente"+ ";");
			EscCliente.write("1"+ ";");
			EscCliente.newLine();
			EscCliente.close();
		}
	}

	int logar(String inpUser,String inpPass) throws IOException {
		Utility.checkIfValidInput(inpUser ,"[^a-z._0-9]");
		Utility.checkIfValidInput(inpPass ,"[^a-z._0-9]");
		int counter = 1;
		Scanner scanUser = null;
		scanUser = new Scanner (new File("database/User.txt"));
		Scanner scanPw = null;
		scanPw = new Scanner (new File("database/Pw.txt"));

	    String user = scanUser.nextLine(); // looks at selected file in scan
	    String pass = scanPw.nextLine(); // looks at selected file in scan
	    
	    while  ((!inpUser.equals(user)) && (scanUser.hasNext())) {
	    	user = scanUser.nextLine();
	    	counter += 1;
	    }
	    if (!inpUser.equals(user)) {
	    	return 4; //Reinicia o Login pois estava errado o usuário.
	    }else {
	    	for (int i = 1; i < counter; i++) {
	    			pass = scanPw.nextLine();
	    			System.out.println(pass);
	    	}
	    	if (inpPass.equals(pass)) {
	    		
	    		
	    		Scanner scanPermissao = new Scanner (new File ("database/Funcionario.txt"));
	    		for(int i = 1; i < counter; i++) scanPermissao.nextLine();
	    		scanPermissao.useDelimiter(";");
	    		scanPermissao.next();
	    		scanPermissao.next();
	    		String per = scanPermissao.next();
	    		scanPermissao.close();
	    		Main.definirUser(counter);
	    		if (per.equals("1")) return 1;
	    		else return 2;	

	    		
	    	}else {
	    		Main.definirUser(counter);
	    		return 5; //Reinicia o Login pois estava errado a senha.
	    	}
	    }
	}

	
}

