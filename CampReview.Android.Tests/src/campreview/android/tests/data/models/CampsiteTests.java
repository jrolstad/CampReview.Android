package campreview.android.tests.data.models;

import android.test.AndroidTestCase;
import campreview.android.data.models.Campsite;

public class CampsiteTests extends AndroidTestCase {

    private static Campsite _campsite;

    public void setUp() {
        _campsite = new Campsite("1","some place","100", 5 ,2,3);
    }

    public void test_id_is_set(){
        assertEquals(_campsite.getCampsiteId(),"1");
    }

    public void test_name_is_set(){
        assertEquals(_campsite.getName(),"some place");
    }

    public void test_campground_id_is_set(){
        assertEquals(_campsite.getCampgroundId(),"100");
    }

    public void test_rating_is_set(){
        assertEquals(_campsite.getRating(),5,0);
    }

    public void test_latitude_is_set(){

        assertEquals(_campsite.getLatitude(),2 ,0);
    }

    public void test_longitude_is_set(){
        assertEquals(_campsite.getLongitude(),3, 0);
    }
}
