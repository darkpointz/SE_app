package com.example.seapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    Context mContext;
    List<Post> mData;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase database;
    private FirebaseUser user;
    private DatabaseReference mRef;


    public PostAdapter(Context mContext, List<Post> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.post_row,parent,false);
        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final Post post = mData.get(position);
        holder.profile_name.setText(mData.get(position).getName());
        holder.post_detail.setText(mData.get(position).getDetail());
        holder.profile_img.setImageResource(mData.get(position).getPic());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //Toast.makeText(mContext,"You Click"+post.getName(),Toast.LENGTH_LONG).show();
               Intent intent = new Intent(mContext, PostDetials.class);
               intent.putExtra("PostKey",mData.get(position).getPostKey().toString());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout layout;
        TextView profile_name,post_detail;
        ImageView profile_img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            post_detail = (TextView) itemView.findViewById(R.id.home_post_detail);
            profile_name = (TextView) itemView.findViewById(R.id.home_post_username);
            profile_img = (ImageView) itemView.findViewById(R.id.home_post_image);
            layout = (ConstraintLayout)itemView.findViewById(R.id.postLayout);

        }


    }


}
