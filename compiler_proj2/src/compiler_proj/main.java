package compiler_proj;
import c0_algorithm.*;

import java.io.*;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Parsing_alg pa = new Parsing_alg();
		
		
		File file = new File("output.txt");
		FileWriter writer = null;
		try {
			 writer = new FileWriter(file, false);
	         for(int i=0;i<pa.getFinal_array().size();i++)
	         {	writer.write("I"+i+"\n");
	        	 for(int j=0;j<pa.getFinal_array().get(i).size();j++)
	        	 {	 
	        		 for(int k=0;k<pa.getFinal_array().get(i).get(j).length;k++)
	        			 writer.write(pa.getFinal_array().get(i).get(j)[k]); 
	        		 writer.write(" ");
	        	 	}
	        	 writer.write("\n");
	         }
			 
	            writer.flush();

	            writer.close();

		}catch(IOException e) {
	            e.printStackTrace();



		}
		
	
		
		
	
		
	
	}

}
