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

	public void visit(MyTree myTree,String wordsFile){

    	String info = null;
    	String[] firstpart = null;
    	int wordCount = 0;
    	List<Integer> lineNumber = new ArrayList<Integer>(); 
    	Map<String,List<Integer>> wordLineMapping = new HashMap<String,List<Integer>>();
    	this.nodesList = myTree.getNodesList();

		for(int i = 0; i < this.inputString.size(); i++){
		
			for(int j = 0; j < this.nodesList.size(); j++){
				
				firstpart = this.nodesList.get(j).getWord().split(" ");
				
				if(this.inputString.get(i).contains(firstpart[0])){

					wordCount++;
					lineNumber.add((i+1));
					wordLineMapping.put(firstpart[0],lineNumber);
					/*System.out.println(this.inputString.get(i)+" "+wordCount+" "+(i+1));*/
				}
			}
		}

		System.out.println(wordCount+""+wordLineMapping.get(firstpart[0]));

		for (Map.Entry<String, List<Integer>> entry : wordLineMapping.entrySet()) {
		    
		    String key = entry.getKey();
		    List<Integer> value = entry.getValue();
		    
		    for(Integer line : value){
		        System.out.println("key : " + key + " value : " + line);
		    }
		}

		System.out.println("No naive stemming match");
	}
}