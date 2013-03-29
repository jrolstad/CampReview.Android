package campreview.android.tests.commands.regions;

import android.test.AndroidTestCase;
import campreview.android.commands.regions.CreateRegionCommand;
import campreview.android.commands.regions.CreateRegionRequest;
import campreview.android.commands.regions.CreateRegionResponse;
import campreview.android.data.IRepository;
import campreview.android.data.models.Region;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateRegionCommandTests extends AndroidTestCase {

    private CreateRegionRequest request;
    private CreateRegionResponse response;
    private IRepository<Region, String> repository;

    public void setUp() throws Exception {
        request = new CreateRegionRequest()
                .WithName("some name")
                .WithLatitude(1.23f)
                .WithLongitude(2.34f);

        repository = (IRepository<Region,String>) mock(IRepository.class);

        CreateRegionCommand command = new CreateRegionCommand(repository);

        response = command.Execute(request);
    }

    public void test_When_creating_then_the_region_id_is_created(){

        assertNotNull(response.getRegion().getRegionId());
    }

    public void test_When_creating_then_the_name_is_saved(){

        assertEquals(request.getName(),response.getRegion().getName());
    }

    public void test_When_creating_then_the_latitude_is_saved(){

        assertEquals(request.getLatitude(),response.getRegion().getLatitude());
    }

    public void test_When_creating_then_the_longitude_is_saved(){

        assertEquals(request.getLongitude(),response.getRegion().getLongitude());
    }

    public void test_When_creating_then_the_region_is_saved() throws Exception {
        verify(repository).Save(response.getRegion());
    }
}
