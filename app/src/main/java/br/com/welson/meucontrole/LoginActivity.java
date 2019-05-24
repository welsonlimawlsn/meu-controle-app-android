package br.com.welson.meucontrole;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import br.com.welson.meucontrole.modelos.RestException;
import br.com.welson.meucontrole.modelos.Token;
import br.com.welson.meucontrole.modelos.Usuario;
import br.com.welson.meucontrole.util.Api;
import br.com.welson.meucontrole.util.FechaTecladoSubmeteForm;
import br.com.welson.meucontrole.util.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private Button entrarButton;
    private ProgressBar progressBar;
    private TextView criarContaTextView;
    private TextView senhaTextView;
    private TextView recuperarSenhaTextView;
    private TextView usuarioTextView;

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
        usuarioTextView = findViewById(R.id.usuarioEditTextLogin);

        progressBar.setVisibility(View.INVISIBLE);

        entrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetButtons("", false, View.VISIBLE);

                fazerLogin();
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

    private void fazerLogin() {
        UsuarioService usuarioService = Api.getInstance().create(UsuarioService.class);

        usuarioService.login(getUsuario(), Util.getDeviceId(getContentResolver())).enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if (response.code() == 200) {
                    Util.setTokenSharedPreferences(getApplicationContext(), response.body());
                    redirecionarMainActivity();
                } else {
                    resetButtons(getString(R.string.entrar), true, View.INVISIBLE);

                    try {
                        Toast.makeText(getApplicationContext(), new Gson().fromJson(response.errorBody().string(), RestException.class).getMessage(), Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                resetButtons(getString(R.string.entrar), true, View.INVISIBLE);
            }
        });
    }

    private void redirecionarMainActivity() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    private void resetButtons(String entrar, boolean enableButtons, int invisible) {
        entrarButton.setText(entrar);
        entrarButton.setEnabled(enableButtons);

        criarContaTextView.setEnabled(enableButtons);
        recuperarSenhaTextView.setEnabled(enableButtons);
        progressBar.setVisibility(invisible);
    }

    private Usuario getUsuario() {
        Usuario usuario = new Usuario();
        usuario.setUsuario(usuarioTextView.getText().toString());
        usuario.setSenha(senhaTextView.getText().toString());
        return usuario;
    }
}
