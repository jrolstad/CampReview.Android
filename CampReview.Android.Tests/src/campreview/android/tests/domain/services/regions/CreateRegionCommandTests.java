package campreview.android.tests.domain.services.regions;

import android.test.AndroidTestCase;
import campreview.android.domain.services.regions.CreateRegionCommand;
import campreview.android.domain.services.regions.CreateRegionRequest;
import campreview.android.domain.services.regions.CreateRegionResponse;
import campreview.android.domain.data.IRepository;
import campreview.android.domain.models.Region;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateRegionCommandTests extends AndroidTestCase {

    private CreateRegionRequest request;
    private CreateRegionResponse response;
    private IRepository<Region, String> repository;
    private Region savedRegion;

    public void setUp() throws Exception {
        request = new CreateRegionRequest()
                .WithName("some name")
                .WithLatitude(1.23f)
                .WithLongitude(2.34f);

        repository = (IRepository<Region,String>) mock(IRepository.class);

        CreateRegionCommand command = new CreateRegionCommand(repository);

        response = command.Execute(request);

        ArgumentCaptor<Region> argument = ArgumentCaptor.forClass(Region.class);
        verify(repository).Save(argument.capture());
        savedRegion = argument.getValue();
    }

    public void test_When_creating_then_the_region_id_is_created(){

        assertNotNull(savedRegion.getRegionId());
    }

    public void test_When_creating_then_the_name_is_saved(){

        assertEquals(request.getName(),savedRegion.getName());
    }

    public void test_When_creating_then_the_latitude_is_saved(){

        assertEquals(request.getLatitude(),savedRegion.getLatitude());
    }

    public void test_When_creating_then_the_longitude_is_saved(){

        assertEquals(request.getLongitude(),savedRegion.getLongitude());
    }

    public void test_When_creating_then_the_regionId_is_returned()  {

        assertEquals(savedRegion.getRegionId(),response.getRegionId());
    }
}
