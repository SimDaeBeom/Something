package com.example.simdaebeom.project_1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class repeat {
    private ArrayList<Object> listDataHeader = new ArrayList<>();
    private   HashMap<Object, Object> listHash = new HashMap<>();
    private void initData() {

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


    public HashMap<Object, Object> getListHash(){
        return listHash;

    }
}

