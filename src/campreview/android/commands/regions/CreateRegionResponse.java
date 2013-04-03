package campreview.android.commands.regions;

import campreview.android.viewmodels.RegionViewModel;

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
