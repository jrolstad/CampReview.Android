package campreview.android.ui.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import campreview.android.R;
import campreview.android.commands.*;
import campreview.android.core.models.Region;
import campreview.android.data.IRepository;
import campreview.android.infrastructure.IoC;
import campreview.android.mappers.RegionViewModelMapper;
import campreview.android.ui.views.TextEditPromptView;
import campreview.android.viewmodels.RegionViewModel;

import java.util.Date;
import java.util.List;


public class RegionListActivity extends ListActivity {

    private IRepository<Region> _repository;
    private ICommand<Request, List<RegionViewModel>> _getRegionsCommand;
    private ICommand<NewRegionRequest,NewRegionResponse> _newRegionCommand;
    private TextEditPromptView _newRegionPromptView;

    private ArrayAdapter<RegionViewModel> _adapter;

    public RegionListActivity(){

        this(IoC.GetRegionRepository(),
                new GetRegionsCommand(IoC.GetRegionRepository(), new RegionViewModelMapper()),
                new NewRegionCommand(IoC.GetRegionRepository()),
                new TextEditPromptView());
    }

    public RegionListActivity(IRepository<Region> repository,
                              ICommand<Request,List<RegionViewModel>> getRegionsCommand,
                              ICommand<NewRegionRequest, NewRegionResponse> newRegionCommand,
                              TextEditPromptView textEditPromptView){
        _repository = repository;
        _getRegionsCommand = getRegionsCommand;
        _newRegionCommand = newRegionCommand;
        _newRegionPromptView = textEditPromptView;

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SeedRegions();
        _adapter = new ArrayAdapter<RegionViewModel>(getApplicationContext(), R.layout.list_region);
        refreshRegionList();

        setListAdapter(_adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.region_list_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);

        // Handle item selection
        switch (item.getItemId()) {
            case R.id.new_region:
                showNewRegionPrompt();
                return true;
            case R.id.refresh:
                showLongToastMessage("Refreshing...");
                refreshRegionList();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void refreshRegionList(){

        List<RegionViewModel> regions = _getRegionsCommand.Execute(Request.Empty);

        _adapter.clear();
        _adapter.addAll(regions);
        _adapter.notifyDataSetChanged();

    }

    public void showLongToastMessage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    private void SeedRegions() {
        Region region = new Region();
        region.Name = new Date().toString();
        _repository.Save(region);
    }

    private class cancelNewRegionCommand implements ICommand<Request,Response> {

        @Override
        public Response Execute(Request request) {
            return Response.Empty;
        }
    }

    private class createNewRegionCommand implements ICommand<String,Response>{

        @Override
        public Response Execute(String regionName) {
            if(!regionName.isEmpty())
            {
                NewRegionRequest request = new NewRegionRequest();
                request.RegionName = regionName;

                NewRegionResponse response = _newRegionCommand.Execute(request);
                refreshRegionList();

                String message = "Created Region: " + response.RegionName;
                showLongToastMessage(message);
            }

            return Response.Empty;
        }
    }

    private void showNewRegionPrompt(){
        _newRegionPromptView.show(this,"New Region Name",new createNewRegionCommand(),new cancelNewRegionCommand());
    }



}