package br.uniso.balcon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SendMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
    }

    /* Comunicação com intenções fora da aplicação */

    public void onEnviarPedido(View view){
        /* Recuperar mensagem digitada pelo usuário no campo EditText */
        EditText viewMensagem = (EditText) findViewById(R.id.txtMensagemEnviada);
        String textoMensagem = viewMensagem.getText().toString();

        /* Informando a inteção */
        Intent intent = new Intent(Intent.ACTION_SEND);

        /* Inforamndo o tipo de dado enviado */
        intent.setType("text/plain");

        /* Tratando o envio */
        intent.putExtra(Intent.EXTRA_TEXT, textoMensagem);

        /* Enviando a inteção como parâmetro */
        startActivity(intent);

    }
}
