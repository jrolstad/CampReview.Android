package campreview.android.ui.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import campreview.android.R;
import campreview.android.commands.*;
import campreview.android.core.models.Region;
import campreview.android.data.IRepository;
import campreview.android.infrastructure.IoC;
import campreview.android.mappers.RegionViewModelMapper;
import campreview.android.messaging.IIntentPublisher;
import campreview.android.messaging.IntentPublisher;
import campreview.android.ui.views.IMessageView;
import campreview.android.ui.views.MessageView;
import campreview.android.ui.views.TextEditPromptView;
import campreview.android.viewmodels.RegionViewModel;

import java.util.List;


public class RegionListActivity extends ListActivity {

    private IRepository<Region> _repository;
    private ICommand<Request, List<RegionViewModel>> _getRegionsCommand;
    private ICommand<NewRegionRequest,NewRegionResponse> _newRegionCommand;
    private TextEditPromptView _newRegionPromptView;
    private IIntentPublisher _intentPublisher;
    private IMessageView _messageView;

    private ArrayAdapter<RegionViewModel> _adapter;
    private ListActivity self = this;

    public RegionListActivity(){

        this(IoC.GetRegionRepository(),
                new GetRegionsCommand(IoC.GetRegionRepository(), new RegionViewModelMapper()),
                new NewRegionCommand(IoC.GetRegionRepository()),
                new TextEditPromptView(),
                new IntentPublisher(),
                new MessageView());
    }

    public RegionListActivity(IRepository<Region> repository,
                              ICommand<Request,List<RegionViewModel>> getRegionsCommand,
                              ICommand<NewRegionRequest, NewRegionResponse> newRegionCommand,
                              TextEditPromptView textEditPromptView,
                              IIntentPublisher intentPublisher,
                              IMessageView messageView){
        _repository = repository;
        _getRegionsCommand = getRegionsCommand;
        _newRegionCommand = newRegionCommand;
        _newRegionPromptView = textEditPromptView;
        _intentPublisher = intentPublisher;
        _messageView = messageView;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        // Handle item selection
        switch (item.getItemId()) {
            case R.id.new_region:
                showNewRegionPrompt();
                return true;
            case R.id.refresh:
                handleRefreshRegion();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void handleRefreshRegion() {
        _messageView.show(this, "Refreshing...");
        refreshRegionList();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        RegionViewModel selectedRegion = _adapter.getItem(position);
        showRegionDetails(selectedRegion);
    }

    private void showRegionDetails(RegionViewModel selectedRegion) {

        Intent showDetailsIntent = new Intent(this,RegionCampgroundListActivity.class);
        showDetailsIntent.putExtra("region_id", selectedRegion.RegionId);
        showDetailsIntent.putExtra("region_name",selectedRegion.Name);

        _intentPublisher.PublishStartActivity(this,showDetailsIntent);
    }

    public void refreshRegionList(){

        List<RegionViewModel> regions = _getRegionsCommand.Execute(Request.Empty);

        _adapter.clear();
        _adapter.addAll(regions);
        _adapter.notifyDataSetChanged();

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
                _messageView.show(self,message);
            }

            return Response.Empty;
        }
    }

    private void showNewRegionPrompt(){
        _newRegionPromptView.show(this,"New Region Name",new createNewRegionCommand(),new cancelNewRegionCommand());
    }



}