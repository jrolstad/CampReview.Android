package campreview.android.mappers.tests;

import android.app.Activity;
import android.content.Intent;
import android.test.ActivityTestCase;
import campreview.android.mappers.IntentRegionViewModelMapper;
import campreview.android.mappers.StartActivityIntentRequest;
import campreview.android.viewmodels.RegionViewModel;
import org.junit.Test;

public class IntentRegionViewModelMapperTests extends ActivityTestCase {

    @Test
    public void test_when_mapping_a_request_to_an_intent_then_it_is_mapped() throws Throwable{

        // Arrange
        StartActivityIntentRequest<RegionViewModel> request = new StartActivityIntentRequest<RegionViewModel>();
        request.Context = new Activity();
        request.TargetActivity = Activity.class;

        request.Payload = new RegionViewModel();
        request.Payload.Name = "foo";
        request.Payload.RegionId = "my id";

        IntentRegionViewModelMapper mapper = new IntentRegionViewModelMapper();

        // Act
        Intent result = mapper.Map(request);

        // Assert
        assertEquals(result.getStringExtra("region_id"),"my id");
        assertEquals(result.getStringExtra("region_name"),"foo");
    }
}
