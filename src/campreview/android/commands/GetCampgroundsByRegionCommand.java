package campreview.android.commands;

import campreview.android.core.models.Campground;
import campreview.android.data.IRepository;
import campreview.android.mappers.IMapper;
import campreview.android.specifications.CampgroundForRegionSpecification;
import campreview.android.specifications.ISpecification;
import campreview.android.viewmodels.CampgroundViewModel;

import java.util.ArrayList;
import java.util.List;

public class GetCampgroundsByRegionCommand implements ICommand<GetCampgroundsByRegionRequest,GetCampgroundsByRegionResponse> {

    private IRepository<Campground> _repository;
    private IMapper<Campground, CampgroundViewModel> _mapper;

    public GetCampgroundsByRegionCommand(IRepository<Campground> repository, IMapper<Campground,CampgroundViewModel> mapper) {

        _repository = repository;
        _mapper = mapper;
    }

    @Override
    public GetCampgroundsByRegionResponse Execute(GetCampgroundsByRegionRequest request) {

        GetCampgroundsByRegionResponse response = new GetCampgroundsByRegionResponse();

        ISpecification<Campground> specification = new CampgroundForRegionSpecification(request.RegionId);
        List<Campground> campgrounds = _repository.Find(specification);

        List<CampgroundViewModel> viewModels = new ArrayList<CampgroundViewModel>();
        for (Campground campground : campgrounds)
        {
            CampgroundViewModel viewModel = _mapper.Map(campground);
            viewModels.add(viewModel);
        }

        response.Campgrounds = viewModels;

        return response;
    }
}
