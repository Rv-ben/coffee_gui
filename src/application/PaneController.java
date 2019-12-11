package application;

import java.util.ArrayList;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import backEnd.Decorators.ToppingPrices;
import backEnd.Factories.DrinkFactory;
import backEnd.Products.PastryPrices;
import backEnd.Products.Product;
import backEnd.enums.*;
public class PaneController {
	
	@FXML
	private Pane coffeeScreen,teaScreen,croissantScreen,cookieScreen,macaroonScreen;
	
	@FXML
	private ChoiceBox coffeeChoice;
	
	@FXML
	private Label halfHalf,milk,soyMilk,whipCream;
	
	@FXML
	private RadioButton small;
	
	@FXML
	private ListView rec;
	
	@FXML
	private DrinkFactory d  = new DrinkFactory();
	
	private ArrayList<Product> cart = new ArrayList<Product>();
	
	private LoadHelper x = new LoadHelper();
	
	//Topping Labels
	@FXML
	private Label wholeMilkLabel,whipLabel,halfHalfLabel,soyMilkLabel;
	
	
	private ArrayList<Pane> productScreenList = new ArrayList<Pane>();
	
	
	@FXML
	public void initialize() {
		x.loadCoffeeChoiceBox(coffeeChoice);
		
		productScreenList.add(coffeeScreen);
		productScreenList.add(teaScreen);
		productScreenList.add(croissantScreen);
		productScreenList.add(cookieScreen);
		productScreenList.add(macaroonScreen);

        PastryPrices p = new PastryPrices();
        ToppingPrices t = new ToppingPrices();

        p.init();
        t.init();
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
	
	public void addCoffeeToCart() {
		Details coffee = new Details();
		
		coffee.spec = DrinkTypes.valueOf(((String)coffeeChoice.getValue()));
		coffee.type = DrinkTypes.coffee;
		coffee.size = Sizes.small;
		
		addToppings(coffee.toppings,Integer.parseInt(soyMilk.getText()),ToppingTypes.soyMilk);
		addToppings(coffee.toppings,Integer.parseInt(halfHalf.getText()),ToppingTypes.halfHalf);
		addToppings(coffee.toppings,Integer.parseInt(whipCream.getText()),ToppingTypes.whipCream);
		
		cart.add(d.createProduct(coffee));
		updateRec();
	}
	
	public void addToppings(ArrayList<ToppingTypes> t,int num,ToppingTypes topping) {
		for(int i = 0;i<num;i++) {
			t.add(topping);
		}
	}
	
	public void updateRec() {
		
		if(rec != null)
			rec.getItems().clear();
		
		for(Product i : cart) {
			rec.getItems().add(i.getDescription()+ "                                         "+ i.getCost());
		}
	}
	

}
