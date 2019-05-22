package br.com.welson.meucontrole;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class RecuperacaoSenhaActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button recuperarSenhaButton;
    private EditText recuperarSenhaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_recuperacao_senha);

        progressBar = findViewById(R.id.progressBarRecuperacaoSenha);
        recuperarSenhaButton = findViewById(R.id.recuperarSehaButtonRecupecaoSenha);
        recuperarSenhaEditText = findViewById(R.id.recuperacaoSenhaEditTextRecuperacaoSenha);


        progressBar.setVisibility(View.INVISIBLE);

        recuperarSenhaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recuperarSenhaButton.setText("");
                progressBar.setVisibility(View.VISIBLE);
            }
        });

        recuperarSenhaEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                recuperarSenhaButton.performClick();
                return false;
            }
        });
    }
}
