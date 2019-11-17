package troubleshootsearch.visitor;

import java.util.List;
import troubleshootsearch.util.FileProcessor;
import troubleshootsearch.element.MyArrayList;
import troubleshootsearch.element.MyTree;
import troubleshootsearch.element.Node;

public class ExactMatcher implements Visitor{

	private List<String> inputString;
	private List<Node> nodesList;

	public void visit(MyArrayList myArrayList){
	
		this.inputString = myArrayList.getMyArrayList();
	}

	public void visit(MyTree myTree,String wordsFile){

		this.nodesList = myTree.getNodesList();

		for(int i = 0; i < this.inputString.size(); i++){

			for(int j = 0; j < this.nodesList.size(); j++){

				if(this.inputString.get(i).contains(this.nodesList.get(j).getWord())){

					System.out.println(this.inputString.get(i));
				}
			}
		}
		System.out.println("No exact match");
	}
}