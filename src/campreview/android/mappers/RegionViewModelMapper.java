package campreview.android.mappers;

import campreview.android.core.models.Region;
import campreview.android.viewmodels.RegionViewModel;


public class RegionViewModelMapper implements IMapper<Region,RegionViewModel> {

    @Override
    public RegionViewModel Map(Region toMap) {
        RegionViewModel result = new RegionViewModel();
        result.Name = toMap.Name;
        result.RegionId = toMap.RegionId;

        return result;
    }
}
