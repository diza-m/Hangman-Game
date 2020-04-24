package assignment10;
import java.util.*;
import java.io.*;


public class assignment10 {
	public final static Integer RAND_MIN=Integer.valueOf(1);	
	public final static Integer RAND_MAX=Integer.valueOf(10);
	public final static int     Guess=10;
	
	public static void main (String [] args) {
		//Scanner fileReader = new Scanner(File); 
		int randLength;
		ArrayList <String> dictionary=new ArrayList<String>();
		
		try(Scanner fileReader = new Scanner(new File("word_list.txt"))){
			while(fileReader.hasNextLine()){
				dictionary.add(fileReader.nextLine());
			}
			//System.out.println("Hi");
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		int bigLength = dictionary.get(0).length();
		for(String s: dictionary) {
			if(s.length() > bigLength) {
				bigLength = s.length();
			}
		}
		
		System.out.println(dictionary);
		int length;
		Random generator=new Random();

			
		length = generator.nextInt(bigLength+1);
		System.out.println("We're playing with words of length: " + length);
		char [] answer=new char [length];
		System.out.println(Arrays.toString(answer));
		ArrayList <String> game=new ArrayList<String>();
		for (int i=0; i<dictionary.size(); i++) {
			if(dictionary.get(i).length()==length) {
				game.add(dictionary.get(i));
			}
		}	
		System.out.println(game);
		
		//non_cheating stuff
		int gameLength = game.size();
		int gameIndex=generator.nextInt(gameLength);
		String realWord = game.get(gameIndex);
		System.out.println(realWord);
		
		char[] realWordArray = realWord.toCharArray();
		for(char c: realWordArray) {
			System.out.println(c);
		}
		System.out.println(realWordArray);
		
		
		
		for(int i=0; i<Guess; i++) {
			Scanner userinput2= new Scanner (System.in);
			System.out.println("Enter a character");
			String s=userinput2.nextLine();
			char c=s.charAt(0);
			int flag=0;
			String value=String.valueOf(c);
			for (int j=0; j<game.size(); j++) {
				if(!game.get(j).contains(value)) {
					flag=1;
				}
			}
			if(flag==1) {
				for (int j=0; j<game.size(); j++) {
					if(game.get(j).contains(value)) {
						game.remove(j);					
					}
				}
			}else {
				Random generates=new Random();
				int r=generates.nextInt(game.size());
				String store=game.get(r);
				ArrayList <Integer> list=new ArrayList<Integer>();
				for(int x=0; x<store.length(); x++) {
					if(store.charAt(x)==c){
						list.add(x);
							
					}
				}
				int count=0;
				for(int m=0; m<list.size(); m++) {
					answer[list.get(m)]=c;
				}
				for(int y=0; y<game.size(); y++) {
					for(int w=0; w<game.get(y).length(); w++) {
						if(game.get(y).charAt(w)==c) {
							count++;
						}
					}
					
					if(count==list.size()) {
						for(int m=0; m<list.size(); m++) {
							if(game.get(y).charAt(list.get(m))==c) {
								continue;
							}else {
								game.remove(y);
							}
						}
					}
					else {
						game.remove(y);
					}
				}
				if(game.size()==1 && game.get(0).equals(new String(answer))){
					System.out.println("user won");
					break;
					
				}
				
			}
		
			
		}
		
	}
	
	

}
	
	
	
	
	
	
