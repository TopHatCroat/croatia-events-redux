package cf.varazdinevents.croatiaevents.data.api.responses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by antonio on 27/07/17.
 */

public class EventResponse {
    public Integer id;
    public String title;
    public String text;
    public Integer date;
    @SerializedName("date_to")
    public Integer dateTo;
    public String host;
    @SerializedName("official_link")
    public String officialLink;
    public String image;
    public String facebook;
    public String offers;
    public String category;
    @SerializedName("date_updated")
    public Integer dateUpdated;
    @SerializedName("author")
    public Integer hostApiId;
    public Double longitude;
    public Double latitude;
    public String address;
    @SerializedName("festival_id")
    public Integer festivalId;
}
