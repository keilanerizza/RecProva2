package keilane.com.recprova2;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import keilane.com.recprova2.Modelo.Aluno;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {
    private final String BASE_URL = "http://angoti.atwebpages.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chamada();
    }

    private Chamadas getRetrofit() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        return (new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()).create(Chamadas.class);
    }

    private void chamada() {
        Call<List<Aluno>> call = getRetrofit().obterNotas();
        call.enqueue(new Callback<List<Aluno>>() {//chamada assíncrona

            public void onResponse(Call<List<Aluno>> call, Response<List<Aluno>> response) {
                Log.i("teste", "alo");
                int statusCode = response.code();
                List<Aluno> alunos = response.body();
                ((ListView)findViewById(R.id.list)).setAdapter(new AlunoAdapter(MainActivity.this, alunos));
            }

            public void onFailure(Call<List<Aluno>> call, Throwable t) {

                // Log error here since request failed
                Log.i("teste", t.toString());
            }
        });
    }
}
