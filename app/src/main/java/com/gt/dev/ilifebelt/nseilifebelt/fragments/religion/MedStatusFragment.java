package com.gt.dev.ilifebelt.nseilifebelt.fragments.religion;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * Created by Community on 27/01/17.
 */

public class MedStatusFragment extends Fragment {

    private PieChart mChart;

    private int[] yValues = {42, 06, 52};
    private String[] xValues = {"Evangénlico", "Otras", "Católico"};

    public static final int[] MY_COLORS = {
            Color.rgb(84, 124, 101), Color.rgb(64, 64, 64), Color.rgb(153, 19, 0),
            Color.rgb(38, 40, 53), Color.rgb(215, 60, 55)
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_med_nse, container, false);

        mChart = (PieChart) v.findViewById(R.id.piechart_religion_med_nse);

        mChart.setDescription("Niveles Medios");

        mChart.setRotationEnabled(true);

        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                if (e == null)
                    return;

                Toast.makeText(getActivity(), xValues[e.getXIndex()] + "is" + e.getVal() + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        setDataforPieChart();

        return v;
    }

    public void setDataforPieChart() {
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

        // Adding colors
        ArrayList<Integer> colors = new ArrayList<Integer>();

        // Added my own colors
        for (int c : MY_COLORS)
            colors.add(c);

        dataSet.setColors(colors);

        // Create pie data object and set xValues and yValues and set it to the pieChart
        PieData data = new PieData(xVals, dataSet);

        data.setValueFormatter(new MyValueFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);

        mChart.setData(data);

        // undo all highligths
        mChart.highlightValues(null);

        // refresh/update pie chart
        mChart.invalidate();

        // animate pieChart
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

}
