package campreview.android.commands;

import campreview.android.commands.requests.Request;
import campreview.android.specifications.AlwaysTrueSpecification;
import campreview.android.data.IRepository;
import campreview.android.core.models.Region;
import campreview.android.mappers.IMapper;
import campreview.android.viewmodels.RegionViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Obtains all regions
 */
public class GetRegionsCommand implements ICommand<Request, List<RegionViewModel>> {

    private IRepository<Region> _repository;
    private IMapper<Region, RegionViewModel> _regionMapper;

    public GetRegionsCommand(IRepository<Region> repository, IMapper<Region,RegionViewModel> regionMapper) {

        _repository = repository;
        _regionMapper = regionMapper;
    }
    public List<RegionViewModel> Execute(Request request) {

        List<Region> regions = _repository.Find(new AlwaysTrueSpecification<Region>());

        List<RegionViewModel> viewModels = new ArrayList<RegionViewModel>();
        for (Region region : regions)
        {
            RegionViewModel viewModel = _regionMapper.Map(region);
            viewModels.add(viewModel);
        }

        return viewModels;
    }
}
