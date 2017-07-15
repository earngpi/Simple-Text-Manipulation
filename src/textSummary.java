import javafx.application.Application;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import java.io.File;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;

public class textSummary extends Application {
	simpleMethods call = new simpleMethods();

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		TextArea input = new TextArea(); 
		input.setFocusTraversable(false);
		input.setPrefSize(500, 300);
		input.setWrapText(true);
		input.setPromptText("Enter text....");
		
		HBox wordHb = new HBox(4);
		Label wordLb = new Label("  Word Count: ");
		TextField wordTf = editTf();
		wordHb.getChildren().addAll(wordLb, wordTf);
		
		HBox vowelHb = new HBox(4);
		Label vowelLb = new Label("  Vowel Count: ");
		TextField vowelTf = editTf();
		vowelHb.getChildren().addAll(vowelLb, vowelTf);
		
		HBox sentHb = new HBox(4);
		Label sentLb = new Label("  Sentence Count: ");
		TextField sentTf = editTf();
		sentHb.getChildren().addAll(sentLb, sentTf);
		
		VBox result = new VBox(10);
		result.getChildren().addAll(wordHb, vowelHb, sentHb);
		
		Button browse = new Button("Open File ");
		browse.setPrefSize(80, 15);
		ImageView pic = new ImageView(call.getImage("textclipart.png", 45, 45));
		VBox Vbrowse = new VBox(5); Vbrowse.setAlignment(Pos.CENTER);
		Vbrowse.getChildren().addAll(browse, pic);
		
		HBox bottom = new HBox(240);
		bottom.getChildren().addAll(result, Vbrowse);
		bottom.setPadding(new Insets(6, 0, 0, 0));
		
		BorderPane frame = new BorderPane();
		frame.setPrefSize(500, 380);
		frame.setCenter(input);
		frame.setBottom(bottom);
		frame.setPadding(new Insets(0, 0, 5, 0));
		
		input.textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable,
					String oldText, String newText){
				wordTf.setText(""+call.countTokens(newText));
				vowelTf.setText(""+call.countVowels(newText));
				sentTf.setText(""+call.delimitersSplit(newText));
			}
		});
		
		browse.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				Stage fileWd = new Stage();
				FileChooser fileChooser = new FileChooser();
				fileChooser.getExtensionFilters().addAll(
						new ExtensionFilter("Text Files", "*.txt"));
				File selectedFile = fileChooser.showOpenDialog(fileWd);
				if (selectedFile != null) {
				    input.setText(call.readFile(selectedFile));
				}

			}
		});

		stage.setScene((new Scene(frame)));
		stage.setTitle("Text Summary");
		stage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}
	
	public static TextField editTf(){
		TextField x = new TextField();
		x.setEditable(false);
		x.setFocusTraversable(false);
		x.setMaxSize(50, 20);
		x.setMinSize(35, 20);
		x.setPrefSize(55, 20);
		return x;
	}

}
