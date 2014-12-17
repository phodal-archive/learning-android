package lbs.com.maisha;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;

import lbs.com.maisha.fragment.ContentFragment;
import lbs.com.maisha.fragment.MenuFragment;

public class MainActivity extends SlidingActivity {

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
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                toggle();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}