package campreview.android.infrastructure;

import campreview.android.core.models.Region;
import campreview.android.data.IRepository;
import campreview.android.data.InMemoryRepository;

public class IoC {

    private static IRepository<Region> _regionRepository;

    public static IRepository<Region> GetRegionRepository(){
        if(_regionRepository == null)
            _regionRepository = new InMemoryRepository<Region>();

        return _regionRepository;
    }

}
