package campreview.android.application.services.region;

import campreview.android.application.viewcommands.IViewCommand;
import campreview.android.core.commands.ICommand;

public class CreateRegionViewCommand implements IViewCommand<CreateRegionRequest,CreateRegionResponse> {

    private ICommand<campreview.android.domain.services.regions.CreateRegionRequest, campreview.android.domain.services.regions.CreateRegionResponse> createCommand;

    public CreateRegionViewCommand(ICommand<campreview.android.domain.services.regions.CreateRegionRequest,campreview.android.domain.services.regions.CreateRegionResponse> createCommand){

        this.createCommand = createCommand;
    }
    @Override
    public CreateRegionResponse Execute(CreateRegionRequest request) throws Exception {

        campreview.android.domain.services.regions.CreateRegionRequest commandRequest =
                new campreview.android.domain.services.regions.CreateRegionRequest()
                .WithName(request.getName());

        createCommand.Execute(commandRequest);

        return new CreateRegionResponse();
    }
}
