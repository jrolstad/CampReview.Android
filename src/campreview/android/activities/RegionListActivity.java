package campreview.android.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import campreview.android.data.RegionRepository;
import campreview.android.data.RepositoryFactory;
import campreview.android.data.database.DatabaseMigrator;
import campreview.android.data.database.OrmLiteDatabase;
import campreview.android.data.models.Region;
import campreview.android.mappers.IMapper;
import campreview.android.mappers.RegionViewModelMapper;
import campreview.android.viewmodels.RegionViewModel;

import java.util.ArrayList;
import java.util.List;


public class RegionListActivity extends ListActivity {

    private RegionRepository repository;
    private IMapper<Region,RegionViewModel> viewModelMapper;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getDependencies();
        showRegions();
    }

    private void getDependencies() {
        RepositoryFactory factory = new RepositoryFactory(new OrmLiteDatabase(this.getApplicationContext(),new DatabaseMigrator()));
        try {
            repository = factory.RegionRepository();
        } catch (Exception e) {
            Log.e("campreview.android", "failed when getting repository", e);
        }

        viewModelMapper = new RegionViewModelMapper();

    }

    private void showRegions(){

        try{
        List<Region> regionData = repository.All();

        List<RegionViewModel> regions = new ArrayList<RegionViewModel>();

        for(Region region:regionData){
            RegionViewModel viewModel = viewModelMapper.Map(region);
            regions.add(viewModel);
        }


        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        ArrayAdapter<RegionViewModel> adapter = new ArrayAdapter<RegionViewModel>(this,android.R.layout.simple_list_item_1, regions);


        // Assign adapter to ListView
        ListView listView = getListView();
        listView.setAdapter(adapter);
        }
        catch (Exception e){
             Log.e("campreview.android","obtaining regions",e);
        }
    }
}