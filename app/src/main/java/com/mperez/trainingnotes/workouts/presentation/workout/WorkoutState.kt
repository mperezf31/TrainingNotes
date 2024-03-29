package com.mperez.trainingnotes.workouts.presentation.workout

import com.mperez.trainingnotes.workouts.domain.model.Exercise

data class WorkoutState(
    val exercises: List<Exercise> = emptyList()
)