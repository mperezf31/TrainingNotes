package com.mperez.trainingnotes.workouts.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mperez.trainingnotes.ui.theme.Pink80
import com.mperez.trainingnotes.ui.theme.Purple80
import com.mperez.trainingnotes.ui.theme.PurpleGrey80

@Entity
data class Exercise(
    val title: String,
    val content: String,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {

    companion object {
        val exerciseColors = listOf(Purple80, PurpleGrey80, Pink80)
    }
}
