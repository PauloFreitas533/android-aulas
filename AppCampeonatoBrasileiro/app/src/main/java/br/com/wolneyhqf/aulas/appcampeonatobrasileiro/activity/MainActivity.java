package br.com.wolneyhqf.aulas.appcampeonatobrasileiro.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import br.com.wolneyhqf.aulas.appcampeonatobrasileiro.R;
import br.com.wolneyhqf.aulas.appcampeonatobrasileiro.fragment.ClubesFragment;

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
                Intent intent = new Intent(getBaseContext(), PreferencesActivity.class);
                startActivity(intent);
                break;
        }
    }

}
