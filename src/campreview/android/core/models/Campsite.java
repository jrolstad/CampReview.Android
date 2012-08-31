package campreview.android.core.models;

import campreview.android.data.IEntity;

public class Campsite  implements IEntity {

    public String CampsiteId;

    public String SiteNumber;

    public String CampgroundId;

    @Override
    public String getIdentifier() {
        return CampsiteId;
    }
}
