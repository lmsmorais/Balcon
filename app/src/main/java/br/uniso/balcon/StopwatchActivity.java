package br.uniso.balcon;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class StopwatchActivity extends AppCompatActivity {

    /*Variáveis para executar o cronômetro*/
    private int segundos = 0;
    private boolean executando;
    private boolean estavaExecutando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        executando = true;
        estavaExecutando = true;

        /*Verificando os dados salvos*/
        if(savedInstanceState != null){
            segundos = savedInstanceState.getInt("segundos");
            executando = savedInstanceState.getBoolean("executando");
            estavaExecutando = savedInstanceState.getBoolean("estavaExecutando");

        }

        /*Iniciando o cronômetro*/
        runStopWatch();

    }

    /*Ferramenta para recuperarmos dados desejados*/
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("segundos",segundos);
        savedInstanceState.putBoolean("executando",executando);
        savedInstanceState.putBoolean("estavaExecutando", estavaExecutando);

        super.onSaveInstanceState(savedInstanceState);
    }

    /*Métodos executáveis quando ocorre a perda de foco*/
    protected void onPause(){
        super.onPause();
        estavaExecutando = executando;
        executando = false;
    }

    protected void onResume(){
        super.onResume();
        executando = estavaExecutando;
    }

    /*Ações para os comandos do cronômetro*/
    public void onClickRun(View view){
        executando = true;
    }

    public void onClickStop(View view){
        executando = false;
    }

    public void onClickReset(View view){
        executando = false;
        segundos = 0;
    }


    private void runStopWatch(){
        /*Iniciando variável insubstituível, para que não haja
        * complicações com o timer do cronômetro*/
        final TextView textView = (TextView) findViewById(R.id.txtCronometro);

        /*Interface para executar um fluxo separado*/
        final Handler handler = new Handler();

        /*Método post para agendar uma execução*/
        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        int horas = segundos/360;
                        int minutos = (segundos%360)/60;
                        int segundos_interno = segundos%60;

                        /*Formatando o cronômetro*/
                        String time = String.format(Locale.getDefault(), "%d:%02d:%02d",horas,minutos,segundos_interno);

                        textView.setText(time);

                        /*Condição para incrementar os valores do cronômetro*/
                        if(executando){
                            segundos++;
                        }

                        /*Setando delay para respeitar a verificação de execução*/
                        handler.postDelayed(this,1000);

                    }
                }
        );

    }

    public void mudarTela(View view){
        Intent intent = new Intent(this, BalconMainActivity.class);
        startActivity(intent);
    }
}
