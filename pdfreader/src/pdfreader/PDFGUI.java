package pdfreader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import javax.swing.*;
import java.awt.*;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import org.apache.pdfbox.Loader;



public class PDFGUI extends JFrame{
	private JTextArea textArea;
	
	public PDFGUI() {
		setTitle("PDF Reader");
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		textArea=new JTextArea();
		textArea.setEditable(false);
		JScrollPane scrollPane=new JScrollPane(textArea);
		add(scrollPane, BorderLayout.CENTER);
		
		JButton openpdfBtn=new JButton("Open PDF");
		openpdfBtn.addActionListener(e-> openPDF());
		add(openpdfBtn, BorderLayout.SOUTH);
	}
	
	private void openPDF() {
		JFileChooser fileChooser=new JFileChooser();
		int option=fileChooser.showOpenDialog(this);
		
		if(option==JFileChooser.APPROVE_OPTION) {
			File file=fileChooser.getSelectedFile();
			
			try(var document=Loader.loadPDF(file)){
				var stripper= new PDFTextStripper();
				
				StringWriter writer=new StringWriter();
				
				stripper.writeText(document, writer);
				
				String text=writer.toString();
				textArea.setText(text);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "Error reading PDF: " + ex.getMessage());
			}
		}
	}
	
}
