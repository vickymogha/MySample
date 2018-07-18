package web.com.mysamplemvvm.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by DIGITALK on 7/17/2018.
 */

public class ScoreViewModel extends ViewModel {

    MutableLiveData<Integer> value;

    public MutableLiveData<Integer> getValue1() {
        if (value == null) {
            value = new MutableLiveData<Integer>();
            value.setValue(0);

        }
        return value;
    }
}
