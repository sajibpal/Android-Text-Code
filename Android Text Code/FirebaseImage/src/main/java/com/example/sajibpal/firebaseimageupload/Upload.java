package com.example.sajibpal.firebaseimageupload;

import com.google.firebase.database.Exclude;

public class Upload {
    private String imgName;
    private String imgUrl;
    String key;

    @Exclude
    public String getKey() {
        return key;
    }
    @Exclude
    public void setKey(String key) {
        this.key = key;
    }

    public Upload() {
    }

    public Upload(String imgName, String imgUrl) {
        if(imgName.trim().equals(""))
        {
            imgName="No name"; //if image name not found editext then default no name
        }
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


}
