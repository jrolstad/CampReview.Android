package campreview.android.application.viewmodels;

import campreview.android.application.services.region.CreateRegionRequest;
import campreview.android.application.services.region.CreateRegionResponse;
import campreview.android.application.viewcommands.IViewCommand;
import campreview.android.application.viewcommands.ViewCommandRequest;

import java.util.ArrayList;

public class RegionListViewModel {

    private ArrayList<RegionViewModel> regions;
    private IViewCommand<ViewCommandRequest, ArrayList<RegionViewModel>> refreshCommand;
    private IViewCommand<CreateRegionRequest, CreateRegionResponse> createRegionCommand;

    public RegionListViewModel(IViewCommand<ViewCommandRequest,ArrayList<RegionViewModel>> refreshCommand,
                               IViewCommand<CreateRegionRequest,CreateRegionResponse> createRegionCommand){

        this.refreshCommand = refreshCommand;
        this.createRegionCommand = createRegionCommand;
    }

    public ArrayList<RegionViewModel> getRegions(){
        return regions;
    }

    public IViewCommand<ViewCommandRequest,ArrayList<RegionViewModel>> getRefreshRegionCommand(){
        return refreshCommand;
    }

    public IViewCommand<CreateRegionRequest,CreateRegionResponse> getCreateRegionCommand(){
        return createRegionCommand;
    }
}
