package campreview.android.commands;

import campreview.android.Specifications.AlwaysTrueSpecification;
import campreview.android.data.IRepository;
import campreview.android.core.models.Region;
import java.util.List;

/**
 * Obtains all regions
 */
public class GetRegionsCommand implements ICommand<Request, List<Region>> {

    private IRepository<Region> _repository;

    public GetRegionsCommand(IRepository<Region> repository) {

        _repository = repository;
    }
    public List<Region> Execute(Request request) {

        List<Region> regions = _repository.Find(new AlwaysTrueSpecification<Region>());

        return regions;
    }
}
