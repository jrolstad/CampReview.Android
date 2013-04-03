package campreview.android.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import campreview.android.commands.ICommand;
import campreview.android.commands.QueryResponse;
import campreview.android.commands.Request;
import campreview.android.domain.services.regions.GetAllRegionsCommand;
import campreview.android.data.RegionRepository;
import campreview.android.data.RepositoryFactory;
import campreview.android.data.database.DatabaseMigrator;
import campreview.android.data.database.OrmLiteDatabase;
import campreview.android.mappers.RegionViewModelMapper;
import campreview.android.viewmodels.RegionViewModel;


public class RegionListActivity extends ListActivity {

    private ICommand<Request, QueryResponse<RegionViewModel>> allRegionsCommand;
    private QueryResponse<RegionViewModel> allRegions;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getDependencies();
        setupEvents();
        showRegions();
    }

    private void getDependencies() {
        try{
            RepositoryFactory factory = new RepositoryFactory(new OrmLiteDatabase(this.getApplicationContext(),new DatabaseMigrator()));
            RegionRepository repository = factory.RegionRepository();
            RegionViewModelMapper mapper = new RegionViewModelMapper();

            //allRegionsCommand = new GetAllRegionsCommand(repository,mapper);
        }
        catch (Exception exception){
            Log.e("RegionListActivity","getDependencies",exception);
        }

    }

    private void showRegions(){

        try{
            QueryResponse<RegionViewModel> response = allRegionsCommand.Execute(Request.Empty);
            allRegions = response;
            ArrayAdapter<RegionViewModel> adapter =
                    new ArrayAdapter<RegionViewModel>(this,android.R.layout.simple_list_item_1, allRegions.getResults());

            ListView listView = getListView();
            listView.setAdapter(adapter);
        }
        catch(Exception exception){
            Log.e("RegionListActivity","showRegions",exception);
        }
    }

    private void setupEvents(){
        ListView listView = getListView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view,
            int position, long id) {
            RegionViewModel region = allRegions.getResults().get(position)     ;
            Toast.makeText(getApplicationContext(),
                    "Click ListItem Number " + region.getName() + "|" + region.getRegionId(), Toast.LENGTH_LONG)
              .show();
          }
        });
    }
}