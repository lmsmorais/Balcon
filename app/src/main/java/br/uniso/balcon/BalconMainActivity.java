package br.uniso.balcon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BalconMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /*Tratando o botão para relizar pedidos, redirecionando para outra atividade*/
    public void onPedido(View view){
        Intent send = new Intent(this, SendMessageActivity.class);
        startActivity(send);

        /*Alterando o texto em branco pra explicitar a ação do botão*/
        TextView textPedido = findViewById(R.id.txtMensagemMain);
        textPedido.setText("Registrando pedido...");
    }

    /*Tratando o botão para contar a horas de trabalho, redirecionando para outra atividade*/
    public void onHorasTrabalhadas (View view){
        finish();
        Intent watch = new Intent(BalconMainActivity.this, StopwatchActivity.class);
        //startActivity(watch);

        /*alterando o texto em branco para explicitar a ação do botão*/
        TextView textHoras = findViewById(R.id.txtMensagemMain);
        textHoras.setText("Total de horas trabalhadas...");
    }

    /*Tratando o botão para enviar uma observação*/
    public void onObs(View view) {
        Intent observacao = new Intent(BalconMainActivity.this, ObsActivity.class);
        startActivity(observacao);

        /*Alterando o texto em branco para explicitar a ação do botão*/
        TextView textObs = findViewById(R.id.txtMensagemMain);
        textObs.setText("Enviando observação...");
    }

}


