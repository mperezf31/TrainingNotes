package com.mperez.trainingnotes.workouts.presentation.exercises

import com.mperez.trainingnotes.workouts.domain.model.Exercise

data class ExercisesState(
    val exercises: List<Exercise> = emptyList()
)