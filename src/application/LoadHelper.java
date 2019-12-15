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
		coffee.getItems().add(DrinkTypes.housePremium.toString());
		coffee.getItems().add(DrinkTypes.seaCream.toString());
		coffee.getItems().add(DrinkTypes.pumpkinSpiceLatte.toString());
		coffee.getItems().add(DrinkTypes.houseCoffee.toString());
		coffee.getItems().add(DrinkTypes.houseDecaf.toString());
		coffee.getItems().add(DrinkTypes.hazelNutLatte.toString());
		coffee.getItems().add(DrinkTypes.Olla.toString());
	}
	public void loadTeaChoiceBox(ChoiceBox tea) {
		tea.getItems().add(DrinkTypes.jasmineGreenTea.toString());
		tea.getItems().add(DrinkTypes.greenTea.toString());
		tea.getItems().add(DrinkTypes.roseGreenTea.toString());
		tea.getItems().add(DrinkTypes.summerMintTea.toString());
		tea.getItems().add(DrinkTypes.taroTea.toString());
	}
	public void loadCorsChoiceBox(ChoiceBox cors) {
		cors.getItems().add(PastryTypes.croissant.toString());
		cors.getItems().add(PastryTypes.strawBerryCroissant.toString());
	}
	public void loadCookieChoiceBox(ChoiceBox cookie) {
		cookie.getItems().add(PastryTypes.oatMeal.toString());
		cookie.getItems().add(PastryTypes.nutChocolateChip.toString());
		cookie.getItems().add(PastryTypes.chocalateChip.toString());
	}
	public void loadMacChoiceBox(ChoiceBox mac) {
		mac.getItems().add(PastryTypes.macaroon.toString());
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
