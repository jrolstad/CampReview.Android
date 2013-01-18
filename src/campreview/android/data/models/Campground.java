package campreview.android.data.models;

public class Campground {

    private int _campgroundId;
    private String _name;
    private int _rating;
    private int _regionId;
    private float _latitude;
    private float _longitude;

    public Campground(){

    }

    public Campground(int campgroundId, String name,int regionId, int rating, float latitude, float longitude){
        _campgroundId = campgroundId;
        _name = name;
        _rating = rating;
        _regionId = regionId;
        _latitude = latitude;
        _longitude = longitude;

    }

    public int getCampgroundId(){
        return _campgroundId;
    }

    public String getName(){
        return _name;
    }

    public float getRegion(){
           return _regionId;
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
