package campreview.android.application.services.region;

import campreview.android.application.viewcommands.IViewCommand;
import campreview.android.application.viewcommands.ViewCommandRequest;
import campreview.android.core.commands.ICommand;
import campreview.android.core.commands.QueryResponse;
import campreview.android.core.commands.Request;
import campreview.android.domain.models.Region;
import campreview.android.core.mappers.IMapper;
import campreview.android.application.viewmodels.RegionViewModel;

import java.util.ArrayList;

public class GetAllRegionsViewCommand implements IViewCommand<ViewCommandRequest,ArrayList<RegionViewModel>> {

    private ICommand<Request, QueryResponse<Region>> getAllRegionDataCommand;
    private IMapper<Region, RegionViewModel> viewModelMapper;

    public GetAllRegionsViewCommand(ICommand<Request,QueryResponse<Region>> getAllRegionDataCommand,
                                IMapper<Region,RegionViewModel> viewModelMapper){

        this.getAllRegionDataCommand = getAllRegionDataCommand;
        this.viewModelMapper = viewModelMapper;
    }

    @Override
    public ArrayList<RegionViewModel> Execute(ViewCommandRequest request) throws Exception {
        QueryResponse<Region> regionData = getAllRegionDataCommand.Execute(Request.Empty);

        ArrayList<RegionViewModel> viewModels = new ArrayList<RegionViewModel>();

        for(Region region: regionData.getResults())
        {
            RegionViewModel viewModel = viewModelMapper.Map(region);
            viewModels.add(viewModel);
        }

        return viewModels;
    }
}
