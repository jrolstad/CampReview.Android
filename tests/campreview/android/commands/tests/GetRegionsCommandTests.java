package campreview.android.commands.tests;

import campreview.android.commands.GetRegionsCommand;
import campreview.android.commands.ICommand;
import campreview.android.commands.Request;
import campreview.android.core.models.Region;
import campreview.android.data.IRepository;
import campreview.android.data.InMemoryRepository;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class GetRegionsCommandTests extends TestCase {

    @Test
    public void test_when_getting_regions_all_regions_are_retrieved(){

        // Arrange
        IRepository<Region> repository = new InMemoryRepository<Region>();
        repository.Save(new Region());
        repository.Save(new Region());

        ICommand<Request, List<Region>> command = new GetRegionsCommand(repository);

        // Act
        List<Region> result = command.Execute(Request.Empty);

        // Assert
        assertEquals(2,result.size());

    }
}
