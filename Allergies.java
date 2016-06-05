import java.util.List;
import java.util.ArrayList;

class Allergies{

	int sum; // sum of allergies
	
	public Allergies(int sum){
		this.sum = sum;
	}	
	
	public boolean isAllergicTo(Allergen allergen) {
		int score = allergen.getScore();
		return ((score & sum) == score);
	}
	
	public List<Allergen> getList(){
		List<Allergen> allergens = new ArrayList<>();
		
		for (Allergen a: Allergen.values()) {
			int score = a.getScore();
			if ((score & sum) == score) allergens.add(a);
		}		
		return allergens;
	}
}