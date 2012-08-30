package campreview.android.ui.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import campreview.android.R;
import campreview.android.commands.GetCampgroundsByRegionCommand;
import campreview.android.commands.GetCampgroundsByRegionRequest;
import campreview.android.commands.GetCampgroundsByRegionResponse;
import campreview.android.commands.ICommand;
import campreview.android.infrastructure.IoC;
import campreview.android.mappers.CampgroundViewModelMapper;
import campreview.android.mappers.IMapper;
import campreview.android.mappers.RegionCampgroundListViewModelIntentMapper;
import campreview.android.ui.views.IMessageView;
import campreview.android.ui.views.MessageView;
import campreview.android.viewmodels.CampgroundViewModel;
import campreview.android.viewmodels.RegionCampgroundListViewModel;

public class RegionCampgroundListActivity extends ListActivity {

    private IMapper<Intent, RegionCampgroundListViewModel> _viewModelIntentMapper;
    private IMessageView _messageView;
    private ICommand<GetCampgroundsByRegionRequest, GetCampgroundsByRegionResponse> _getCampgroundsCommand;

    private RegionCampgroundListViewModel _viewModel;
    private ArrayAdapter<CampgroundViewModel> _adapter;
    private ListActivity self = this;

    public RegionCampgroundListActivity(){
        this(new RegionCampgroundListViewModelIntentMapper(),
                new MessageView(),
                new GetCampgroundsByRegionCommand(IoC.getCampgroundRepository(),new CampgroundViewModelMapper()));
    }

    public RegionCampgroundListActivity(
            IMapper<Intent,RegionCampgroundListViewModel> viewModelIntentMapper,
            IMessageView messageView,
            ICommand<GetCampgroundsByRegionRequest,GetCampgroundsByRegionResponse> getCampgroundsCommand){

        _viewModelIntentMapper = viewModelIntentMapper;
        _messageView = messageView;
        _getCampgroundsCommand = getCampgroundsCommand;
    }

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        _viewModel = _viewModelIntentMapper.Map(getIntent());

        _adapter = new ArrayAdapter<CampgroundViewModel>(this, R.layout.list_campground);
        refreshCampgroundList(_viewModel);

        setListAdapter(_adapter);
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