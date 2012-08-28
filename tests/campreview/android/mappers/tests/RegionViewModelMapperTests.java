package campreview.android.mappers.tests;


import campreview.android.core.models.Region;
import campreview.android.mappers.RegionViewModelMapper;
import campreview.android.viewmodels.RegionViewModel;
import junit.framework.TestCase;
import org.junit.Test;

public class RegionViewModelMapperTests extends TestCase {

    @Test
    public void test_when_mapping_region_to_view_model_then_it_is_mapped(){

        // Arrange
        Region region = new Region();
        region.Name = "foo";
        region.RegionId = "my id";

        RegionViewModelMapper mapper = new RegionViewModelMapper();

        // Act
        RegionViewModel result = mapper.Map(region);

        // Assert
        assertEquals(region.Name,result.Name);
        assertEquals(region.RegionId,result.RegionId);
    }
}
