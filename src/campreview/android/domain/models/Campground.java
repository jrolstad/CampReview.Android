package campreview.android.domain.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "campground")
public class Campground {

    @DatabaseField(id = true)
    private String campgroundId;
    @DatabaseField
    private String name;
    @DatabaseField
    private int rating;
    @DatabaseField
    private String regionId;
    @DatabaseField
    private float latitude;
    @DatabaseField
    private float longitude;

    public Campground(){

    }

    public Campground(String campgroundId, String name,String regionId, int rating, float latitude, float longitude){
        this.campgroundId = campgroundId;
        this.name = name;
        this.rating = rating;
        this.regionId = regionId;
        this.latitude = latitude;
        this.longitude = longitude;

    }

    public String getCampgroundId(){
        return campgroundId;
    }

    public String getName(){
        return name;
    }

    public String getRegion(){
           return regionId;
       }

    public float getRating(){
            return rating;
    }

    public float getLatitude(){
        return latitude;
    }

    public float getLongitude(){
        return longitude;
    }
}
