
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Phrase;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class produtosReport {

	private static Scanner scanCliente;
	public static void relatorio() throws IOException, DocumentException {
			
		String scanAux;
		Document document1 = new Document(PageSize.A4);
		PdfWriter.getInstance(document1, new FileOutputStream("Produtos.pdf"));
		document1.open();
		scanCliente = new Scanner (new File("database/Estoque.txt"));
		scanCliente.useDelimiter(";");			 
	    
		// Escrevendo no pdf os headers do template Report e ajeitando o tamanho e posição da table
		PdfPTable table1 = new PdfPTable(4);
		table1.setWidths(new int[]{16, 15, 15, 20 });
		table1.setSpacingBefore(0);       
	    table1.setSpacingAfter(0);
	    Font boldFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
	    PdfPCell c1 = new PdfPCell(new Phrase("ID", boldFont));         
	    table1.addCell(c1);
	    PdfPCell c2 = new PdfPCell(new Phrase("Quantidade", boldFont));   
	    table1.addCell(c2); 
	    PdfPCell c3 = new PdfPCell(new Phrase("Preço", boldFont)); 
	    table1.addCell(c3); 
	    PdfPCell c4 = new PdfPCell(new Phrase("Produto", boldFont));   
	    table1.addCell(c4);
	    //
	    
		fillTable(table1);
		scanCliente.close();
	    document1.add(table1);
	    document1.close();   
	}
	
	
	
	public static void fillTable(PdfPTable table1){
		String scanAux;
		while (scanCliente.hasNext()) {
			scanAux = scanCliente.next();
			if (!scanAux.equals(System.lineSeparator())) {
				table1.addCell(scanAux);
			}

		}
	}
}