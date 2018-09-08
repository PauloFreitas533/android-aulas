package br.com.wolneyhqf.aulas.appcbr.activity;

import android.content.pm.PackageManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.wolneyhqf.aulas.appcbr.R;
import br.com.wolneyhqf.aulas.appcbr.fragment.ClubesFragment;
import br.com.wolneyhqf.aulas.appcbr.fragment.ConfigFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();
        setupNavDrawer();
    }

    @Override
    protected void onNavDrawerItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (itemId) {
            case R.id.nav_item_clubes:
                ft.replace(R.id.container, new ClubesFragment(), ClubesFragment.TAG);
                ft.commit();
                break;
            case R.id.nav_item_configuracoes:
                ft.replace(R.id.container, new ConfigFragment(), ClubesFragment.TAG);
                ft.commit();
                break;
        }
    }

}
