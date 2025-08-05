package com.example.android_assignment_1.post_recycler_view;

public class PostDM {
    private final String userName;
    private final String postMetadata;
    private final String postText;
    private final String postLink;
    private final int postImageResId;
    private final int likesCount;
    private final int sharesCount;

    public PostDM(String userName, String postMetadata, String postText, String postLink, int postImageResId, int likesCount, int sharesCount) {
        this.userName = userName;
        this.postMetadata = postMetadata;
        this.postText = postText;
        this.postLink = postLink;
        this.postImageResId = postImageResId;
        this.likesCount = likesCount;
        this.sharesCount = sharesCount;
    }

    public String getUserName() {
        return userName;
    }

    public String getPostMetadata() {
        return postMetadata;
    }

    public String getPostText() {
        return postText;
    }

    public String getPostLink() {
        return postLink;
    }

    public int getPostImageResId() {
        return postImageResId;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public int getSharesCount() {
        return sharesCount;
    }
}
