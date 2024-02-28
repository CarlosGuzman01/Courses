package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.data.DataSource
import com.example.courses.model.CourseTopic
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoursesApp()
                }
            }
        }
    }
}


@Composable
fun CoursesApp(modifier: Modifier = Modifier) {


    val coursesList = DataSource.topics

    CourseList(courseList = coursesList)


}

@Composable
fun CourseItem(
    courseTopic: CourseTopic,
    modifier: Modifier = Modifier
){
    
    Card(modifier = modifier.padding(8.dp)) {
        Row {
            Image(
                painter = painterResource(courseTopic.courseImage),
                contentDescription = null
            )
            
            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = stringResource(id = courseTopic.courseName),

                    )

                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null
                    )

                    Text(
                        text = courseTopic.courseNumber.toString()
                    )
                }
            }

        }
    }
}

@Composable
fun CourseList(
    courseList: List<CourseTopic>,
    modifier: Modifier = Modifier
){
    
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            items(courseList){ course ->
                CourseItem(
                    courseTopic = course
                )
            }
        }
    )
    
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoursesTheme {
        CoursesApp()
    }
}