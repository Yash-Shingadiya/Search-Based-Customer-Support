package troubleshootsearch.element;

import java.util.List;
import java.util.ArrayList;
import troubleshootsearch.util.FileProcessor;
import troubleshootsearch.visitor.ExactMatcher;
import troubleshootsearch.visitor.NaiveBayesMatcher;
import troubleshootsearch.visitor.SemanticMatcher;

public class MyArrayList implements Element{ 
   
   	private List<String> technicalInfo;
   	
   	public List getMyArrayList(){

   		return this.technicalInfo;
   	}

    public String accept(ExactMatcher exactMatcher, String inputFile){return null;}
    public String accept(NaiveBayesMatcher naiveBayesMatcher, String inputFile){return null;} 
    public String accept(SemanticMatcher semanticMatcher, String inputFile){return null;} 

    public void accept(ExactMatcher exactMatcher){

    	exactMatcher.visit(this);
    }
    public void accept(NaiveBayesMatcher naiveBayesMatcher){
    	naiveBayesMatcher.visit(this);
    } 
    public void accept(SemanticMatcher semanticMatcher){
    	semanticMatcher.visit(this);
    } 

    public void technicalInfoProcessing(String inputFile){

    	FileProcessor fileProcessor = new FileProcessor(inputFile);
    	this.technicalInfo = new ArrayList<String>();
    	String info = null;

		try{    	
	    	while((info = fileProcessor.readLineFromFile()) != null){
	    		
	    		this.technicalInfo.add(info);
	    	}
	    }
	    
	    catch(Exception e){

			System.err.println("Please check the formatting of input file");
			System.exit(0);
		}
		
		finally{}
			
    }
} 