package campreview.android.mappers;

import android.content.Intent;
import campreview.android.viewmodels.RegionCampgroundListViewModel;

public class RegionCampgroundListViewModelIntentMapper implements IMapper<Intent,RegionCampgroundListViewModel>{
    @Override
    public RegionCampgroundListViewModel Map(Intent intent) {

        RegionCampgroundListViewModel viewModel = new RegionCampgroundListViewModel();

        viewModel.RegionId = intent.getStringExtra("region_id");
        viewModel.RegionName = intent.getStringExtra("region_name");

        return viewModel;

    }
}
