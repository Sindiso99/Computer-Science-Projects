/**
 * Application which implements the Rotation class for a client
 * @author Sindiso
 * @version 1.0
 * 
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.*;
import javafx.scene.control.TextField;

public class RotationWindow extends Application {

	/**
	 * Displays a window with 2 textfields and a button to give output
	 */
	public void start(Stage stage) throws FileNotFoundException, IOException {
		GridPane root = new GridPane();
		root.setVgap(10);
		root.setHgap(10);
		
		Button transform = new Button("Rotate");
		
		Label rotationOutput = new Label(null);
		
		//Labels to give understanding of textfields
		Label stringInfo = new Label("Enter String:");
		Label rotationInfo = new Label("Enter Rotation:");
		//Label to give final output
		Label resultInfo = new Label(null);
		
		TextField textBox = new TextField();
		textBox.setPromptText("Enter String");
		
		//numBox works as it should but I believe I could have implemented it better
		TextField numBox = new TextField("0");
		numBox.setPromptText("Enter rotation value");
		
		//Arranging the layout of the stage
		root.setConstraints(resultInfo, 0, 1);
		root.setConstraints(stringInfo, 0, 3);
		root.setConstraints(rotationInfo, 0, 4);
		root.setConstraints(rotationOutput, 1, 1);
		root.setConstraints(textBox, 1, 3);
		root.setConstraints(numBox, 1, 4);
		root.setConstraints(transform, 1, 5);
		
		root.setAlignment(Pos.CENTER);
		root.setHalignment(rotationOutput, HPos.CENTER);
		root.setHalignment(transform, HPos.CENTER);
		
		transform.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			/**
			 * Runs Rotation and outputs the result using the information from the textfields
			 */
			public void handle(ActionEvent event) {
				Integer rotationValue = Integer.parseInt(numBox.getText());
				Rotation newRotation = new Rotation(textBox.getText(), rotationValue);
				rotationOutput.setText(newRotation.getNewWord());
				resultInfo.setText("Result:");
			}
		});

		root.getChildren().addAll(rotationOutput, transform, textBox, numBox, stringInfo, rotationInfo, resultInfo);
		Scene scene = new Scene(root, 800, 400);
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Veeqo String Manipulator");
	}

	public static void main(String[] args) {
		launch();
	}

}
