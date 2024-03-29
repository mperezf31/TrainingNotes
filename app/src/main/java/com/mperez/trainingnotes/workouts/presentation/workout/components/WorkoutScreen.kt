package com.mperez.trainingnotes.workouts.presentation.workout.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mperez.trainingnotes.workouts.presentation.workout.WorkoutEvent
import com.mperez.trainingnotes.workouts.presentation.workout.WorkoutViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutScreen(
    navController: NavController,
    viewModel: WorkoutViewModel,
    modifier: Modifier = Modifier
) {

    val state = viewModel.state.value

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { viewModel.onEvent(WorkoutEvent.AddExercise) }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add exercise")
        }
    }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Your exercise", style = MaterialTheme.typography.headlineMedium)
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.exercises) {
                    ExerciseItem(exercise = it, modifier = Modifier
                        .fillMaxWidth()
                        .clickable {

                        })
                }
            }
        }
    }


}
