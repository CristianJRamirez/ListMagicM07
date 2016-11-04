




/*
public class MainActivityFragment extends Fragment {


    //region VARIABLES

//   private ArrayList<String> cartas;
 //   private ArrayAdapter<String> adapter;
    private ArrayList<Carta> cartas;
    //private ArrayAdapter<Carta> adapter;
    private CartaAdapter adapter;
    //endregion



    public MainActivityFragment() {
    }

    @Override//notificamos al activity quer le añadimos items al menu
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ListView listaCartas = (ListView) view.findViewById(R.id.listaCartas);

        cartas = new ArrayList<>();


        adapter = new CartaAdapter(
             getContext(),
             R.layout.cartas_layout,
            // R.id.Carta,
                cartas
             );
        listaCartas.setAdapter(adapter);

        return view;
    }

    @Override//añadimos items al menu
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_cartas,menu);
    }


    //region Click en el boton Actualizar


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent i = new Intent(getContext(), SettingsActivity.class);
            startActivity(i);
            return true;
        }
        else if (id == R.id.actualizar) {
            refresh();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }

    private void refresh() {

           RefreshDataTask task = new RefreshDataTask();
           task.execute();
    }

*/

/*

    private class RefreshDataTask extends AsyncTask<Void, Void, ArrayList<Carta>> {
        @Override
        protected ArrayList<Carta> doInBackground(Void... voids) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
            String color = preferences.getString("colors", "White");
            String rareza = preferences.getString("rarity", "Todas");
            Api api = new Api();



            ArrayList<Carta> result = null;
            if (rareza.equalsIgnoreCase("Todas"))
            {
                result = api.getAllCartas();
            }
            else {
                result = api.getCartasRareza(rareza, color);
            }
*/
/*
            Log.d("DEBUG", result != null ? result.toString() : null);

            return result;
        }


        protected void onPostExecute(ArrayList<Carta> cartas) {
            super.onPostExecute(cartas);
            adapter.clear();
            for (Carta c : cartas) {
                //adapter.add(c.getName());
                adapter.add(c);
            }
        }
    }
    //endregion

}
*/