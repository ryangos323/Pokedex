package pMain.CustomsView;

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

public class CustomViewControl {

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
	
	ObservableList<Integer> height_ft_List = FXCollections.observableArrayList
			(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,
			28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,
			53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,
			79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,
			104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,
			124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,
			144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,
			164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,
			184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,
			204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,
			224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,
			244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,263,
			264,265,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,281,282,283,
			284,285,286,287,288,289,290,291,292,293,294,295,296,297,298,299,300,301,302,303,
			304,305,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,321,322,323,
			324,325,326,327,328,329,330,331,332,333,334,335,336,337,338,339,340,341,342,343,
			344,345,346,347,348,349,350,351,352,353,354,355,356,357,358,359,360,361,362,363,
			364,365,366,367,368,369,370,371,372,373,374,375,376,377,378,379,380,381,382,383,
			384,385,386,387,388,389,390,391,392,393,394,395,396,397,398,399,400,401,402,403,
			404,405,406,407,408,409,410,411,412,413,414,415,416,417,418,419,420,421,422,423,
			424,425,426,427,428,429,430,431,432,433,434,435,436,437,438,439,440,441,442,443,
			444,445,446,447,448,449,450,451,452,453,454,455,456,457,458,459,460,461,462,463,
			464,465,466,467,468,469,470,471,472,473,474,475,476,477,478,479,480,481,482,483,
			484,485,486,487,488,489,490,491,492,493,494,495,496,497,498,499,500,501,502,503,
			504,505,506,507,508,509,510,511,512,513,514,515,516,517,518,519,520,521,522,523,
			524,525,526,527,528,529,530,531,532,533,534,535,536,537,538,539,540,541,542,543,
			544,545,546,547,548,549,550,551,552,553,554,555,556,557,558,559,560,561,562,563,
			564,565,566,567,568,569,570,571,572,573,574,575,576,577,578,579,580,581,582,583,
			584,585,586,587,588,589,590,591,592,593,594,595,596,597,598,599,600,601,602,603,
			604,605,606,607,608,609,610,611,612,613,614,615,616,617,618,619,620,621,622,623,
			624,625,626,627,628,629,630,631,632,633,634,635,636,637,638,639,640,641,642,643,
			644,645,646,647,648,649,650,651,652,653,654,655,656,657,658,659,660,661,662,663,
			664,665,666,667,668,669,670,671,672,673,674,675,676,677,678,679,680,681,682,683,
			684,685,686,687,688,689,690,691,692,693,694,695,696,697,698,699,700,701,702,703,
			704,705,706,707,708,709,710,711,712,713,714,715,716,717,718,719,720,721,722,723,
			724,725,726,727,728,729,730,731,732,733,734,735,736,737,738,739,740,741,742,743,
			744,745,746,747,748,749,750,751,752,753,754,755,756,757,758,759,760,761,762,763,
			764,765,766,767,768,769,770,771,772,773,774,775,776,777,778,779,780,781,782,783,
			784,785,786,787,788,789,790,791,792,793,794,795,796,797,798,799,800,801,802,803,
			804,805,806,807,808,809,810,811,812,813,814,815,816,817,818,819,820,821,822,823,
			824,825,826,827,828,829,830,831,832,833,834,835,836,837,838,839,840,841,842,843,
			844,845,846,847,848,849,850,851,852,853,854,855,856,857,858,859,860,861,862,863,
			864,865,866,867,868,869,870,871,872,873,874,875,876,877,878,879,880,881,882,883,
			884,885,886,887,888,889,890,891,892,893,894,895,896,897,898,899,900,901,902,903,
			904,905,906,907,908,909,910,911,912,913,914,915,916,917,918,919,920,921,922,923,
			924,925,926,927,928,929,930,931,932,933,934,935,936,937,938,939,940,941,942,943,
			944,945,946,947,948,949,950,951,952,953,954,955,956,957,958,959,960,961,962,963,
			964,965,966,967,968,969,970,971,972,973,974,975,976,977,978,979,980,981,982,983,
			984,985,986,987,988,989,990,991,992,993,994,995,996,997,998,999);
	
	
	ObservableList<Integer> height_in_List = FXCollections.observableArrayList
			(0,1,2,3,4,5,6,7,8,9,10,11);
	
	ObservableList<String> genderList = FXCollections.observableArrayList
			("Male", "Female", "Both", "Unknown");
	
	ObservableList<String> type_and_weakness_List = FXCollections.observableArrayList
			("Fire", "Water", "Grass", "Rock", "Bug", "Flying", "Normal", "Poison", "Electric",
			"Ground", "Fairy", "Fighting", "Psychic", "Steel", "Ghost", "Dark", "Dragon", "Ice");
	
	ObservableList<Integer> hpList = FXCollections.observableArrayList
			(1,2,3,4,5,6,7,8,9,10);
	
	ObservableList<Integer> speedList = FXCollections.observableArrayList
			(1,2,3,4,5,6,7,8,9,10);
	
	ObservableList<Integer> defenseList = FXCollections.observableArrayList
			(1,2,3,4,5,6,7,8,9,10);
	
	ObservableList<Integer> attackList = FXCollections.observableArrayList
			(1,2,3,4,5,6,7,8,9,10);
	
	@FXML
	private ComboBox<String> sort;
	
	@FXML
	private ComboBox<Integer> c_height_ft;
	
	@FXML
	private ComboBox<Integer> c_height_in;
	
	@FXML
	private ComboBox<String> c_gender;
	
	@FXML
	private ComboBox<String> c_type;
	
	@FXML
	private ComboBox<String> c_weakness;
	
	@FXML
	private ComboBox<Integer> c_hp;
	
