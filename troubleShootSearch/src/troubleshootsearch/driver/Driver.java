package troubleshootsearch.driver;

import java.util.List;
import java.io.IOException;
import troubleshootsearch.element.MyArrayList;
import troubleshootsearch.element.MyTree;
import troubleshootsearch.visitor.ExactMatcher;
import troubleshootsearch.visitor.SemanticMatcher;
import troubleshootsearch.visitor.NaiveBayesMatcher;
import troubleshootsearch.util.MyLogger;
import troubleshootsearch.util.MyLogger.DebugLevel;
import troubleshootsearch.util.Results;
import troubleshootsearch.util.FileProcessor;

/**
 * @author Yash Shingadiya
 *
 */
public class Driver {
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
				|| args[3].equals("${arg3}")|| args[4].equals("${arg4}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		}
		
		/**
		 * Restricting the order and name of the input and output files
		 */
		String input1 = "technicalInfo.txt";
		String input2 = "userInput.txt";
		String input3 = "synonyms.txt";
		String input4 = "output.txt";
		String finalResults = "";
		
		if((args[0].equals(input1)) && (args[1].equals(input2)) && (args[2].equals(input3)) && (args[3].equals(input4))){

			MyLogger ml = new MyLogger();
		    try {
		    	ml.setDebugValue(Integer.parseInt(args[4]));
		    }
		    catch(IOException e)
		    {
		    	System.err.println("Invalid integer input for debug level");
				System.exit(0);
		    }

			MyArrayList myArrayList = new MyArrayList();
			myArrayList.technicalInfoProcessing(input1);

			ExactMatcher exactMatcher = new ExactMatcher();
			myArrayList.accept(exactMatcher);

			NaiveBayesMatcher naiveBayesMatcher = new NaiveBayesMatcher();
			myArrayList.accept(naiveBayesMatcher);

			SemanticMatcher semanticMatcher = new SemanticMatcher();
			myArrayList.accept(semanticMatcher);

			MyTree myTree = new MyTree();
			myTree.userInfoProcessing(input2);

			FileProcessor fileProcessor = new FileProcessor(input2);
	    	String info = null;
	    	String info2 = null;

			try{    	
		    	while((info = fileProcessor.readLineFromFile()) != null){
		    		
		    		finalResults = finalResults+myTree.accept(exactMatcher,info)+"\n";
		    		finalResults = finalResults+myTree.accept(naiveBayesMatcher,info)+"\n";
		    		finalResults = finalResults+myTree.accept(semanticMatcher,info,input3)+"\n";
		    	}
		    	
		    }
		    
		    catch(Exception e){

				System.err.println("Please check the formatting of input file");
				System.exit(0);
			}
			
			finally{}
			Results results = new Results();

			/**
			* For writing output to file
			*/
			results.writeToFile(args[3],finalResults);
						
		}	

		else{

			System.err.println("Please pass arguments in following order: technicalInfo.txt userInput.txt synonyms.txt output.txt");
			System.exit(0);
		}

	}
}
