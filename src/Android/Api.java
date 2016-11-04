package Android;

/**
 * Created by 45858000w on 14/10/16.
 *//*
import android.net.Uri;
import android.support.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
*/
import com.sun.istack.internal.Nullable;


import java.io.IOException;
import java.util.ArrayList;

import static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Uri;

public class Api {
    //http://api.magicthegathering.io/v1/cards?page=311

    private final String API_KEY = "9htuhtcb4ymusd73d4z6jxcj";

/*
     String getCartas(String pais) { //para utilizar el parametro

        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                //.appendPath("vi")
                //.appendPath("cards")
                //.appendPath("box_office.json")
               // .appendQueryParameter("country", pais)//para buscar dentro de la api con algun paramentro en concreto
                //.appendQueryParameter("apikey", API_KEY)
                .build();
        String url = builtUri.toString();

        try {
            String JsonResponse = HttpUtils.get(url);
            return JsonResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;


    }


    ArrayList<Carta> getAllCartas(){
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .build();
        String url = builtUri.toString();

        return getDatosCartas(url);
    }

    //Devuelve un arrayList de Cartas con el url
    @Nullable
    private ArrayList<Carta> getDatosCartas(String url) {
        try {
            String JsonResponse = HttpUtils.get(url);
            ArrayList<Carta> cartas =new ArrayList<>();

            JSONObject data= new JSONObject(JsonResponse);
            JSONArray jsonCartas = data.getJSONArray("cards");

            for (int i = 0; i<jsonCartas.length() ; i++) {
                Carta c= new Carta();
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
                if (object.has("power"))
                {
                    c.setPower(object.getString("power"));
                }
                if (object.has("imageUrl")) {
                    c.setImageUrl(object.getString("imageUrl"));
                }
                if (object.has("colors"))
                {
                    c.setColor(object.getString("colors"));
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

    private final String BASE_URL = "http://api.magicthegathering.io/v1/cards/";
    private final String BASE_URL2 = "http://api.magicthegathering.io";

    public ArrayList<Carta> getCartasRareza(String rareza,String color) {


        Uri builtUri = Uri.parse(BASE_URL2)
                .buildUpon()
                .appendPath("v1")
                .appendPath("cards")
                //.appendPath("box_office.json")
                // .appendQueryParameter("rarity", "Rare")//para buscar dentro de la api con algun paramentro en concreto
                .appendQueryParameter("rarity", rareza)//para buscar dentro de la api con algun paramentro en concreto,
                .appendQueryParameter("colors", color)//para buscar dentro de la api con algun paramentro en concreto
                .build();
        String url = builtUri.toString();
        return getDatosCartas(url); //return null;
    }

*/

    /*
    Get cards from Khans of Tarkir that have the colors red, white and blue
    "https://api.magicthegathering.io/v1/cards?set=ktk&colors=red,white,blue"

    Uso avanzado

    Los siguientes campos permiten que los modificadores gt (mayor que), GTE (mayor que o igual a),
                    LT (menor que), y LTE (menos de o igual a) a los usados en el parámetro url:
     poder
     tenacidad
     lealtad
     CMC
 "https://api.magicthegathering.io/v1/cards?power=gt3&cmc=lte6"


*/
}