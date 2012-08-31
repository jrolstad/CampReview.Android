package campreview.android.commands;

import campreview.android.commands.requests.GetCampsiteByCampgroundRequest;
import campreview.android.commands.responses.GetCampsiteByCampgroundResponse;
import campreview.android.core.models.Campsite;
import campreview.android.data.IRepository;
import campreview.android.mappers.IMapper;
import campreview.android.specifications.CampsiteForCampgroundSpecification;
import campreview.android.specifications.ISpecification;
import campreview.android.viewmodels.CampsiteViewModel;

import java.util.ArrayList;
import java.util.List;

public class GetCampsiteByCampgroundCommand implements ICommand<GetCampsiteByCampgroundRequest, GetCampsiteByCampgroundResponse> {

    private IRepository<Campsite> _repository;
    private IMapper<Campsite, CampsiteViewModel> _mapper;

    public GetCampsiteByCampgroundCommand(IRepository<Campsite> repository, IMapper<Campsite,CampsiteViewModel> mapper) {

        _repository = repository;
        _mapper = mapper;
    }

    @Override
    public GetCampsiteByCampgroundResponse Execute(GetCampsiteByCampgroundRequest request) {

        GetCampsiteByCampgroundResponse response = new GetCampsiteByCampgroundResponse();

        ISpecification<Campsite> specification = new CampsiteForCampgroundSpecification(request.CampgroundId);
        List<Campsite> campsites = _repository.Find(specification);

        List<CampsiteViewModel> viewModels = new ArrayList<CampsiteViewModel>();
        for (Campsite campsite : campsites)
        {
            CampsiteViewModel viewModel = _mapper.Map(campsite);
            viewModels.add(viewModel);
        }

        response.Campsites = viewModels;

        return response;
    }
}
