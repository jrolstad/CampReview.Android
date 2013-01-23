package campreview.android.tests.data.models;

import android.test.AndroidTestCase;
import campreview.android.data.models.Region;

public class RegionTests extends AndroidTestCase {

    private static Region _region;

    public  void setUp() {
        _region = new Region("1","some place",2,3);
    }

    public void test_region_is_set(){
        assertEquals(_region.getRegionId(),"1");
    }

    public void test_name_is_set(){
        assertEquals(_region.getName(),"some place");
    }

    public void test_latitude_is_set(){

        assertEquals(_region.getLatitude(),2 ,0);
    }

    public void test_longitude_is_set(){
        assertEquals(_region.getLongitude(),3, 0);
    }
}