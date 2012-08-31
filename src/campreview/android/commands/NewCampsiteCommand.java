package campreview.android.commands;

import campreview.android.commands.requests.NewCampsiteRequest;
import campreview.android.commands.responses.NewCampsiteResponse;
import campreview.android.core.models.Campsite;
import campreview.android.data.IRepository;

import java.util.UUID;

public class NewCampsiteCommand implements ICommand<NewCampsiteRequest,NewCampsiteResponse> {

    private IRepository<Campsite> _repository;

    public NewCampsiteCommand(IRepository<Campsite> repository) {
        _repository = repository;
    }

    @Override
    public NewCampsiteResponse Execute(NewCampsiteRequest request) {

        Campsite newCampsite = new Campsite();
        newCampsite.CampsiteId = UUID.randomUUID().toString();
        newCampsite.CampgroundId = request.CampgroundId;
        newCampsite.SiteNumber = request.SiteNumber;

        _repository.Save(newCampsite);

        NewCampsiteResponse response= new NewCampsiteResponse();
        response.SiteNumber = request.SiteNumber;

        return response;

    }
}
