package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

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
    public TextArea txtAreaText;
    public TextField txtRarity;
    public TextField txtType;
    public TextField txtPower;
    public TextField txtMana;
    public TextField txtName;
    public ImageView Imagen;
//endregion

    public ArrayList<String> imagenes = new ArrayList<String>();

    public ObservableList<String> listaCartas = FXCollections.observableArrayList ();
    public ObservableList<String> indices = FXCollections.observableArrayList ();
    public ArrayList<Carta> cartas;


    public void initialize() throws JSONException, IOException, URISyntaxException {
        /*createTree();
        txtTitulo.setText("");
        txtDefinicion.setText("");
        txtCodigo.setText("");*/
        //txtColor.setText("HOLA!");
        Refresh(new ActionEvent());
    }

    public void Refresh(ActionEvent actionEvent) throws URISyntaxException, IOException, JSONException {
        Api api= new Api();
        cartas= api.getAllCartas();


        for (int i = 0; i <cartas.size() ; i++) {
            System.out.println(cartas.get(i).getName());
        }

        for (int i = 0; i <cartas.size() ; i++) {
            indices.add(""+i);
            imagenes.add(cartas.get(i).imageUrl);
            listaCartas.add(cartas.get(i).getName());

        }
        listViewCartas.setItems(indices);



        listViewCartas.setCellFactory(param -> new ListCell<String>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    Image IMAGE = new Image(imagenes.get(Integer.parseInt(item)),50,50,true,true,true);
                    imageView.setImage(IMAGE);
                    imageView.setCache(true);
                    setText(listaCartas.get(Integer.parseInt(item)));
                    setGraphic(imageView);
                }
            }
        });

    }

    public void datos(MouseEvent mouseEvent) {
        //int numeroCarta= Integer.parseInt(listViewCartas.getSelectionModel().getSelectedItems().toString());
        String valor=listViewCartas.getSelectionModel().getSelectedItems().toString();
        int numeroCarta= Integer.parseInt(valor.substring(1,valor.length()-1));

        txtName.setText(cartas.get(numeroCarta).getName());
        txtMana.setText(cartas.get(numeroCarta).getManaCost());
        txtPower.setText(cartas.get(numeroCarta).getPower());
        txtRarity.setText(cartas.get(numeroCarta).getRarity());
        txtType.setText(cartas.get(numeroCarta).getType());
        txtAreaText.setText(cartas.get(numeroCarta).getText());
        Image img= new Image(cartas.get(numeroCarta).getImageUrl(),600,300,true,true,true);
        Imagen.setCache(true);
        Imagen.setFitHeight(600);
        Imagen.setFitWidth(300);
        Imagen.setImage(img);


    }


}
//TODO Hacer que en la cuadricula te ponga los colores correspondientes por cada carta los sleeccionados
//TODO Hacer filtro por cartas