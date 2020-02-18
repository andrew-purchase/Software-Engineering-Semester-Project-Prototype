package test1;

import javax.swing.JFileChooser;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class txtFileChooser{
	
	public txtFileChooser() throws Exception {
		
			//creating a file chooser with a txt file filter
		JFileChooser fileChooser = new JFileChooser();		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt files", "txt", "text");
		fileChooser.setFileFilter(filter);
			
			//printing file to user's home directory
		String u = System.getProperty("user.home");
		File f1 = new File(u, "testfile");
		PrintWriter writer = new PrintWriter(f1);	
		
			//
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File openedFile = fileChooser.getSelectedFile();
		
			Scanner in = new Scanner(openedFile);
			
			System.out.println("File is printed to home directory");
			
			while(in.hasNext()) {
				writer.println(in.nextLine());
				}
			writer.close();				
			in.close();
			
		} else {
			
			System.out.println("File not selected");
			System.exit(1);
		}
	}
}
