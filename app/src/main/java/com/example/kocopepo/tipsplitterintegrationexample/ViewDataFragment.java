package com.example.kocopepo.tipsplitterintegrationexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Martin Kocour
 *         created on 13.4.17
 */

public class ViewDataFragment extends Fragment {

    public static ViewDataFragment newInstance() {

        Bundle args = new Bundle();

        ViewDataFragment fragment = new ViewDataFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
