package monzonis.ioc.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorDatos extends RecyclerView.Adapter<AdaptadorDatos.ViewHolderCategoria> {

    ArrayList<String> listaCategorias;
    private View.OnClickListener listener;

    public AdaptadorDatos(ArrayList<String> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    @NonNull
    @Override
    public ViewHolderCategoria onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_categorias,null,false);
        //view.setOnClickListener(this);
        return new ViewHolderCategoria(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCategoria holder, int position) {
        holder.asignarDatos(listaCategorias.get(position));

    }

    @Override
    public int getItemCount() {
        return listaCategorias.size();
    }

    public void setOnClickListener (View.OnClickListener listener){
        this.listener=listener;
    }

    public class ViewHolderCategoria extends RecyclerView.ViewHolder {

        TextView categoria;

        public ViewHolderCategoria(@NonNull View itemView) {
            super(itemView);
            categoria = (TextView) itemView.findViewById(R.id.idDatos);
        }

        public void asignarDatos(String libros) {

            categoria.setText(libros);
        }
    }
}
