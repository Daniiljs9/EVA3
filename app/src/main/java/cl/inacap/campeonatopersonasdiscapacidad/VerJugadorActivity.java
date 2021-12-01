package cl.inacap.campeonatopersonasdiscapacidad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import cl.inacap.campeonatopersonasdiscapacidad.modelo.CampeonatoDatabaseHelper;
import cl.inacap.campeonatopersonasdiscapacidad.modelo.Jugador;

public class VerJugadorActivity extends ListActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void cargarLista() {
        lista = getListView();
        CampeonatoDatabaseHelper helper = new CampeonatoDatabaseHelper(this);
        List<Jugador> jugadorList = helper.listaJugadores();
        ArrayAdapter<Jugador> listaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, jugadorList);
        lista.setAdapter(listaAdapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object ob = lista.getItemAtPosition(i);
                String linea = ob.toString();
                String[] separar = linea.split(":");
                Intent intent = new Intent(VerJugadorActivity.this, InformacionJugadorActivity.class);
                intent.putExtra("nombreJugador", separar[0]);
                startActivityForResult(intent, 1);
            }
        });
/*
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data){
            if(requestCode==1){
                if(resultCode== RESULT_OK){
                    cargarLista();
                }
            }
        }*/
    }
}
