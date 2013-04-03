package campreview.android.domain.services.regions;

import campreview.android.commands.ICommand;
import campreview.android.commands.QueryResponse;
import campreview.android.commands.Request;
import campreview.android.data.IRepository;
import campreview.android.data.models.Region;

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
