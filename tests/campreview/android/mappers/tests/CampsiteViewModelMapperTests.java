package campreview.android.mappers.tests;


import campreview.android.core.models.Campsite;
import campreview.android.mappers.CampsiteViewModelMapper;
import campreview.android.viewmodels.CampsiteViewModel;
import junit.framework.TestCase;
import org.junit.Test;

public class CampsiteViewModelMapperTests extends TestCase {

    @Test
    public void test_when_mapping_campsite_to_view_model_then_it_is_mapped(){

        // Arrange
        Campsite campsite = new Campsite();
        campsite.SiteNumber = "foo";
        campsite.CampsiteId = "my id";

        CampsiteViewModelMapper mapper = new CampsiteViewModelMapper();

        // Act
        CampsiteViewModel result = mapper.Map(campsite);

        // Assert
        assertEquals(campsite.SiteNumber,result.SiteNumber);
        assertEquals(campsite.CampsiteId,result.CampsiteId);
    }
}
