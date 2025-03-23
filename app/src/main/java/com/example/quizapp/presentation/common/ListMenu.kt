package com.example.quizapp.presentation.common

import android.content.Context
import com.example.quizapp.R

object ListMenu {

    fun getListNumberOfQuestions() = (1..10).map { it.toString() }

    fun getListCategories(context: Context) = listOf(
        context.getString(R.string.itemCategories1)
    )

    fun getListDifficultly(context: Context) = listOf(
        context.getString(R.string.itemDifficultly1),
        context.getString(R.string.itemDifficultly2),
        context.getString(R.string.itemDifficultly3),
    )

    fun getListType(context: Context) = listOf(
        context.getString(R.string.itemType1),
        context.getString(R.string.itemType2),
    )

}