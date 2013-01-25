package campreview.android.tests.viewmodels;

import android.test.AndroidTestCase;
import campreview.android.viewmodels.RegionViewModel;

public class RegionViewModelTests extends AndroidTestCase {

    private RegionViewModel _viewModel;

    public void setUp(){
        _viewModel = new RegionViewModel("my id","my name");
    }

    public void test_getName(){
        assertEquals("my name",_viewModel.getName());
    }

    public void test_getId(){
        assertEquals("my id",_viewModel.getRegionId());
    }

    public void test_toString_returns_the_name(){
        assertEquals("my name",_viewModel.toString());
    }
}
