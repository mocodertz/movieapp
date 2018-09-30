package com.jengasoft.movietheater;

import java.io.Serializable;

/**
 * Created by MoCoder#1956# on 3/31/2018.
 */

public class Movie implements Serializable {
    private String title;
    private String description;
    private String runningTime;
    private String releaseDate;
    private String posterLink;
    private String coverLink;
    private String belongTo;
    private String ratingCount;

    public Movie(String title, String description, String runningTime,
                 String releaseDate, String posterLink, String coverLink,
                 String belongTo, String ratingCount) {
        this.title = title;
        this.description = description;
        this.runningTime = runningTime;
        this.releaseDate = releaseDate;
        this.posterLink = posterLink;
        this.coverLink = coverLink;
        this.belongTo = belongTo;
        this.ratingCount = ratingCount;
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

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPosterLink() {
        return posterLink;
    }

    public void setPosterLink(String posterLink) {
        this.posterLink = posterLink;
    }

    public String getCoverLink() {
        return coverLink;
    }

    public void setCoverLink(String coverLink) {
        this.coverLink = coverLink;
    }

    public String getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo;
    }

    public String getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(String ratingCount) {
        this.ratingCount = ratingCount;
    }
}
