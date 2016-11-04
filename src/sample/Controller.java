package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Controller {

    //region Controladores
    public Button btActualizar;
    public ListView listViewCartas;
    public TextArea txtColor;
    public RadioButton rdbtComun;
    public RadioButton rdbtNoComun;
    public RadioButton rdbtRaro;
    public RadioButton rdbtEspecial;
    public RadioButton rdbtMistic;
    public RadioButton rdbtBasicLand;
//endregion


    public void initialize(){
        /*createTree();
        txtTitulo.setText("");
        txtDefinicion.setText("");
        txtCodigo.setText("");*/
        txtColor.setText("HOLA!");
    }

    public void Refresh(ActionEvent actionEvent) throws URISyntaxException, IOException, JSONException {
        Api api= new Api();
        ArrayList<Carta> cartas= api.getAllCartas();


        for (int i = 0; i <cartas.size() ; i++) {
            System.out.println(cartas.get(i).getName());
        }

    }
}
