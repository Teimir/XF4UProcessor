package emuprocJava;
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import java.io.IOException;
import java.net.URISyntaxException;



public class Main {

		
		public static String ver = "0.0.3 " + " - Первопроходец(Pathfinder)";
		public static String cr = "ЭмуПроц был сделан Ether Studio.";
		public static String name = "Эмулятор Процессора (ЭмуПроц)";
		public static String[] ram = new String[255];
		public static boolean debug = false;
	
	public static void main(String[] args) {
		//тех часть
		Scanner in = new Scanner(System.in);
		
		//Ввод данных
		System.out.println(name + System.lineSeparator() + ver + System.lineSeparator() + cr );
		System.out.println("Включить вывод дебага?");
		String inp = in.nextLine();
		if(inp == "y" || inp == "yes" || inp == "да" || inp == "д") {
			debug = true;
		}
		in.close();
		
		//Загрузка систем
		
		try {
			
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Проверка системы, файлов (должен быть вывод 03, 02 после запуска ядра)");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Запуск ядра");
		
		try {
			core();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//Главный модуль
	
	public static void core() throws URISyntaxException {
		//Объявление переменных
		String[] rom = new String[255];
		String[] reg = new String[10];
		String[] stack = new String[50];
		int sp = 0;
		
		//Инициализация
		rom[0] = "01";
		rom[1] = "01";
		rom[2] = "03";
		rom[3] = "02";
		rom[4] = "01";
		rom[5] = "00";
		rom[6] = "01";
		rom[7] = "01";
		rom[8] = "02";
		rom[9] = "02";
		rom[10] = "01";
		rom[11] = "00";
		rom[12] = "09";
		rom[13] = "00";
		rom[14] = "00";
		
		ram = rom.clone();
		
		for(int i1 = 0; i1 < reg.length; i1++) {
			reg[i1] = "00";
		}
		
		
		//Главный цикл!
		
		for(int i = 0; i < ram.length - 3;) {
			
			
			//Вывод дебага
			if(debug == true) {
			System.out.println(ram[i] + "|" + ram[i + 1] + "|" + ram[i + 2]);
			for(int i1 = 0; i1 < reg.length; i1++) {
				System.out.print(reg[i1] + "|");
			}
			System.out.println();
			}
			
			switch(ram[i]) {
			case"00":
				break;
			case"01":
				reg[estrn(ram [i + 1])] = ram[i + 2];
				break;
			case"02":
				System.out.println(reg[estrn(ram [i + 1])]);
				break;
			case"03":
				reg[estrn(ram [i + 2])] = dth(htd(reg[estrn(ram [i + 1])]) + htd(reg[estrn(ram [i + 2])]));
				break;
			case"04":
				reg[estrn(ram [i + 2])] = dth(htd(reg[estrn(ram [i + 1])]) - htd(reg[estrn(ram [i + 2])]));
				break;
			case"05":
				reg[estrn(ram [i + 2])] = dth(htd(reg[estrn(ram [i + 1])]) * htd(reg[estrn(ram [i + 2])]));
				break;
			case"06":
				reg[estrn(ram [i + 2])] = dth(htd(reg[estrn(ram [i + 1])]) / htd(reg[estrn(ram [i + 2])]));
				break;
			case"07":
				i = htd(reg[estrn(ram [i + 2])]) - 3;
				break;
			case"08":
				if(reg[estrn(ram [i + 1])] == "ff") {
					i = htd(reg[estrn(ram [i + 2])]) - 3;
				}
				break;
			case"09":
				i = -3;
				lp();
				break;
			case"0a":
				reg[estrn(ram [i + 2])] = data.dataread(ram [i + 1]);
				break;
			case"0b":
				inout.tov(reg[estrn(ram [i + 1])]);
				break;
			case"0c":
				reg[estrn(ram [i + 1])] = inout.inp();
				break;
			case"0d":
				inout.load();
				break;
			case"0e":
				data.datawr(ram[i + 1], ram[i + 2]);
				break;
			case"0f":
				stack[sp] = ram[i + 1];
				sp++;
				break;
			case"10":
				reg[estrn(ram [i + 1])] = stack[sp];
				sp--;
				break;
			case"11":
				if(reg[estrn(ram [i + 1])] == reg[estrn(ram [i + 2])])
				{
					reg[estrn(ram [i + 2])] = "ff";
				}
				break;
			case"12":
				inout.cl();
				break; 
				
				
			}
			try {
			if(ram[i+3] == null){
				break;
			}
			else{
				i = i + 3;
				}
			}
			finally{
			}
			
			//Замедляемся до 2герц (нада)
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		
		
		
	}
	
	
	//получение номера регистра
	public static int estrn(String a) {
		int res = 0;
		String b = a.substring(1);
		res = Integer.parseInt(b);
		return res; 
	}
	
	//шестнадцатиричное число в десятичную си
	public static int htd(String a) {
		int res = 0, an = 0,bn = 0;
		String b =  a.substring(1);
		if(a != "a" || a != "b"|| a != "c" || a != "d"|| a != "e" || a != "f" ) {
			an = Integer.parseInt(a);
		}
		else {
			switch(a) {
			case"a":
				an = 10;
				break;
			case"b":
				an = 11;
				break;
			case"c":
				an = 12;
				break;
			case"d":
				an = 13;
				break;
			case"e":
				an = 14;
				break;
			case"f":
				an = 15;
				break;
			}
		}
		if(b != "a" || b != "b"|| b != "c" || b != "d"|| b != "e" || b != "f" ) {
			bn = Integer.parseInt(b);
		}
		else {
			switch(a) {
			case"a":
				bn = 10;
				break;
			case"b":
				bn = 11;
				break;
			case"c":
				bn = 12;
				break;
			case"d":
				bn = 13;
				break;
			case"e":
				bn = 14;
				break;
			case"f":
				bn = 15;
				break;
			}
		}
		res = an * 16 + bn;
		return res; 
	}
	
	//десят в шестн
	public static String dth (int a) {
		String res;
		res = Integer.toHexString(a);
		if (res.length() < 2) {
			String.join("0", res);
		}
		return res;
	}
	
	//Загрузка биоса
	public static void lp() throws URISyntaxException {
		String a = "";
		String userDirectory = Paths.get("").toAbsolutePath().toString();
		 try(FileInputStream fin=new FileInputStream(userDirectory + "/cod.txt"))
	        {
	            
	              
	            int i=-1;
	            while((i=fin.read())!=-1){
	              
	                a = a + (char)i;
	            }   
	        }
	        catch(IOException ex) {
	        } 
		 String[] b = a.split(" ");
		 if(b.length <= ram.length) {
		 ram = b.clone();
		 }
		 else {
			 System.out.println("Error");
		 }
	}
	

}
