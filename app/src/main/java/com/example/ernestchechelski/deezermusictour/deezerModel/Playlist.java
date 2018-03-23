package com.example.ernestchechelski.deezermusictour.deezerModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ernest.chechelski on 23-Mar-18.
 */

public class Playlist {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("public")
    @Expose
    private Boolean _public;
    @SerializedName("is_loved_track")
    @Expose
    private Boolean isLovedTrack;
    @SerializedName("collaborative")
    @Expose
    private Boolean collaborative;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("nb_tracks")
    @Expose
    private Integer nbTracks;
    @SerializedName("fans")
    @Expose
    private Integer fans;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("share")
    @Expose
    private String share;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("picture_small")
    @Expose
    private String pictureSmall;
    @SerializedName("picture_medium")
    @Expose
    private String pictureMedium;
    @SerializedName("picture_big")
    @Expose
    private String pictureBig;
    @SerializedName("picture_xl")
    @Expose
    private String pictureXl;
    @SerializedName("checksum")
    @Expose
    private String checksum;
    @SerializedName("tracklist")
    @Expose
    private String tracklist;
    @SerializedName("creation_date")
    @Expose
    private String creationDate;
    @SerializedName("creator")
    @Expose
    private Creator creator;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("tracks")
    @Expose
    private PlaylistTracks tracks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Boolean getPublic() {
        return _public;
    }

    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    public Boolean getIsLovedTrack() {
        return isLovedTrack;
    }

    public void setIsLovedTrack(Boolean isLovedTrack) {
        this.isLovedTrack = isLovedTrack;
    }

    public Boolean getCollaborative() {
        return collaborative;
    }

    public void setCollaborative(Boolean collaborative) {
        this.collaborative = collaborative;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getNbTracks() {
        return nbTracks;
    }

    public void setNbTracks(Integer nbTracks) {
        this.nbTracks = nbTracks;
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPictureSmall() {
        return pictureSmall;
    }

    public void setPictureSmall(String pictureSmall) {
        this.pictureSmall = pictureSmall;
    }

    public String getPictureMedium() {
        return pictureMedium;
    }

    public void setPictureMedium(String pictureMedium) {
        this.pictureMedium = pictureMedium;
    }

    public String getPictureBig() {
        return pictureBig;
    }

    public void setPictureBig(String pictureBig) {
        this.pictureBig = pictureBig;
    }

    public String getPictureXl() {
        return pictureXl;
    }

    public void setPictureXl(String pictureXl) {
        this.pictureXl = pictureXl;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public String getTracklist() {
        return tracklist;
    }

    public void setTracklist(String tracklist) {
        this.tracklist = tracklist;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PlaylistTracks getTracks() {
        return tracks;
    }

    public void setTracks(PlaylistTracks tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", _public=" + _public +
                ", isLovedTrack=" + isLovedTrack +
                ", collaborative=" + collaborative +
                ", rating=" + rating +
                ", nbTracks=" + nbTracks +
                ", fans=" + fans +
                ", link='" + link + '\'' +
                ", share='" + share + '\'' +
                ", picture='" + picture + '\'' +
                ", pictureSmall='" + pictureSmall + '\'' +
                ", pictureMedium='" + pictureMedium + '\'' +
                ", pictureBig='" + pictureBig + '\'' +
                ", pictureXl='" + pictureXl + '\'' +
                ", checksum='" + checksum + '\'' +
                ", tracklist='" + tracklist + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", creator=" + creator +
                ", type='" + type + '\'' +
                ", tracks=" + tracks +
                '}';
    }
}