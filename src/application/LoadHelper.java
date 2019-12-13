package application;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

import backEnd.enums.*;

public class LoadHelper {
	
	@SuppressWarnings("unchecked")
	public void loadCoffeeChoiceBox(ChoiceBox coffee) {
			coffee.getItems().add(DrinkTypes.darkRoast.toString());
			coffee.getItems().add(DrinkTypes.almondLatte.toString());
			coffee.getItems().add(DrinkTypes.hazelnutLatte.toString());
			coffee.getItems().add(DrinkTypes.pumpkinSpiceLatte.toString());
	}
	
	
	public  ArrayList<Label> getListOf(ObservableList<Node> observableList){
		ArrayList<Label> temp = new ArrayList<Label>();
		
		for(Node i: observableList) {
			if(i instanceof Pane) {
				for(Node j:((Pane) i).getChildren() ){
					if(j instanceof Label)
						temp.add((Label) j);
				}
			}
		}
		return temp;
	}
}
