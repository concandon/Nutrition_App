package com.example.epsilonnutrition;

import android.content.Context;
import android.util.Log;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.HashMap;

enum ActivityLvl {
  SEDENTARY,
  LIGHTLY_ACTIVE,
  MODERATELY_ACTIVE,
  VERY_ACTIVE,
  EXTREMELY_ACTIVE
}

class Profile implements Serializable {
  // datatypes subject to change
  String name;
  String bday;
  String gender;
  ActivityLvl activityLvl;
  int heightFeet;
  int heightInches;
  int age;
  double caloriesConsumed;
  double weight;
  double bmi;
  double bmr;
  double tdee;
  // plus other preferences

  Profile() {}
  Profile(String name,
          String bday,
          int heightFeet,
          int heightInches,
          double weight,
          String gender,
          ActivityLvl activityLvl) {
    this.name = name;
    this.bday = bday;
    this.heightFeet = heightFeet;
    this.heightInches = heightInches;
    this.weight = weight;
    this.gender = gender;
    this.activityLvl = activityLvl;
    this.caloriesConsumed = 0.0;
    // do math for bmi bmr and tdee
  }
}

class Food implements Serializable {
  String name;
  String servingUnit;
  int servingWeightGrams;
  Double calories;
  Double totalFat;
  Double saturatedFat;
  Double cholesterol;
  Double sodium;
  Double potassium;
  Double carbs;
  Double fiber;
  Double sugar;
  Double protein;
  String dateConsumed;
  String ogObj;
  Food(){}
  Food(JSONObject og) {
    ogObj = og.toString();
    try {
      name = og.get("food_name").toString();
      servingUnit = og.get("serving_unit").toString();
      servingWeightGrams = Integer.parseInt(og.get("serving_weight_grams").toString());
      calories = Double.parseDouble(og.get("nf_calories").toString());
      totalFat = Double.parseDouble(og.get("nf_total_fat").toString());
      saturatedFat = Double.parseDouble(og.get("nf_saturated_fat").toString());
      cholesterol = Double.parseDouble(og.get("nf_cholesterol").toString());
      sodium = Double.parseDouble(og.get("nf_sodium").toString());
      potassium = Double.parseDouble(og.get("nf_potassium").toString());
      carbs = Double.parseDouble(og.get("nf_total_carbohydrate").toString());
      fiber = Double.parseDouble(og.get("nf_dietary_fiber").toString());
      sugar = Double.parseDouble(og.get("nf_sugars").toString());
      protein = Double.parseDouble(og.get("nf_protein").toString());

    } catch (org.json.JSONException e) {
      Log.d("JSONObject ERROR", e.toString());
    }
  }
}

class DiaryEntry implements Serializable {
  String title;
  String entry;
  String date;
  String time;

  DiaryEntry(){
    title = "";
    entry = "";
    getDateTime();
  }

  DiaryEntry(String title, String entry) {
    this.title = title;
    this.entry = entry;
    getDateTime();
  }

  void getDateTime() {
    GregorianCalendar g = new GregorianCalendar();
    date = String.format("%02d/%02d/%d", g.get(Calendar.MONTH) + 1, g.get(Calendar.DAY_OF_MONTH), g.get(Calendar.YEAR));
    time = String.format("%d:%d%s", g.get(Calendar.HOUR), g.get(Calendar.MINUTE), g.get(Calendar.AM_PM) == 1 ? "PM" : "AM");
  }

//  DiaryEntry(String title, String entry, )

}

public class Database implements Serializable {
  Profile profile;
  HashMap<String, ArrayList<Food>> foodData;
  ArrayList<DiaryEntry> diary;

  Database() {
    profile = new Profile();
    foodData = new HashMap<>();
    diary = new ArrayList<>();
  }
}
