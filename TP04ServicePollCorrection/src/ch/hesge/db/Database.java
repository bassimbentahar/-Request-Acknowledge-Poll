package ch.hesge.db;

import java.io.*;
import java.net.URLDecoder;


/**
implemente la partie : Queue/RequestProcessor/Database
lit dans un fichier text oÃ¹ un compteur est incrementé ,

*/
public class Database {

	private static final String PATH="cpt.txt";
	
	
  public String read () {
    try {
	    String s = Database.class.getClassLoader().getResource(PATH).getPath();
	    String fullPath = URLDecoder.decode(s, "UTF-8");
	    BufferedReader reader = new BufferedReader(new FileReader(fullPath));
	    String line = reader.readLine();
	    reader.close();
      return line.toString();
    }
    catch (FileNotFoundException e0) {e0.printStackTrace(); return "";}
    catch (IOException e1) {e1.printStackTrace(); return "";}
    catch(NullPointerException e2) {return "0";}
  } // read

    
  public void inc () {
	    try {
	    	
	    	String is = Database.class.getClassLoader().getResource(PATH).getPath();
		    String fullPath = URLDecoder.decode(is, "UTF-8");
		    BufferedReader reader = new BufferedReader(new FileReader(fullPath));
		    String line = reader.readLine();
		    reader.close();
		    String resourceT = Database.class.getClassLoader().getResource(PATH).getPath().toString();
		    File x = new File(resourceT);
		    System.out.println(x.getAbsolutePath());
		    	Integer cpt=Integer.parseInt(line.toString().trim());
		    	PrintWriter pw=new PrintWriter(x);
		    	pw.println((++cpt).toString().trim());
		    	pw.flush();
		    	pw.close();
	    }
	    catch (FileNotFoundException e0) {e0.printStackTrace(); }
	    catch (IOException e1) {e1.printStackTrace(); }
	  } // inc


  public  void initialiser () {
	    try {

		  String resourceT = Database.class.getClassLoader().getResource(PATH).getPath().toString();

		    File x = new File(resourceT);
		    	PrintWriter pw=new PrintWriter(x);
		    	pw.println("0");
		    	pw.flush();
		    	pw.close();
	    }
	    catch (FileNotFoundException e0) {e0.printStackTrace(); }
	    catch (IOException e1) {e1.printStackTrace(); }
	  } // inc

  /**
   * @return false si cpt <1
   * @return true si cpt >=1
   */
  public  boolean reponsePrete () {
		if (Integer.parseInt(read()) < 1) {
			return false;
		}else {
			initialiser();
			return true;	    
		}
	  } // reponsePrete
  

} // ReadFile