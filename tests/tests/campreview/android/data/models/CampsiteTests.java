package tests.campreview.android.data.models;


import campreview.android.data.models.Campsite;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CampsiteTests {

    private static Campsite _campsite;

    @BeforeClass
    public static void BeforeAll() {
        _campsite = new Campsite(1,"some place",100, 5 ,2,3);
    }

    @Test
    public void id_is_set(){
        assertEquals(_campsite.getCampsiteId(),1, 0);
    }

    @Test
    public void name_is_set(){
        assertEquals(_campsite.getName(),"some place");
    }

    @Test
    public void campground_id_is_set(){
        assertEquals(_campsite.getCampgroundId(),100,0);
    }

    @Test
    public void rating_is_set(){
        assertEquals(_campsite.getRating(),5,0);
    }

    @Test
    public void latitude_is_set(){

        assertEquals(_campsite.getLatitude(),2 ,0);
    }

    @Test
    public void longitude_is_set(){
        assertEquals(_campsite.getLongitude(),3, 0);
    }
}
