package android.com.example1views;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SamplePojo {

    @SerializedName("firstname")
//    @SerializedName(value="name", alternate={"firstname"})
    @Expose
    private String name;
    @SerializedName("place")
    @Expose
    private String place;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

}
