package com.example.printapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Imageviewholder> {
    private int[] image;
    private String[] name;
    private String[] des;
    private String[] price;
    Imageviewholder imageviewholder;
    private Context context;
    public  RecyclerAdapter(){

    }

    public RecyclerAdapter(int[] image, String[] name, String[] des, String[] price, Context context){
        this.image=image;
        this.name=name;
        this.des=des;
        this.price=price;
        this.context=context;

    }

    @NonNull
    @Override
    public Imageviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cartdisplay,viewGroup,false);
         imageviewholder=new Imageviewholder(view,context,name);
        return imageviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Imageviewholder viewHolder, int i) {
    int image_id = image[i];
    String name_id = name[i];
    String des_id = des[i];
    String price_id = price[i];
    viewHolder.imageView.setImageResource(image_id);
    viewHolder.names.setText(name_id);
    viewHolder.des.setText(des_id);
    viewHolder.price.setText(price_id);
    viewHolder.elegantNumberButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           String m=  viewHolder.elegantNumberButton.getNumber();

           Log.d("TAG",m);
           Toast.makeText(context,"hello", Toast.LENGTH_SHORT);
        }
    });
    }

    @Override
    public int getItemCount() {
        return image.length;

    }
    public String getFins(){
        Log.d("RECYCLER",imageviewholder.getFin());
        return imageviewholder.getFin();
    }


public static class Imageviewholder extends RecyclerView.ViewHolder  {
ImageView imageView;
TextView names,des,price;
Context context;
RecyclerAdapter recyclerAdapter = new RecyclerAdapter();
ElegantNumberButton elegantNumberButton;
public static String books = "Book ",pen=" Pen ",pencil=" Pencil",b,p,penn;
Integer i;
    public static String result="",fin =" ";


    public String getFin() {
        Log.d("GETTER ",fin);
        return result;
    }

    public void setFin(String fin) {
        this.fin = fin;
        result =fin;
        Log.d("SETER",result);

    }

    public Imageviewholder(@NonNull View itemView, final Context context, final String[] name) {
        super(itemView);
        imageView = itemView.findViewById(R.id.img);
        names = itemView.findViewById(R.id.name);
        des = itemView.findViewById(R.id.description);
        price = itemView.findViewById(R.id.price);
        elegantNumberButton = (ElegantNumberButton)itemView.findViewById(R.id.elebutton);
        //itemView.setOnClickListener(this);
        this.context=context;
        //this.name=name;
        elegantNumberButton.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                b = elegantNumberButton.getNumber();
                penn = elegantNumberButton.getNumber();
                p = elegantNumberButton.getNumber();
                if(name[getAdapterPosition()].equals("Book")) {

                    books= name[getAdapterPosition()]+" " + b + " ,";

                   // Log.e("TAG",books)
                    }
                else if(name[getAdapterPosition()].equals("Pen"))
                {

                    pen=  name[getAdapterPosition()]+" " + penn + " ,";

                  //  Log.e("TAG",pen);
                }
                else if(name[getAdapterPosition()].equals("Pencil")){


                    pencil =  name[getAdapterPosition()]+ " " + p  + " ,";
                   // Log.e("TAG",pencil);
                }

                fin=books+pen+pencil;

                Log.e("TAG",fin);

        setFin(fin);
            }
        });






    }





}
}