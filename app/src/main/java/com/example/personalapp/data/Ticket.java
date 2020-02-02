package com.example.personalapp.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Ticket extends RealmObject implements Parcelable {

    @SerializedName("EventId")
    @Expose
    @PrimaryKey
    private String mEventId;
    @SerializedName("EventDate")
    @Expose
    private String eventDate;
    @SerializedName("EventTime")
    @Expose
    private String eventTime;
    @SerializedName("ArtistID")
    @Expose
    private String artistID;
    @SerializedName("ArtistName")
    @Expose
    private String artistName;
    @SerializedName("ArtistImage")
    @Expose
    private String artistImage;
    @SerializedName("ArtiestPopularity")
    @Expose
    private String artiestPopularity;
    @SerializedName("ArtistTourName")
    @Expose
    private String artistTourName;
    @SerializedName("VenueID")
    @Expose
    private String venueID;
    @SerializedName("VenueName")
    @Expose
    private String venueName;
    @SerializedName("VenueCity")
    @Expose
    private String venueCity;
    @SerializedName("VenueCountry")
    @Expose
    private String venueCountry;
    @SerializedName("VenueZipcode")
    @Expose
    private String venueZipcode;
    @SerializedName("VenueStreet")
    @Expose
    private String venueStreet;
    @SerializedName("VenuebuildingNumber")
    @Expose
    private String venuebuildingNumber;
    @SerializedName("VenueLat")
    @Expose
    private String venueLat;
    @SerializedName("VanueLong")
    @Expose
    private String vanueLong;
    @SerializedName("VenueImageUrl")
    @Expose
    private String venueImageUrl;
    @SerializedName("Stock")
    @Expose
    private String stock;

    private boolean isFavorite;

    public Ticket() {
    }

    public Ticket(String eventId, String eventDate, String eventTime, String artistID, String artistName, String artistImage, String artiestPopularity, String artistTourName, String venueID, String venueName, String venueCity, String venueCountry, String venueZipcode, String venueStreet, String venuebuildingNumber, String venueLat, String vanueLong, String venueImageUrl, String stock, boolean isFavorite) {
        mEventId = eventId;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.artistID = artistID;
        this.artistName = artistName;
        this.artistImage = artistImage;
        this.artiestPopularity = artiestPopularity;
        this.artistTourName = artistTourName;
        this.venueID = venueID;
        this.venueName = venueName;
        this.venueCity = venueCity;
        this.venueCountry = venueCountry;
        this.venueZipcode = venueZipcode;
        this.venueStreet = venueStreet;
        this.venuebuildingNumber = venuebuildingNumber;
        this.venueLat = venueLat;
        this.vanueLong = vanueLong;
        this.venueImageUrl = venueImageUrl;
        this.stock = stock;
        this.isFavorite = isFavorite;
    }

    protected Ticket(Parcel in) {
        mEventId = in.readString();
        eventDate = in.readString();
        eventTime = in.readString();
        artistID = in.readString();
        artistName = in.readString();
        artistImage = in.readString();
        artiestPopularity = in.readString();
        artistTourName = in.readString();
        venueID = in.readString();
        venueName = in.readString();
        venueCity = in.readString();
        venueCountry = in.readString();
        venueZipcode = in.readString();
        venueStreet = in.readString();
        venuebuildingNumber = in.readString();
        venueLat = in.readString();
        vanueLong = in.readString();
        venueImageUrl = in.readString();
        stock = in.readString();
        isFavorite = in.readByte() != 0;
    }

    public static final Creator<Ticket> CREATOR = new Creator<Ticket>() {
        @Override
        public Ticket createFromParcel(Parcel in) {
            return new Ticket(in);
        }

        @Override
        public Ticket[] newArray(int size) {
            return new Ticket[size];
        }
    };

    public String getEventId() {
        return mEventId;
    }

    public void setEventId(String eventId) {
        mEventId = eventId;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getArtistID() {
        return artistID;
    }

    public void setArtistID(String artistID) {
        this.artistID = artistID;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistImage() {
        return artistImage;
    }

    public void setArtistImage(String artistImage) {
        this.artistImage = artistImage;
    }

    public String getArtiestPopularity() {
        return artiestPopularity;
    }

    public void setArtiestPopularity(String artiestPopularity) {
        this.artiestPopularity = artiestPopularity;
    }

    public String getArtistTourName() {
        return artistTourName;
    }

    public void setArtistTourName(String artistTourName) {
        this.artistTourName = artistTourName;
    }

    public String getVenueID() {
        return venueID;
    }

    public void setVenueID(String venueID) {
        this.venueID = venueID;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueCity() {
        return venueCity;
    }

    public void setVenueCity(String venueCity) {
        this.venueCity = venueCity;
    }

    public String getVenueCountry() {
        return venueCountry;
    }

    public void setVenueCountry(String venueCountry) {
        this.venueCountry = venueCountry;
    }

    public String getVenueZipcode() {
        return venueZipcode;
    }

    public void setVenueZipcode(String venueZipcode) {
        this.venueZipcode = venueZipcode;
    }

    public String getVenueStreet() {
        return venueStreet;
    }

    public void setVenueStreet(String venueStreet) {
        this.venueStreet = venueStreet;
    }

    public String getVenuebuildingNumber() {
        return venuebuildingNumber;
    }

    public void setVenuebuildingNumber(String venuebuildingNumber) {
        this.venuebuildingNumber = venuebuildingNumber;
    }

    public String getVenueLat() {
        return venueLat;
    }

    public void setVenueLat(String venueLat) {
        this.venueLat = venueLat;
    }

    public String getVanueLong() {
        return vanueLong;
    }

    public void setVanueLong(String vanueLong) {
        this.vanueLong = vanueLong;
    }

    public String getVenueImageUrl() {
        return venueImageUrl;
    }

    public void setVenueImageUrl(String venueImageUrl) {
        this.venueImageUrl = venueImageUrl;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mEventId);
        dest.writeString(eventDate);
        dest.writeString(eventTime);
        dest.writeString(artistID);
        dest.writeString(artistName);
        dest.writeString(artistImage);
        dest.writeString(artiestPopularity);
        dest.writeString(artistTourName);
        dest.writeString(venueID);
        dest.writeString(venueName);
        dest.writeString(venueCity);
        dest.writeString(venueCountry);
        dest.writeString(venueZipcode);
        dest.writeString(venueStreet);
        dest.writeString(venuebuildingNumber);
        dest.writeString(venueLat);
        dest.writeString(vanueLong);
        dest.writeString(venueImageUrl);
        dest.writeString(stock);
        dest.writeByte((byte) (isFavorite ? 1 : 0));
    }
}
