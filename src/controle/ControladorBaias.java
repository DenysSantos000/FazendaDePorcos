package controle;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import modelo.Baia;
import persistencia.BaiaDAO;

public class ControladorBaias implements Initializable {
    BaiaDAO baiaDAO = new BaiaDAO();
    @FXML
        private AnchorPane anchorBaias;
    @FXML
        private BorderPane borderBaias;
    @FXML
        private  JFXButton btAdicionar, btRemover; 
    @FXML
        private TableView<Baia> tabelaBaias;
    @FXML
        private TableColumn<Baia, Integer > colunaID;  
    @FXML
        private TableColumn<Baia, Double> colunaTamanho;
    @FXML
        private TableColumn<Baia, Boolean> colunaLimpeza;    
    private ObservableList<Baia> listaBaia = FXCollections.observableArrayList();    
        public void tabelaBaia(){       
            listaBaia.clear();
            listaBaia.addAll(baiaDAO.readBaias());
            tabelaBaias.setItems(listaBaia);
        }
    @FXML
	private void adicionarBaia() {
            try {
		Parent adicionarBaia =  FXMLLoader.load(getClass().getResource("/visao/AdicionarBaias.fxml"));
		borderBaias.setCenter(adicionarBaia);	
		} catch (IOException e) {
		}	
	} 
    @FXML
	private void removerBaia() {
            try {
		Parent removerBaia =  FXMLLoader.load(getClass().getResource("/visao/RemoverBaias.fxml"));
		borderBaias.setCenter(removerBaia);	
		} catch (IOException e) {
		}	
	} 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            colunaID.setCellValueFactory(new PropertyValueFactory<Baia, Integer>("id"));           
            colunaTamanho.setCellValueFactory(new PropertyValueFactory<Baia, Double>("tam"));            
            colunaLimpeza.setCellValueFactory(new PropertyValueFactory<Baia, Boolean>("limp"));
            tabelaBaia();
    }
}