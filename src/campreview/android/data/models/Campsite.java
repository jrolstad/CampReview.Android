package campreview.android.data.models;

public class Campsite {

    private int _campsiteId;
    private String _name;
    private int _rating;
    private int _campgroundId;
    private float _latitude;
    private float _longitude;

    public Campsite(){

    }

    public Campsite(int campsiteId, String name, int campgroundId, int rating, float latitude, float longitude){
        _campsiteId = campsiteId;
        _campgroundId = campgroundId;
        _name = name;
        _rating = rating;
        _latitude = latitude;
        _longitude = longitude;
    }

    public float getCampsiteId(){
           return _campsiteId;
    }

    public int getCampgroundId(){
        return _campgroundId;
    }

    public String getName(){
        return _name;
    }

    public float getRating(){
            return _rating;
    }

    public float getLatitude(){
        return _latitude;
    }

    public float getLongitude(){
        return _longitude;
    }
}
