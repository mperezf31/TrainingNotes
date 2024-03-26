package com.mperez.trainingnotes.workouts.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Exercise(
    val title: String,
    val content: String,
    val category: ExerciseCategory,
    @PrimaryKey val id: Int? = null
)

enum class ExerciseCategory { LEGS, BACK, CHEST, ARMS }

class InvalidExerciseException(msg: String) : Exception(msg)
