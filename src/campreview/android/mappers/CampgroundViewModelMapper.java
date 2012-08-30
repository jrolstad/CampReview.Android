package campreview.android.mappers;

import campreview.android.core.models.Campground;
import campreview.android.viewmodels.CampgroundViewModel;

public class CampgroundViewModelMapper implements IMapper<Campground, CampgroundViewModel> {
    @Override
    public CampgroundViewModel Map(Campground toMap) {
        CampgroundViewModel result = new CampgroundViewModel();
        result.Name = toMap.Name;
        result.CampgroundId = toMap.CampgroundId;

        return result;
    }
}
