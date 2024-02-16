package com.example.bmi_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmi_mvvm.ui.theme.BMI_MVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMI_MVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Bmi()
                }
            }
        }
    }
}


@Composable
fun Bmi(modifier: Modifier = Modifier, myViewModel: MyViewModel = viewModel()) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = stringResource(R.string.bmi_calculator_mvvm_version),
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp),
        )
        OutlinedTextField(
            value = myViewModel.heightInput,
            onValueChange = { myViewModel.changeHeightInput(it) },
            label = { Text(text = stringResource(R.string.height)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = myViewModel.weightInput,
            onValueChange = { myViewModel.changeWeightInput(it) },
            label = { Text(text = stringResource(R.string.weight)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = modifier.fillMaxWidth()
        )
        Text(
            text = stringResource(
                R.string.bmi_result_is,
                String.format("%.2f", myViewModel.bmi).replace(oldChar = ',', newChar = '.')
            ),
            modifier = modifier.padding(5.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BMI_MVVMTheme {
        Bmi()
    }
}