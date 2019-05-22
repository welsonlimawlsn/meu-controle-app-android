package br.com.welson.meucontrole.util;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;

public class FechaTecladoSubmeteForm implements TextView.OnEditorActionListener {

    private Button buttonQueExecutaAcao;

    public FechaTecladoSubmeteForm(Button buttonQueExecutaAcao) {
        this.buttonQueExecutaAcao = buttonQueExecutaAcao;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            buttonQueExecutaAcao.performClick();
        }
        return false;
    }
}
