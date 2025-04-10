package studentmanagement;
import java.io.*;
import java.util.*;

public class StudentsFileHandler {
	public static final String TextFILE="master.txt";
	public static final String BinaryFILE="master.dat";
	
	public StudentsFileHandler() {
		
	}
	
	public void writeToTextFile(Student aStudent) throws IOException {
		File outFile =new File(TextFILE);
		FileWriter writer=new FileWriter(outFile, true);
		writer.write(aStudent.toString());
		writer.write('\n');
		writer.close();
	}
	
	public void readFromTextFile() throws IOException,FileNotFoundException{
		File inFile=new File(TextFILE);
		if(inFile.exists()) {
			FileReader freader=new FileReader(inFile);
			BufferedReader reader=new BufferedReader(freader);
			String line;
			line=reader.readLine();
			while(line!=null) {
				System.out.println(line);
				line=reader.readLine();
			}
			System.out.println();
			freader.close();
			reader.close();
		}
	}
	
	public void writeToBinaryFile(ArrayList<Student>db)throws IOException{
		File destination=new File(BinaryFILE);
		FileOutputStream fouts=new FileOutputStream(destination);
		ObjectOutputStream os=new ObjectOutputStream(fouts);
		os.writeObject(db);
		fouts.close();
		os.close();
	}
	
	public ArrayList<Student> readFromBinaryFile() throws IOException,ClassNotFoundException{
		File source=new File(BinaryFILE);
		if(source.exists()) {
			FileInputStream fins=new FileInputStream(source);
			ObjectInputStream is=new ObjectInputStream(fins);
			ArrayList<Student> db=(ArrayList<Student>)is.readObject();
			fins.close();
			is.close();
			return db;
		}else {
			return null;
		}
	}
	
	
}
