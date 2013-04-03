package campreview.android.domain.services.regions;

public class CreateRegionResponse {

    private String regionId;

    public String getRegionId(){
        return regionId;
    }

    public CreateRegionResponse WithRegionId(String value){
        regionId = value;

        return this;
    }
}
