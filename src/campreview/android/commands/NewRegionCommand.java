package campreview.android.commands;

import campreview.android.core.models.Region;
import campreview.android.data.IRepository;
import campreview.android.data.InMemoryRepository;

import java.util.UUID;


public class NewRegionCommand implements ICommand<NewRegionRequest,NewRegionResponse> {
    private IRepository<Region> _repository;

    public NewRegionCommand(IRepository<Region> repository) {
        _repository = repository;
    }

    @Override
    public NewRegionResponse Execute(NewRegionRequest request) {
        NewRegionResponse response =  new NewRegionResponse();

        Region regionToCreate = new Region();
        regionToCreate.Name = request.RegionName;
        regionToCreate.RegionId = UUID.randomUUID().toString();

        _repository.Save(regionToCreate);

        response.RegionName = regionToCreate.Name;

        return response;
    }
}
