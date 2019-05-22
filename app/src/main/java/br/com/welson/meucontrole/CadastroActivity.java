package br.com.welson.meucontrole;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import br.com.welson.meucontrole.util.FechaTecladoSubmeteForm;

public class CadastroActivity extends AppCompatActivity {

    private Button criarContaButton;
    private ProgressBar progressBar;
    private EditText senhaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_cadastro);

        criarContaButton = findViewById(R.id.criarContaButtonCadastro);
        progressBar = findViewById(R.id.progressBarCadastro);
        senhaEditText = findViewById(R.id.senhaEditTextCadastro);

        progressBar.setVisibility(View.INVISIBLE);

        criarContaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarContaButton.setEnabled(false);
                criarContaButton.setText("");

                progressBar.setVisibility(View.VISIBLE);
            }
        });

        senhaEditText.setOnEditorActionListener(new FechaTecladoSubmeteForm(criarContaButton));
    }
}
