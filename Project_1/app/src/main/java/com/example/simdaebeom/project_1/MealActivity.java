package com.example.simdaebeom.project_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MealActivity extends AppCompatActivity {
    private static DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private ExpandableListAdapter listAdapter;
    private ExpandableListView listView;
    private List<String> listDataHeader;
    private HashMap<String,List<String >> listHash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        listView =(ExpandableListView)findViewById(R.id.lvExp);
        initData();
        listAdapter = new ExpandableListAdapter(this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if(groupPosition==0&&childPosition==0)
                {

                    startActivity(new Intent(v.getContext(),Understand_1_Activity.class));

                }
                else if(groupPosition==5&&childPosition==1)
                {
                    startActivity(new Intent(v.getContext(),Info_1_Activity.class));
                }
                return false;

            }
        });
    }
    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();
        listDataHeader.add("장루 이해");
        listDataHeader.add("장루 관리");
        listDataHeader.add("식이 관리");
        listDataHeader.add("생활 관리");
        listDataHeader.add("일정 관리");
        listDataHeader.add("관련 정보");

        List<String> a1 = new ArrayList<>();
        a1.add("장의 구조");
        a1.add("장루의 정의");
        a1.add("장루의 적용");
        a1.add("장루의 형태");
        a1.add("장루의 종류");
        List<String> a2 = new ArrayList<>();
        a2.add("2");
        List<String> a3 = new ArrayList<>();
        a3.add("3");
        List<String> a4 = new ArrayList<>();
        a4.add("4");
        List<String> a5 = new ArrayList<>();
        a5.add("5");
        List<String> a6 = new ArrayList<>();
        a6.add("장루 도움 사이트 찾기");
        a6.add("병원 및 응급실 찾기");
        listHash.put(listDataHeader.get(0),a1 );
        listHash.put(listDataHeader.get(1),a2 );
        listHash.put(listDataHeader.get(2),a3 );
        listHash.put(listDataHeader.get(3),a4 );
        listHash.put(listDataHeader.get(4),a5 );
        listHash.put(listDataHeader.get(5),a6 );

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void Goback(View view) {
        finish();
    }

}
