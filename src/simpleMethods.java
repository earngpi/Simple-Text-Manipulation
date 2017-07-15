//import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Platform;
import javafx.scene.image.Image;

public class simpleMethods {
	
	public String reverseString(String x){
		String output = "";
		for(int i=x.length()-1; i>=0; i--){ //create new String starting from last letter of the input String
			output += x.charAt(i); //addition of chars create String
		}
		return output;
	}
	
	
	public Boolean isPalindrome(String x){
		return (x.equalsIgnoreCase(reverseString(x)));
	}
	
	
	public int countVowels(String x){
		int count = 0;
		for(int i=0; i<x.length(); i++){
			char letter = x.charAt(i);
			if("a".equalsIgnoreCase(""+letter) || "e".equalsIgnoreCase(""+letter) 
					|| "i".equalsIgnoreCase(""+letter) || "o".equalsIgnoreCase(""+letter) 
					|| "u".equalsIgnoreCase(""+letter)){
					count++;
			}
		}
		return count;
	}
	
	/*public int countWords(String x){ //word counting manually
		int count = 0;
		for(int i=0; i<x.length()-1; i++){
			char letter = x.charAt(i);
			char next = x.charAt(i+1);
			if(!(" ".equals(""+letter)) 
					&& (" ".equals(""+next) || i+1==x.length()-1)){
				count++;
			}
		}
		return count;
	}*/
	
	/*public int countTokens(String x){ //word counting automatically using tokenizer
		StringTokenizer tokenizer = new StringTokenizer(x);
		return tokenizer.countTokens();
	}*/
	
	public int wordsSplit(String x){ //word counting automatically using split
		return x.split("[ ]").length;
	}
	
	/*public int countSent(String x){ //sentence count manually (*ISSUE WHEN SENTENCES END WITH MULTIPLE DELIMITERS E.G. HI!!!!)
		int count = 0;
		for(int i=0; i<x.length(); i++){
			if(".".equals(""+x.charAt(i)) || 
					"!".equals(""+x.charAt(i)) || "?".equals(""+x.charAt(i))){
				count++;
			}
		}
		return count;
	}*/
	
	public int delimitersSplit(String x){ //sentence count automatically by spliting delimiters
		return x.split("[.!?]+").length;
	}
	

	public Image getImage(String path, double w, double h){
		Image img = null;
		try{
		    img = new Image(new FileInputStream(path), w, h, true, false);
		}catch (FileNotFoundException e){
			System.out.println("pic not found"); 
			Platform.exit();
		}
		return img;
	}
	
	public String readFile(File file){
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;
         
        try {
 
            bufferedReader = new BufferedReader(new FileReader(file));
             
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text);
            }
 
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        } catch (IOException ex) {
            System.out.println("IO error");
        }
        return stringBuffer.toString();
    }
	

}
