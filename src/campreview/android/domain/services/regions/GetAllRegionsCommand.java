package campreview.android.domain.services.regions;

import campreview.android.core.commands.ICommand;
import campreview.android.core.commands.QueryResponse;
import campreview.android.core.commands.Request;
import campreview.android.domain.data.IRepository;
import campreview.android.domain.models.Region;

import java.util.List;

public class GetAllRegionsCommand implements ICommand<Request,QueryResponse<Region>> {

    private IRepository<Region,String> repository;

    public GetAllRegionsCommand(IRepository<Region,String> repository){

        this.repository = repository;
    }

    public QueryResponse<Region> Execute(Request request) throws Exception  {

       List<Region> regionData = repository.All();

       return new QueryResponse<Region>(regionData);
    }
}
