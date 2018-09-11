package pMain.MainView;

import java.io.IOException;

import javafx.fxml.FXML;
import pMain.Main;

public class MainViewControl {

	Main main = new Main();
	
	@FXML
	private void goPokedex() throws IOException{
		main.showPokedexView();
	}
	
	@FXML
	private void goCustoms() throws IOException{
		main.showCustomsView();
	}
	
}
