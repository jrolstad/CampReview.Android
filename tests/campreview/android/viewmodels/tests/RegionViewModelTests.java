package campreview.android.viewmodels.tests;

import campreview.android.viewmodels.RegionViewModel;
import junit.framework.TestCase;
import org.junit.Test;

public class RegionViewModelTests extends TestCase {

    @Test
    public void test_when_converting_to_a_string_then_the_region_name_is_returned(){

        // Arrange
        RegionViewModel viewModel = new RegionViewModel();
        viewModel.Name = "Some Region, eh?";

        // Act
        String result = viewModel.toString();

        // Assert
        assertEquals(viewModel.Name,result);
    }
}
