package com.harshharsora.cityguide.HelperClasses.HomeAdapter;

public class FeaturedHelperClass {
    int image;
    String title,description;

    public FeaturedHelperClass(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public FeaturedHelperClass(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
}

