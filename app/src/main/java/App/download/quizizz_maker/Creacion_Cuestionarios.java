package App.download.quizizz_maker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




public class Creacion_Cuestionarios extends AppCompatActivity {
    BaseDeDatos cuestionarios;
    String accion = "";
    String Id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion_cuestionarios);

        mostrardatos();

    }

    public void GuardarQuizz(View v) {
        final EditText tNombre = (EditText) this.findViewById(R.id.NombreQuizz);
        final EditText Tcategoria = (EditText) this.findViewById(R.id.Categotia);
        final EditText tPregunta = (EditText) this.findViewById(R.id.pregunta);
        final EditText tCorrecto = (EditText) this.findViewById(R.id.respCorrecta_1_);
        final EditText tIncorrecto1 = (EditText) this.findViewById(R.id.respIncorrecta_1_);
        final EditText tIncorrecto2 = (EditText) this.findViewById(R.id.respIncorrecta_1_2);
        final EditText tIncorrecto3 = (EditText) this.findViewById(R.id.respIncorrecta_1_3);
        final EditText tPregunta2 = (EditText) this.findViewById(R.id.pregunta2);
        final EditText tCorrecto2 = (EditText) this.findViewById(R.id.respCorrecta_1_2);
        final EditText tIncorrecto2_1 = (EditText) this.findViewById(R.id.respIncorrecta_2_1);
        final EditText tIncorrecto2_2 = (EditText) this.findViewById(R.id.respIncorrecta_2_2);
        final EditText tIncorrecto2_3 = (EditText) this.findViewById(R.id.respIncorrecta_2_3);
        String Nombre = tNombre.getText().toString();
        String categoria = Tcategoria.getText().toString();
        String Pregunta = tPregunta.getText().toString();
        String Correcto = tCorrecto.getText().toString();
        String Incorrecto1 = tIncorrecto1.getText().toString();
        String Incorrecto2 = tIncorrecto2.getText().toString();
        String Incorrecto3 = tIncorrecto3.getText().toString();
        String Pregunta2 = tPregunta2.getText().toString();
        String Correcto2 = tCorrecto2.getText().toString();
        String Incorrecto2_1 = tIncorrecto2_1.getText().toString();
        String Incorrecto2_2 = tIncorrecto2_2.getText().toString();
        String Incorrecto2_3 = tIncorrecto2_3.getText().toString();
        try{


            cuestionarios = new BaseDeDatos(Creacion_Cuestionarios.this, "",null,1);
            cuestionarios.guardarCuestionario( Nombre, categoria,  Pregunta,Correcto,Incorrecto1,Incorrecto2,Incorrecto3,Pregunta2,Correcto2,Incorrecto2_1,Incorrecto2_2,Incorrecto2_3,accion,Id);
            Toast.makeText(Creacion_Cuestionarios.this, "Listo, Cuestionario registrado con exito", Toast.LENGTH_LONG).show();
            Intent imostrar= new Intent(Creacion_Cuestionarios.this, Cuestionario_disponible_Docente.class);
            startActivity(imostrar);
        }
        catch(Exception ex){
            Toast.makeText(Creacion_Cuestionarios.this, "Error: "+ ex.getMessage().toString(), Toast.LENGTH_LONG).show();
        }


    }




public void mostrardatos(){
        try {
            Bundle bundle = getIntent().getExtras();
            accion = bundle.getString("accion");
            if (accion.equals("modificar")) {
                Id = bundle.getString("id");
                String user[] = bundle.getStringArray("user");
                TextView tempVal = (TextView) findViewById(R.id.NombreQuizz);
                tempVal.setText(user[0].toString());
                tempVal = (TextView) findViewById(R.id.Categotia);
                tempVal.setText(user[1].toString());
                tempVal = (TextView) findViewById(R.id.pregunta);
                tempVal.setText(user[2].toString());
                tempVal  = (TextView) findViewById(R.id.respCorrecta_1_);
                tempVal.setText(user[3].toString());
                tempVal = (TextView) findViewById(R.id.respIncorrecta_1_);
                tempVal.setText(user[4].toString());
                tempVal = (TextView) findViewById(R.id.respIncorrecta_1_2);
                tempVal.setText(user[5].toString());
                tempVal = (TextView) findViewById(R.id.respIncorrecta_1_3);
                tempVal.setText(user[6].toString());
                tempVal = (TextView) findViewById(R.id.pregunta2);
                tempVal.setText(user[7].toString());
                tempVal = (TextView) findViewById(R.id.respCorrecta_1_2);
                tempVal.setText(user[8].toString());
                tempVal = (TextView) findViewById(R.id.respIncorrecta_2_1);
                tempVal.setText(user[9].toString());
                tempVal = (TextView) findViewById(R.id.respIncorrecta_2_2);
                tempVal.setText(user[10].toString());
                tempVal = (TextView) findViewById(R.id.respIncorrecta_2_3);
                tempVal.setText(user[11].toString());

            }
        }catch (Exception e){
            Toast.makeText(Creacion_Cuestionarios.this, "Error: "+ e.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
        }

    }
}