package com.example.levon.lebona;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterForPosts extends RecyclerView.Adapter<AdapterForPosts.ViewH>{
    private List<Model> listOfModels;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
       mListener = listener;
    }

    public AdapterForPosts(List<Model> listOfModels) {
        this.listOfModels = listOfModels;
    }

    @NonNull
    @Override
    public ViewH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_style, parent, false);
        return new ViewH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewH holder, int position) {
        Model model = listOfModels.get(position);
        Picasso.get().load(model.getImgUrl()).into(holder.imageView);
        holder.likeCounterText.setText(String.valueOf(model.counters.likeCounter));
    }


    @Override
    public int getItemCount() {
        return listOfModels.size();
    }

    class ViewH extends RecyclerView.ViewHolder{
        ImageButton likeButton;
        ImageButton commentButton;
        Button shareButton;
        ImageView imageView;
        TextView likeCounterText;
        TextView commentCounterText;

        public ViewH(View v) {
            super(v);
            imageView = v.findViewById(R.id.imageforitem);
            likeButton = v.findViewById(R.id.likebutton);
            commentButton = v.findViewById(R.id.commentbutton);
            shareButton = v.findViewById(R.id.sharebutton);
            likeCounterText = v.findViewById(R.id.likecountertext);
            commentCounterText = v.findViewById(R.id.commentcountertext);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                           mListener.onItemClick(position);
                        }
                    }
                }
            });

        }

    }
}
