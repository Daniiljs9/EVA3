package cl.inacap.campeonatopersonasdiscapacidad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cl.inacap.campeonatopersonasdiscapacidad.modelo.CampeonatoDatabaseHelper;
import cl.inacap.campeonatopersonasdiscapacidad.modelo.Jugador;

public class InformacionJugadorActivity extends AppCompatActivity {

    public Jugador jugador;
    public Intent intent;
    public CampeonatoDatabaseHelper helper = new CampeonatoDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_jugador);
        intent = getIntent();
        String nombreJugador = (String) intent.getExtras().get("nombreJugador");

        jugador = helper.getJugador(nombreJugador);

        TextView txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtNombre.setText(jugador.getNombre());

        TextView txtRut = (TextView) findViewById(R.id.txtRut);
        txtRut.setText(jugador.getRut());

        TextView txtAltura = (TextView) findViewById(R.id.txtAltura);
        txtRut.setText(jugador.getAltura());

        TextView txtPeso = (TextView) findViewById(R.id.txtPeso);
        txtRut.setText(jugador.getPeso());

        TextView txtEdad = (TextView) findViewById(R.id.txtEdad);
        txtRut.setText(jugador.getEdad());

        TextView txtNacimiento = (TextView) findViewById(R.id.txtNacimiento);
        txtRut.setText(jugador.getNacimiento());

        TextView txtSexo = (TextView) findViewById(R.id.txtSexo);
        txtRut.setText(jugador.getSexo());

        TextView txtClub = (TextView) findViewById(R.id.txtClub);
        txtRut.setText(jugador.getClub());

        TextView txtDiscapacidad = (TextView) findViewById(R.id.txtDiscapacidad);
        txtRut.setText(jugador.getDiscapacidad());

    }

    public void eliminar(View view){
        String msg = helper.eliminarJugador();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

/*
    public void actualizarJugador(View view){
        jugador.setNombre(!jugador.);
        String mensaje = helper.actualizarJugador(jugador);
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();

        setResult(RESULT_OK, intent);
        finish();
        }*/
    }

