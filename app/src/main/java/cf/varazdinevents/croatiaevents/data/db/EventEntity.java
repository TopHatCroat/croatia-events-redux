package cf.varazdinevents.croatiaevents.data.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by antonio on 27/07/17.
 */

@Entity(tableName = "events")
public class EventEntity {
    @PrimaryKey
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
}
