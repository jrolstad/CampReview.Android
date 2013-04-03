package campreview.android.domain.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "campsite")
public class Campsite {

    @DatabaseField(id = true)
    private String campsiteId;
    @DatabaseField
    private String name;
    @DatabaseField
    private int rating;
    @DatabaseField
    private String campgroundId;
    @DatabaseField
    private float latitude;
    @DatabaseField
    private float longitude;

    public Campsite(){

    }

    public Campsite(String campsiteId, String name, String campgroundId, int rating, float latitude, float longitude){
        this.campsiteId = campsiteId;
        this.campgroundId = campgroundId;
        this.name = name;
        this.rating = rating;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCampsiteId(){
           return campsiteId;
    }

    public String getCampgroundId(){
        return campgroundId;
    }

    public String getName(){
        return name;
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
