package br.com.welson.meucontrole;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import br.com.welson.meucontrole.util.Util;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String token = Util.getTokenSharedPreferences(this);
        if (token == null) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        } else {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }
}
