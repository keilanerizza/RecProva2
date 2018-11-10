package keilane.com.recprova2;

import java.util.List;

import keilane.com.recprova2.Modelo.Aluno;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Chamadas {

    @GET("/lista_de_alunos")
    Call<List<Aluno>> obterNotas();
}
