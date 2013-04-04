package campreview.android.application.services.region;

public class CreateRegionRequest {

    private String name;

    public String getName(){
        return name;
    }

    public CreateRegionRequest withName(String value){
        name = value;

        return this;
    }
}
