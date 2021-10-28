package emuprocJava;

import java.util.Scanner;

public class inout {
		public static String[] outk = new String[255];
		public static int kp;
		
		public static void tov(String a) {
			if(kp < outk.length) {
				outk[kp] = a;
				kp++;
			}
			else {
				if(Main.debug == true)
				{
					System.out.println("error");
				}
			}
			
		}
		
		public static void load() {
			String out = ""; 
			for(int i = 0; i < outk.length; i++) {
				if(outk[i] != null) {
				out = out + outp(outk[i]);
				}
			}
			System.out.println(out);
		}
		
		public static void cl() {
			for(int i = 0; i < outk.length; i++) {
				outk[i] = "";
			}
		}
		
	
	
		public static String outp(String a) {
			String res = "";
			switch(a) {
			case"00":
			res = "0";
			break;
			case"01":
			res = "1";
			break;
			case"02":
				res = "2";
				break;
			case"03":
				res = "3";
				break;
			case"04":
				res = "4";
				break;
			case"05":
				res = "5";
				break;
			case"06":
				res = "6";
				break;
			case"07":
				res = "7";
				break;
			case"08":
				res = "8";
				break;
			case"09":
				res = "9";
				break;
			case"0a":
				res = " ";
				break;
			case"0b":
				res = "а";
				break;
			case"0c":
				res = "б";
				break;
			case"0d":
				res = "в";
				break;
			case"0e":
				res = "г";
				break;
			case"0f":
				res = "д";
				break;
			case"10":
				res = "е";
				break;
			case"11":
				res = "ё";
				break;
			case"12":
				res = "ж";
				break;
			case"13":
				res = "з";
				break;
			case"14":
				res = "и";
				break;
			case"15":
				res = "й";
				break;
			case"16":
				res = "к";
				break;
			case"17":
				res = "л";
				break;
			case"18":
				res = "м";
				break;
			case"19":
				res = "н";
				break;
			case"1a":
				res = "о";
				break;
			case"1b":
				res = "п";
				break;
			case"1c":
				res = "р";
				break;
			case"1d":
				res = "с";
				break;
			case"1e":
				res = "т";
				break;
			case"1f":
				res = "у";
				break;
			case"20":
				res = "ф";
				break;
			case"21":
				res = "х";
				break;
			case"22":
				res = "ц";
				break;
			case"23":
				res = "ч";
				break;
			case"24":
				res = "ш";
				break;
			case"25":
				res = "щ";
				break;
			case"26":
				res = "ъ";
				break;
			case"27":
				res = "ы";
				break;
			case"28":
				res = "ь";
				break;
			case"29":
				res = "э";
				break;
			case"2a":
				res = "ю";
				break;
			case"2b":
				res = "я";
				break;
			case"2e":
				res = " ";
				break;
			case"2f":
				res = "!";
				break;
			case"30":
				res = "?";
				break;
			}
			return res;
			
		}

	public static String inp() {
			String resu = "";
			String a = "";
			Scanner in = new Scanner(System.in);
			a = in.nextLine();
			in.close();
			switch(a) {
			case"0":
			resu ="00";
			break;
			case"1":
			resu ="01";
			break;
			case"2":
				resu ="02";
				break;
			case"3":
				resu ="03";
				break;
			case"4":
				resu ="04";
				break;
			case"5":
				resu ="05";
				break;
			case"6":
				resu ="06";
				break;
			case"7":
				resu ="07";
				break;
			case"8":
				resu ="08";
				break;
			case"9":
				resu ="09";
				break;
			case" ":
				resu ="0a";
				break;
			case"а":
				resu ="0b";
				break;
			case"б":
				resu ="0c";
				break;
			case"в":
				resu ="0d";
				break;
			case"г":
				resu ="0e";
				break;
			case"д":
				resu ="0f";
				break;
			case"е":
				resu ="10";
				break;
			case"ё":
				resu ="11";
				break;
			case"ж":
				resu ="12";
				break;
			case"з":
				resu ="13";
				break;
			case"и":
				resu ="14";
				break;
			case"й":
				resu ="15";
				break;
			case"к":
				resu ="16";
				break;
			case"л":
				resu ="17";
				break;
			case"м":
				resu ="18";
				break;
			case"н":
				resu ="19";
				break;
			case"о":
				resu ="1a";
				break;
			case"п":
				resu ="1b";
				break;
			case"р":
				resu ="1c";
				break;
			case"с":
				resu ="1d";
				break;
			case"т":
				resu ="1e";
				break;
			case"у":
				resu ="1f";
				break;
			case"ф":
				resu ="20";
				break;
			case"х":
				resu ="21";
				break;
			case"ц":
				resu ="22";
				break;
			case"ч":
				resu ="23";
				break;
			case"ш":
				resu ="24";
				break;
			case"щ":
				resu ="25";
				break;
			case"ъ":
				resu ="26";
				break;
			case"ы":
				resu ="27";
				break;
			case"ь":
				resu ="28";
				break;
			case"э":
				resu ="29";
				break;
			case"ю":
				resu ="2a";
				break;
			case"я":
				resu ="2b";
				break;
			case"":
				resu ="2e";
				break;
			case"!":
				resu ="2f";
				break;
			case"?":
				resu ="30";
				break;
			}
			return resu;
			
		
	}
	
}
