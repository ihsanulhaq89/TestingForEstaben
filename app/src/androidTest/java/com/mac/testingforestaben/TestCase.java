package com.mac.testingforestaben;


import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.test.InstrumentationTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TestCase extends InstrumentationTestCase {
    private List<String> testCart = new ArrayList<>();
    Instrumentation instrumentation;
    Activity currentActivity;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.out.println("setUp");
    }

    @Override
    protected void tearDown() throws Exception {
        //super.tearDown();
        System.out.println("tearDown");
    }

    @MediumTest
    public void test1(){
        instrumentation = getInstrumentation();

        // Register we are interested in the main activity
        Instrumentation.ActivityMonitor monitor = instrumentation.addMonitor(MainActivity.class.getName(), null, false);

        // Start the main activity as the first activity
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClassName(instrumentation.getTargetContext(), MainActivity.class.getName());
        instrumentation.startActivitySync(intent);

        // Wait for it to start...
        currentActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);

        ViewPager pager = (ViewPager) currentActivity.findViewById(R.id.pager);
        final View listFragmentView = pager.getChildAt(0);


        instrumentation.waitForIdleSync();

        ListView listView = (ListView) listFragmentView.findViewById(R.id.list);
        final View row1 = listView.getChildAt(0);

        final Switch switchView = (Switch) row1.findViewById(R.id.switchId);


    }
}
