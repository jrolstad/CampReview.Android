package campreview.android.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import campreview.android.commands.ICommand;
import campreview.android.commands.QueryResponse;
import campreview.android.commands.Request;
import campreview.android.commands.regions.GetAllRegionsCommand;
import campreview.android.data.RegionRepository;
import campreview.android.data.RepositoryFactory;
import campreview.android.data.database.DatabaseMigrator;
import campreview.android.data.database.OrmLiteDatabase;
import campreview.android.mappers.RegionViewModelMapper;
import campreview.android.viewmodels.RegionViewModel;


public class RegionListActivity extends ListActivity {

    private ICommand<Request, QueryResponse<RegionViewModel>> allRegionsCommand;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getDependencies();
        showRegions();
    }

    private void getDependencies() {
        try{
            RepositoryFactory factory = new RepositoryFactory(new OrmLiteDatabase(this.getApplicationContext(),new DatabaseMigrator()));
            RegionRepository repository = factory.RegionRepository();
            RegionViewModelMapper mapper = new RegionViewModelMapper();

            allRegionsCommand = new GetAllRegionsCommand(repository,mapper);
        }
        catch (Exception exception){
            Log.e("RegionListActivity","getDependencies",exception);
        }

    }

    private void showRegions(){

        try{
            QueryResponse<RegionViewModel> response = allRegionsCommand.Execute(Request.Empty);
            ArrayAdapter<RegionViewModel> adapter =
                    new ArrayAdapter<RegionViewModel>(this,android.R.layout.simple_list_item_1, response.getResults());

            ListView listView = getListView();
            listView.setAdapter(adapter);
        }
        catch(Exception exception){
            Log.e("RegionListActivity","showRegions",exception);
        }
    }
}