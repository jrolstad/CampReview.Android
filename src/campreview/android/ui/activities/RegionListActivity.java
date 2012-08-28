package campreview.android.ui.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import campreview.android.R;
import campreview.android.commands.GetRegionsCommand;
import campreview.android.commands.ICommand;
import campreview.android.commands.Request;
import campreview.android.core.models.Region;
import campreview.android.data.InMemoryRepository;
import campreview.android.mappers.RegionViewModelMapper;
import campreview.android.viewmodels.RegionViewModel;

import java.util.Date;
import java.util.List;


public class RegionListActivity extends ListActivity {

    private final InMemoryRepository<Region> _repository = new InMemoryRepository<Region>();
    private ICommand<Request, List<RegionViewModel>> _getRegionsCommand = new GetRegionsCommand(_repository, new RegionViewModelMapper());

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SeedRegions();

        ArrayAdapter<RegionViewModel> adapter = new ArrayAdapter<RegionViewModel>(getApplicationContext(), R.layout.list_region);
        adapter.addAll(_getRegionsCommand.Execute(Request.Empty));

        setListAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.region_list_menu, menu);

        return true;
    }

    private void SeedRegions() {
        Region region = new Region();
        region.Name = new Date().toString();
        _repository.Save(region);
    }

}