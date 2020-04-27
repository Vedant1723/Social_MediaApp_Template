package com.vedev.assignmentblackcoffer;

public class Tags {
    private String tagTitle,noOfTags;

    public Tags(String tagTitle, String noOfTags) {
        this.tagTitle = tagTitle;
        this.noOfTags = noOfTags;
    }

    public String getTagTitle() {
        return tagTitle;
    }

    public void setTagTitle(String tagTitle) {
        this.tagTitle = tagTitle;
    }

    public String getNoOfTags() {
        return noOfTags;
    }

    public void setNoOfTags(String noOfTags) {
        this.noOfTags = noOfTags;
    }
}
