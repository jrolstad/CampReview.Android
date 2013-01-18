package campreview.android.ui.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import campreview.android.R;
import campreview.android.commands.*;
import campreview.android.commands.requests.GetCampgroundsByRegionRequest;
import campreview.android.commands.requests.NewCampgroundRequest;
import campreview.android.commands.requests.Request;
import campreview.android.commands.responses.GetCampgroundsByRegionResponse;
import campreview.android.commands.responses.NewCampgroundResponse;
import campreview.android.commands.responses.Response;
import campreview.android.infrastructure.RepositoryBuilder;
import campreview.android.mappers.CampgroundViewModelMapper;
import campreview.android.mappers.IMapper;
import campreview.android.mappers.RegionCampgroundListViewModelIntentMapper;
import campreview.android.ui.views.IMessageView;
import campreview.android.ui.views.IPromptView;
import campreview.android.ui.views.ToastMessageView;
import campreview.android.ui.views.TextEditPromptView;
import campreview.android.viewmodels.CampgroundViewModel;
import campreview.android.viewmodels.RegionCampgroundListViewModel;

public class RegionCampgroundListActivity extends ListActivity {

    private IMapper<Intent, RegionCampgroundListViewModel> _viewModelIntentMapper;
    private IMessageView _messageView;
    private ICommand<GetCampgroundsByRegionRequest, GetCampgroundsByRegionResponse> _getCampgroundsCommand;
    private IPromptView _newCampgroundPromptView;
    private ICommand<NewCampgroundRequest, NewCampgroundResponse> _newCampgroundCommand;

    private RegionCampgroundListViewModel _viewModel;
    private ArrayAdapter<CampgroundViewModel> _adapter;
    private ListActivity self = this;

    public RegionCampgroundListActivity(){
        this(new RegionCampgroundListViewModelIntentMapper(),
                new ToastMessageView(),
                new GetCampgroundsByRegionCommand(RepositoryBuilder.getCampgroundRepository(),new CampgroundViewModelMapper()),
                new TextEditPromptView(),
                new NewCampgroundCommand(RepositoryBuilder.getCampgroundRepository())
        );
    }

    public RegionCampgroundListActivity(
            IMapper<Intent,RegionCampgroundListViewModel> viewModelIntentMapper,
            IMessageView messageView,
            ICommand<GetCampgroundsByRegionRequest,GetCampgroundsByRegionResponse> getCampgroundsCommand,
            IPromptView newCampgroundMessageView,
            ICommand<NewCampgroundRequest,NewCampgroundResponse> newCampgroundCommand){

        _viewModelIntentMapper = viewModelIntentMapper;
        _messageView = messageView;
        _getCampgroundsCommand = getCampgroundsCommand;
        _newCampgroundPromptView = newCampgroundMessageView;
        _newCampgroundCommand = newCampgroundCommand;
    }

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        _viewModel = _viewModelIntentMapper.Map(getIntent());

        _adapter = new ArrayAdapter<CampgroundViewModel>(this, R.layout.list_campground);
        refreshCampgroundList(_viewModel);

        setListAdapter(_adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.campground_list_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle item selection
        switch (item.getItemId()) {
            case R.id.new_campground:
                showNewCampgroundPrompt();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showNewCampgroundPrompt() {
        _newCampgroundPromptView.show(this,"New Campground Name",new createNewCampgroundCommand(),new cancelNewCampgroundCommand());
    }

    private class cancelNewCampgroundCommand implements ICommand<Request,Response> {

        @Override
        public Response Execute(Request request) {
            return Response.Empty;
        }
    }

    private class createNewCampgroundCommand implements ICommand<String,Response>{

        @Override
        public Response Execute(String campgroundName) {
            if(!campgroundName.isEmpty())
            {
                NewCampgroundRequest request = new NewCampgroundRequest();
                request.CampgroundName = campgroundName;
                request.RegionId = _viewModel.RegionId;

                NewCampgroundResponse response = _newCampgroundCommand.Execute(request);
                refreshCampgroundList(_viewModel);

                String message = "Created Campground: " + response.CampgroundName;
                _messageView.show(self,message);
            }

            return Response.Empty;
        }
    }


    private void refreshCampgroundList(RegionCampgroundListViewModel viewModel) {

        GetCampgroundsByRegionRequest request = new GetCampgroundsByRegionRequest();
        request.RegionId = viewModel.RegionId;

        GetCampgroundsByRegionResponse response = _getCampgroundsCommand.Execute(request);

        _adapter.clear();
        _adapter.addAll(response.Campgrounds);
        _adapter.notifyDataSetChanged();
    }
}