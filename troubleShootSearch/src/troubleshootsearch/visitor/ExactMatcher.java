package troubleshootsearch.visitor;

import java.util.List;
import troubleshootsearch.element.MyArrayList;
import troubleshootsearch.element.MyTree;
import troubleshootsearch.element.Node;

public class ExactMatcher implements Visitor{

	private List<String> inputString;
	private List<Node> nodesList;

	public void visit(MyArrayList myArrayList){
	
		this.inputString = myArrayList.getMyArrayList();
	}

	public String visit(MyTree myTree,String wordsFile){

		this.nodesList = myTree.getNodesList();
		String result = "";
		int count = 0;

		for(int i = 0; i < this.inputString.size(); i++){
	
			if(this.inputString.get(i).contains(wordsFile)){

				result = ""+result + this.inputString.get(i);
				count++;
			}
			
		}

		if(count > 0){
			return result;
		}
		else{
			result = ""+result + "No exact match";
			return result;
		}
		
	}
}