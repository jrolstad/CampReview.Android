package campreview.android.mappers.tests;

import android.content.Intent;
import campreview.android.mappers.RegionCampgroundListViewModelIntentMapper;
import campreview.android.viewmodels.RegionCampgroundListViewModel;
import junit.framework.TestCase;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RegionCampgroundListViewModelIntentMapperTests extends TestCase {

    @Test
    public void test_when_mapping_an_intent_to_the_view_model_then_it_is_mapped(){
        // Arrange
        Intent intent = mock(Intent.class);
        when(intent.getStringExtra("region_id")).thenReturn("some id");
        when(intent.getStringExtra("region_name")).thenReturn("my name");

        RegionCampgroundListViewModelIntentMapper mapper = new RegionCampgroundListViewModelIntentMapper();

        // Act
        RegionCampgroundListViewModel result = mapper.Map(intent);

        // Assert
        assertEquals(result.RegionName,"my name");
        assertEquals(result.RegionId,"some id");
    }
}
