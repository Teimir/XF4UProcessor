package emucompile;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		if (args.length!=2) {
			System.out.println("Usage: emucompile <input file(source)> <output file>");
			System.exit(1);
		}
		String code="", compiled="";
		try (BufferedReader in = new BufferedReader(new FileReader(args[0]))) {
			String line;
			while ((line=in.readLine())!=null) {
				code+=line+" ";
			}
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		compiled=code.replaceAll("regwrite", "01").replaceAll("vmload", "0b").replaceAll("regread", "02").replaceAll("add", "03").replaceAll("vmout", "0d 00 00").replaceAll("sub", "04").replaceAll("mul", "05").replaceAll("div", "06").replaceAll("jmp", "07").replaceAll("jfe", "08").replaceAll("loadbios", "09").replaceAll("push", "0f").replaceAll("vmflash", "12 00 00").replaceAll("pop", "10").replaceAll("end", "00 00 00");
		try (BufferedWriter out = new BufferedWriter(new FileWriter(args[1]))) {
			out.write(compiled);
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
