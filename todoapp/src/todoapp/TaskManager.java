package todoapp;
import java.io.*;
import java.util.*;


public class TaskManager {
	private List<String> tasks;
	private  final String FileName="tasks.txt";
	
	public TaskManager() {
		tasks=new ArrayList<>();
	}

	public List<String> getTasks() {
		return tasks;
	}

	public void setTasks(List<String> tasks) {
		this.tasks = tasks;
	}
	
	
	public void addTask(String task) {
		tasks.add(task);
	}
	
	public void removeTask(int index) {
		if(index>=0 && index<tasks.size()) {
			tasks.remove(index);
		}
	}
	
	public void clearTasks() {
		tasks.clear();
	}
	
	
	public void saveTasks() throws IOException {
		FileWriter fw=null;
		BufferedWriter bw=null;
		
		try {
			fw=new FileWriter(FileName);
			bw=new BufferedWriter(fw);
			
			for(String task:tasks) {
				bw.write(task);
				bw.newLine();
			}
		}finally {
			if(bw!=null) {
				bw.close();
			}
			
			if(fw!=null) {
				fw.close();
			}
		}
		
	}
	
	
	public void loadTasks() throws IOException{
		FileReader fr=null;
		BufferedReader br=null;
		
		tasks.clear();
		
		try {
			 fr=new FileReader(FileName);
			 br=new BufferedReader(fr);
			
			 String line;
			 while((line=br.readLine())!=null) {
				 tasks.add(line);
			 }
		}finally {
			if(br!=null) {
				br.close();
			}
			if(fr!=null) {
				fr.close();
			}
		}
	}
	
}
