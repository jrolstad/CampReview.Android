package campreview.android.commands.regions;

public class CreateRegionRequest {

    private String name;
    private float latitude;
    private float longitude;

    public String getName(){
        return name;
    }

    public float getLatitude(){
        return latitude;
    }

    public float getLongitude(){
        return longitude;
    }

    public CreateRegionRequest WithName(String nameValue){
        name = nameValue;

        return this;
    }

    public CreateRegionRequest WithLatitude(float latitudeValue){
        latitude = latitudeValue;

        return this;
    }

    public CreateRegionRequest WithLongitude(float longitudeValue){
        longitude = longitudeValue;

        return this;
    }
}
