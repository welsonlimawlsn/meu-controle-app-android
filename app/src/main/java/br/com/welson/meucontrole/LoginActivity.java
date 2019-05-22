package br.com.welson.meucontrole;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import br.com.welson.meucontrole.util.FechaTecladoSubmeteForm;

public class LoginActivity extends AppCompatActivity {

    private Button entrarButton;
    private ProgressBar progressBar;
    private TextView criarContaTextView;
    private TextView senhaTextView;
    private TextView recuperarSenhaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_login);

        entrarButton = findViewById(R.id.entrarButtonLogin);
        progressBar = findViewById(R.id.progressBarLogin);
        criarContaTextView = findViewById(R.id.crirContaTextViewLogin);
        senhaTextView = findViewById(R.id.senhaEditTextLogin);
        recuperarSenhaTextView = findViewById(R.id.esqueciSenhaTextViewLogin);

        progressBar.setVisibility(View.INVISIBLE);

        entrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrarButton.setText("");
                entrarButton.setEnabled(false);

                criarContaTextView.setEnabled(false);
                recuperarSenhaTextView.setEnabled(false);

                progressBar.setVisibility(View.VISIBLE);
            }
        });

        criarContaTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CadastroActivity.class));
            }
        });

        senhaTextView.setOnEditorActionListener(new FechaTecladoSubmeteForm(entrarButton));

        recuperarSenhaTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RecuperacaoSenhaActivity.class));
            }
        });
    }
}
