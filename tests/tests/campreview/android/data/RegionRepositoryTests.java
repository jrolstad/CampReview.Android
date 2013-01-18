package tests.campreview.android.data;

import campreview.android.data.RegionRepository;
import campreview.android.data.models.Region;
import org.junit.*;

import java.util.List;
import static org.junit.Assert.*;

public class RegionRepositoryTests {

    private RegionRepository _repository;

    @Before
    public void BeforeEach(){
        _repository = new RegionRepository();

        ClearDatabase();
        CreateRegion(1, "Washington");
        CreateRegion(2, "Oregon");
        CreateRegion(3,"Idaho");
    }

    private void ClearDatabase(){

    }
    private void CreateRegion(int id, String name){

    }

    @Test
    public void All_gets_all_regions(){
        List<Region> allRegions = _repository.All();

        assertEquals(3,allRegions.size());
    }

    @Test
    public void Get_gets_a_single_region(){
        Region region = _repository.Get(2);

        assertEquals("Oregon",region.getName());

    }

    @Test
    public void Save_saves_an_new_region(){
        Region region = new Region(0,"California",1,1);
        _repository.Save(region);

        List<Region> allRegions = _repository.All();

        assertEquals(4,allRegions.size());
    }
}
