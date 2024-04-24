package com.example.famousgreatromanians;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonalitatiAdaptor extends RecyclerView.Adapter<PersonalitatiAdaptor.PersonalitatiRowHolder> {
    //cream parametri de pus in (Constructorul) Adaptorul nostru
    ArrayList<Personalitate> personaliateData;
    Context context;
    MyClickInterface myClickInterface;
    View overlayView;


    //cream Costructorul
    public PersonalitatiAdaptor(ArrayList<Personalitate> personaliateData, Context context, MyClickInterface myClickInterface){
        this.personaliateData = personaliateData;
        this.context = context;
        this.myClickInterface = myClickInterface;
    }

    @NonNull
    @Override
    public PersonalitatiRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.personalitati_row, parent,false);
        return new PersonalitatiRowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonalitatiRowHolder holder, int position) {
        holder.txtPersonalitatiNume.setText(personaliateData.get(position).getName());
        holder.imgPersonalitati.setImageResource(personaliateData.get(position).getImage());


        //mai jos am vrut sa evidentiez card-ul din mijloc, marindu-l sau intunecandu-le pe cele de
        // mai sus sau mai de jos. NU am reusit inca

        //Personalitate view = personaliateData.get(position);
       // holder.bind(personaliateData);

//        boolean isCenterItem = position == getItemCount() / 2;
//
//        if (isCenterItem) {
//            // Emphasize the card view in the center
//            ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
//            layoutParams.height = 300; // set a higher height for emphasis
//                    holder.itemView.setLayoutParams(layoutParams);
//        } else {
//            // Reset the layout parameters for other items
//            ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
//            layoutParams.height = 250;// set the original height
//                    holder.itemView.setLayoutParams(layoutParams);
//        }
    }


//
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        MyItem currentItem = mItems.get(position);
//        holder.bind(currentItem);
//
//        // Determine if the current item is at the center position
//        boolean isCenterItem = position == getItemCount() / 2;
//
//        // Adjust the layout parameters based on position
//        if (isCenterItem) {
//            // Emphasize the card view in the center
//            ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
//            layoutParams.height = // set a higher height for emphasis
//                    holder.itemView.setLayoutParams(layoutParams);
//        } else {
//            // Reset the layout parameters for other items
//            ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
//            layoutParams.height = // set the original height
//                    holder.itemView.setLayoutParams(layoutParams);
//        }
//    }
//



    @Override
    public int getItemCount() {
        return personaliateData.size();
    }



    class PersonalitatiRowHolder extends RecyclerView.ViewHolder{

        //declar TextView si ImageView din Carduri, dar cu alte nume, nu ID-urile lor aici
        TextView txtPersonalitatiNume;
        ImageView imgPersonalitati;
        //View overlayView;


        public PersonalitatiRowHolder(@NonNull View itemView) {
            super(itemView);

            //initializam cele 2 componente ale cardurilor, iar findViewById nu exista aici, ci e
            //chemat de Views, prin itemView (de mai sus: "(View itemView") = e cardul nostru)
            txtPersonalitatiNume = itemView.findViewById(R.id.txt_nume_personalitati);
            imgPersonalitati = itemView.findViewById(R.id.img_personalitati);

           // overlayView = itemView.findViewById(R.id.overlayView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myClickInterface.onItemClick(getAdapterPosition());
                }
            });


        }
    }


    interface MyClickInterface{
        void onItemClick(int positionOfThePersonalitate);
    }
}
