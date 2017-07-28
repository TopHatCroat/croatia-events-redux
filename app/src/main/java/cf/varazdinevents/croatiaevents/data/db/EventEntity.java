package cf.varazdinevents.croatiaevents.data.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by antonio on 27/07/17.
 */

@Entity(tableName = "events")
public class EventEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "api_id")
    public int apiId;
    public String title;
    public String text;
    public long date;
    public long dateTo;
    public String host;
    @ColumnInfo(name = "official_link")
    public String officialLink;
    public String image;
    public String facebook;
    public String offers;
    public String category;
    @ColumnInfo(name = "date_updated")
    public int dateUpdated;
    @ColumnInfo(name = "host_id")
    public int hostApiId;
    public double longitude;
    public double latitude;
    public String address;
    @ColumnInfo(name = "festival_id")
    public int festivalId;

    public EventEntity(int id, int apiId, String title, String text, long date,
                       long dateTo, String host, String officialLink, String image, String facebook,
                       String offers, String category, int dateUpdated, int hostApiId, double longitude,
                       double latitude, String address, int festivalId) {
        this.id = id;
        this.apiId = apiId;
        this.title = title;
        this.text = text;
        this.date = date;
        this.dateTo = dateTo;
        this.host = host;
        this.officialLink = officialLink;
        this.image = image;
        this.facebook = facebook;
        this.offers = offers;
        this.category = category;
        this.dateUpdated = dateUpdated;
        this.hostApiId = hostApiId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.festivalId = festivalId;
    }
}
