package campreview.android.tests.domain.services.regions;

import android.test.AndroidTestCase;
import campreview.android.core.commands.QueryResponse;
import campreview.android.core.commands.Request;
import campreview.android.domain.data.IRepository;
import campreview.android.domain.models.Region;
import campreview.android.domain.services.regions.GetAllRegionsCommand;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetAllRegionsCommandTests extends AndroidTestCase {

    public void test_when_getting_all_regions_then_they_are_obtained() throws Exception {

        // Arrange
        List<Region> allRegions = new ArrayList<Region>();

        IRepository<Region,String> repository = (IRepository<Region,String>) mock(IRepository.class);
        when(repository.All()).thenReturn(allRegions);

        GetAllRegionsCommand command = new GetAllRegionsCommand(repository);

        // Act
        QueryResponse<Region> response = command.Execute(Request.Empty);

        // Assert
        assertSame(allRegions,response.getResults());
    }
}
