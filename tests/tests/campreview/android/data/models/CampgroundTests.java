package tests.campreview.android.data.models;


import campreview.android.data.models.Campground;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CampgroundTests {

    private static Campground _campground;

    @BeforeClass
    public static void BeforeAll() {
        _campground = new Campground(1,"some place",100, 5 ,2,3);
    }

    @Test
    public void id_is_set(){
        assertEquals(_campground.getCampgroundId(),1);
    }

    @Test
    public void name_is_set(){
        assertEquals(_campground.getName(),"some place");
    }

    @Test
    public void region_id_is_set(){
        assertEquals(_campground.getRegion(),100,0);
    }

    @Test
    public void rating_is_set(){
        assertEquals(_campground.getRating(),5,0);
    }

    @Test
    public void latitude_is_set(){

        assertEquals(_campground.getLatitude(),2 ,0);
    }

    @Test
    public void longitude_is_set(){
        assertEquals(_campground.getLongitude(),3, 0);
    }
}
