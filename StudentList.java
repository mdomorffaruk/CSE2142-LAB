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
						new FileInputStream(Constants.FILE_NAME))); 
				singleline = bufferReader.readLine();
				bufferReader.close();
			
			}else{
				BufferedWriter s = new BufferedWriter(
						new FileWriter(Constants.FILE_NAME, true));

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
			System.out.println(Constants.LOADING_TXT);					
				String singleline = bufferFunction("r");
				String arrayOfString[] = singleline.split(",");			
				for(String singleString : arrayOfString) { 
					System.out.println(singleString); 
				}
			
			System.out.println(Constants.AFTER_LOADING_TEXT);
		}
		else if(args[0].equals("r")) {
			System.out.println(Constants.LOADING_TXT);			
			 
				String r = bufferFunction("r");
				String i[] = r.split(",");
					
				Random x = new Random();
				
				int y = x.nextInt(4);
				System.out.println(i[y]);

			System.out.println(Constants.AFTER_LOADING_TEXT);			
		}
		else if(args[0].contains("+")){
			System.out.println(Constants.LOADING_TXT);			

				
				String t = args[0].substring(1);
				Date d = new Date();
				String df = Constants.DATE_FORMAT;
				DateFormat dateFormat = new SimpleDateFormat(df);
				String fd= dateFormat.format(d);
				bufferFunction(", "+t+"\n"+Constants.LIST_UPDATE_TXT+fd);	
			System.out.println(Constants.AFTER_LOADING_TEXT);	
		}
		else if(args[0].contains("?")) {
			System.out.println(Constants.LOADING_TXT);			
			try {
				 
				String r = bufferFunction("r");
				String i[] = r.split(",");	
				// boolean done = false;
				String t = args[0].substring(1);
				for(int idx = 0; idx<i.length; idx++) {
					if(i[idx].equals(t)) {
						System.out.println(Constants.FOUND);
						break;
							// done=true;
					}else{
						System.out.println(Constants.NOT_FOUND);
					}
				}
			} catch (Exception e){} 
			System.out.println(Constants.AFTER_LOADING_TEXT);				
		}
		else if(args[0].contains("c")) {
			System.out.println(Constants.LOADING_TXT);			
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
				System.out.println(count +Constants.COUNT_TXT );
			} catch (Exception e){} 
			System.out.println(Constants.AFTER_LOADING_TEXT);				
		}
		else{
			System.out.println(Constants.WRONG_ARG_TXT); 

		}
	}
}