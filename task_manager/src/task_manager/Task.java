package task_manager;

public class Task {
	private String title;
	private String category;
	private boolean completed;
	
	public Task(String title,String category) {
		this.title=title;
		this.category=category;
		this.completed=false;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public String toString() {
		return (completed? "[YES]":"[NO]") + title + " ("+category+")";
	}
	
	
}
