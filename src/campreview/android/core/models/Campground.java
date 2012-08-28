package campreview.android.core.models;

import campreview.android.data.IEntity;

public class Campground implements IEntity {

    String CampgroundId;

    String Name;

    String RegionId;

    @Override
    public String getIdentifier() {
        return CampgroundId;
    }
}
