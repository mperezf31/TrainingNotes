package com.mperez.trainingnotes.workouts.presentation.workout.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mperez.trainingnotes.workouts.domain.model.Exercise

@Composable
fun ExerciseItem(
    exercise: Exercise,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier.background(Color.Gray),
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = exercise.title, style = MaterialTheme.typography.titleSmall)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = exercise.content, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = exercise.content, style = MaterialTheme.typography.bodyMedium)
    }

}