	@FXML
	private ComboBox<Integer> c_attack;
	
	@FXML
	private ComboBox<Integer> c_speed;
	
	@FXML
	private ComboBox<Integer> c_defense;
	
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
	private TextField c_name;
	
	@FXML
	private TextField c_weight;
	
	@FXML
	public void initialize(){
		c_height_ft.setValue(0);
		c_height_ft.setItems(height_ft_List);
		c_height_in.setValue(0);
		c_height_in.setItems(height_in_List);
		c_hp.setValue(0);
		c_hp.setItems(hpList);
		c_attack.setValue(0);
		c_attack.setItems(attackList);
		c_speed.setValue(0);
		c_speed.setItems(speedList);
		c_defense.setValue(0);
		c_defense.setItems(defenseList);
		c_gender.setItems(genderList);
		c_type.setItems(type_and_weakness_List);
		c_weakness.setItems(type_and_weakness_List);
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
			ResultSet res = st.executeQuery("select * from custom_pokemon where cp_id = " + id_number);
			while(res.next()){
					gender.setText(res.getString("cp_gender"));
					weight.setText(res.getString("cp_wieght"));
					String height_format = (res.getString("cp_height_ft") + "' " + res.getString("cp_height_in") + "''");
					height.setText(height_format);
					type.setText(res.getString("cp_type"));
					weakness.setText(res.getString("cp_weakness"));
					hp.setText(res.getString("cp_hp"));
					speed.setText(res.getString("cp_speed"));
					defense.setText(res.getString("cp_defense"));
					attack.setText(res.getString("cp_attack"));
			}
			}catch(Exception exo){
				text.setText("Error: Please enter a valid ID number");
				System.out.println(exo.getMessage());
				id.setText("");
			}
	}
	
	public void create(){
		if(c_gender.getValue() == null || c_type.getValue() == null || c_weakness.getValue() == null || c_name.getText().equals("")){
			text.setText("Error: Please make sure all\nfields are selected when creating");
		}
		else{
			try{
			Connection con = DriverManager.getConnection(connect, username, password);
			Statement st = con.createStatement();
			st.executeUpdate("INSERT INTO custom_pokemon VALUES (default," + "'" + c_name.getText() + "'" + "," + c_weight.getText() + "," + c_height_ft.getValue() + "," + c_height_in.getValue() + "," +
					"'" + c_gender.getValue() + "'" + "," + "'" + c_type.getValue() + "'" + "," + "'" + c_weakness.getValue() + "'" + "," + c_hp.getValue() + "," + c_attack.getValue() + ","
					+ c_defense.getValue() + "," + c_speed.getValue() + ")");
			getConnection();
			}catch(Exception exo){
				System.out.println(exo.getMessage());
				text.setText("Error: Please enter a valid weight");
			}
		}	
		c_height_ft.setValue(0);
		c_height_in.setValue(0);
		c_hp.setValue(0);
		c_attack.setValue(0);
		c_speed.setValue(0);
		c_defense.setValue(0);
		c_name.setText("");
		c_weight.setText("");
		c_gender.setValue(null);
		c_type.setValue(null);
		c_weakness.setValue(null);
	}
	
	public void delete(){
		try{
		Connection con = DriverManager.getConnection(connect, username, password);
		Statement st = con.createStatement();
		st.executeUpdate("delete from custom_pokemon where cp_id = " + id.getText());	
		}catch(Exception exo){
			System.out.println(exo.getMessage());
		}
		id.setText("");
		getConnection();
	}
	
	public void getConnection(){
		String out = "";
		if (sort.getValue() == "None"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Gender - Both"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_gender = 'Both'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Gender - Male"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_gender = 'Male'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Gender - Female"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_gender = 'Female'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Gender - Unknown"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_gender = 'Unknown'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Fire"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_type = 'Fire'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Water"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_type = 'Water'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Grass"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_type = 'Grass'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Rock"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_type = 'Rock'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Bug"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_type = 'Bug'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Flying"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_type = 'Flying'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");	
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Normal"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_type = 'Normal'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Poison"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_type = 'Poison'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Electric"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_type = 'Electric'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Ground"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_type = 'Ground'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Fairy"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_type = 'Fairy'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Fighting"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_type = 'Fighting'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Psychic"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_type = 'Psychic'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Steel"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_type = 'Steel'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Ghost"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_type = 'Ghost'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Dark"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_type = 'Dark'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Dragon"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_type = 'Dragon'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Type - Ice"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_type = 'Ice'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Fire"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_weakness = 'Fire'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Water"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_weakness = 'Water'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Grass"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_weakness = 'Grass'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Rock"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_weakness = 'Rock'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Bug"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_weakness = 'Bug'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Flying"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_weakness = 'Flying'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Normal"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_weakness = 'Normal'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Poison"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_weakness = 'Poison'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Electric"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_weakness = 'Electric'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Ground"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_weakness = 'Ground'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Fairy"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_weakness = 'Fairy'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}else if(sort.getValue() == "Weakness - Fighting"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_weakness = 'Fighting'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}else if(sort.getValue() == "Weakness - Psychic"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_weakness = 'Psychic'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Steel"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_weakness = 'Steel'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Dark"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_weakness = 'Dark'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Ghost"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_weakness = 'Ghost'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Dragon"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_weakness = 'Dragon'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
		else if(sort.getValue() == "Weakness - Ice"){
			try{
				Connection con = DriverManager.getConnection(connect, username, password);
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from custom_pokemon where cp_weakness = 'Ice'");
				while(res.next()){
					out = out + (res.getString("cp_id") + "\t  " + res.getString("cp_name") + "\n");
				}
				}catch(Exception exo){
					System.out.println(exo.getMessage());
				}
		}
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
