package com.nagarro.smarthomeapplication.datasetmanager

import com.github.mikephil.charting.data.LineDataSet

//can be used later

class DatasetConfig {

     fun configureSetLayout(set: LineDataSet, color: Int) {

        set.color = color                         // color of the line
        set.setDrawFilled(true)                   // fill the space between line and chart bottom
        set.fillColor = color                     // color of the fill
        set.setDrawCircles(false)                 // disable drawing circles over each Entry point
        set.mode = LineDataSet.Mode.CUBIC_BEZIER  // round the line
        set.fillAlpha = 50                        // make fill transparent with alpha (0-255)

    }
}