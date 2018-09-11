package pMain;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage pStage;
	private static BorderPane MainView;
	
	@Override
	public void start(Stage pStage) throws IOException {
		this.pStage = pStage;
		this.pStage.setTitle("PokeDextrous");
		showMainView();
		playSound();
	}
	
	public void playSound() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:/Users/Michael/Desktop/Poke/music.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception exo) {
	        System.out.println("Error: Could not find file");
	    }
	}

	public void showMainView() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("MainView/MainView.fxml"));
		MainView = loader.load();
		Scene scene = new Scene(MainView);
		pStage.setScene(scene);
		pStage.show();
	}
	
	public void showPokedexView() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("PokedexView/PokedexView.fxml"));
		BorderPane PokedexView = loader.load();
		
		Stage pvStage = new Stage();
		pvStage.setTitle("Pokedex");
		pvStage.initModality(Modality.WINDOW_MODAL);
		pvStage.initOwner(pStage);
		Scene scene = new Scene(PokedexView);
		pvStage.setScene(scene);
		pvStage.showAndWait();
	}
	
	public void showCustomsView() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("CustomsView/CustomsView.fxml"));
		BorderPane CustomsView = loader.load();
		
		Stage cvStage = new Stage();
		cvStage.setTitle("Customs");
		cvStage.initModality(Modality.WINDOW_MODAL);
		cvStage.initOwner(pStage);
		Scene scene = new Scene(CustomsView);
		cvStage.setScene(scene);
		cvStage.showAndWait();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
