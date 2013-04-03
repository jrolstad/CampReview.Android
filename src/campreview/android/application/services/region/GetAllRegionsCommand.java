package campreview.android.application.services.region;

import campreview.android.commands.ICommand;
import campreview.android.commands.QueryResponse;
import campreview.android.commands.Request;
import campreview.android.data.models.Region;
import campreview.android.mappers.IMapper;
import campreview.android.viewmodels.RegionViewModel;

import java.util.ArrayList;

public class GetAllRegionsCommand implements ICommand<Request,ArrayList<RegionViewModel>> {

    private ICommand<Request, QueryResponse<Region>> getAllRegionDataCommand;
    private IMapper<Region, RegionViewModel> viewModelMapper;

    public GetAllRegionsCommand(ICommand<Request,QueryResponse<Region>> getAllRegionDataCommand,
                                IMapper<Region,RegionViewModel> viewModelMapper){

        this.getAllRegionDataCommand = getAllRegionDataCommand;
        this.viewModelMapper = viewModelMapper;
    }

    @Override
    public ArrayList<RegionViewModel> Execute(Request request) throws Exception {
        QueryResponse<Region> regionData = getAllRegionDataCommand.Execute(request);

        ArrayList<RegionViewModel> viewModels = new ArrayList<RegionViewModel>();

        for(Region region: regionData.getResults())
        {
            RegionViewModel viewModel = viewModelMapper.Map(region);
            viewModels.add(viewModel);
        }

        return viewModels;
    }
}
