package troubleshootsearch.element;

import java.util.List;
import java.util.ArrayList;
import troubleshootsearch.visitor.ExactMatcher;
import troubleshootsearch.visitor.NaiveBayesMatcher;
import troubleshootsearch.visitor.SemanticMatcher;
import troubleshootsearch.util.FileProcessor;
import troubleshootsearch.element.Node;
import troubleshootsearch.util.MyLogger;
import troubleshootsearch.util.MyLogger.DebugLevel;

public class MyTree implements Element{ 
   
   	Node node;
   	private List<Node> nodesList;
    MyLogger ml = new MyLogger();
    
   	public MyTree(){

   		ml.writeMessage("Constructor called: MyTree()", DebugLevel.CONSTRUCTOR);
   		this.nodesList = new ArrayList<Node>();
   	}

   	public List getNodesList(){
   		
   		return this.nodesList;
   	}

    public void accept(ExactMatcher exactMatcher){}
    public void accept(NaiveBayesMatcher naiveBayesMatcher){} 
    public void accept(SemanticMatcher semanticMatcher){}

    public void accept(ExactMatcher exactMatcher,String wordsFile){

    	exactMatcher.visit(this, wordsFile);
    }
    public void accept(NaiveBayesMatcher naiveBayesMatcher,String wordsFile){
    	
    	naiveBayesMatcher.visit(this, wordsFile);
    } 
    public void accept(SemanticMatcher semanticMatcher,String wordsFile){
    	
    	semanticMatcher.visit(this, wordsFile);
    } 

    public void userInfoProcessing(String inputFile){

    	FileProcessor fileProcessor = new FileProcessor(inputFile);
    	String info = null;

		try{    	
	    	while((info = fileProcessor.readLineFromFile()) != null){
	    		
	    		this.node = new Node();
	    		this.nodesList.add(this.node);
	    		this.node.setNode(info);

	    	}
	    }
	    
	    catch(Exception e){

			System.err.println("Please check the formatting of input file");
			System.exit(0);
		}
		
		finally{}
			
    
    }
} 