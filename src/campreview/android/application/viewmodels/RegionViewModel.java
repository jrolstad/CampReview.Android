package campreview.android.application.viewmodels;

public class RegionViewModel {

    private String regionId;
    private String name;

    public RegionViewModel(String regionId, String name){

        this.regionId = regionId;
        this.name = name;
    }

    public String getRegionId(){
        return regionId;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name;
    }

}
