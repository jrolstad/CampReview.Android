package campreview.android.commands.tests;

import campreview.android.commands.*;
import campreview.android.commands.requests.NewCampgroundRequest;
import campreview.android.commands.responses.NewCampgroundResponse;
import campreview.android.core.models.Campground;
import campreview.android.data.IRepository;
import campreview.android.data.InMemoryRepository;
import junit.framework.TestCase;
import org.junit.Test;

public class NewCampgroundCommandTests extends TestCase {

    @Test
    public void test_when_creating_a_new_campground_then_it_is_created(){
        // Arrange
        IRepository<Campground> repository = new InMemoryRepository<Campground>();

        ICommand<NewCampgroundRequest,NewCampgroundResponse> command = new NewCampgroundCommand(repository);

        NewCampgroundRequest request = new NewCampgroundRequest();
        request.CampgroundName = "What I want to be named";
        request.RegionId = "23";

        // Act
        NewCampgroundResponse response = command.Execute(request);

        // Assert
        assertEquals(request.CampgroundName,response.CampgroundName);
    }
}
