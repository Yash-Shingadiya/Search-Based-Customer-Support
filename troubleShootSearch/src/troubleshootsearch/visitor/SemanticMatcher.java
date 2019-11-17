package troubleshootsearch.visitor;

import java.util.List;
import troubleshootsearch.util.FileProcessor;
import troubleshootsearch.element.MyArrayList;
import troubleshootsearch.element.MyTree;

public class SemanticMatcher implements Visitor{

	public void visit(MyArrayList myArrayList){

		System.out.println("I am inside SemanticMatcher");
	}
	public void visit(MyTree myTree, String wordsFile){}
}