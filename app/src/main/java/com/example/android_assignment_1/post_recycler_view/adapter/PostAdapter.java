package com.example.android_assignment_1.post_recycler_view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_assignment_1.post_recycler_view.PostDM;
import com.example.android_assignment_1.R;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private final List<PostDM> postList;

    public PostAdapter(List<PostDM> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostDM post = postList.get(position);
        holder.postImage.setImageResource(post.getPostImageResId());
        holder.userName.setText(post.getUserName());
        holder.postMetadata.setText(post.getPostMetadata());
        holder.postText.setText(post.getPostText());
        holder.postLink.setText(post.getPostLink());
        holder.likesCount.setText(String.valueOf(post.getLikesCount()));
        holder.sharesCount.setText(String.valueOf(post.getSharesCount()));
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        ImageView  postImage;
        TextView userName, postMetadata, postText, postLink, likesCount, sharesCount;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            postImage = itemView.findViewById(R.id.post_image);
            userName = itemView.findViewById(R.id.user_name);
            postMetadata = itemView.findViewById(R.id.post_metadata);
            postText = itemView.findViewById(R.id.post_text);
            postLink = itemView.findViewById(R.id.post_link);
            likesCount = itemView.findViewById(R.id.likes_count);
            sharesCount = itemView.findViewById(R.id.shares_count);
        }
    }
}
