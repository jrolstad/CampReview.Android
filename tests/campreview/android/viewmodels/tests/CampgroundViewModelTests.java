package campreview.android.viewmodels.tests;

import campreview.android.viewmodels.CampgroundViewModel;
import junit.framework.TestCase;
import org.junit.Test;

public class CampgroundViewModelTests extends TestCase {

    @Test
    public void test_when_converting_to_a_string_then_the_campground_name_is_returned(){

        // Arrange
        CampgroundViewModel viewModel = new CampgroundViewModel();
        viewModel.Name = "Some Place, eh?";

        // Act
        String result = viewModel.toString();

        // Assert
        assertEquals(viewModel.Name,result);
    }
}
