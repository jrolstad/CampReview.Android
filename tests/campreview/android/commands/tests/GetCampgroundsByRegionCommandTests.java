package campreview.android.commands.tests;

import campreview.android.commands.GetCampgroundsByRegionCommand;
import campreview.android.commands.GetCampgroundsByRegionRequest;
import campreview.android.commands.GetCampgroundsByRegionResponse;
import campreview.android.commands.ICommand;
import campreview.android.core.models.Campground;
import campreview.android.core.models.Region;
import campreview.android.data.IRepository;
import campreview.android.data.InMemoryRepository;
import campreview.android.infrastructure.IoC;
import campreview.android.mappers.CampgroundViewModelMapper;
import campreview.android.mappers.IMapper;
import campreview.android.specifications.AlwaysTrueSpecification;
import campreview.android.viewmodels.CampgroundViewModel;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class GetCampgroundsByRegionCommandTests extends TestCase {

    @Test
    public void test_integration(){
        IMapper<Campground,CampgroundViewModel> mapper = new CampgroundViewModelMapper();

        ICommand<GetCampgroundsByRegionRequest,GetCampgroundsByRegionResponse> command = new GetCampgroundsByRegionCommand(IoC.getCampgroundRepository(),mapper);

        GetCampgroundsByRegionRequest request = new GetCampgroundsByRegionRequest();

        IRepository<Region> regionRepo = IoC.getRegionRepository();
        List<Region> regions = regionRepo.Find(new AlwaysTrueSpecification<Region>());

        request.RegionId = regions.get(0).RegionId;

        GetCampgroundsByRegionResponse response = command.Execute(request);

        assertEquals(3,response.Campgrounds.size());

    }

    @Test
    public void test_when_getting_campgrounds_for_a_region_then_only_those_in_that_region_are_retrieved(){

        // Arrange
        String regionToSearchFor = "where I want to go";

        IRepository<Campground> repository = new InMemoryRepository<Campground>();

        Campground campground1 = new Campground();
        campground1.RegionId = regionToSearchFor;
        repository.Save(campground1);

        Campground campground2 = new Campground();
        campground2.RegionId = regionToSearchFor;
        repository.Save(campground2);

        Campground campground3 = new Campground();
        campground3.RegionId = "somewhere else";
        repository.Save(campground3);

        IMapper<Campground,CampgroundViewModel> mapper = new CampgroundViewModelMapper();

        ICommand<GetCampgroundsByRegionRequest,GetCampgroundsByRegionResponse> command = new GetCampgroundsByRegionCommand(repository,mapper);

        GetCampgroundsByRegionRequest request = new GetCampgroundsByRegionRequest();
        request.RegionId = regionToSearchFor;

        // Act
        GetCampgroundsByRegionResponse result = command.Execute(request);

        // Assert
        assertEquals(2, result.Campgrounds.size());

    }
}
