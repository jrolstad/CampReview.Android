package tests.campreview.android.data.models;


import campreview.android.data.models.Region;
import org.junit.*;
import static org.junit.Assert.*;


public class RegionTests  {

    private static Region _region;

    @BeforeClass
    public static void BeforeAll() {
        _region = new Region(1,"some place",2,3);
    }

    @Test
    public void region_is_set(){
        assertEquals(_region.getRegionId(),1);
    }

    @Test
    public void name_is_set(){
        assertEquals(_region.getName(),"some place");
    }

    @Test
    public void latitude_is_set(){

        assertEquals(_region.getLatitude(),2 ,0);
    }

    @Test
    public void longitude_is_set(){
        assertEquals(_region.getLongitude(),3, 0);
    }
}
