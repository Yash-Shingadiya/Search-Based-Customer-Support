package troubleshootsearch.visitor;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import troubleshootsearch.element.MyArrayList;
import troubleshootsearch.element.MyTree;
import troubleshootsearch.element.Node;

public class NaiveBayesMatcher implements Visitor{

	private List<String> inputString;
	private List<Node> nodesList;

	public void visit(MyArrayList myArrayList){
	
		this.inputString = myArrayList.getMyArrayList();
	}

	public String visit(MyTree myTree,String wordsFile){

    	String info = null;
    	String[] firstpart = null;
    	String[] individualWords = null;
    	String result = "";
    	int wordCount = 0;
    	List<Integer> lineNumber = new ArrayList<Integer>(); 
    	Map<String,List<Integer>> wordLineMapping = new HashMap<String,List<Integer>>();
    
		for(int i = 0; i < this.inputString.size(); i++){
			
				firstpart = wordsFile.split(" ");	
				individualWords = this.inputString.get(i).split(" ");

				for (int j = 0;j < individualWords.length ;j++ ) {
				
					if((individualWords[j].contains(firstpart[0])) && (individualWords[j].length() != firstpart[0].length())){
						
						wordCount++;
						lineNumber.add((i+1));
						wordLineMapping.put(firstpart[0],lineNumber);
						result = ""+"Word Count = "+String.valueOf(wordCount)+"\n"+"Line Numbers = "+wordLineMapping.get(firstpart[0])+"";		
					}	
				}
			
			individualWords = null;
			wordLineMapping.clear();
		}

		if(wordCount > 0){

			return result;
		}
		else{

			result = ""+result+"No naive stemming match";
			return result;
		}
	}
}