package controll;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.ConCustomerDao;
import dao.ConcertDao;
import dao.TicketingDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import vo.ConCustomer;
import vo.Concert;
import vo.Ticketing;

public class ConcertControl implements Initializable{
	
	@FXML
	private BorderPane borderPane;
	
	
	@FXML
	private Tab tabCon;
	
	@FXML
	private BorderPane borderPane1;
	
	@FXML
	private TextField txtConId;

	@FXML
	private TextField txtConName;
	
	@FXML
	private TextField txtConHost;
	
	@FXML
	private TextField txtPrice;
	
	@FXML
	private Button btnInsert;
	
	@FXML
	private Button btnUpdate;
	
	@FXML
	private Button btnDelete;
	
	@FXML
	private Button btnFind;
	
	@FXML
	private TableView<Concert> tableview;
	
	@FXML
	private TableColumn<Concert, Integer> colId;
	
	@FXML
	private TableColumn<Concert, String> colConName;
	
	@FXML
	private TableColumn<Concert, String> colConHost;
	
	@FXML
	private TableColumn<Concert, Integer> colPrice;
	
	@FXML
	private Tab tabCust;

    @FXML
    private BorderPane borderPane2;
	
	@FXML
	private TextField txtCustId;
	
	@FXML
	private TextField txtCustName;
	
	@FXML
	private TextField txtCustAdd;
	
	@FXML
	private TextField txtCustPhone;
	
	@FXML
	private Button btnInsert1;
	
	@FXML
	private Button btnUpdate1;
	
	@FXML
	private Button btnDelete1;
	
	@FXML
	private Button btnFind1;
	
	@FXML
	private TableView<ConCustomer> tableview1;
	
    @FXML
    private TableColumn<ConCustomer, Integer> colCustId;

    @FXML
    private TableColumn<ConCustomer, String> colCustName;
    
    @FXML
    private TableColumn<ConCustomer, String> colCustAdd;
    
    @FXML
    private TableColumn<ConCustomer, String> colCustPhone;
    
    @FXML
    private Tab tabTic;
    
    @FXML
    private BorderPane borderPane3;
    
    @FXML
	private TextField txtOrderId;
	
	@FXML
	private TextField txtCustId2;
	
	@FXML
	private TextField txtConId2;
	
	@FXML
	private TextField txtSale;

    @FXML
    private Button txtInsert2;
    
    @FXML
    private Button txtUpdate2;
    
    @FXML
    private Button btnDelete2;
    
    @FXML
    private Button txtFind2;

    @FXML
    private TableView<Ticketing> tableview2;
    
    @FXML
    private TableColumn<Ticketing, Integer> colOrderId2;

    @FXML
    private TableColumn<Ticketing, Integer> colCustId2;

    @FXML
    private TableColumn<Ticketing, Integer> colConId2;
    
    @FXML
    private TableColumn<Ticketing, Integer> colSale2;


