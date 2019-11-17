package troubleshootsearch.visitor;

import troubleshootsearch.element.MyArrayList;
import troubleshootsearch.element.MyTree;

public class NaiveBayesMatcher implements Visitor{

	public void visit(MyArrayList myArrayList){

		System.out.println("I am inside NaiveBayesMatcher");
	}
	public void visit(MyTree myTree, String wordsFile){}
}