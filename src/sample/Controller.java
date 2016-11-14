package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.json.JSONException;

import java.io.IOException;
import java.net.URISyntaxException;
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
    public TextArea txtAreaText;
    public TextField txtRarity;
    public TextField txtType;
    public TextField txtPower;
    public TextField txtMana;
    public TextField txtName;
    public ImageView Imagen;
//endregion

    public ArrayList<String> imagenes ;

    public ObservableList<String> listaCartas ;
    public ObservableList<String> indices;
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


        CrearLista();

    }

    private void CrearLista() {
        for (int i = 0; i <cartas.size() ; i++) {
            System.out.println(cartas.get(i).getName());
        }

        indices= FXCollections.observableArrayList ();
        listaCartas= FXCollections.observableArrayList ();
        imagenes = new ArrayList<String>();
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
                    if (imagenes.get(Integer.parseInt(item))!=null){
                        Image IMAGE = new Image(imagenes.get(Integer.parseInt(item)), 50, 50, true, true, true);
                        imageView.setImage(IMAGE);
                        imageView.setCache(true);
                    }
                    else {
                        Image img = new Image("ic_close_black_48dp_2x.png", 50, 50, true, true, true);
                        imageView.setImage(img);
                        imageView.setCache(true);
                    }
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
        if (cartas.get(numeroCarta).getImageUrl()!=null) {
            Image img = new Image(cartas.get(numeroCarta).getImageUrl(), 600, 300, true, true, true);
            Imagen.setCache(true);
            Imagen.setFitHeight(600);
            Imagen.setFitWidth(300);
            Imagen.setImage(img);

        }
        else {
            Image img = new Image("ic_close_black_48dp_2x.png");
            Imagen.setImage(img);
        }
    }


    public void selecionRareza(ActionEvent actionEvent) throws URISyntaxException, JSONException, IOException {
        String NombreRareza="";
        if(rdbtComun.isArmed())
        {NombreRareza="Common";}
        else if(rdbtNoComun.isArmed())
        {NombreRareza="Uncommon";}
        else if(rdbtRaro.isArmed())
        {NombreRareza="Rare";}
        else if(rdbtEspecial.isArmed())
        {NombreRareza="Special";}
        else if(rdbtMistic.isArmed())
        {NombreRareza="Mythic_Rare";}
        else if(rdbtBasicLand.isArmed())
        {NombreRareza="Basic_Land";}
        if (NombreRareza=="")
        {
            Api api= new Api();
            api.getAllCartas();

            //TODO Acabar el filtrado
        }
        else
            {
                Api api= new Api();
                cartas=api.getCartasFiltro(NombreRareza);
                if(cartas!=null) {
                    CrearLista();
                }
        }
    }
}
//TODO Hacer que en la cuadricula te ponga los colores correspondientes por cada carta los sleeccionados
//TODO Hacer filtro por cartas