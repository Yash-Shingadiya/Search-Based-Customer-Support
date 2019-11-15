package troubleshootsearch.element;

import troubleshootsearch.visitor.Visitor;

public interface Element{ 
    
    public void accept(Visitor visitor); 
} 