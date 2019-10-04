package com.example.inmobiliaria.ui.op_inquilinos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.inmobiliaria.InquilinoSelectFragment;
import com.example.inmobiliaria.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class OpInquilino extends Fragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;

    private OpInquilinoViewModel opInquilinoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        opInquilinoViewModel =
                ViewModelProviders.of(this).get(OpInquilinoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_inquilino, container, false);

        viewPager=root.findViewById(R.id.viewPager);
        appBarLayout=root.findViewById(R.id.appBar);
        tabLayout=new TabLayout(getActivity());

        appBarLayout.addView(tabLayout);

        ViewPageAdapter vpa=new ViewPageAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpa.addFragment(new InquilinoSelectFragment(),"Inquilino 1");
        vpa.addFragment(new InquilinoSelectFragment(),"Inquilino 2");
        viewPager.setAdapter(vpa);
        tabLayout.setupWithViewPager(viewPager);
        return root;
    }

    public class ViewPageAdapter extends FragmentPagerAdapter{
        List<Fragment> fragmentList=new ArrayList<>();
        List<String> titulosFragment=new ArrayList<>();

        public ViewPageAdapter(@NonNull FragmentManager fm,int behavior){
            super(fm,behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }


        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titulosFragment.get(position);
        }

        public void addFragment(Fragment fragment,String titulo){
            fragmentList.add(fragment);
            titulosFragment.add(titulo);
        }


    }
}