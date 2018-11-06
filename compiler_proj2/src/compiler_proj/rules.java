package compiler_proj;

import java.io.*;
import java.util.*;

/*
 * read rule.txt and add "-" in  index(1) of each rule;
 * */

public class rules {
	
	private ArrayList<String> rule_line = new ArrayList<>();
	
	
	public rules() throws IOException  {
	
		rule_line.clear();
		BufferedReader br = new BufferedReader(new FileReader("rule.txt"));
		
	    while(true) {
	        String line = br.readLine();
	        if(line==null) break;
	        if(line.charAt(0)!='R'){
	        	StringBuilder newline = new StringBuilder(line);
	        	newline.insert(1, '-');
	        	newline.insert(0, '[');
	        	newline.append(']');
	        	newline.append(' ');
	        	rule_line.add(newline.toString());
	        } 
	    }
	    br.close();
	    rule_line.add(0, "[S->E] ");
	    
	  
	    
	    
	
	}
	public List<String> getRules(){
		return this.rule_line;
	}
	
	
}
