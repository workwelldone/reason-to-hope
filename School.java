import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class School {

	private Map<Integer, List<String>> students = new HashMap<>();
	
	public School() {}
	
	private Map<Integer, List<String>> cloneDB(){
		if (students == null) return null;
		Map<Integer, List<String>> clone = new HashMap<>();
		for (Integer i: students.keySet()){
			clone.put(new Integer(i), new ArrayList<>(students.get(i)));
		}
		return clone;
	}
	
	public Map<Integer, List<String>> db() {
		return cloneDB();
	}

	public void add(String student, int grade){
		if (students.get(grade) == null) {
			students.put(grade, new ArrayList<String>());
		}
		students.get(grade).add(student);
	}

	public List<String> grade(int grade) {
		List<String> gradeList = cloneDB().get(grade);
		return gradeList == null ? new ArrayList<>() : gradeList;
	}
	
	public Map<Integer, List<String>> sort(){
		if (students == null) return null;
		for (Integer i: students.keySet()) {
			Collections.sort(students.get(i));
		}
		return cloneDB();
	}
}