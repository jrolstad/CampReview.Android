package campreview.android.commands;

import campreview.android.commands.requests.NewCampgroundRequest;
import campreview.android.commands.responses.NewCampgroundResponse;
import campreview.android.core.models.Campground;
import campreview.android.data.IRepository;

import java.util.UUID;

public class NewCampgroundCommand implements ICommand<NewCampgroundRequest,NewCampgroundResponse> {

    private IRepository<Campground> _repository;

    public NewCampgroundCommand(IRepository<Campground> repository) {
        _repository = repository;
    }

    @Override
    public NewCampgroundResponse Execute(NewCampgroundRequest request) {

        Campground newCampground = new Campground();
        newCampground.CampgroundId = UUID.randomUUID().toString();
        newCampground.RegionId = request.RegionId;
        newCampground.Name = request.CampgroundName;

        _repository.Save(newCampground);

        NewCampgroundResponse response= new NewCampgroundResponse();
        response.CampgroundName = request.CampgroundName;

        return response;

    }
}
