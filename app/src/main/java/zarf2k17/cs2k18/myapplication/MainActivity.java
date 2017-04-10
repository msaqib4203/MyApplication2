package zarf2k17.cs2k18.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends DrawerActivity {

    @BindView(R.id.materialViewPager)
    MaterialViewPager mViewPager;
    String tab_titles[] = {"Technical","Cultural","Literary","Sports"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("");
        ButterKnife.bind(this);

        final Toolbar toolbar = mViewPager.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 4) {
                    //case 0:
                    //    return RecyclerViewFragment.newInstance();
                    //case 1:
                    //    return RecyclerViewFragment.newInstance();
                    //case 2:
                    //    return WebViewFragment.newInstance();
                    default:
                        return RecyclerViewFragment.newInstance();

                }
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tab_titles[position%4];
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                               R.color.green,"http://cbit.ac.in/files/synapse/dance.jpg"
                                /*"http://phandroid.s3.amazonaws.com/wp-content/uploads/2014/06/android_google_moutain_google_now_1920x1080_wallpaper_Wallpaper-HD_2560x1600_www.paperhi.com_-640x400.jpg"*/);
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,"http://i0.wp.com/eventmagazine.townscript.com/wp-content/uploads/2016/04/workshops11.png?fit=1080%2C9999"
                               /* "http://www.hdiphonewallpapers.us/phone-wallpapers/540x960-1/540x960-mobile-wallpapers-hd-2218x5ox3.jpg"*/);
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.cyan,"http://www.newburghlibrary.org/wp-content/uploads/book-club-stack1.jpg"
                                /*"http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg"*/);
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,"https://media.licdn.com/mpr/mpr/AAEAAQAAAAAAAAaQAAAAJDBkNTQ2NmYxLWZiNjEtNDFmNi1iYzE2LTFjNWY2YjU2NzE2Mg.jpg"
                                /*"http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg"*/);
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        final View logo = findViewById(R.id.logo_white);
        if (logo != null) {
            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.notifyHeaderChanged();
                    Toast.makeText(getApplicationContext(), "Yes, the title is clickable", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
