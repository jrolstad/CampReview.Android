package tests.campreview.android.data;

import campreview.android.data.CampgroundRepository;
import campreview.android.data.models.Campground;
import org.junit.*;

import java.util.List;
import static org.junit.Assert.*;

public class CampgroundRepositoryTests {

    private CampgroundRepository _repository;

    @Before
    public void BeforeEach(){
        _repository = new CampgroundRepository();

        ClearDatabase();

        CreateRegion(100, "Washington");
        CreateRegion(200, "Oregon");

        CreateCampground(1, 100, "Rasar State Park");
        CreateCampground(2,100,"Larrabee State Park");
        CreateCampground(3,200,"South Beach State Park");
    }

    private void CreateCampground(int id, int regionid, String name) {

    }

    private void ClearDatabase(){

    }
    private void CreateRegion(int id, String name){

    }

    @Test
    public void GetByRegion_gets_all_campgrounds_in_a_region(){
        List<Campground> campgroundsInRegion = _repository.GetByRegion(100);

        assertEquals(2,campgroundsInRegion.size());
    }

    @Test
    public void Get_gets_a_single_campground(){
        Campground campground = _repository.Get(2);

        assertEquals("Larrabee State Park",campground.getName());

    }

    @Test
    public void Save_saves_an_new_campground(){
        Campground campground = new Campground(0,"Nehalem Bay",200,3,1,1);
        _repository.Save(campground);

        List<Campground> campgroundsInRegion = _repository.GetByRegion(200);

        assertEquals(2,campgroundsInRegion.size());
    }
}
