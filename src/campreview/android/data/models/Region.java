package campreview.android.data.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "region")
public class Region {

    @DatabaseField(id = true)
    private int regionId;
    @DatabaseField
    private String name;
    @DatabaseField
    private float latitude;
    @DatabaseField
    private float longitude;

    public Region(){

    }

    public Region(int regionId, String name, float latitude, float longitude){
        this.regionId = regionId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getRegionId(){
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
