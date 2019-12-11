package application;

import javafx.scene.control.ChoiceBox;
import backEnd.enums.*;

public class LoadHelper {
	
	@SuppressWarnings("unchecked")
	public void loadCoffeeChoiceBox(ChoiceBox coffee) {
			coffee.getItems().add(DrinkTypes.darkRoast.toString());
			coffee.getItems().add(DrinkTypes.almondLatte.toString());
			coffee.getItems().add(DrinkTypes.hazelnutLatte.toString());
			coffee.getItems().add(DrinkTypes.pumpkinSpiceLatte.toString());
	}
	
}
