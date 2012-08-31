package campreview.android.commands.tests;

import campreview.android.commands.GetCampsiteByCampgroundCommand;
import campreview.android.commands.ICommand;
import campreview.android.commands.requests.GetCampsiteByCampgroundRequest;
import campreview.android.commands.responses.GetCampsiteByCampgroundResponse;
import campreview.android.core.models.Campsite;
import campreview.android.data.IRepository;
import campreview.android.data.InMemoryRepository;
import campreview.android.mappers.CampsiteViewModelMapper;
import campreview.android.mappers.IMapper;
import campreview.android.viewmodels.CampsiteViewModel;
import junit.framework.TestCase;
import org.junit.Test;

public class GetCampsiteByCampgroundCommandTests extends TestCase {

    @Test
    public void test_when_getting_campsites_for_a_campground_then_only_those_in_that_campground_are_retrieved(){

        // Arrange
        String campgroundToSearchFor = "where I want to go";

        IRepository<Campsite> repository = new InMemoryRepository<Campsite>();

        Campsite campsite1 = new Campsite();
        campsite1.CampgroundId = campgroundToSearchFor;
        repository.Save(campsite1);

        Campsite campsite2 = new Campsite();
        campsite2.CampgroundId = campgroundToSearchFor;
        repository.Save(campsite2);

        Campsite campsite3 = new Campsite();
        campsite3.CampgroundId = "somewhere else";
        repository.Save(campsite3);

        IMapper<Campsite,CampsiteViewModel> mapper = new CampsiteViewModelMapper();

        ICommand<GetCampsiteByCampgroundRequest,GetCampsiteByCampgroundResponse> command = new GetCampsiteByCampgroundCommand(repository,mapper);

        GetCampsiteByCampgroundRequest request = new GetCampsiteByCampgroundRequest();
        request.CampgroundId = campgroundToSearchFor;

        // Act
        GetCampsiteByCampgroundResponse result = command.Execute(request);

        // Assert
        assertEquals(2, result.Campsites.size());
    }
}
