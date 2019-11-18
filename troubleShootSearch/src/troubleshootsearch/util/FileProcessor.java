package troubleshootsearch.util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import troubleshootsearch.util.MyLogger;
import troubleshootsearch.util.MyLogger.DebugLevel;

/**
 * Reference: https://stackoverflow.com/questions/3806062/how-to-open-a-txt-file-and-read-numbers-in-java
 */


/**
 * Common class for reading all the input files
 */
public class FileProcessor {
	
	static int noOfLines = 0;
	private BufferedReader br;
	MyLogger ml = new MyLogger();
	private String inputFile;
	
	/** 
	 * Constructor initialises the input file and checks whether it exists or not
	 */
	public FileProcessor(String inputFile) {
		
		try 
		{
			this.inputFile = inputFile;	
			ml.writeMessage("Constructor called: FileProcessor()", DebugLevel.CONSTRUCTOR);
			File f = new File(this.inputFile);
			
			if(f.length() == 0){
				System.err.println("The given input file is empty or file does not exist");
				System.exit(0);	
			}
			else{
				this.br = new BufferedReader(new FileReader(f));	
			}
			
		} 
		catch (Exception e) {
			System.err.println("The file does not exist");
			System.exit(0);
		}
	}
	  
	/**
	*This method reads each line of the file and returns each line
	*/
	public String readLineFromFile() {
		try
		{
			String s = null;
			
			while ((s = this.br.readLine()) != null) {
				
				ml.writeMessage("Reading line from: "+this.inputFile+" "+"file: "+ s, DebugLevel.FROM_INPUTFILE);
				return s;	
			}
		} 
		catch (Exception e) {
			System.err.println("Error with file");
			e.printStackTrace();
			System.exit(0);
		}
		
		try {
			noOfLines=0;
			this.br.close();
		}
		catch (Exception e)
		{
			System.err.println("Error while closing file");
			e.printStackTrace();
			System.exit(0);
		}
		finally{

		}
		return null;
	}	
}

