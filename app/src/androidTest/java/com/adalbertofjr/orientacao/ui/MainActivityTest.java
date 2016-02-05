package com.adalbertofjr.orientacao.ui;

import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ListView;

import com.adalbertofjr.orientacao.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.InstrumentationRegistry.getTargetContext;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by AdalbertoF on 05/02/2016.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    MainActivity mActivity;
    Context mContext;

    @Before
    public void setUp() throws Exception{
        mContext = getTargetContext();
        mActivity = mActivityRule.getActivity();
    }

    @Test
    public void adicionarTextoTest(){
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mActivity.mNome.setText("Junior");
                mActivity.mClick.callOnClick();
            }
        });

        getInstrumentation().waitForIdleSync();
        ListView listView = (ListView) mActivity.findViewById(R.id.lstView1);
        assertThat(listView.getCount(), is(1));
    }
}