package keilane.com.recprova2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import keilane.com.recprova2.Modelo.Aluno;

public class AlunoAdapter extends BaseAdapter {

    Context contexto;
    List<Aluno> lista;

    public AlunoAdapter(Context contexto, List<Aluno> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View linha = LayoutInflater.from(contexto).inflate(R.layout.list_item, null);
        Aluno aluno = lista.get(position);

        TextView nome = (TextView) linha.findViewById(R.id.nome_aluno);
        TextView nota = (TextView) linha.findViewById(R.id.nota_aluno);
        ImageView circle = (ImageView) linha.findViewById(R.id.circle);

        if(aluno.getNota() >= 6){
            circle.setImageResource(R.drawable.blue_circle);
        }
        else {
            circle.setImageResource(R.drawable.red_circle);
        }

        nome.setText(aluno.getNome() + "");
        nota.setText(aluno.getNota() + "");
        return linha;
    }
}
