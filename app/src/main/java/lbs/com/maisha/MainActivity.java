package lbs.com.maisha;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;

import lbs.com.maisha.fragment.ContentFragment;
import lbs.com.maisha.fragment.MenuFragment;

public class MainActivity extends SlidingActivity {

    private static final int SCANNER = 0;
    private static final int MENU_SCANNER = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.title);
        setContentView(R.layout.frame_content);

        setBehindContentView(R.layout.frame_menu);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        MenuFragment menuFragment = new MenuFragment();
        fragmentTransaction.replace(R.id.menu, menuFragment);
        fragmentTransaction.replace(R.id.content, new ContentFragment("Welcome"));
        fragmentTransaction.commit();

        SlidingMenu sm = getSlidingMenu();
        sm.setShadowWidth(50);
        sm.setShadowDrawable(R.drawable.shadow);
        sm.setBehindOffset(60);
        sm.setFadeDegree(0.35f);
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);

        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(SCANNER, MENU_SCANNER, 0 , R.string.scanner );
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                toggle();
                return true;

            case MENU_SCANNER:
                startScanner();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void startScanner() {
        Intent startScanner = new Intent(this, SimpleScannerActivity.class);
        startActivity(startScanner);
    }
}