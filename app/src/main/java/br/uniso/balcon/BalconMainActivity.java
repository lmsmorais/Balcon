package br.uniso.balcon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BalconMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button enviarPedido = (Button) findViewById(R.id.btnEnviarPedidoMain);


        enviarPedido.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(BalconMainActivity.this, SendMessageActivity.class);
                startActivity(intent);
            }
        });

    }
}