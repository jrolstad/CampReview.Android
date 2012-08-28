package campreview.android.core.models;

import campreview.android.data.IEntity;

public class Region implements IEntity {

    public String RegionId;

    public String Name;

    @Override
    public String getIdentifier() {
        return RegionId;
    }
}
