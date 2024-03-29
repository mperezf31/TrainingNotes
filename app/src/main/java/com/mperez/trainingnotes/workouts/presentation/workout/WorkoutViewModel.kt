package com.mperez.trainingnotes.workouts.presentation.workout

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mperez.trainingnotes.workouts.domain.model.ExerciseCategory
import com.mperez.trainingnotes.workouts.domain.usecase.ExerciseUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkoutViewModel @Inject constructor(
    private val exerciseUseCases: ExerciseUseCases
) : ViewModel() {

    private val _state = mutableStateOf(WorkoutState())
    val state: State<WorkoutState> = _state

    private var getExercisesJob: Job? = null

    init {
        getExercises()
    }

    fun onEvent(event: WorkoutEvent) {
        when (event) {
            is WorkoutEvent.DeleteExercise -> {
                viewModelScope.launch {
                    exerciseUseCases.deleteExerciseUseCase(exercise = event.exercise)
                }
            }

            is WorkoutEvent.Filter -> getExercises(event.category)
            WorkoutEvent.AddExercise -> Unit
        }
    }

    private fun getExercises(category: ExerciseCategory? = null) {
        getExercisesJob?.cancel()
        getExercisesJob = exerciseUseCases.getExercisesUseCase(category).onEach { exercises ->
            _state.value = state.value.copy(exercises = exercises)
        }.launchIn(viewModelScope)
    }

}