package com.edu.news.Models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.ServerValue;

public class SavePost {
    @Exclude
    public String postKey;
    public String postTitle, postDescription, postPicture, postUserId, postUserPhoto, postUsername;
    private Object timeStamp;

    public SavePost(String postKey, String postTitle, String postDescription, String postPicture, String postUserId, String postUserPhoto, String postUsername, Object timeStamp) {
        this.postKey = postKey;
        this.postTitle = postTitle;
        this.postDescription = postDescription;
        this.postPicture = postPicture;
        this.postUserId = postUserId;
        this.postUserPhoto = postUserPhoto;
        this.postUsername = postUsername;
        this.timeStamp = ServerValue.TIMESTAMP;
    }

    public SavePost(){

    }

    public String getPostKey() {
        return postKey;
    }

    public void setPostKey(String postKey) {
        this.postKey = postKey;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getPostPicture() {
        return postPicture;
    }

    public void setPostPicture(String postPicture) {
        this.postPicture = postPicture;
    }

    public String getPostUserId() {
        return postUserId;
    }

    public void setPostUserId(String postUserId) {
        this.postUserId = postUserId;
    }

    public String getPostUserPhoto() {
        return postUserPhoto;
    }

    public void setPostUserPhoto(String postUserPhoto) {
        this.postUserPhoto = postUserPhoto;
    }

    public String getPostUsername() {
        return postUsername;
    }

    public void setPostUsername(String postUsername) {
        this.postUsername = postUsername;
    }

    public Object getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Object timeStamp) {
        this.timeStamp = timeStamp;
    }
}
