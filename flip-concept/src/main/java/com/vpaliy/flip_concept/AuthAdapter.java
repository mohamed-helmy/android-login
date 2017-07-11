package com.vpaliy.flip_concept;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;

public class AuthAdapter extends FragmentStatePagerAdapter
        implements AuthFragment.Callback{

    private ViewPager pager;
    private SparseArray<AuthFragment> authArray;

    public AuthAdapter(FragmentManager manager, ViewPager pager){
        super(manager);
        this.pager=pager;
        this.authArray=new SparseArray<>(getCount());
    }

    @Override
    public AuthFragment getItem(int position) {
        AuthFragment fragment=authArray.get(position);
        if(fragment==null){
            fragment=position!=1?new LogInFragment():new SignUpFragment();
            authArray.put(position,fragment);
            fragment.setCallback(this);
        }
        return fragment;
    }

    @Override
    public void show(AuthFragment fragment) {
        final int index=authArray.keyAt(authArray.indexOfValue(fragment));
        pager.setCurrentItem(index,true);
        for(int jIndex=0;jIndex<authArray.size();jIndex++){
            if(jIndex!=index){
               // authArray.get(jIndex).fold();
            }
        }
    }

    @Override
    public float getPageWidth(int position) {
        return 0.89f;
    }

    @Override
    public int getCount() {
        return 2;
    }
}