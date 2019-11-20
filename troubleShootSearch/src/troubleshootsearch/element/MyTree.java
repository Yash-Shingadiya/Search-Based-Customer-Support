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

    
    public String accept(ExactMatcher exactMatcher,String wordsFile){

      String result = "";

      result = "user input - "+wordsFile+"\n";
      result = result+"Exact Match"+"\n";
      result = result+"-----------"+"\n";
      result = result+exactMatcher.visit(this, wordsFile);
      ml.writeMessage(result,DebugLevel.IN_RESULTS);
      return result;
    }
    public String accept(NaiveBayesMatcher naiveBayesMatcher,String wordsFile){
  
      String result = ""+"\n";
      result = result + "Naive Stemming Match"+"\n";
      result = result + "--------------------"+"\n";
      result = result + naiveBayesMatcher.visit(this, wordsFile);
      ml.writeMessage(result,DebugLevel.IN_RESULTS);
      return result;
    } 
    public String accept(SemanticMatcher semanticMatcher,String wordsFile){return null;} 

    public String accept(SemanticMatcher semanticMatcher,String wordsFile,String synonymsFile){
    
      FileProcessor fileProcessor = new FileProcessor(synonymsFile);
  
      String[] synonyms = null;
      String info = null;
      String result = ""+"\n";
      result = result + "Semantic Match"+"\n";
      result = result + "--------------"+"\n";

    try{      

      while((info = fileProcessor.readLineFromFile()) != null){
            
          synonyms = info.split("=");  
          result = result + semanticMatcher.visit(this,wordsFile,synonyms[0],synonyms[1])+"\n";
          ml.writeMessage(result,DebugLevel.IN_RESULTS);
          return result;          
        }
      }
      
      catch(Exception e){

        System.err.println("Please check the formatting of input file");
        System.exit(0);
      }
    
      finally{}
      return null;
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