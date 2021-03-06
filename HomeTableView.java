import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.control.SelectionMode;
// import javafx.scene.control.FocusMode;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.io.File;
import java.io.FilenameFilter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
public class HomeTableView {
	public static TableView<Company> getTable() {



		TableView<Company> companyHomeView = new TableView<Company>();


		ObservableList<Company> companies = StockTableView.getCompanies();

		companyHomeView.setItems(companies);

		TableColumn<Company, String> nameCol = new TableColumn<Company, String>("Name");
		nameCol.setCellValueFactory(new PropertyValueFactory("companyName"));


		TableColumn<Company, String> stockCol = new TableColumn<Company, String>("Stock Symbol");
		stockCol.setCellValueFactory(new PropertyValueFactory("stockSymbol"));


		TableColumn<Company, Double> closeCol = new TableColumn<Company, Double>("Latest Share Price");
		closeCol.setCellValueFactory(new PropertyValueFactory("mostRecentClose"));



		stockCol.prefWidthProperty().bind(companyHomeView.widthProperty().multiply(2.0/11.0));
		closeCol.prefWidthProperty().bind(companyHomeView.widthProperty().multiply(2.0/11.0));
		nameCol.prefWidthProperty().bind(companyHomeView.widthProperty().multiply(6.0/11.0));
		companyHomeView.getColumns().setAll(stockCol,nameCol,closeCol);
		closeCol.setStyle( "-fx-alignment: CENTER-RIGHT;");
		companyHomeView.getSelectionModel().select(0);

		return companyHomeView;

	}


}