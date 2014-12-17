package lbs.com.maisha.fragment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;

import lbs.com.maisha.MainActivity;
import lbs.com.maisha.R;

public class MenuFragment extends PreferenceFragment implements OnPreferenceClickListener{
    int index = -1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        addPreferencesFromResource(R.xml.menu);
        findPreference("a").setOnPreferenceClickListener(this);
        findPreference("b").setOnPreferenceClickListener(this);
        findPreference("n").setOnPreferenceClickListener(this);
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        String key = preference.getKey();
        if("a".equals(key)) {
            if(index == 0) {
                ((MainActivity)getActivity()).getSlidingMenu().toggle();
                return true;
            }
            index = 0;
            FragmentManager fragmentManager = ((MainActivity)getActivity()).getFragmentManager();
            ContentFragment contentFragment = (ContentFragment)fragmentManager.findFragmentByTag("A");
            fragmentManager.beginTransaction()
            .replace(R.id.content, contentFragment == null ?new ContentFragment("This is A Menu"):contentFragment ,"A")
            .commit();
        }else if("b".equals(key)) {
            if(index == 1) {
                ((MainActivity)getActivity()).getSlidingMenu().toggle();
                return true;
            }
            index = 1;
            FragmentManager fragmentManager = ((MainActivity)getActivity()).getFragmentManager();
            ContentFragment contentFragment = (ContentFragment)fragmentManager.findFragmentByTag("B");
            fragmentManager.beginTransaction()
            .replace(R.id.content, contentFragment == null ? new ContentFragment("This is B Menu"):contentFragment,"B")
            .commit();
        }else if("n".equals(key)) {

            if(index == 2) {
                ((MainActivity)getActivity()).getSlidingMenu().toggle();
                return true;
            }
            index = 2;
            FragmentManager fragmentManager = ((MainActivity)getActivity()).getFragmentManager();
            ContentFragment contentFragment = (ContentFragment)fragmentManager.findFragmentByTag("N");
            fragmentManager.beginTransaction()
            .replace(R.id.content, contentFragment == null ? new ContentFragment("This is N Menu"):contentFragment,"C")
            .commit();
        }
        ((MainActivity)getActivity()).getSlidingMenu().toggle();
        return false;
    }
}
