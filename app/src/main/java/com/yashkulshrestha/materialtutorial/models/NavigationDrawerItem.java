package com.yashkulshrestha.materialtutorial.models;

import com.yashkulshrestha.materialtutorial.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Yash Kulshrestha on 2/27/2016.
 */
public class NavigationDrawerItem {

    private String title;
    private int imageId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public static List<NavigationDrawerItem> getData() {
        List<NavigationDrawerItem> dataList = new ArrayList<>();

        int[] imageIds = getImages();
        String[] titles = getTitles();

        for (int i = 0; i < titles.length; i++) {
            NavigationDrawerItem navItem = new NavigationDrawerItem();
            navItem.setTitle(titles[i]);
            navItem.setImageId(imageIds[i]);
            dataList.add(navItem);
        }

        return dataList;
    }

    private static String[] getTitles() {
        return new String[] {
                "3D Rotation",
                "Developer Board",
                "Fingerprint",
                "Multiline Chart",
                "Track Changes"
        };
    }

    private static int[] getImages() {
        return new int[] {
                R.drawable.ic_3d_rotation_black_24dp,
                R.drawable.ic_developer_board_black_24dp,
                R.drawable.ic_fingerprint_black_24dp,
                R.drawable.ic_multiline_chart_black_24dp,
                R.drawable.ic_track_changes_black_24dp
        };
    }
}
