package troubleshootsearch.visitor;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import troubleshootsearch.util.FileProcessor;
import troubleshootsearch.element.MyArrayList;
import troubleshootsearch.element.MyTree;
import troubleshootsearch.element.Node;

public class SemanticMatcher implements Visitor{

	private List<String> inputString;
	private List<Node> nodesList;

	public void visit(MyArrayList myArrayList){
	
		this.inputString = myArrayList.getMyArrayList();
	}

	public String visit(MyTree myTree,String wordsFile){ return null;}

	public String visit(MyTree myTree,String wordsFile,String word,String synonym){

    	int count = 0;
    	String[] endpart;
    	String result = "";
    	Map<String,String> synonyms = new HashMap<String,String>();
    	this.nodesList = myTree.getNodesList();
		

		for(int i = 0; i < this.inputString.size(); i++){

			endpart = wordsFile.split(" ");
			if(!this.inputString.get(i).contains(endpart[1])){
				
				if((endpart[1].equals(word))||(endpart[1].equals(synonym))){

					if((this.inputString.get(i).contains(word))||(this.inputString.get(i).contains(synonym))){
						result = ""+result+this.inputString.get(i)+"\n";			
						count++;

					}	
				}
							
			}	
		}

		if(count > 0){
			return result;
		}
		else{

			result = ""+result+"No semantic match";
			return result;
		}
	}
}