package campreview.android.mappers;

import android.content.Intent;
import campreview.android.viewmodels.RegionViewModel;

public class IntentRegionViewModelMapper implements IMapper<StartActivityIntentRequest<RegionViewModel>, Intent> {
    @Override
    public Intent Map(StartActivityIntentRequest<RegionViewModel> toMap) {

        Intent intent = new Intent(toMap.Context,toMap.TargetActivity);
        intent.putExtra("region_id", toMap.Payload.RegionId);
        intent.putExtra("region_name", toMap.Payload.Name);

        return intent;
    }
}
