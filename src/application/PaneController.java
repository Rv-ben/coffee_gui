package application;

import java.util.ArrayList;
import java.util.function.Predicate;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import backEnd.Decorators.ToppingPrices;
import backEnd.Factories.DrinkFactory;
import backEnd.Factories.PastryFactory;
import backEnd.Products.DrinkPrices;
import backEnd.Products.PastryPrices;
import backEnd.Products.Product;
import backEnd.enums.*;
import backEnd.testPackage.Coupon;
import backEnd.testPackage.Receipt;
public class PaneController {
	
	@FXML
	private Pane coffeeScreen,teaScreen,croissantScreen,cookieScreen,macaroonScreen,checkoutScreen;
	
	@FXML
	private GridPane coffeeToppings,teaToppings;
	
	@FXML
	private ArrayList<Label> coffeeToppingLabels, teaToppingLabels;
	
	@FXML
	private ChoiceBox coffeeChoice,teaChoice,macChoice,cookieChoice,corsChoice,recChoice;
	
	@FXML
	private Label coffeeQty,teaQty,sweetnessLabel,corsQty,cookieQty,macQty;
	
	@FXML
	private TextField nameField, couponCodeField,cashTenderedField;
	
	@FXML
	private VBox navButtons;
	
	@FXML
	private Button payButton;
	
	@FXML
	private ToggleGroup coffeeSize,teaSize;
	
	@FXML
	private RadioButton heatedCors;
	
	@FXML
	private ListView rec;
	
	private int currentRecieptIndex;
	
	@FXML
	private Label subTotal,total,tax,changeDueAmount;
	
	@FXML
	private DrinkFactory d  = new DrinkFactory();
	
	private PastryFactory pf = new PastryFactory();
	
	private ArrayList<Product> cart = new ArrayList<Product>();
	
	private LoadHelper x = new LoadHelper();
	
	private ArrayList<Receipt> recs = new ArrayList<Receipt>();
	
