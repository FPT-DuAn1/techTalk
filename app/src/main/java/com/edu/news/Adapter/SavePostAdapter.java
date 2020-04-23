package com.edu.news.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.edu.news.Models.SavePost;
import com.edu.news.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;


public class SavePostAdapter extends RecyclerView.Adapter<SavePostAdapter.MyViewHolder> {

    private Context mCtx;
    private List<SavePost> savePostList;

    public SavePostAdapter(Context mCtx, List<SavePost> savePostList){
        this.mCtx = mCtx;
        this.savePostList = savePostList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.row_post_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvTitle.setText(savePostList.get(position).getPostTitle());
        Glide.with(mCtx).load(savePostList.get(position).getPostPicture()).into(holder.imgPost);
        Glide.with(mCtx).load(savePostList.get(position).getPostUserPhoto()).into(holder.imgPostProfile);
    }

    @Override
    public int getItemCount() {
        return savePostList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements CompoundButton.OnCheckedChangeListener {

        TextView tvTitle;
        ImageView imgPost;
        ImageView imgPostProfile;
        CheckBox btnSavePost;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.row_post_title);
            imgPost = itemView.findViewById(R.id.row_post_img);
            imgPostProfile = itemView.findViewById(R.id.row_post_profile_img);
            btnSavePost = itemView.findViewById(R.id.btnSavePost);

            btnSavePost.setOnCheckedChangeListener(this);
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean b) {
            //Test tạo favorite
//            if(FirebaseAuth.getInstance().getCurrentUser() == null){
//                Toast.makeText(mCtx, "Xin hãy đăng nhập...", Toast.LENGTH_SHORT).show();
//                buttonView.setChecked(false);
//                return;
//            }

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference dbFav = database.getReference("SavePost").push();


            int position = getAdapterPosition();
            SavePost savePost = savePostList.get(position);

            if(buttonView.isChecked()){
                //dbFav.child(savePost.postKey).setValue(savePost);
                Toast.makeText(buttonView.getContext(), "Hello", Toast.LENGTH_SHORT).show();
            }else {
                //dbFav.child(savePost.postKey).setValue(null);
            }

        }
    }
}
