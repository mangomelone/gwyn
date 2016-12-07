package com.genosharing.gwyn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        ResultListArrayAdapter adapter = new ResultListArrayAdapter(this,
                R.layout.single_result, DummyData.getOffers(this));

        ListView listView = (ListView) findViewById(R.id.resultList);
        listView.setAdapter(adapter);
    }
}
