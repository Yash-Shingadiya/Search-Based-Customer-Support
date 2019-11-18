package troubleshootsearch.util;

import java.io.IOException;

public class MyLogger {

    /*DEBUG_VALUE=3 [Print every line read by input file to stdout]
      DEBUG_VALUE=2 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=1 [Print to results to stdout]
      DEBUG_VALUE=0 [No output will be printed from the application to stdout. Only errors will be printed to stdout" ]
    */

    public static enum DebugLevel {RELEASE, FROM_INPUTFILE, IN_RESULTS, IN_RUN, CONSTRUCTOR};

    private static DebugLevel debugLevel;

    /**
     * This method matches the input level with a debug level which is an enum
     */
    public static void setDebugValue (int level) throws IOException {
	
		if(level < 0 || level > 3){
			
            throw new IOException("Program accepts integers between 0-3 only");
        }
		
		switch (level) {
			
			//Read line from every input file
            case 3: debugLevel = DebugLevel.FROM_INPUTFILE; break;
            //For all the constructors
            case 2: debugLevel = DebugLevel.CONSTRUCTOR; break;
            //From file print the final results
			case 1: debugLevel = DebugLevel.IN_RESULTS; break;
            //Only errors
            case 0: debugLevel = DebugLevel.RELEASE; break;
		}
    	
	
    }
    
    /**
     * This method accepts type debug level to assign it
     */
    public static void setDebugValue (DebugLevel level) {
	   
        debugLevel = level;
    }

    
    /**
     * This method writes to stdout if the debug level matches the
     * input level provided
     */
    public static void writeMessage (String  message, DebugLevel level) {
    	
        if (level == debugLevel){
    	    System.out.println(message);
        }
    }
}
