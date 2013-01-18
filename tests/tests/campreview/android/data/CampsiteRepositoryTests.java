package tests.campreview.android.data;

import campreview.android.data.CampsiteRepository;
import campreview.android.data.models.Campsite;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CampsiteRepositoryTests {

    private CampsiteRepository _repository;

    @Before
    public void BeforeEach(){
        _repository = new CampsiteRepository();

        ClearDatabase();

        CreateRegion(100, "Washington");
        CreateCampground(1, 100, "Rasar State Park");

        CreateCampsite(1,"F1");
        CreateCampsite(2,"A4");
        CreateCampsite(3,"Yurt 5");

    }

    private void CreateCampsite(int campgroundId, String name) {

    }

    private void CreateCampground(int id, int regionid, String name) {

    }

    private void ClearDatabase(){

    }
    private void CreateRegion(int id, String name){

    }

    @Test
    public void GetByCampground_gets_all_campsites_in_a_campground(){
        List<Campsite> campsites = _repository.GetByCampground(1);

        assertEquals(3, campsites.size());
    }

    @Test
    public void Get_gets_a_single_campsite(){
        Campsite campsite = _repository.Get(2);

        assertEquals("A4", campsite.getName());

    }

    @Test
    public void Save_saves_an_new_campground(){
        Campsite campsite = new Campsite(0,"Cabin 2",1,3,1,1);
        _repository.Save(campsite);

        List<Campsite> campsites = _repository.GetByCampground(1);

        assertEquals(4, campsites.size());
    }
}
