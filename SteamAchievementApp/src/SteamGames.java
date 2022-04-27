import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class SteamGames extends Application {
	private String textToSearch;
	@Override
	public void start(Stage mainStage) throws Exception {
		// TODO Auto-generated method stub
		
		//Textfield to get game user is searching for
		TextField gameSearchTextField = new TextField();
		gameSearchTextField.setPromptText("Enter a game to search for here...");
		gameSearchTextField.setPrefWidth(300);
		
		//Labels
		Label applicationNameLabel = new Label("Steam game search");
		Label gameSearchResultLabel = new Label("");
		
		//Button for searching steam games
		Button searchButton = new Button("Search games");
		searchButton.setOnAction(event -> {
			gameSearchResultLabel.setText(String.format(gameSearchTextField.getText()));
		});
				
		//hboxes for horizontal placement
		HBox applicationNameHBox = new HBox(applicationNameLabel);
		applicationNameHBox.setAlignment(Pos.CENTER);
		HBox searchGamesHBox = new HBox(10, gameSearchTextField, searchButton);
		HBox searchGamesResultHBox = new HBox(10, gameSearchResultLabel);
		
		//vboxes for vertical placement.
		//Build an HBox before this to place similar objects on the same horizontal plane
		VBox mainVBox = new VBox(10, applicationNameHBox,searchGamesHBox,searchGamesResultHBox);
		
		//Adding top nested object container
		//Currently this is mainVBox. This will be final unless we need to add GridPane.
		Scene scene = new Scene(mainVBox);
		
		mainStage.setScene(scene);
		mainStage.show();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
