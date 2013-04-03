package campreview.android.domain.services.regions;

import campreview.android.core.commands.ICommand;
import campreview.android.domain.data.IRepository;
import campreview.android.domain.models.Region;

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

        return new CreateRegionResponse().WithRegionId(region.getRegionId());
    }
}
