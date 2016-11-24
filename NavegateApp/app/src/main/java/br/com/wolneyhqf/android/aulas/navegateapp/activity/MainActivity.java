package br.com.wolneyhqf.android.aulas.navegateapp.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.wolneyhqf.android.aulas.navegateapp.R;
import br.com.wolneyhqf.android.aulas.navegateapp.fragment.FragmentA;
import br.com.wolneyhqf.android.aulas.navegateapp.fragment.FragmentB;
import br.com.wolneyhqf.android.aulas.navegateapp.fragment.FragmentC;
import br.com.wolneyhqf.android.aulas.navegateapp.fragment.HomeFragment;
import br.com.wolneyhqf.android.aulas.navegateapp.fragment.TabsFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                onNavDrawerItemSelected(menuItem);
                return true;
            }
        });

        replaceFragments(new HomeFragment(), HomeFragment.TAG);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void onNavDrawerItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case R.id.nav_item_home:
                replaceFragments(new HomeFragment(), HomeFragment.TAG);
                break;
            case R.id.nav_item_frag_a:
                replaceFragments(new FragmentA(), FragmentA.TAG);
                break;
            case R.id.nav_item_frag_b:
                replaceFragments(new FragmentB(), FragmentB.TAG);
                break;
            case R.id.nav_item_frag_c:
                replaceFragments(new FragmentC(), FragmentC.TAG);
                break;
            case R.id.nav_item_frag_tabs:
                replaceFragments(new TabsFragment(), TabsFragment.TAG);
                break;
            case R.id.nav_item_exit:
                Snackbar.make(drawerLayout, "Sair", Snackbar.LENGTH_SHORT).show();
                break;
        }
    }

    private void replaceFragments(Fragment fragment, String tag){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, tag).commit();
    }
}
