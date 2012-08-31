package campreview.android.mappers;

import campreview.android.core.models.Campsite;
import campreview.android.viewmodels.CampsiteViewModel;

public class CampsiteViewModelMapper implements IMapper<Campsite, CampsiteViewModel> {

    @Override
    public CampsiteViewModel Map(Campsite toMap) {

        CampsiteViewModel result = new CampsiteViewModel();
        result.SiteNumber = toMap.SiteNumber;
        result.CampsiteId = toMap.CampsiteId;

        return result;
    }
}
