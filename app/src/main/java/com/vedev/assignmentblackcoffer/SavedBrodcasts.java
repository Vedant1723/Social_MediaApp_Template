package com.vedev.assignmentblackcoffer;

import de.hdodenhof.circleimageview.CircleImageView;

public class SavedBrodcasts {

    private CircleImageView userDp;
    private String userName,userLocation,brodCastDescription,tags,userDesig;

    public SavedBrodcasts(CircleImageView userDp, String userName, String userLocation, String brodCastDescription, String tags, String userDesig) {
        this.userDp = userDp;
        this.userName = userName;
        this.userLocation = userLocation;
        this.brodCastDescription = brodCastDescription;
        this.tags = tags;
        this.userDesig = userDesig;
    }

    public CircleImageView getUserDp() {
        return userDp;
    }

    public void setUserDp(CircleImageView userDp) {
        this.userDp = userDp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getBrodCastDescription() {
        return brodCastDescription;
    }

    public void setBrodCastDescription(String brodCastDescription) {
        this.brodCastDescription = brodCastDescription;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getUserDesig() {
        return userDesig;
    }

    public void setUserDesig(String userDesig) {
        this.userDesig = userDesig;
    }
}
