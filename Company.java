import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.DoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Company {

	private StringProperty companyName;
	private StringProperty stockSymbol;
	private DoubleProperty mostRecentAdjVal;
	private ObservableList<DayEntry> companyData = FXCollections.observableArrayList();

	public Company(String companyName, String stockSymbol){
		setCompanyName(companyName);
		setStockSymbol(stockSymbol);
	}

	public final void setCompanyName(String value){
		companyNameProperty().set(value);
	}

	public final String getCompanyName(){
		return companyNameProperty().get();

	}

	public StringProperty companyNameProperty() {
		if (companyName == null) {
			companyName = new SimpleStringProperty();
		}
		return companyName;
	}


	public final void setStockSymbol(String value){
		stockSymbolProperty().set(value);
	}

	public final String getStockSymbol(){
		return stockSymbolProperty().get() + " .L ";
		
	}

	public StringProperty stockSymbolProperty() {
		if (stockSymbol == null) {
			stockSymbol = new SimpleStringProperty();
		}
		return stockSymbol;
	}

	public ObservableList<DayEntry> companyDataProperty() {
		return companyData;
	}

	public Double getTickerString() {
		Double todayClose = companyData.get(0).getAdjClose();
		Double yDayClose = companyData.get(1).getAdjClose();
		Double percentChange = todayClose / yDayClose * 100 - 100;
		// String posSign = "";
		// if (percentChange > 0) {
		// 	posSign = "+";
		// }

		// return posSign + String.format("%.3f",percentChange)+ "% | ";
		return percentChange;

	}

	public String getHighest() {
		Double fHighest = 0.00;
		String fDate = "";
		for (int i = 0; i < companyData.size(); i++){
			Double tHighest = companyData.get(i).getHigh();
			if (tHighest >= fHighest){
				fHighest = tHighest;
				fDate = companyData.get(i).getDate();
			}
		}
		return fDate + " " + fHighest;

	}

	public String getLowest() {
		Double fLowest = companyData.get(0).getLow();
		String fDate = "";
		for (int i = 0; i < companyData.size(); i++){
			Double tLowest = companyData.get(i).getLow();
			if (tLowest <= fLowest){
				fLowest = tLowest;
				fDate = companyData.get(i).getDate();
			}
		}
		return fDate + " " + fLowest;

	}

	public Double getAverageClose() {
		Double fClosing = 0.00;
		for (int i = 0; i < companyData.size(); i++){
			fClosing += companyData.get(i).getAdjClose();
		}
		fClosing /= companyData.size();
		return fClosing;
	}

	public Double getLatestClose() {
		return companyData.get(0).getAdjClose();
	}


	public String toString() {
		return getCompanyName();
	}

}