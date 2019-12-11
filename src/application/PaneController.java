package application;

import java.util.ArrayList;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import backEnd.enums.*;
public class PaneController {
	
	@FXML
	private Pane coffeeScreen,teaScreen,croissantScreen,cookieScreen,macaroonScreen;
	
	@FXML
	private ChoiceBox coffeeChoice;
	
	
	//Topping Labels
	@FXML
	private Label wholeMilkLabel,whipLabel,halfHalfLabel,soyMilkLabel;
	
	
	private ArrayList<Pane> productScreenList = new ArrayList<Pane>();
	
	
	@FXML
	public void initialize() {
		productScreenList.add(coffeeScreen);
		productScreenList.add(teaScreen);
		productScreenList.add(croissantScreen);
		productScreenList.add(cookieScreen);
		productScreenList.add(macaroonScreen);
		//coffeeChoice.getItems().add(DrinkTypes.almondLatte.toString());
	}
	
	public void productButtonClicked(ActionEvent evt) {
		Node source = (Node) evt.getSource();
		clearProductScreens();
		
		switch(source.getId()) {
		case "CoffeeButton":
			coffeeScreen.setVisible(true); break;
		case "TeaButton":
			teaScreen.setVisible(true); break;
		case "CookieButton":
			cookieScreen.setVisible(true); break;
		case "CorsButton":
			croissantScreen.setVisible(true); break;
		case "MacButton":
			macaroonScreen.setVisible(true); break;
		}
	}
	
	public void clearProductScreens() {
		for(Pane i: productScreenList) {
			i.setVisible(false);
		}
	}
	
	public void toppingCount(ActionEvent evt) {
		//gets name of button
		Node source = (Node) evt.getSource();
		
		Label count = (Label)source.getParent().getChildrenUnmodifiable().get(2);
		
		int countVal = Integer.parseInt(count.getText());
		
		
		if(countVal != 0 && source.getId().equalsIgnoreCase("minus")) {
			count.setText(""+(--countVal));
		}
		else if(source.getId().equalsIgnoreCase("plus")){
			count.setText(""+(++countVal));
		}

	}
	
	
	
	
}
