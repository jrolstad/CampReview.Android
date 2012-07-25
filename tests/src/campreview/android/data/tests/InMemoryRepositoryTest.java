package campreview.android.data.tests;

import campreview.android.core.models.Region;
import campreview.android.data.InMemoryRepository;
import campreview.android.data.Specification;
import junit.framework.TestCase;

import java.util.List;

public class InMemoryRepositoryTest extends TestCase {

    public void when_searching_for_an_item_all_are_found() throws Exception {
        // Arrange
        Region regionToSave = new Region();

        InMemoryRepository repository = new InMemoryRepository();
        repository.Save(regionToSave);

        // Act
        List<Region> regions = repository.Find(new Specification<Region>(Region.class));

        // Assert
        assertNotNull(regions);

    }

}
