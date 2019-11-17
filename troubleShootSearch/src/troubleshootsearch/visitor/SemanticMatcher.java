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

	public void visit(MyTree myTree,String wordsFile){

		FileProcessor fileProcessor = new FileProcessor(wordsFile);
  
  		String[] phrases = null;
    	String info = null;
    	String[] endpart;
    	Map<String,String> synonyms = new HashMap<String,String>();
    	this.nodesList = myTree.getNodesList();
		

		try{    	

			while((info = fileProcessor.readLineFromFile()) != null){
		    		
	    		phrases = info.split("=");	
	    		synonyms.put(phrases[0],phrases[1]);
	    	}
	    }
	    
	    catch(Exception e){

			System.err.println("Please check the formatting of input file");
			System.exit(0);
		}
		
		finally{}

		for(int i = 0; i < this.inputString.size(); i++){
		
			for(int j = 0; j < this.nodesList.size(); j++){
				
				endpart = this.nodesList.get(j).getWord().split(" ");
				
				if(synonyms.containsKey(endpart[1])){
					
					if(this.inputString.get(i).contains(synonyms.get(endpart[1]))||this.inputString.get(i).contains(endpart[1])){

						System.out.println(this.inputString.get(i));
					}
				}

			}
		}

		System.out.println("No semantic match");
	}
}