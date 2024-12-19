/*
 * First Java program to say Hello
 */
public class Hello {   // Save as "Hello.java" under "d:\myProject"
   public static void main(String[] args) {
      System.out.println("Hello, worlddsdsa!"+args[3]);

if (args.length > 0) { 
    	    System.out.println( 
    	        "The command line arguments are:"); 

    	    // iterating the args array and printing 
    	    // the command line arguments 
    	    for (String val : args) 
		if(val.equalsIgnoreCase("*"))
		System.out.println("*");
		else
			System.out.println(val); 
    	
    	       
    	} 
    	else
    	    System.out.println("No command line "
    	                       + "arguments found."); 
    	} 
   }
