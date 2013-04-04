package campreview.android.tests.application.services.regions;

import android.test.AndroidTestCase;
import campreview.android.application.services.region.CreateRegionRequest;
import campreview.android.application.services.region.CreateRegionResponse;
import campreview.android.application.services.region.CreateRegionViewCommand;
import campreview.android.core.commands.ICommand;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateRegionViewCommandTests extends AndroidTestCase {

    public void test_when_creating_a_new_region_then_it_is_created() throws Exception {
        // Arrange
        ICommand<campreview.android.domain.services.regions.CreateRegionRequest, campreview.android.domain.services.regions.CreateRegionResponse> domainCommand
                = (ICommand<campreview.android.domain.services.regions.CreateRegionRequest, campreview.android.domain.services.regions.CreateRegionResponse>)
                mock(ICommand.class);

        CreateRegionViewCommand command = new CreateRegionViewCommand(domainCommand);

        String regionName = "somewhere";

        CreateRegionRequest request = new CreateRegionRequest().withName(regionName);

        // Act
         CreateRegionResponse response = command.Execute(request);

        // Assert
        ArgumentCaptor<campreview.android.domain.services.regions.CreateRegionRequest> argument = ArgumentCaptor.forClass(campreview.android.domain.services.regions.CreateRegionRequest.class);
        verify(domainCommand).Execute(argument.capture());

        assertEquals(regionName,argument.getValue().getName());
    }

}
