import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class textEditor extends Application {
	simpleMethods call = new simpleMethods();

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		TextField editor = new TextField(); 
		editor.setAlignment(Pos.TOP_LEFT);
		editor.setPrefSize(400, 70);
		editor.setFocusTraversable(false); 
		editor.setPromptText("Enter a phase.."); 
		
		TextField result = new TextField(); 
		result.setAlignment(Pos.TOP_LEFT); 
		result.setPrefSize(400, 70);
		result.setFocusTraversable(false);
		result.setEditable(false);
		
		Button reverseBt = new Button("Reverse String");
		reverseBt.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				result.setText(call.reverseString(editor.getText()));
			}
		});
		
		Button palindromeBt = new Button("Check Palindrome");
		palindromeBt.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				boolean isPalin = call.isPalindrome(editor.getText());
				if(isPalin==true){
					result.setText(editor.getText()+" is a Palindrome");
				}else{
					result.setText(editor.getText()+" is a not Palindrome");
				}
			}
		});
		
		Button vowelBt = new Button("Vowel Count");
		vowelBt.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				result.setText("Vowel Count:  " +call.countVowels(editor.getText()));
			}
		});
		
		Button wordBt = new Button("Word Count");
		wordBt.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				result.setText("Word Count:  " +call.countTokens(editor.getText()));
			}
		});
		
		HBox btList = new HBox(8);
		btList.getChildren().addAll(reverseBt, palindromeBt, vowelBt, wordBt);
		
		VBox tfList = new VBox(8);
		tfList.getChildren().addAll(editor, result, btList);
		
		stage.setScene((new Scene(tfList)));
		stage.setTitle("Text Manipulation Program");
		stage.show();
	}
	
	//public static void main(String[] args) {
     //  Application.launch(args);
    //}

}
