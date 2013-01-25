package campreview.android.commands.regions;

import campreview.android.commands.ICommand;
import campreview.android.commands.QueryResponse;
import campreview.android.commands.Request;
import campreview.android.data.RegionRepository;
import campreview.android.data.models.Region;
import campreview.android.mappers.IMapper;
import campreview.android.viewmodels.RegionViewModel;

import java.util.ArrayList;
import java.util.List;

public class GetAllRegionsCommand implements ICommand<Request,QueryResponse<RegionViewModel>> {

    private RegionRepository repository;
    private final IMapper<Region, RegionViewModel> mapper;

    public GetAllRegionsCommand(RegionRepository repository, IMapper<Region,RegionViewModel> mapper){

        this.repository = repository;
        this.mapper = mapper;
    }

    public QueryResponse<RegionViewModel> Execute(Request request) throws Exception  {
       List<Region> regionData = repository.All();

       List<RegionViewModel> regions = new ArrayList<RegionViewModel>();

       for(Region region:regionData){
           RegionViewModel viewModel = mapper.Map(region);
           regions.add(viewModel);
       }
        return new QueryResponse<RegionViewModel>(regions);
    }
}
