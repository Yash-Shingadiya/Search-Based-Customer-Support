package troubleshootsearch.driver;

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
		if (args.length != 4 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
				|| args[3].equals("${arg3}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 4 argumnets.");
			System.exit(0);
		}
		
		/**
		 * Restricting the order and name of the input and output files
		 */
		String input1 = "technicalInfo.txt";
		String input2 = "userInfo.txt";
		String input3 = "synonyms.txt";
		String input4 = "output.txt";
		
		if((args[0].equals(input1)) && (args[1].equals(input2)) && (args[2].equals(input3)) && (args[3].equals(input4))){

			
		
		}	

		else{

			System.err.println("Please pass arguments in following order: technicalInfo.txt userInfo.txt synonyms.txt output.txt");
			System.exit(0);
		}

	}
}
