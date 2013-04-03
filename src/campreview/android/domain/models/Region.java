package campreview.android.domain.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "region")
public class Region {

    @DatabaseField(id = true)
    private String regionId;
    @DatabaseField
    private String name;
    @DatabaseField
    private float latitude;
    @DatabaseField
    private float longitude;

    public Region(){

    }

    public Region(String regionId, String name, float latitude, float longitude){
        this.regionId = regionId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getRegionId(){
        return regionId;
    }

    public String getName(){
        return name;
    }

    public float getLatitude(){
        return latitude;
    }

    public float getLongitude(){
        return longitude;
    }
}
