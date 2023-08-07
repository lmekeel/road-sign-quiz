/*This class holds the data for the Road Quiz including images, choices, and correct answers
for each question */

package com.example.roadsigntest;

public class RoadQuiz {

    //Array of road sign images
    public static int[] roadSigns ={
            R.drawable.merge_left,
            R.drawable.roundabout,
            R.drawable.stop_sign,
            R.drawable.stop_sign_ahead,
            R.drawable.u_turn_prohibited,
            R.drawable.winding_road,
            R.drawable.yeild_sign

    };

    //Array of answer choice options for each question
    public static String[][] choices = {
            {"Merge Left", "Roundabout", "Stop Sign","U-Turn Prohibited"},
            {"Winding Road", "Roundabout", "Yield Sign","U-Turn Prohibited"},
            {"Merge Left", "Yield Sign", "Stop Sign","Stop Sign Ahead"},
            {"Stop Sign Ahead", "Roundabout", "Winding Road","Yield Sign"},
            {"Stop Sign", "Roundabout", "Winding Road","U-Turn Prohibited"},
            {"Yield Sign", "Winding Road", "Stop Sign Ahead","Roundabout"},
            {"U-Turn Prohibited", "Yield Sign", "Roundabout","Winding Road"}

    };

    //Array of correct answers for each choice option
    public static String[] correctAnswers={
            "Merge Left",
            "Roundabout",
            "Stop Sign",
            "Stop Sign Ahead",
            "U-Turn Prohibited",
            "Winding Road",
            "Yield Sign"
    };
}
