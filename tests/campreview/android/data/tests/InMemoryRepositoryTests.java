package campreview.android.data.tests;

import campreview.android.core.models.Region;
import campreview.android.specifications.AlwaysTrueSpecification;
import campreview.android.data.InMemoryRepository;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class InMemoryRepositoryTests extends TestCase {

    @Test
    public void test_when_searching_for_an_item_all_are_found() throws Exception {

        // Arrange
        Region regionToSave = new Region();

        InMemoryRepository repository = new InMemoryRepository<Region>();
        repository.Save(regionToSave);

        // Act
        List<Region> regions = repository.Find(new AlwaysTrueSpecification<Region>());

        // Assert
        assertNotNull(regions);
        assertEquals(1,regions.size());
    }

    @Test
    public void test_when_getting_an_item_then_it_is_retrieved() throws Exception {

        // Arrange
        Region regionToSave = new Region();
        regionToSave.Name = "my region";
        regionToSave.RegionId = "34";

        InMemoryRepository repository = new InMemoryRepository<Region>();
        repository.Save(regionToSave);

        // Act
        Region result = (Region) repository.Get("34");

        // Assert
        assertEquals(regionToSave.RegionId,result.RegionId);
        assertEquals(regionToSave.Name,result.Name);
    }

    @Test
    public void test_when_getting_an_unknown_item_then_null_is_retrieved() throws Exception {

        // Arrange
        Region regionToSave = new Region();
        regionToSave.Name = "my region";
        regionToSave.RegionId = "34";

        InMemoryRepository repository = new InMemoryRepository<Region>();
        repository.Save(regionToSave);

        // Act
        Region result = (Region) repository.Get("37");

        // Assert
        assertNull(result);
    }

    @Test
    public void test_when_deleting_an_item_then_it_is_deleted() throws Exception {

        // Arrange
        Region regionToSave = new Region();

        InMemoryRepository repository = new InMemoryRepository<Region>();
        repository.Save(regionToSave);

        // Act
        repository.Delete(regionToSave);

        // Assert
        List<Region> regions = repository.Find(new AlwaysTrueSpecification<Region>());
        assertEquals(0,regions.size());
    }


}
