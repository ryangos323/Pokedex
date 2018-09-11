package pMain.PokedexView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pMain.Main;

public class PokedexViewControl {

	Main main = new Main();
	
	ObservableList<String> sortList = FXCollections.observableArrayList
			("None", "Gender - Both", "Gender - Male", "Gender - Female", "Gender - Unknown", "Type - Fire",
			"Type - Water", "Type - Grass", "Type - Rock", "Type - Bug", "Type - Flying", 
			"Type - Normal", "Type - Poison", "Type - Electric", "Type - Ground", "Type - Fairy",
			"Type - Fighting", "Type - Psychic", "Type - Steel", "Type - Ghost", "Weakness - Fire",
			"Type - Dark",  "Type - Dragon", "Type - Ice", "Weakness - Water", "Weakness - Bug",
			"Weakness - Flying", "Weakness - Normal", "Weakness - Grass", "Weakness - Rock",
			"Weakness - Poison", "Weakness - Electric", "Weakness - Ground", "Weakness - Fairy",
			"Weakness - Fighting", "Weakness - Psychic", "Weakness - Steel", "Weakness - Ghost", 
			"Weakness - Dark", "Weakness - Dragon", "Weakness - Ice");
	
	@FXML
	private ComboBox<String> sort;
	
	@FXML
	private TextArea text;
	
	@FXML
	private TextField gender;
	
	@FXML
	private TextField weight;
	
	@FXML
	private TextField height;
	
	@FXML
	private TextField type;
	
	@FXML
	private TextField weakness;
	
	@FXML
	private TextField hp;
	
	@FXML
	private TextField attack;
	
	@FXML
	private TextField id;
	
	@FXML
	private TextField defense;
	
	@FXML
	private TextField speed;
	
	@FXML
	public void initialize(){
		sort.setValue("None");
		sort.setItems(sortList);
		
		getConnection();
	}
	
	String connect = "jdbc:mysql://localhost:3306/pokemon?autoReconnect=true&useSSL=false";
	String username = "root";
	String password = "password";
	
	public void getInfo(){
		String id_number;
		id_number = id.getText();
		try{
			Connection con = DriverManager.getConnection(connect, username, password);
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("select * from pokemon where p_id = " + id_number);
			while(res.next()){
					gender.setText(res.getString("p_gender"));
					weight.setText(res.getString("p_wieght"));
					String height_format = (res.getString("p_height_ft") + "' " + res.getString("p_height_in") + "''");
					height.setText(height_format);
					type.setText(res.getString("p_type"));
					weakness.setText(res.getString("p_weakness"));
					hp.setText(res.getString("p_hp"));
					speed.setText(res.getString("p_speed"));
					defense.setText(res.getString("p_defense"));
					attack.setText(res.getString("p_attack"));
			}
			}catch(Exception exo){
				text.setText("Error: Please enter a valid ID number");
				System.out.println(exo.getMessage());
				id.setText("");
			}
	}
	
	public void getConnection(){
		String out = "";
		if (sort.getValue() == "None"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Gender - Both"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_gender = 'Both'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Gender - Male"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_gender = 'Male'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Gender - Female"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_gender = 'Female'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Gender - Unknown"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_gender = 'Unknown'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Fire"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_type = 'Fire'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Water"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_type = 'Water'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Grass"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_type = 'Grass'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Rock"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_type = 'Rock'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Bug"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_type = 'Bug'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Flying"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_type = 'Flying'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Normal"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_type = 'Normal'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Poison"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_type = 'Poison'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Electric"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_type = 'Electric'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Ground"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_type = 'Ground'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Fairy"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_type = 'Fairy'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Fighting"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_type = 'Fighting'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Psychic"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_type = 'Psychic'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Steel"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_type = 'Steel'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Ghost"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_type = 'Ghost'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Dark"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_type = 'Dark'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Dragon"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_type = 'Dragon'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Ice"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_type = 'Ice'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Fire"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_weakness = 'Fire'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Water"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_weakness = 'Water'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Grass"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_weakness = 'Grass'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Rock"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_weakness = 'Rock'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Bug"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_weakness = 'Bug'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Flying"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_weakness = 'Flying'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Normal"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_weakness = 'Normal'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Poison"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_weakness = 'Poison'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Electric"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_weakness = 'Electric'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Ground"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_weakness = 'Ground'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Fairy"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_weakness = 'Fairy'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}else if(sort.getValue() == "Weakness - Fighting"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_weakness = 'Fighting'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}else if(sort.getValue() == "Weakness - Psychic"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_weakness = 'Psychic'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Steel"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_weakness = 'Steel'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Dark"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_weakness = 'Dark'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Ghost"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_weakness = 'Ghost'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Dragon"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_weakness = 'Dragon'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Ice"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from pokemon where p_weakness = 'Ice'");
				while(res.next()){
					out = out + (res.getString("p_id") + "\t  " + res.getString("p_index") + "\t\t" + res.getString("p_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		text.setText(out);
		text.setText(out);
		gender.setText("");
		type.setText("");
		id.setText("");
		hp.setText("");
		speed.setText("");
		defense.setText("");
		attack.setText("");
		weakness.setText("");
		height.setText("");
		weight.setText("");
	}
}
