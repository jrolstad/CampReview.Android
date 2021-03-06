package campreview.android.infrastructure;

import campreview.android.core.models.Campground;
import campreview.android.core.models.Campsite;
import campreview.android.core.models.Region;
import campreview.android.data.IRepository;
import campreview.android.data.InMemoryRepository;

import java.util.UUID;

public class RepositoryBuilder {

    private static IRepository<Region> _regionRepository = null;

    public static IRepository<Region> getRegionRepository(){
        if(_regionRepository == null)
        {
            _regionRepository = new InMemoryRepository<Region>();
            SeedRegions();
        }

        return _regionRepository;
    }

    private static IRepository<Campground> _campgroundRepository = null;

    public static IRepository<Campground> getCampgroundRepository() {

        if(_campgroundRepository == null)
        {
            _campgroundRepository = new InMemoryRepository<Campground>();
            SeedCampgrounds();
        }
        return _campgroundRepository;

    }

    private static IRepository<Campsite> _campsiteRepository = null;

    public static IRepository<Campsite> getCampsiteRepository() {

        if(_campsiteRepository == null)
        {
            _campsiteRepository = new InMemoryRepository<Campsite>();
            SeedCampsites();
        }
        return _campsiteRepository;

    }

    private static void SeedRegions(){

        Region region1 = new Region();
        region1.RegionId = "1";
        region1.Name = "Washington";
        _regionRepository.Save(region1);

        Region region2 = new Region();
        region2.RegionId = "2";
        region2.Name = "Oregon";
        _regionRepository.Save(region2);

        Region region3 = new Region();
        region3.RegionId = "3";
        region3.Name = "Idaho";
        _regionRepository.Save(region3);
    }

    private static void SeedCampsites(){
        newCampsite("F1","1");
        newCampsite("F2","1");
        newCampsite("F3","1");
        newCampsite("F4","1");

        newCampsite("23","2");
        newCampsite("32","2");
        newCampsite("55","2");
    }

    private static void newCampsite(String siteNumber, String campgroundId){
        Campsite site = new Campsite();
        site.CampgroundId = campgroundId;
        site.SiteNumber = siteNumber;
        site.CampsiteId = UUID.randomUUID().toString();

        _campsiteRepository.Save(site);
    }

    private static void SeedCampgrounds(){

        Campground campground1 = new Campground();
        campground1.RegionId = "1";
        campground1.CampgroundId = "1";
        campground1.Name = "Larrabee State Park";
        _campgroundRepository.Save(campground1);

        Campground campground2 = new Campground();
        campground2.RegionId = "1";
        campground2.CampgroundId = "2";
        campground2.Name = "Rasar State Park";
        _campgroundRepository.Save(campground2);

        Campground campground3 = new Campground();
        campground3.RegionId = "1";
        campground3.CampgroundId = "3";
        campground3.Name = "Flowing Lake County Park";
        _campgroundRepository.Save(campground3);

        Campground campground4 = new Campground();
        campground4.RegionId = "2";
        campground4.CampgroundId = "4";
        campground4.Name = "Nehalem Bay State Park";
        _campgroundRepository.Save(campground4);


    }
}
