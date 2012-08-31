package campreview.android.commands.tests;

import campreview.android.commands.ICommand;
import campreview.android.commands.NewRegionCommand;
import campreview.android.commands.requests.NewRegionRequest;
import campreview.android.commands.responses.NewRegionResponse;
import campreview.android.core.models.Region;
import campreview.android.data.IRepository;
import campreview.android.data.InMemoryRepository;
import junit.framework.TestCase;
import org.junit.Test;

public class NewRegionCommandTests extends TestCase {

    @Test
    public void test_when_creating_a_new_command_then_it_is_created(){
        // Arrange
        IRepository<Region> repository = new InMemoryRepository<Region>();

        ICommand<NewRegionRequest,NewRegionResponse> command = new NewRegionCommand(repository);

        NewRegionRequest request = new NewRegionRequest();
        request.RegionName = "What I want to be named";

        // Act
        NewRegionResponse response = command.Execute(request);

        // Assert
        assertEquals(request.RegionName,response.RegionName);
    }
}
