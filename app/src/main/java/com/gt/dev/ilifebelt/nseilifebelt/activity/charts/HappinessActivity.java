package com.gt.dev.ilifebelt.nseilifebelt.activity.charts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.ValueFormatter;
import com.gt.dev.ilifebelt.nseilifebelt.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class HappinessActivity extends AppCompatActivity {

    private PieChart mChart;

    private int[] yValues = {54, 37, 9};
    private String[] xValues = {"Es muy feliz", "Es razonablemente fleiz", "Es infeliz"};

    //Colors for different sections in piechart
    public static final int[] MY_COLORS = {
            Color.rgb(84, 124, 101), Color.rgb(64, 64, 64), Color.rgb(153, 19, 0),
            Color.rgb(38, 40, 53), Color.rgb(215, 60, 55)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_happiness);

        startVars();

        setDataForPieChart();
    }

    private void startVars() {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Felicidad");

        mChart = (PieChart) findViewById(R.id.piechart_happiness);

        // mChart.setUsePercenValues(true)
        mChart.setDescription(getString(R.string.felicity_description));

        mChart.setRotationEnabled(true);

        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                // display msg when vlaue selected
                if (e == null)
                    return;

                Toast.makeText(HappinessActivity.this, xValues[e.getXIndex()] + "is " + e.getVal() + "", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected() {

            }
        });
    }

    public void setDataForPieChart() {
        ArrayList<Entry> yVals1 = new ArrayList<>();

        for (int i = 0; i < yValues.length; i++)
            yVals1.add(new Entry(yValues[i], i));

        ArrayList<String> xVals = new ArrayList<>();

        for (int i = 0; i < xValues.length; i++)
            xVals.add(xValues[i]);

        // Create pieDataSet
        PieDataSet dataSet = new PieDataSet(yVals1, "");
        dataSet.setSliceSpace(3);
        dataSet.setSelectionShift(5);

        // Ading colors
        ArrayList<Integer> colors = new ArrayList<Integer>();

        // Added my own colors
        for (int c : MY_COLORS)
            colors.add(c);

        dataSet.setColors(colors);

        // Create pie data object and set xValues and yValues and set it to the pieChart
        PieData data = new PieData(xVals, dataSet);
        // data.setValueFormatter(new DefaultValueFormatter());
        // data.setValueFormatter(new PercentFormatter());

        data.setValueFormatter(new MyValueFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);

        mChart.setData(data);

        // undo all highlights
        mChart.highlightValues(null);

        // refresh/update pie chart
        mChart.invalidate();

        // animate piechart
        mChart.animateXY(1400, 1400);

        // Legends to show on bottom of the graph
        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
        l.setXEntrySpace(7);
        l.setYEntrySpace(5);
    }

    public class MyValueFormatter implements ValueFormatter {
        private DecimalFormat mFormat;

        public MyValueFormatter() {
            mFormat = new DecimalFormat("###,###,##0"); // use one decimal if needed
        }

        @Override
        public String getFormattedValue(float value) {
            return mFormat.format(value) + "";
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
