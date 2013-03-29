package campreview.android.commands.regions;

import campreview.android.data.models.Region;

public class CreateRegionResponse {

    private Region region;

    public Region getRegion(){
        return region;
    }

    public CreateRegionResponse WithRegion(Region value){
        region = value;

        return this;
    }
}
