package campreview.android.tests.data.models;

import android.test.AndroidTestCase;
import campreview.android.data.models.Campground;

public class CampgroundTests extends AndroidTestCase {

    private static Campground _campground;


    public void setUp() {
        _campground = new Campground("1","some place","100", 5 ,2,3);
    }

    public void test_id_is_set(){
        assertEquals(_campground.getCampgroundId(),"1");
    }

    public void test_name_is_set(){
        assertEquals(_campground.getName(),"some place");
    }

    public void test_region_id_is_set(){
        assertEquals(_campground.getRegion(),"100");
    }

    public void test_rating_is_set(){
        assertEquals(_campground.getRating(),5,0);
    }

    public void test_latitude_is_set(){

        assertEquals(_campground.getLatitude(),2 ,0);
    }

    public void test_longitude_is_set(){
        assertEquals(_campground.getLongitude(),3, 0);
    }
}