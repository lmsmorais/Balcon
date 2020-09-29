package br.uniso.balcon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ObsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obs);
    }

        public void onEnviarObs(View view){
            /*Recuperar mensagem digitada*/
            EditText viewMensagem = (EditText) findViewById(R.id.txtEnviarObs);
            String textoMensagem = viewMensagem.getText().toString();

            /*Informando a itnenção*/
            Intent intent = new Intent(Intent.ACTION_SEND);

            /*Informando o tipo de dado enviado*/
            intent.setType("text/plain");

            /*Tratando o envio*/
            intent.putExtra(Intent.EXTRA_TEXT, textoMensagem);

            /*Enviando a intenção como parâmetro*/
            startActivity(intent);

            finish();
        }
}

