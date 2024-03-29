package com.mperez.trainingnotes.workouts.presentation.workout.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mperez.trainingnotes.workouts.domain.model.ExerciseCategory

@Composable
fun FilterSection(
    modifier: Modifier = Modifier,
    selectedCategory: ExerciseCategory,
    onCategoryChange: (ExerciseCategory) -> Unit,
) {


    Row(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.width(8.dp))
        DefaultRadioButton(
            text = "ARMS",
            selected = selectedCategory == ExerciseCategory.ARMS,
            onSelect = { onCategoryChange(ExerciseCategory.ARMS) }
        )
        DefaultRadioButton(
            text = "CHEST",
            selected = selectedCategory == ExerciseCategory.CHEST,
            onSelect = { onCategoryChange(ExerciseCategory.CHEST) }
        )
        Spacer(modifier = Modifier.width(8.dp))
        DefaultRadioButton(
            text = "BACK",
            selected = selectedCategory == ExerciseCategory.BACK,
            onSelect = { onCategoryChange(ExerciseCategory.BACK) }
        )
        Spacer(modifier = Modifier.width(8.dp))
        DefaultRadioButton(
            text = "LEGS",
            selected = selectedCategory == ExerciseCategory.LEGS,
            onSelect = { onCategoryChange(ExerciseCategory.LEGS) }
        )
        Spacer(modifier = Modifier.height(16.dp))
    }

}