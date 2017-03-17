package br.com.wolneyhqf.android.aulas.navegateapp.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.wolneyhqf.android.aulas.navegateapp.R;
import br.com.wolneyhqf.android.aulas.navegateapp.adapter.TabsAdapter;

/**
 * Created by wolney on 16/11/16.
 */

public class TabsFragment extends Fragment {

    public static final String TAG = "TabsFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_tabs, container, false);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new TabsAdapter(getChildFragmentManager()));

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        int cor = ContextCompat.getColor(getContext(), R.color.white);
        tabLayout.setTabTextColors(cor, cor);

        return view;
    }

}
