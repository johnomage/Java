package EventDrivenProgAndAnim;

import javafx.application.Application; 
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage; 

public class LogIn extends Application { 
	 static //Creating Text Filed for account holder name       
    TextField accountText = new TextField();       
    
    //Creating Text Filed for pin       
    PasswordField pinText = new PasswordField();
   @Override 
   public void start(Stage stage) {      
      //creating label email 
      Text account = new Text("Account");       
      //creating label password 
      Text pin = new Text("PIN"); 
	  pin.setTextAlignment(TextAlignment.RIGHT);
      //Creating Buttons 
      Button submit = new Button("Submit"); 
      Button clear = new Button("Clear"); 
      
//      pinText.
      
      //Creating a Grid Pane 
      GridPane gridPane = new GridPane();    
      
      //Setting size for the pane  
      gridPane.setMinSize(400, 200); 
       
      //Setting the padding  
      gridPane.setPadding(new Insets(10, 10, 10, 10)); 
      
      //Setting the vertical and horizontal gaps between the columns 
      gridPane.setVgap(5); 
      gridPane.setHgap(5);       
      
      //Setting the Grid alignment 
      gridPane.setAlignment(Pos.CENTER); 
       
      //Arranging all the nodes in the grid 
      gridPane.add(account, 0, 0); 
      gridPane.add(accountText, 1, 0); 
      gridPane.add(pin, 0, 1);       
      gridPane.add(pinText, 1, 1); 
      gridPane.add(submit, 0, 2); 
      gridPane.add(clear, 1, 2);  
      
      clear.setOnAction(e -> clear());
      new ATMProgram();
     
      //Creating a scene object 
      Scene scene = new Scene(gridPane);  
      
      //Setting title to the Stage 
      stage.setTitle("Grid Pane Example"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
      stage.show();
      submit.setOnAction(e -> {
//    	  System.out.print(accountText.getText());
    	  stage.close();
    	  ATMProgram.Main(null);
		});
      submit.setOnKeyPressed(e->{
//    	  e.getCode() = KeyCode.ENTER;
      });
   }
   
   public static String getAccountName() {
	   return accountText.getText();
   }
   private void clear() {
	   accountText.clear();
	   pinText.clear();
	return;
}
public static void main(String args[]){ 
      launch(args); 
   } 
} 
