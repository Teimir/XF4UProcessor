package emuprocJava;
import java.io.*;
import java.nio.file.*;

public class data {
			
		public static String dataread(String a) {
			String res = "";
			String as = "";
			String userDirectory = Paths.get("").toAbsolutePath().toString();
			
			 try(FileInputStream fin=new FileInputStream(userDirectory + "/data/disk.txt"))
		        {
		              
		            int i=-1;
		            while((i=fin.read())!=-1){
		              
		                as = as + (char)i;
		            }   
		        }
		        catch(IOException ex) {
		        } 
			 String[] s = as.split(";");
			 
			for(int i = 0; i < s.length; i++) {
				String[] l = s[i].split(":");
				
				if(l.length != 1) {
					if (l[0].equals(a)) {
						res = l[1];
					}
				}
			}
			 
			
			return res;
			
		}
		public static void datawr(String a, String b) {
			String as = "", bs = "";
			String userDirectory = Paths.get("").toAbsolutePath().toString();
			
			try(FileInputStream fin=new FileInputStream(userDirectory + "/data/disk.txt"))
			{
	              
	            int i=-1;
	            while((i=fin.read())!=-1){
	              
	              as = as + (char)i;
	            }   
	        }
	        catch(IOException ex){
	              
	            System.out.println(ex.getMessage());
	        } 
			
			String[] s = as.split(";");
			 
			for(int i = 0; i < s.length; i++) {
				String[] l = s[i].split(":");
				
				if(l.length != 1) {
					if (l[0].equals(a)) {
						l[1] = b;
						s[i] = l[0] + ":" +l[1];
					}
				}			
				
			}	
			
			for(int l = 0; l < s.length; l++) {
				bs = bs + s[l] + ";";
			}
			
			
			try(FileOutputStream fos=new FileOutputStream(userDirectory + "/data/disk.txt"))
	        {
	            // перевод строки в байты
	            byte[] buffer = bs.getBytes();
	              
	            fos.write(buffer, 0, buffer.length);
	        }
	        catch(IOException ex){
	              
	            System.out.println(ex.getMessage());
	        }
			
			
		}
}
