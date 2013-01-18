package campreview.android.data.models;

public class Region {

    private int _regionId;
    private String _name;
    private float _latitude;
    private float _longitude;

    public Region(){

    }

    public Region(int regionId, String name, float latitude, float longitude){
        _regionId = regionId;
        _name = name;
        _latitude = latitude;
        _longitude = longitude;
    }

    public int getRegionId(){
        return _regionId;
    }

    public String getName(){
        return _name;
    }

    public float getLatitude(){
        return _latitude;
    }

    public float getLongitude(){
        return _longitude;
    }
}
