package br.com.wolneyhqf.aulas.appcbr.activity;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.wolneyhqf.aulas.appcbr.R;

/**
 * Created by wolney on 21/02/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected DrawerLayout drawerLayout;

    protected void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    protected void setupNavDrawer(){
        final ActionBar actionBar = getSupportActionBar();

        actionBar.setHomeAsUpIndicator(R.drawable.ic_action_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        if(navigationView != null && drawerLayout != null){
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawers();
                    onNavDrawerItemSelected(menuItem);
                    return false;
                }
            });
        }
    }

    protected void onNavDrawerItemSelected(MenuItem menuItem){}

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case android.R.id.home:
                if(drawerLayout != null){
                    openDrawer();
                    return true;
                }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void openDrawer(){
        if(drawerLayout != null){
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    protected void closeDrawer(){
        if(drawerLayout != null){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        boolean ok = true;
        for(int result : grantResults){
            if(result == PackageManager.PERMISSION_DENIED){
                ok = false;
            }
        }
        if(!ok){
            Toast.makeText(this, "Há permissões negadas para o aplicativo, vá nas configurações do dispositivo para conceder as permissões necessárias", Toast.LENGTH_LONG).show();
        }
    }

}
