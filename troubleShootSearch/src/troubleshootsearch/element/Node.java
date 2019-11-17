package troubleshootsearch.element;

import java.util.Map;
import java.util.HashMap;
import troubleshootsearch.visitor.ExactMatcher;
import troubleshootsearch.visitor.NaiveBayesMatcher;
import troubleshootsearch.visitor.SemanticMatcher;
import troubleshootsearch.element.Node;

public class Node{ 
   
    private String word;
    private Map<String,String> words;

    public Node(){

        this.words = new HashMap<String,String>();
    }
    public void setNode(String word){

        this.word = word;
    }
    
    public String getWord(){

        return this.word;
    }
} 