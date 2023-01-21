package monzonis.ioc.recyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    ArrayList<String> listaCategorias;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler= (RecyclerView)  findViewById(R.id.recyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));

        listaCategorias = new ArrayList<String>();
        listaCategorias.add("Ciencia");
        listaCategorias.add("Tecnologia");
        listaCategorias.add("Salud");
        listaCategorias.add("Tiempo");
        listaCategorias.add("Economia");

        AdaptadorDatos adaptador = new AdaptadorDatos(listaCategorias);
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Seleccion: "+ listaCategorias.get(recycler.getChildAdapterPosition(view)),Toast.LENGTH_SHORT).show();
            }
        } );
        recycler.setAdapter(adaptador);


    }

    @Override
    public void onClick(View v) {
        int position= listaCategorias.size() ;
        listaCategorias.add ("");
        recycler.getAdapter().notifyItemInserted(position);
        recycler.smoothScrollToPosition(position);
        String element = listaCategorias.get(position);
        listaCategorias .set(position, "Clicked " + element);
    }
}