package campreview.android.specifications;

import campreview.android.core.models.Campground;

public class CampgroundForRegionSpecification implements ISpecification<Campground> {

    private String _regionId;

    public CampgroundForRegionSpecification(String regionId){
        _regionId = regionId;
    }
    @Override
    public boolean Matches(Campground item) {
        if(_regionId == null || _regionId.isEmpty())
            return false;

        return _regionId.equalsIgnoreCase(item.RegionId);
    }
}
