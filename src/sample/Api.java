package sample;



import com.sun.istack.internal.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

/**
 * Created by 45858000w on 28/10/16.
 */
public class Api {

    private final String API_KEY = "9htuhtcb4ymusd73d4z6jxcj";
    private final String BASE_URL = "http://api.magicthegathering.io/v1/cards/";
    private final String BASE_URL2 = "http://api.magicthegathering.io";





    public String getCartas() throws URISyntaxException { //para utilizar el parametro


        String url = BASE_URL;
        System.out.println(url);

        try {
            String JsonResponse = HttpUtils.get(url);
            System.out.println("-----------------------------__"+JsonResponse);
            return JsonResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    ArrayList<Carta> getAllCartas() throws URISyntaxException, JSONException, IOException {
        String url = BASE_URL;
        return getDatosCartas(url);
    }

    //Devuelve un arrayList de Cartas con el url
    @Nullable
    private ArrayList<Carta> getDatosCartas(String url) throws JSONException {
        try {
            String JsonResponse = HttpUtils.get(url);
            ArrayList<Carta> cartas = new ArrayList<>();

            JSONObject data = new JSONObject(JsonResponse);
            JSONArray jsonCartas = data.getJSONArray("cards");

            for (int i = 0; i < jsonCartas.length(); i++) {
                Carta c = new Carta();
                JSONObject object = jsonCartas.getJSONObject(i);

                if (object.has("name")) {
                    c.setName(object.getString("name"));
                }
                if (object.has("manaCost")) {
                    c.setManaCost(object.getString("manaCost"));
                }
                if (object.has("type")) {
                    c.setType(object.getString("type"));
                }
                if (object.has("rarity")) {
                    c.setRarity(object.getString("rarity"));
                }
                if (object.has("text")) {
                    c.setText(object.getString("text"));
                }
                if (object.has("power")) {
                    c.setPower(object.getString("power"));
                }
                if (object.has("imageUrl")) {
                    c.setImageUrl(object.getString("imageUrl"));
                }
                if (object.has("colors")) {
                    c.setColors(object.getString("colors"));
                }

                cartas.add(c);
            }


            return cartas;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    public ArrayList<Carta> getCartasFiltro(String rareza) throws JSONException {
        //"https://api.magicthegathering.io/v1/cards?language=russian&name=Зурго Шлемобой" //dos filtros
        String BASE_URL3="https://api.magicthegathering.io/v1/cards?rarity="+rareza;
        System.out.println(rareza);
        System.out.println(BASE_URL3);
        return getDatosCartas(BASE_URL3);
    }
}



