package com.example.simdaebeom.project_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class CalendarActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemClickListener

{
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private ExpandableListAdapter listAdapter;
    private ExpandableListView listView;
    private List<String> listDataHeader;
    private HashMap<String,List<String >> listHash;

    /////////////////////////////////////////////////
    ArrayList<String> mItems;
    ArrayAdapter<String> adapter;
    TextView textYear;
    TextView textMon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        listView = (ExpandableListView) findViewById(R.id.lvExp);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if (groupPosition == 0 && childPosition == 0) {

                    startActivity(new Intent(v.getContext(), Understand_1_Activity.class));

                } else if (groupPosition == 5 && childPosition == 1) {
                    startActivity(new Intent(v.getContext(), Info_1_Activity.class));
                }
                return false;

            }
        });

        textYear = (TextView) this.findViewById(R.id.edit1);
        textMon = (TextView) this.findViewById(R.id.edit2);

        mItems = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mItems);

        GridView gird = (GridView) this.findViewById(R.id.grid1);
        gird.setAdapter(adapter);
        gird.setOnItemClickListener(this);

        Date date = new Date();// 오늘에 날짜를 세팅 해준다.
        int year = date.getYear() + 1900;
        int mon = date.getMonth() + 1;
        textYear.setText(year + "");
        textMon.setText(mon + "");

        fillDate(year, mon);

        Button btnmove = (Button) this.findViewById(R.id.bt1);
        btnmove.setOnClickListener(this);



    }

    private void fillDate(int year, int mon) {
        mItems.clear();

        mItems.add("일");
        mItems.add("월");
        mItems.add("화");
        mItems.add("수");
        mItems.add("목");
        mItems.add("금");
        mItems.add("토");

        Date current = new Date(year - 1900, mon - 1, 1);
        int day = current.getDay(); // 요일도 int로 저장.

        for (int i = 0; i < day; i++) {
            mItems.add("");
        }

        current.setDate(32);// 32일까지 입력하면 1일로 바꿔준다.
        int last = 32 - current.getDate();

        for (int i = 1; i <= last; i++) {
            mItems.add(i + "");
        }
        adapter.notifyDataSetChanged();



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

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v.getId() == R.id.bt1) {
            int year = Integer.parseInt(textYear.getText().toString());
            int mon = Integer.parseInt(textMon.getText().toString());
            fillDate(year, mon);


        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (mItems.get(position).equals("")) {
            ;
        }else {
            Intent intent = new Intent(this, ExToday.class);//해당 일을 눌렸을때
            intent.putExtra("Param1", textYear.getText().toString() + "/"
                    + textMon.getText().toString() + "/" + mItems.get(position));
            startActivity(intent);
        }



    }
}
