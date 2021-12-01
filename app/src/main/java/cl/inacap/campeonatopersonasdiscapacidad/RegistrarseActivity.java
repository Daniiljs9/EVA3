package cl.inacap.campeonatopersonasdiscapacidad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cl.inacap.campeonatopersonasdiscapacidad.modelo.CampeonatoDatabaseHelper;
import cl.inacap.campeonatopersonasdiscapacidad.modelo.Jugador;

public class RegistrarseActivity extends AppCompatActivity {

    private CampeonatoDatabaseHelper helper = new CampeonatoDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
    }
    public void registrarJugador(View view) {
        String nombre = ((EditText) findViewById(R.id.ingresarNombre)).getText().toString();
        String rut = ((EditText) findViewById(R.id.ingresarRut)).getText().toString();
        String altura = ((EditText) findViewById(R.id.ingresarAltura)).getText().toString();
        String peso = ((EditText) findViewById(R.id.ingresarPeso)).getText().toString();
        int edad = 0;
        String edadString = ((EditText) findViewById(R.id.ingresarEdad)).getText().toString();
        String nacimiento = ((EditText) findViewById(R.id.ingresarNacimiento)).getText().toString();
        String sexo = ((EditText) findViewById(R.id.ingresarSexo)).getText().toString();
        String club = ((EditText) findViewById(R.id.ingresarClub)).getText().toString();
        String discapacidad = ((EditText) findViewById(R.id.ingresarDiscapacidad)).getText().toString();

        try {
            edad = Integer.parseInt(edadString);
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Debe ingresar su edad", Toast.LENGTH_SHORT).show();
        }

        Jugador jugadores = new Jugador(nombre, rut, altura, peso, edad, nacimiento, sexo, club, discapacidad);
        helper.registrarJugador(jugadores);
        finish();
    }
}