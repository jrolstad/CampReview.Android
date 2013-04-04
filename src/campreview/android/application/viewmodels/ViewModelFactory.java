package campreview.android.application.viewmodels;

import android.content.Context;
import campreview.android.application.mappers.RegionViewModelMapper;
import campreview.android.application.services.region.CreateRegionRequest;
import campreview.android.application.services.region.CreateRegionResponse;
import campreview.android.application.services.region.CreateRegionViewCommand;
import campreview.android.application.services.region.GetAllRegionsViewCommand;
import campreview.android.application.viewcommands.IViewCommand;
import campreview.android.application.viewcommands.ViewCommandRequest;
import campreview.android.core.commands.ICommand;
import campreview.android.core.commands.QueryResponse;
import campreview.android.core.commands.Request;
import campreview.android.domain.data.RegionRepository;
import campreview.android.domain.data.RepositoryFactory;
import campreview.android.domain.data.database.DatabaseMigrator;
import campreview.android.domain.data.database.OrmLiteDatabase;
import campreview.android.domain.models.Region;
import campreview.android.domain.services.regions.CreateRegionCommand;
import campreview.android.domain.services.regions.GetAllRegionsCommand;

import java.util.ArrayList;

public class ViewModelFactory {


    public RegionListViewModel getRegionListViewModel(Context context) throws Exception {

        RepositoryFactory factory = new RepositoryFactory(new OrmLiteDatabase(context,new DatabaseMigrator()));
        RegionRepository repository = factory.RegionRepository();

        RegionViewModelMapper mapper = new RegionViewModelMapper();

        ICommand<Request,QueryResponse<Region>> getAllRegionsDomainCommand =
                new GetAllRegionsCommand(repository);

        IViewCommand<ViewCommandRequest, ArrayList<RegionViewModel>> refreshRegionViewCommand
                = new GetAllRegionsViewCommand(getAllRegionsDomainCommand,mapper);

        ICommand<campreview.android.domain.services.regions.CreateRegionRequest,campreview.android.domain.services.regions.CreateRegionResponse> createRegionDomainCommand
                = new CreateRegionCommand(repository);

        IViewCommand<CreateRegionRequest,CreateRegionResponse> createRegionViewCommand
                = new CreateRegionViewCommand(createRegionDomainCommand);

        return new RegionListViewModel(refreshRegionViewCommand,createRegionViewCommand);
    }
}
