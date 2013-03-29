package campreview.android.commands.regions;

import campreview.android.commands.ICommand;
import campreview.android.data.IRepository;
import campreview.android.data.models.Region;

import java.util.UUID;

public class CreateRegionCommand implements ICommand<CreateRegionRequest,CreateRegionResponse> {

    private IRepository<Region, String> repository;

    public CreateRegionCommand(IRepository<Region,String> repository)
    {
        this.repository = repository;
    }

    public CreateRegionResponse Execute(CreateRegionRequest request) throws Exception {

        String newId = UUID.randomUUID().toString();

        Region region = new Region(newId,
                request.getName(),
                request.getLatitude(),
                request.getLongitude());

        repository.Save(region);

        return new CreateRegionResponse().WithRegion(region);
    }
}
