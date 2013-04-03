package campreview.android.application.mappers;

import campreview.android.core.mappers.IMapper;
import campreview.android.domain.models.Region;
import campreview.android.application.viewmodels.RegionViewModel;

public class RegionViewModelMapper implements IMapper<Region,RegionViewModel> {

    @Override
    public RegionViewModel Map(Region from) {
        return new RegionViewModel(from.getRegionId(),from.getName());
    }
}
