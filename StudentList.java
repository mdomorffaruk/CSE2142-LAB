import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {

	public static String bufferFunction( String rw){
		String singleline = "";
		try{
			if(rw=="r"){
				
				BufferedReader bufferReader = new BufferedReader(
					new InputStreamReader(
						new FileInputStream("students.txt"))); 
				singleline = bufferReader.readLine();
			
			}else{
				BufferedWriter s = new BufferedWriter(
						new FileWriter("students.txt", true));

				s.write(rw);
				s.close();
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
		
		return singleline;

		
	}

	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");					
				String singleline = bufferFunction("r");
				String arrayOfString[] = singleline.split(",");			
				for(String singleString : arrayOfString) { 
					System.out.println(singleString); 
				}
			
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");			
			 
				String r = bufferFunction("r");
				String i[] = r.split(",");
					
				Random x = new Random();
				
				int y = x.nextInt(4);
				System.out.println(i[y]);

			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			

				
				String t = args[0].substring(1);
				Date d = new Date();
				String df = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(df);
				String fd= dateFormat.format(d);
				bufferFunction(", "+t+"\nList last updated on "+fd);	
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) {
			System.out.println("Loading data ...");			
			try {
				 
				String r = bufferFunction("r");
				String i[] = r.split(",");	
				// boolean done = false;
				String t = args[0].substring(1);
				for(int idx = 0; idx<i.length; idx++) {
					if(i[idx].equals(t)) {
						System.out.println("We found it!");
						break;
							// done=true;
					}else{
						System.out.println("Not found...please try again.. ");
					}
				}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) {
			System.out.println("Loading data ...");			
			try {
				
				String D = bufferFunction("r");
				char a[] = D.toCharArray();			
				boolean in_word = false;
				int count=0;
				for(char c:a) {
					if(c ==' ') 
					{
						if (!in_word) {
							count++;
							in_word =true;
						}
						else { 
							in_word=false;
						}			
					}
				}
				System.out.println(count +" word(s) found " );
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else{
			System.out.println("Wrong argument, please try again.."); 

		}
	}
}