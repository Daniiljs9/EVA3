package cl.inacap.campeonatopersonasdiscapacidad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import cl.inacap.campeonatopersonasdiscapacidad.modelo.CampeonatoDatabaseHelper;
import cl.inacap.campeonatopersonasdiscapacidad.modelo.Jugador;

public class MainActivity extends AppCompatActivity {

    private CampeonatoDatabaseHelper helper = new CampeonatoDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void registrarse(View view) {
        Intent intent = new Intent(this, RegistrarseActivity.class);
        startActivity(intent);
    }

    public void verJugador(View view) {
        try {
            ArrayList<Jugador> jugadores = (ArrayList<Jugador>) helper.listaJugadores();
            Intent intent = new Intent(this, EditarDatosActivity.class);
            startActivity(intent);
        }catch (Exception ex){
            Toast.makeText(this, "No hay jugadores inscritos", Toast.LENGTH_SHORT).show();
        }
    }
}