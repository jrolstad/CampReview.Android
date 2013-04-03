package campreview.android.tests.application.mappers;

import android.test.AndroidTestCase;
import campreview.android.domain.models.Region;
import campreview.android.application.mappers.RegionViewModelMapper;
import campreview.android.application.viewmodels.RegionViewModel;

public class RegionViewModelMapperTests extends AndroidTestCase {

    private Region _region;
    private RegionViewModel _result;

    public void setUp(){
        _region = new Region("id","some name",1,2);

        RegionViewModelMapper mapper = new RegionViewModelMapper();

        _result = mapper.Map(_region);
    }

    public void test_regionId_is_mapped(){
        assertEquals(_region.getRegionId(),_result.getRegionId());
    }

    public void test_name_is_mapped(){
           assertEquals(_region.getName(),_result.getName());
       }
}
