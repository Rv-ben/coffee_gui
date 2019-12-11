package application;

import java.util.ArrayList;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class PaneController {
	
	@FXML
	private Pane coffeeScreen;
	
	
	//Topping Labels
	@FXML
	private Label wholeMilkLabel,whipLabel,halfHalfLabel,soyMilkLabel;
	
	
	private ArrayList<Pane> productScreenList = new ArrayList<Pane>();
	
	
	@FXML
	public void initialize() {
		productScreenList.add(coffeeScreen);
	}
	
	public void productButtonClicked(ActionEvent evt) {
		Node source = (Node) evt.getSource();
		clearProductScreens();
		
		switch(source.getId()) {
		case "CoffeeButton":
			coffeeScreen.setVisible(true);
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
