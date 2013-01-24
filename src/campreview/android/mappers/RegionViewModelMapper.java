package campreview.android.mappers;

import campreview.android.data.models.Region;
import campreview.android.viewmodels.RegionViewModel;

public class RegionViewModelMapper implements IMapper<Region,RegionViewModel> {

    @Override
    public RegionViewModel Map(Region from) {
        return new RegionViewModel(from.getRegionId(),from.getName());
    }
}
