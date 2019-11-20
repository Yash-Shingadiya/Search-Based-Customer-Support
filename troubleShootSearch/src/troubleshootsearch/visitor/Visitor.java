package troubleshootsearch.visitor;

import troubleshootsearch.element.MyArrayList;
import troubleshootsearch.element.MyTree;

public interface Visitor{ 
   
    public void visit(MyArrayList myArrayList);
    public String visit(MyTree myTree, String inputFile); 
} 