	@FXML
	void Insert(ActionEvent event) {
		try {
			int conid = Integer.parseInt(txtConId.getText());
			String name = txtConName.getText();
			String conhost = txtConHost.getText();
			int price = Integer.parseInt(txtPrice.getText());

			Concert vo = new Concert();
			vo.setConid(conid);
			vo.setConname(name);
			vo.setConhost(conhost);
			vo.setPrice(price);

			ConcertDao dao = new ConcertDao();
			dao.insert(vo);
			tableview.getItems().add(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void Update(ActionEvent event) {
		ConcertDao dao = new ConcertDao();
		Concert vo = new Concert();
		int conid = Integer.parseInt(txtConId.getText());
		String name = txtConName.getText();
		String conhost = txtConHost.getText();
		int price = Integer.parseInt(txtPrice.getText());

		vo.setConid(conid);
		vo.setConname(name);
		vo.setConhost(conhost);
		vo.setPrice(price);

		try {
			dao.update(vo);
			int pos = tableview.getSelectionModel().getSelectedIndex();
			tableview.getItems().set(pos, vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void Delete(ActionEvent event) {
		Concert concert = tableview.getSelectionModel().getSelectedItem();
		ConcertDao dao = new ConcertDao();
		try {
			dao.delete(concert.getConid());
			tableview.getItems().remove(concert);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@FXML
	void Find(ActionEvent event) {
		ConcertDao dao = new ConcertDao();
		Concert concert = null;
		try {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("콘서트정보 찾기");
			dialog.setHeaderText("콘서트정보는 CONID로 검색하세요");
			dialog.setContentText("CONID를 입력하세요:");
			Optional<String> result = dialog.showAndWait();
			int x = Integer.parseInt(result.get());
			concert = dao.select(x);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("검색된 자료");
		alert.setHeaderText("검색결과입니다.");
		alert.setContentText(concert.toString());
		alert.showAndWait();
	}

	@FXML
	void insert1(ActionEvent event) {
		try {
			int custid = Integer.parseInt(txtCustId.getText());
			String name = txtCustName.getText();
			String address = txtCustAdd.getText();
			String phone = txtCustPhone.getText();

			ConCustomer vo = new ConCustomer();
			vo.setCustid(custid);
			vo.setName(name);
			vo.setAddress(address);
			vo.setPhone(phone);

			ConCustomerDao dao = new ConCustomerDao();
			dao.insert(vo);
			tableview1.getItems().add(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void Update1(ActionEvent event) {
		ConCustomerDao dao = new ConCustomerDao();
		ConCustomer vo = new ConCustomer();
		int custid = Integer.parseInt(txtCustId.getText());
		String name = txtCustName.getText();
		String address = txtCustAdd.getText();
		String phone = txtCustPhone.getText();

		vo.setCustid(custid);
		vo.setName(name);
		vo.setAddress(address);
		vo.setPhone(phone);

		try {
			dao.update(vo);
			int pos = tableview1.getSelectionModel().getSelectedIndex();
			tableview1.getItems().set(pos, vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void Delete1(ActionEvent event) {
		ConCustomer concustomer = tableview1.getSelectionModel().getSelectedItem();
		ConCustomerDao dao = new ConCustomerDao();
		try {
			dao.delete(concustomer.getCustid());
			tableview1.getItems().remove(concustomer);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@FXML
	void Find1(ActionEvent event) {
		ConCustomerDao dao = new ConCustomerDao();
		ConCustomer concustomer = null;
		try {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("콘서트이용자정보 찾기");
			dialog.setHeaderText("콘서트이용자 정보는 CUSTID로 검색하세요");
			dialog.setContentText("CUSTID를 입력하세요:");
			Optional<String> result = dialog.showAndWait();
			int x = Integer.parseInt(result.get());
			concustomer = dao.select(x);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("검색된 자료");
		alert.setHeaderText("검색결과입니다.");
		alert.setContentText(concustomer.toString());
		alert.showAndWait();
	}

	@FXML
	void Insert2(ActionEvent event) {
		try {
			int orderid = Integer.parseInt(txtOrderId.getText());
			int custid = Integer.parseInt(txtCustId2.getText());
			int conid = Integer.parseInt(txtConId2.getText());
			int saleprice = Integer.parseInt(txtSale.getText());

			Ticketing vo = new Ticketing();
			vo.setOrderid(orderid);
			vo.setCustid(custid);
			vo.setConid(conid);
			vo.setSaleprice(saleprice);

			TicketingDao dao = new TicketingDao();
			dao.insert(vo);
			tableview2.getItems().add(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void Update2(ActionEvent event) {
		TicketingDao dao = new TicketingDao();
		Ticketing vo = new Ticketing();
		int orderid = Integer.parseInt(txtOrderId.getText());
		int custid = Integer.parseInt(txtCustId2.getText());
		int conid = Integer.parseInt(txtConId2.getText());
		int saleprice = Integer.parseInt(txtSale.getText());

		vo.setOrderid(orderid);
		vo.setCustid(custid);
		vo.setConid(conid);
		vo.setSaleprice(saleprice);

		try {
			dao.update(vo);
			int pos = tableview2.getSelectionModel().getSelectedIndex();
			tableview2.getItems().set(pos, vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void Delete2(ActionEvent event) {
		Ticketing ticketing = tableview2.getSelectionModel().getSelectedItem();
		TicketingDao dao = new TicketingDao();
		try {
			dao.delete(ticketing.getOrderid());
			tableview2.getItems().remove(ticketing);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@FXML
	void txtFind2(ActionEvent event) {
		TicketingDao dao = new TicketingDao();
		Ticketing ticketing = null;
		try {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("콘서트 주문 내역 찾기");
			dialog.setHeaderText("콘서트 주문 내역은 ORDERID로 검색하세요");
			dialog.setContentText("ORDERID를 입력하세요:");
			Optional<String> result = dialog.showAndWait();
			int x = Integer.parseInt(result.get());
			ticketing = dao.select(x);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("검색된 자료");
		alert.setHeaderText("검색결과입니다.");
		alert.setContentText(ticketing.toString());
		alert.showAndWait();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) 
		{colId.setCellValueFactory(new PropertyValueFactory<Concert, Integer>("conid"));
		colConName.setCellValueFactory(new PropertyValueFactory<Concert, String>("conname"));
		colConHost.setCellValueFactory(new PropertyValueFactory<Concert, String>("conhost"));
		colPrice.setCellValueFactory(new PropertyValueFactory<Concert, Integer>("price"));

		ConcertDao dao = new ConcertDao();
			try {
				List<Concert> data = dao.selectAll();
				tableview.getItems().addAll(data);
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		{colCustId.setCellValueFactory(new PropertyValueFactory<ConCustomer, Integer>("custid"));
		colCustName.setCellValueFactory(new PropertyValueFactory<ConCustomer, String>("name"));
		colCustAdd.setCellValueFactory(new PropertyValueFactory<ConCustomer, String>("address"));
		colCustPhone.setCellValueFactory(new PropertyValueFactory<ConCustomer, String>("phone"));

		ConCustomerDao dao1 = new ConCustomerDao();
			try {
				List<ConCustomer> data = dao1.selectAll();
				tableview1.getItems().addAll(data);
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		{colOrderId2.setCellValueFactory(new PropertyValueFactory<Ticketing, Integer>("orderid"));
		colCustId2.setCellValueFactory(new PropertyValueFactory<Ticketing, Integer>("custid"));
		colConId2.setCellValueFactory(new PropertyValueFactory<Ticketing, Integer>("conid"));
		colSale2.setCellValueFactory(new PropertyValueFactory<Ticketing, Integer>("saleprice"));

		TicketingDao dao3 = new TicketingDao();
			try {
				List<Ticketing> data = dao3.selectAll();
				tableview2.getItems().addAll(data);
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
		}
	}
}