	private ArrayList<Pane> productScreenList = new ArrayList<Pane>();
	
	
	@FXML
	public void initialize() {
		x.loadCoffeeChoiceBox(coffeeChoice);
		x.loadTeaChoiceBox(teaChoice);
		x.loadCorsChoiceBox(corsChoice);
		x.loadMacChoiceBox(macChoice);
		x.loadCookieChoiceBox(cookieChoice);
		
		productScreenList.add(coffeeScreen);
		productScreenList.add(teaScreen);
		productScreenList.add(croissantScreen);
		productScreenList.add(cookieScreen);
		productScreenList.add(macaroonScreen);
		
		recs.add(new Receipt(.10,rec,subTotal,tax,total));
		recChoice.getItems().add(recs.get(recs.size()-1).getName());
		
		coffeeToppingLabels = x.getListOf(coffeeToppings.getChildren());
		teaToppingLabels = x.getListOf(teaToppings.getChildren());
		

        PastryPrices p = new PastryPrices();
        ToppingPrices t = new ToppingPrices();
        DrinkPrices d = new DrinkPrices();
        
        d.init(true);
        p.init(true);
        t.init(true);
        
        recChoice.getSelectionModel()
        .selectedItemProperty()
        .addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String > observableValue, String number, String number2) {
              displayRec(number2);
              currentRecieptIndex = findRecIndex(number2);
            }
          });
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
	
	public void sweetnessCount(ActionEvent evt) {

		Node source = (Node) evt.getSource();
		
		Label count = (Label)source.getParent().getChildrenUnmodifiable().get(2);
		
		double countVal = Double.parseDouble(count.getText());
		
		if(countVal != 0  && source.getId().equalsIgnoreCase("minus")) {
			countVal -= .25;
			count.setText(""+(countVal));
		}
		else if(source.getId().equalsIgnoreCase("plus")&& countVal != 1) {
			countVal += .25;
			count.setText(""+(countVal));
		}
	}
	
	public void addCoffeeToCart() {
		Details coffee = new Details();
		
		coffee.spec = DrinkTypes.valueOf(((String)coffeeChoice.getValue()));
		coffee.type = DrinkTypes.coffee;
		coffee.size = Sizes.valueOf(((RadioButton)coffeeSize.getSelectedToggle()).getId());
		
		addToppings(coffee.toppings,coffeeToppingLabels);
		
		addAmountToCart(Integer.parseInt(coffeeQty.getText()),d.createProduct(coffee));
		updateRec();
	}
	
	public void addTeaToCart() {
		Details tea = new Details();
		
		tea.spec = DrinkTypes.valueOf((String)teaChoice.getValue());
		tea.type = DrinkTypes.tea;
		tea.size = Sizes.valueOf(((RadioButton)teaSize.getSelectedToggle()).getId());
		tea.sweetness = Double.parseDouble((sweetnessLabel.getText()));
		
		addToppings(tea.toppings,teaToppingLabels);
		
		addAmountToCart(Integer.parseInt(teaQty.getText()),d.createProduct(tea));
		updateRec();
	}
	
	//test2
	
	public void addCorsToCart() {
		Details cors = new Details();
		
		cors.heated = heatedCors.isSelected();
		
		cors.pType = PastryTypes.croissant;
		cors.special = PastryTypes.valueOf((String)corsChoice.getValue());
		
		addAmountToCart(Integer.parseInt(corsQty.getText()),pf.createProduct(cors));
		updateRec();
		
	}
	
	public void addCookieToCart() {
		Details cookie = new Details();
		
		cookie.pType = PastryTypes.cookie;
		cookie.special = PastryTypes.valueOf((String)cookieChoice.getValue());
		cookie.qty = Integer.parseInt(cookieQty.getText());
		
		addAmountToCart(1,pf.createProduct(cookie));
		updateRec();
	}
	
	public void addMacToCart() {
		Details mac = new Details();
		
		mac.pType = PastryTypes.macaroon;
		mac.special = PastryTypes.valueOf((String)macChoice.getValue());
		mac.qty = Integer.parseInt(macQty.getText());
		
		addAmountToCart(1,pf.createProduct(mac));
		updateRec();
		
	}
	
	
	
	public void addToppings(ArrayList<ToppingTypes> t,ArrayList<Label> labels) {
		for(Label i:labels) {
			for(int j = 0; j < Integer.parseInt(i.getText()); j++) {
				t.add(ToppingTypes.valueOf(i.getId()));
			}
		}
	}
	
	public void addAmountToCart(int num, Product x) {
		
		for(int i = 0; i<num;i++) {
			recs.get(currentRecieptIndex).listOfProducts.add(x);
		}
		
	}
	
	public void updateRec() {
		recs.get(currentRecieptIndex).printReceipt();
	}
	
	public void displayRec(String name) {
		Receipt r = findRecByName(name);
		r.printReceipt();
	}
	
	public Receipt findRecByName(String name) {
		for(Receipt i: recs) {
			if(i.getName().equalsIgnoreCase(name))
				return i;
		}
		return null;
	}
	
	public int findRecIndex(String name) {
		for(int i=0;i<recs.size();i++) {
			if(recs.get(i).getName().equalsIgnoreCase(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public void backButton() {
		checkoutScreen.setVisible(false);
		navButtons.setVisible(true);
		payButton.setVisible(true);
		recChoice.getSelectionModel().selectLast();
		
	}
	
	public void clearCheckout() {
		changeDueAmount.setText("");
		cashTenderedField.setText("");
		nameField.setText("");
		couponCodeField.setText("");
		
	}
	
	public void checkoutButton() {
		navButtons.setVisible(false);
		clearProductScreens();
		checkoutScreen.setVisible(true);
	}
	
	public void payButton() {
		recs.get(currentRecieptIndex).setName(nameField.getText());
		recs.add(new Receipt(.10,rec,subTotal,tax,total));
		updateRecChoice();
		payButton.setVisible(false);
		double changeDue = Double.parseDouble(cashTenderedField.getText()) - Double.parseDouble(total.getText());
		changeDueAmount.setText(""+changeDue);
	}
	
	public void updateRecChoice() {
		recChoice.getItems().clear();
		for(Receipt i : recs) {
			recChoice.getItems().add(i.getName());
		}
		
	}
	
	public void displayRec() {
		displayRec(recChoice.getValue().toString());
	}
	
	public void createCoupon() {
		String s = couponCodeField.getText();
		Coupon coupon = new Coupon();
		s.toLowerCase();
		
		if (s.equals("drink")) 
			coupon.drink = true;
		else if (s.equals("pastry")) 
			coupon.pastry = true;
		else if (s.equals("general")) 
			coupon.general = true;
		
		recs.get(currentRecieptIndex).setCoupon(coupon);
		recs.get(currentRecieptIndex).printReceipt();
	}

}
