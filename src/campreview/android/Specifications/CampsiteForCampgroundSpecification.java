package campreview.android.specifications;

import campreview.android.core.models.Campsite;

public class CampsiteForCampgroundSpecification implements ISpecification<Campsite> {

    private String _campgroundId;

    public CampsiteForCampgroundSpecification(String campgroundId){

        _campgroundId = campgroundId;
    }

    @Override
    public boolean Matches(Campsite item) {
        if(_campgroundId == null || _campgroundId.isEmpty())
            return false;

        return _campgroundId.equalsIgnoreCase(item.CampgroundId);
    }
}
