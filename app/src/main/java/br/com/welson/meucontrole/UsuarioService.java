package br.com.welson.meucontrole;

import br.com.welson.meucontrole.modelos.Token;
import br.com.welson.meucontrole.modelos.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UsuarioService {

    @POST("login")
    Call<Token> login(@Body Usuario usuario, @Header("Device-Id") String deviceId);
}
