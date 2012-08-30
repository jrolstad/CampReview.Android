package campreview.android.core.models;

import campreview.android.data.IEntity;

public class Campground implements IEntity {

    public String CampgroundId;

    public String Name;

    public String RegionId;

    @Override
    public String getIdentifier() {
        return CampgroundId;
    }
}
