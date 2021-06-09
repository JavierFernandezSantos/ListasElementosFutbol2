package com.example.listaselementosfutbol;

import android.view.View;
import android.view.ViewGroup;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private ArrayList<String[]> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    Adaptador(Context context) {
        this.mInflater = LayoutInflater.from(context);
        mData = new ArrayList<String[]>();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_elementos, parent, false);
        return new ViewHolder(view);
    }

    //Actualizar datos de un viewholder ya existente
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String[] partido=mData.get(position);
        holder.equipo1.setText(partido[0]);
        holder.marcador1.setText(partido[1]);
        holder.guion.setText(partido[2]);
        holder.marcador2.setText(partido[3]);
        holder.equipo2.setText(partido[4]);
    }

    //Numero de filas
    @Override
    public int getItemCount() {
        return mData.size();
    }
    //Añade la informacion
    public void addData(ArrayList<String[]> info) {
        mData.addAll(info);
        notifyDataSetChanged();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
       TextView equipo1;
       TextView equipo2;
       TextView marcador1;
       TextView marcador2;
       TextView guion;


        ViewHolder(View itemView) {
            super(itemView);
            equipo1=itemView.findViewById(R.id.txtEquipo1);
            equipo2=itemView.findViewById(R.id.txtEquipo2);
            marcador1=itemView.findViewById(R.id.txtMarcador1);
            marcador2=itemView.findViewById(R.id.txtMarcador2);
            guion=itemView.findViewById(R.id.txtGuion);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }


    // convenience method for getting data at click position
    String[] getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}