package com.yashkulshrestha.materialtutorial.models;

import com.yashkulshrestha.materialtutorial.R;

import java.util.ArrayList;

/**
 * Created by Yash Kulshrestha on 2/13/2016.
 */
public class SampleCard {

    private int imageId;
    private String title;
    private String description;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ArrayList<SampleCard> getData() {

        ArrayList<SampleCard> dataList = new ArrayList<>();

        int[] images = getImages();

        for (int i = 0; i < images.length; i++) {
            SampleCard sampleCard = new SampleCard();
            sampleCard.setImageId(images[i]);
            sampleCard.setTitle("Sample Card" + i);
            sampleCard.setDescription("Description");

            dataList.add(sampleCard);
        }

        return dataList;
    }

    public static int[] getImages() {
        int[] images = {
                R.drawable.common_google_signin_btn_icon_dark,
                R.drawable.common_google_signin_btn_icon_light,
                R.drawable.common_google_signin_btn_text_dark,
                R.drawable.common_google_signin_btn_text_light,
                R.drawable.common_ic_googleplayservices,
                R.drawable.common_plus_signin_btn_text_dark,
                R.drawable.common_plus_signin_btn_icon_dark,
                R.drawable.common_plus_signin_btn_icon_light,
                R.drawable.common_plus_signin_btn_text_light
        };

        return images;
    }

}
