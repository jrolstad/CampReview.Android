package campreview.android.commands;

import campreview.android.viewmodels.Region;

import java.util.ArrayList;
import java.util.List;

/**
 * Obtains all regions
 */
public class GetRegionsCommand implements ICommand<Request, List<Region>> {

    public List<Region> Execute(Request request) {
        List<Region> regions =  new ArrayList<Region>();

        regions.add(new Region(){{Name="One";RegionId = "1";}});
        regions.add(new Region(){{Name="Two";RegionId = "2";}});
        regions.add(new Region(){{Name="Three";RegionId = "3";}});

        return regions;
    }
}
