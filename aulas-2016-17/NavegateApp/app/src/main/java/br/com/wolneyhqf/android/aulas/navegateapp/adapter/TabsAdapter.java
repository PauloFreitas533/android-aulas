package br.com.wolneyhqf.android.aulas.navegateapp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.wolneyhqf.android.aulas.navegateapp.fragment.FragmentA;
import br.com.wolneyhqf.android.aulas.navegateapp.fragment.FragmentB;
import br.com.wolneyhqf.android.aulas.navegateapp.fragment.FragmentC;

/**
 * Created by wolney on 16/11/16.
 */

public class TabsAdapter extends FragmentPagerAdapter {

    public TabsAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public CharSequence getPageTitle(int position){
        if(position==0){
            return "Frag A";
        }else if(position==1){
            return "Frag B";
        }
        return "Frag C";
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if(position == 0){
            fragment = new FragmentA();
        }else if(position == 1){
            fragment = new FragmentB();
        }else {
            fragment = new FragmentC();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
