package campreview.android.mappers.tests;


import campreview.android.core.models.Campground;
import campreview.android.mappers.CampgroundViewModelMapper;
import campreview.android.viewmodels.CampgroundViewModel;
import junit.framework.TestCase;
import org.junit.Test;

public class CampgroundViewModelMapperTests extends TestCase {

    @Test
    public void test_when_mapping_campground_to_view_model_then_it_is_mapped(){

        // Arrange
        Campground campground = new Campground();
        campground.Name = "foo";
        campground.CampgroundId = "my id";

        CampgroundViewModelMapper mapper = new CampgroundViewModelMapper();

        // Act
        CampgroundViewModel result = mapper.Map(campground);

        // Assert
        assertEquals(campground.Name,result.Name);
        assertEquals(campground.CampgroundId,result.CampgroundId);
    }
}
