package com.example.new_sample;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TesKlikButton {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    //BUG
    /*1. ketika kita selesai melakukan operasi matematika kita tidak bisa langsung menggunakan angka tersebut untuk diproses
         lebih lanjut (harus mengisi ulang)
      2. ketika kita click angka setelah itu click equal maka angka langsung menuju output dan ketika di click equal lagi akan
         menampilkan output Error
      3. ketika kita click tombol +- secara otomatis akan masuk ke output dan tidak bisa dilakukan operasi aritmatika
      4. tombol persen masih tidak dapat dipergunakan semisal kalkulator pada umumnya
    */

    @Test
    public void tesKlikButtonSatu(){
        //cari id button1 terus di klik
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.input)).check(matches(withText("1")));
    }
    @Test
    public void testClickAllButton(){
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.button4)).perform(click());
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.button6)).perform(click());
        onView(withId(R.id.button7)).perform(click());
        onView(withId(R.id.button8)).perform(click());
        onView(withId(R.id.button9)).perform(click());
        onView(withId(R.id.button0)).perform(click());
        onView(withId(R.id.input)).check(matches(withText("1234567890")));
    }

    @Test
    public void testSimpleAddition(){
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.input)).check(matches(withText("3")));
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("3+")));
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.input)).check(matches(withText("5")));
        onView(withId(R.id.button_equal)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("8")));
    }

    @Test
    public void testSimpleSubstraction(){
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.input)).check(matches(withText("12")));
        onView(withId(R.id.button_sub)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("12-")));
        onView(withId(R.id.button7)).perform(click());
        onView(withId(R.id.input)).check(matches(withText("7")));
        onView(withId(R.id.button_equal)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("5")));
    }

    @Test
    public void testSimpleDivision(){
        onView(withId(R.id.button9)).perform(click());
        onView(withId(R.id.input)).check(matches(withText("9")));
        onView(withId(R.id.button_divide)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("9/")));
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.input)).check(matches(withText("2")));
        onView(withId(R.id.button_equal)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("4.5")));
    }

    @Test
    public void testSimpleMultiplication(){
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.input)).check(matches(withText("5")));
        onView(withId(R.id.button_multi)).perform(click());
        onView(withId(R.id.button6)).perform(click());
        onView(withId(R.id.input)).check(matches(withText("6")));
        onView(withId(R.id.button_equal)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("30")));
    }

    @Test
    public void testDecimalNumberAddition(){
        onView(withId(R.id.button3)).perform(click());
        onView(withId(R.id.input)).check(matches(withText("3")));
        onView(withId(R.id.button_dot)).perform(click());
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.input)).check(matches(withText("3.5")));
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("3.5+")));
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.button_dot)).perform(click());
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.button_equal)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("5")));
    }

    @Test
    public void testClearButton(){
        onView(withId(R.id.button7)).perform(click());
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("7+")));
        onView(withId(R.id.button8)).perform(click());
        onView(withId(R.id.button_clear)).perform(click());
        onView(withId(R.id.input)).check(matches(withText("")));
        onView(withId(R.id.button_clear)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("")));
    }



}
