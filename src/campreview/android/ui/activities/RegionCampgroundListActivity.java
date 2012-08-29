package campreview.android.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import campreview.android.mappers.IMapper;
import campreview.android.mappers.RegionCampgroundListViewModelIntentMapper;
import campreview.android.ui.views.IMessageView;
import campreview.android.ui.views.MessageView;
import campreview.android.viewmodels.RegionCampgroundListViewModel;

public class RegionCampgroundListActivity extends Activity {

    private IMapper<Intent, RegionCampgroundListViewModel> _viewModelIntentMapper;
    private IMessageView _messageView;

    private RegionCampgroundListViewModel _viewModel;

    public RegionCampgroundListActivity(){
        this(new RegionCampgroundListViewModelIntentMapper(),
                new MessageView());
    }

    public RegionCampgroundListActivity(
            IMapper<Intent,RegionCampgroundListViewModel> viewModelIntentMapper,
            IMessageView messageView){

        _viewModelIntentMapper = viewModelIntentMapper;
        _messageView = messageView;
    }

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        _viewModel = _viewModelIntentMapper.Map(getIntent());

        _messageView.show(this,_viewModel.RegionName);
    }
}