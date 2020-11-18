package br.com.local.buscacepwebapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Button btnBuscarCep;
    EditText txtCep;
    TextView lblResposta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCep = findViewById(R.id.txtCep);
        lblResposta = findViewById(R.id.lblResposta);

        btnBuscarCep = findViewById(R.id.btnBuscaCep);

        btnBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    CEP retorno = new HttpService(txtCep.getText().toString()).execute().get();
                    lblResposta.setText(retorno.toString());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}