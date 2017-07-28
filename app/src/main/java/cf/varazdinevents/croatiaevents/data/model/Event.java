package cf.varazdinevents.croatiaevents.data.model;

import java.util.Date;

import cf.varazdinevents.croatiaevents.base.ui.list.Listable;

/**
 * Created by antonio on 26/07/17.
 */

public class Event implements Listable {
    private Integer apiId;
    private String title;
    private String text;
    private Date date;
    private Date dateTo;
    private String host;
    private String officialLink;
    private String image;
    private String facebook;
    private String offers;
    private String category;
    private Integer dateUpdated;
    private Integer hostApiId;
    private Double longitude;
    private Double latitude;
    private String address;
    private Integer festivalId;

    public Event(Integer apiId, String title, String text, Date date, Date dateTo, String host,
                 String officialLink, String image, String facebook, String offers, String category,
                 Integer dateUpdated, Integer hostApiId, Double longitude, Double latitude,
                 String address, Integer festivalId) {
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

    public Integer getApiId() {
        return apiId;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public String getHost() {
        return host;
    }

    public String getOfficialLink() {
        return officialLink;
    }

    public String getImage() {
        return image;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getOffers() {
        return offers;
    }

    public String getCategory() {
        return category;
    }

    public Integer getDateUpdated() {
        return dateUpdated;
    }

    public Integer getHostApiId() {
        return hostApiId;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public String getAddress() {
        return address;
    }

    public Integer getFestivalId() {
        return festivalId;
    }

    @Override
    public Object getId() {
        return apiId;
    }
}
