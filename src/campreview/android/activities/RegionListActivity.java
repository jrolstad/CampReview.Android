package campreview.android.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import campreview.android.application.viewcommands.ViewCommandRequest;
import campreview.android.application.viewmodels.RegionListViewModel;
import campreview.android.application.viewmodels.RegionViewModel;
import campreview.android.application.viewmodels.ViewModelFactory;


public class RegionListActivity extends ListActivity {

    private RegionListViewModel viewModel;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getDependencies();
        setupEvents();
        showRegions();
    }

    private void getDependencies() {
        try{
            ViewModelFactory factory = new ViewModelFactory();

            viewModel = factory.getRegionListViewModel(this.getApplicationContext());
        }
        catch (Exception exception){
            Log.e("RegionListActivity","getDependencies",exception);
        }

    }

    private void showRegions(){

        try{
            viewModel.getRefreshRegionCommand().Execute(ViewCommandRequest.Empty);

            ArrayAdapter<RegionViewModel> adapter =
                                new ArrayAdapter<RegionViewModel>(this,android.R.layout.simple_list_item_1,
                                        viewModel.getRegions());

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
            RegionViewModel region = viewModel.getRegions().get(position)     ;
            Toast.makeText(getApplicationContext(),
                    "Click ListItem Number " + region.getName() + "|" + region.getRegionId(), Toast.LENGTH_LONG)
              .show();
          }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add("New");

        return true;
    }


}