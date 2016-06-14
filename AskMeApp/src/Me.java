import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.AbstractListModel;

/**
 * This class describes information about me
 * @author Andhika Srimadeva
 * @param <E>
 *
 */
public class Me<E> extends AbstractListModel<E>{

	private Map<String, String> information;
	private ArrayList<String> questions;
	private final String name = "Andhika Srimadeva";
	private final String age = "18";
	private final String birthday = "09th July 1997";
	private final String birthplace = "Pekanbaru, Indonesia";
	private final String religion = "Islam";	
	
	public Me(){
		
		information = new TreeMap<String, String>();
		questions = new ArrayList<String>();
		
		setInformation();
		
	}

	private void setInformation(){
		
		information.put("What is my full name?", name);
		information.put("How old am I?", age);
		information.put("Where is my birthplace?", birthplace);
		information.put("When is my birthday?", birthday);
		information.put("What is my religion?", religion);
		information.put("How many languages do I speak?", "3 - Indonesian, English, French");
		information.put("What are the programming/markup languages am I familiar with?", "Java is my primary one. I also understand HTML, CSS and Javascript");
		
		addQuestions();
	}
	
	public String getAnswer(String question){
		
		return information.get(question);
	}
	
	private void addQuestions(){
		
		for(String question: information.keySet()){
			questions.add(question);
		}
	}

	@Override
	public E getElementAt(int arg0) {
		
		return (E) questions.get(arg0);
	
	}

	@Override
	public int getSize() {
		
		return questions.size();
	
	}
	
}
