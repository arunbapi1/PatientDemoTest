package com.patient.harman.patientinfo.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.patient.harman.patientinfo.R;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;


/**
 * Created by arupanig on 4/6/2019.
 */

public abstract class BaseActivity extends DaggerAppCompatActivity {

    @LayoutRes
    protected abstract int layoutRes();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutRes());
        ButterKnife.bind(this);
    }

    /**
     * Add a fragment to the given container.
     *
     * @param fragment
     * @param containerId
     */
    public void addFragment(Fragment fragment, @IdRes int containerId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(containerId, fragment);
        transaction.commit();
    }

    /**
     * Remove the fragment.
     *
     * @param fragment
     */
    public void removeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.remove(fragment);
        transaction.commitAllowingStateLoss();
    }

    /**
     * Replace the fragment by the given one on the given container, adding the transaction to the back-stack.
     *
     * @param fragment
     * @param containerId
     */
    public void replaceFragment(Fragment fragment, @IdRes int containerId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(
                R.anim.slide_in_from_right_fragment, R.anim.slide_out_to_left_fragment,
                R.anim.slide_in_from_left_fragment, R.anim.slide_out_to_right_fragment);
        transaction.replace(containerId, fragment, fragment.getClass().getSimpleName());
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
