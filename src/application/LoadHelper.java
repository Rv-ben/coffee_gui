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
	public void loadTeaChoiceBox(ChoiceBox tea) {
		tea.getItems().add(DrinkTypes.jasmineGreenTea.toString());
		tea.getItems().add(DrinkTypes.milkTea.toString());
		tea.getItems().add(DrinkTypes.summerMintTea.toString());
	}
	public void loadCorsChoiceBox(ChoiceBox cors) {
		cors.getItems().add(PastryTypes.chocolateNut.toString());
		cors.getItems().add(PastryTypes.plain.toString());
	}
	public void loadCookieChoiceBox(ChoiceBox cookie) {
		cookie.getItems().add(PastryTypes.oatmeal.toString());
		cookie.getItems().add(PastryTypes.variety.toString());
	}
	public void loadMacChoiceBox(ChoiceBox mac) {
		mac.getItems().add(PastryTypes.variety.toString());
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
