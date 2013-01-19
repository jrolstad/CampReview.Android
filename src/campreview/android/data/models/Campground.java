package campreview.android.data.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "campground")
public class Campground {

    @DatabaseField(id = true)
    private int campgroundId;
    @DatabaseField
    private String name;
    @DatabaseField
    private int rating;
    @DatabaseField
    private int regionId;
    @DatabaseField
    private float latitude;
    @DatabaseField
    private float longitude;

    public Campground(){

    }

    public Campground(int campgroundId, String name,int regionId, int rating, float latitude, float longitude){
        this.campgroundId = campgroundId;
        this.name = name;
        this.rating = rating;
        this.regionId = regionId;
        this.latitude = latitude;
        this.longitude = longitude;

    }

    public int getCampgroundId(){
        return campgroundId;
    }

    public String getName(){
        return name;
    }

    public float getRegion(){
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
