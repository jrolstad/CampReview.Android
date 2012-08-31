package campreview.android.commands.tests;

import campreview.android.commands.ICommand;
import campreview.android.commands.NewCampsiteCommand;
import campreview.android.commands.requests.NewCampsiteRequest;
import campreview.android.commands.responses.NewCampsiteResponse;
import campreview.android.core.models.Campsite;
import campreview.android.data.IRepository;
import campreview.android.data.InMemoryRepository;
import junit.framework.TestCase;
import org.junit.Test;

public class NewCampsiteCommandTests extends TestCase {

    @Test
    public void test_when_creating_a_new_campsite_then_it_is_created(){
        // Arrange
        IRepository<Campsite> repository = new InMemoryRepository<Campsite>();

        ICommand<NewCampsiteRequest,NewCampsiteResponse> command = new NewCampsiteCommand(repository);

        NewCampsiteRequest request = new NewCampsiteRequest();
        request.SiteNumber = "What I want to be named";
        request.CampgroundId = "23";

        // Act
        NewCampsiteResponse response = command.Execute(request);

        // Assert
        assertEquals(request.SiteNumber,response.SiteNumber);
    }
}
