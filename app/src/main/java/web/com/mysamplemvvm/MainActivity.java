package web.com.mysamplemvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import web.com.mysamplemvvm.databinding.ActivityMainBinding;
import web.com.mysamplemvvm.model.ScoreViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ScoreViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setSupportActionBar(binding.toolbar);
        viewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);
        binding.incl.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = viewModel.getValue1().getValue();
                viewModel.getValue1().postValue(value+1);
            }
        });
        displayForTeamA(viewModel);

    }

    private void displayForTeamA(final ScoreViewModel viewModel) {
       viewModel.getValue1().observe(this, new Observer<Integer>() {
           @Override
           public void onChanged(@Nullable Integer integer) {
               binding.incl.textView.setText(""+integer);
           }
       });
    }
}
