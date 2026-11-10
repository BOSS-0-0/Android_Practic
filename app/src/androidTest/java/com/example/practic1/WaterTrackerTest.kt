package com.example.practic1

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WaterTrackerTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<Practic8Activity>()

    @Test
    fun testAddWaterButton() {
        composeTestRule.onNodeWithText("+250 мл").assertExists()
        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("250 мл").assertExists()
    }

    @Test
    fun testEndDayButtonWithEnoughWater() {
        for (i in 1..6) {
            composeTestRule.onNodeWithText("+250 мл").performClick()
        }

        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("Дней подряд (1500+ мл): 1").assertExists()
    }

    @Test
    fun testEndDayButtonWithNotEnoughWater() {
        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("+250 мл").performClick()

        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("Дней подряд (1500+ мл): 0").assertExists()
    }
}