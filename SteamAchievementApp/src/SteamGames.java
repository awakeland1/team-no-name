import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.ArrayList;

public class SteamGames extends Application {

	@Override
	public void start(Stage mainStage) throws Exception {
		// TODO Auto-generated method stub
		
		//Button for searching steam games
		Button searchButton = new Button("Search games");
		
		//Textfield to get game user is searching for
		TextField gameSearchTextField = new TextField();
		gameSearchTextField.setPromptText("Enter a game to search for here...");
		gameSearchTextField.setPrefWidth(300);
		
		//Labels
		Label applicationNameLabel = new Label("Steam game search");
		
		//hboxes for horizontal placement
		HBox applicationNameHBox = new HBox(applicationNameLabel);
		applicationNameHBox.setAlignment(Pos.CENTER);
		HBox searchGamesHBox = new HBox(10, gameSearchTextField, searchButton);
		
		//vboxes for vertical placement.
		//Build an HBox before this to place similar objects on the same horizontal plane
		VBox mainVBox = new VBox(10, applicationNameHBox,searchGamesHBox);
		
		//Adding top nested object container
		//Currently this is mainVBox. This will be final unless we need to add GridPane.
		Scene scene = new Scene(mainVBox);
		
		mainStage.setScene(scene);
		mainStage.show();
		
	}
	
	public ArrayList<Response> OkHttp() throws IOException {
		
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		Request request = new Request.Builder()
				  .url("http://api.steampowered.com/isteamapps/getapplist/v0002?format=XML")
				  .method("GET", null)
				  .build();
		Response response = client.newCall(request).execute();
		ArrayList<Response> apiResponse = new ArrayList<Response>();
		apiResponse.add(response);
		return apiResponse;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
