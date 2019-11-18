package troubleshootsearch.element;

import java.util.Map;
import java.util.HashMap;
import troubleshootsearch.visitor.ExactMatcher;
import troubleshootsearch.visitor.NaiveBayesMatcher;
import troubleshootsearch.visitor.SemanticMatcher;
import troubleshootsearch.element.Node;
import troubleshootsearch.util.MyLogger;
import troubleshootsearch.util.MyLogger.DebugLevel;

public class Node{ 
   
    private String word;
    private Map<String,String> words;
    private int wordCount;
    MyLogger ml = new MyLogger();

    public Node(){

        ml.writeMessage("Constructor called: Node()", DebugLevel.CONSTRUCTOR);
        this.words = new HashMap<String,String>();
        this.wordCount = 0;
    }
    public void setNode(String word){

        this.word = word;
    }
    
    public String getWord(){

        return this.word;
    }
    
} 