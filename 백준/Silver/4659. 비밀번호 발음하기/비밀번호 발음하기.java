import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = br.readLine();
			if(input.equals("end")) break;
			
			if(validPassword(input)) {
				sb.append("<"+input+">"+" is acceptable.\n");
			}
			else {
				sb.append("<"+input+">"+" is not acceptable.\n");
			}
			
			
		}
		System.out.println(sb.toString());
	}
	
	
	static boolean validPassword(String password) {
		boolean aeiou = false;
		if(password.contains("a") || password.contains("e") || password.contains("i") ||password.contains("o") ||
		password.contains("u")) {
			aeiou = true;
		}
		if(!aeiou) {
			return false;
		}
		
		
		for(int i=0; i<password.length()-2; i++) {
			String data = password.substring(i,i+3);
			int count1 = 0;
			int count2 = 0;

			for(int j=0; j<data.length(); j++) {
				if(data.charAt(j) == 'a' || data.charAt(j) == 'e' ||
						data.charAt(j) == 'i' ||
						data.charAt(j) == 'o' ||
						data.charAt(j) == 'u' ) {
					count1++;
				}
				else {
					count2++;
				}
			}
			if(count1 > 2 || count2 > 2) {
				return false;
			}
		}
		
		for(int i=0; i<password.length()-1; i++) {
			if(password.charAt(i) != 'e' && password.charAt(i) != 'o') {
				if(password.charAt(i) == password.charAt(i+1)) {
					return false;
				}
			}
		}
		
		
		
		return true;
	}

}
