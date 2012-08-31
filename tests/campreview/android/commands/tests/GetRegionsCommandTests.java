package campreview.android.commands.tests;

import campreview.android.commands.GetRegionsCommand;
import campreview.android.commands.ICommand;
import campreview.android.commands.requests.Request;
import campreview.android.core.models.Region;
import campreview.android.data.IRepository;
import campreview.android.data.InMemoryRepository;
import campreview.android.mappers.IMapper;
import campreview.android.mappers.RegionViewModelMapper;
import campreview.android.viewmodels.RegionViewModel;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class GetRegionsCommandTests extends TestCase {

    @Test
    public void test_when_getting_regions_then_all_regions_are_retrieved(){

        // Arrange
        IRepository<Region> repository = new InMemoryRepository<Region>();
        repository.Save(new Region());
        repository.Save(new Region());

        IMapper<Region,RegionViewModel> mapper = new RegionViewModelMapper();

        ICommand<Request, List<RegionViewModel>> command = new GetRegionsCommand(repository,mapper);

        // Act
        List<RegionViewModel> result = command.Execute(Request.Empty);

        // Assert
        assertEquals(2,result.size());

    }
}
