package uteq.solutions.Calendario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import uteq.solutions.navviewpractices.R;

public class MainActivityNavView extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nav_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarNavView);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navView = (NavigationView)findViewById(R.id.nav_view);
	navView.setNavigationItemSelectedListener(this);

    }

    @Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case android.R.id.home:
            drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        default:
            return super.onOptionsItemSelected(item);
      }
}
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        boolean fragmentTransaction = false;

    Fragment fragment = null;
    switch (menuItem.getItemId()) {
        case R.id.año:
            fragment = new año();
           fragmentTransaction = true;
            break;
        case R.id.Mes:
            fragment = new Mes();
            fragmentTransaction = true;
            break;
        case R.id.Dia:
            fragment = new Dia();
            fragmentTransaction = true;
            break;

    }

    if(fragmentTransaction) {
        getSupportFragmentManager().beginTransaction()
        .replace(R.id.content_frame, fragment)
        .commit();

        menuItem.setChecked(true);
        getSupportActionBar().setTitle(menuItem.getTitle());
    }
    drawerLayout.closeDrawers();
        return false;
    }
}