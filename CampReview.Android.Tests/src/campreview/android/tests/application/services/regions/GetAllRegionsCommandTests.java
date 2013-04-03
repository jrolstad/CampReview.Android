package campreview.android.tests.application.services.regions;

import android.test.AndroidTestCase;
import campreview.android.application.services.region.GetAllRegionsCommand;
import campreview.android.application.viewmodels.RegionViewModel;
import campreview.android.core.commands.ICommand;
import campreview.android.core.commands.QueryResponse;
import campreview.android.core.commands.Request;
import campreview.android.core.mappers.IMapper;
import campreview.android.domain.models.Region;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetAllRegionsCommandTests extends AndroidTestCase {

    public void test_when_getting_all_regions_then_they_all_are_obtained() throws Exception {
        // Arrange
        Region region1 = new Region();
        Region region2 = new Region();

        RegionViewModel viewModel1 = new RegionViewModel(region1.getRegionId(),region1.getName());
        RegionViewModel viewModel2 = new RegionViewModel(region2.getRegionId(),region2.getName());

        List<Region> regions = new ArrayList<Region>();
        regions.add(region1);
        regions.add(region2);

        ICommand<Request,QueryResponse<Region>> dataCommand = (ICommand<Request,QueryResponse<Region>>) mock(ICommand.class);
        when(dataCommand.Execute(Request.Empty)).thenReturn(new QueryResponse<Region>(regions));

        IMapper<Region,RegionViewModel> mapper = (IMapper<Region,RegionViewModel>)mock(IMapper.class);
        when(mapper.Map(region1)).thenReturn(viewModel1);
        when(mapper.Map(region2)).thenReturn(viewModel2);

        GetAllRegionsCommand command = new GetAllRegionsCommand(dataCommand,mapper);

        // Act
        ArrayList<RegionViewModel> response = command.Execute(Request.Empty);

        // Assert
        assertEquals(response.size(),regions.size());
    }
}
