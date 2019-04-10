package com.patient.harman.patientinfo.base;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.patient.harman.patientinfo.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;


/**
 * Created by arupanig on 4/7/2019.
 */

public abstract class BaseFragment extends DaggerFragment {

    private Unbinder unbinder;
    private AppCompatActivity activity;

    @LayoutRes
    protected abstract int layoutRes();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(layoutRes(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (AppCompatActivity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

    public AppCompatActivity getBaseActivity() {
        return activity;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }

    /*
    * Method to check Network Connectivity.
    *
    * @return boolean.
    * */
    protected boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null) {
            showNetworkAlertDialog();
            return false;
        } else
            return true;
    }

    /*
    *
    * Method to show Alert if there is not NetWork.
    * */
    private void showNetworkAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
// Add the buttons
        builder.setTitle(R.string.app_name);
        builder.setMessage(getString(R.string.internet_error_msg));
        builder.setPositiveButton(getString(R.string.ok_btn), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                activity.finish();
            }
        });


// Create the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * Replace the fragment by the given one on the given container, adding the transaction to the back-stack.
     *
     * @param fragment
     * @param containerId
     */
    public void replaceFragment(Fragment fragment, @IdRes int containerId) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(
                R.anim.slide_in_from_right_fragment, R.anim.slide_out_to_left_fragment,
                R.anim.slide_in_from_left_fragment, R.anim.slide_out_to_right_fragment);
        transaction.replace(containerId, fragment, fragment.getClass().getSimpleName());
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

