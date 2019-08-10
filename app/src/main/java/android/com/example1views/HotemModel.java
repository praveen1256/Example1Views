package android.com.example1views;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HotemModel {


    @SerializedName("hotel_id")
    @Expose
    private String hotelId;

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

}
