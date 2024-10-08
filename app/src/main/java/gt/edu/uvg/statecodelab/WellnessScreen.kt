package gt.edu.uvg.statecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column {
        StatefulCounter()

        WellnessTaskList(
            list = wellnessViewModel.tasks,
            onCheckedTask = {task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked) },
            onClose = {
                task -> wellnessViewModel.remove(task)})
    }
}

