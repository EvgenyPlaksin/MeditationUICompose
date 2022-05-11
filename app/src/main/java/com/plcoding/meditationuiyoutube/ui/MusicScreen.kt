package com.plcoding.meditationuiyoutube.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.meditationuiyoutube.R
import com.plcoding.meditationuiyoutube.ui.theme.*
import com.plcoding.meditationuiyoutube.utils.data.Feature
import com.plcoding.meditationuiyoutube.utils.data.MusicBoxContent
import com.plcoding.meditationuiyoutube.utils.standardQuadFromTo


@Composable
fun MusicScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            Title(
                "The best music for meditation",
                "Listen and relax"
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
            )

            MusicForYou()

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )
            MusicList(
                   listOf(
                       repeat()[0],
                       repeat()[1],
                       repeat()[2],
                       repeat()[3],
                       repeat()[1],
                       repeat()[2],
                       repeat()[3],
                       repeat()[0],
                       repeat()[1],
                       repeat()[2],
                       repeat()[3],
                       repeat()[0],
                       repeat()[1],
                       repeat()[2],
                       repeat()[3],
                       repeat()[0],
                       repeat()[1],
                       repeat()[2],
                       repeat()[3],
                       repeat()[0],
                       repeat()[1],
                       repeat()[2],
                       repeat()[3],
                       repeat()[0],
                       repeat()[1],
                       repeat()[2],
                       repeat()[3],
                       repeat()[0],
                       repeat()[1],
                       repeat()[2],
                       repeat()[3],
                       repeat()[0],
                       repeat()[1],
                       repeat()[2],
                       repeat()[3],
                       repeat()[0],
                       repeat()[1],
                       repeat()[2],
                       repeat()[3],
                       repeat()[0],
                       repeat()[1],
                       repeat()[2],
                       repeat()[3],
                       repeat()[0],
                       repeat()[1],
                       repeat()[2],
                       repeat()[3],
                       repeat()[0],
                       repeat()[1],
                       repeat()[2],
                       repeat()[3],
                       repeat()[0],
                       repeat()[1],
                       repeat()[2],
                       repeat()[3]
            )
            )
        }
    }
}

@Composable
fun MusicForYou(){
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "For You",
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(start = 15.dp)
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(5.dp))

        CurrentMeditation(
            OrangeYellow1,
            "Night island"
        )
    }
}

@Composable
fun MusicList(
    items: List<MusicBoxContent>
) {

    Column{
        Text(
            text = "Popular",
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(start = 15.dp)
        )

        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)){
            items(items.size){
                MusicItem(items[it])
            }
        }

    }

}

@Composable
fun MusicItem(
    data: MusicBoxContent
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
    ){
        MusicBox(
            title = data.title,
            lightColor = data.lightColor,
            mediumColor = data.mediumColor,
            darkColor = data.darkColor
        )
    }
}

@Composable
fun MusicBox(
    title: String,
    lightColor: Color,
    mediumColor: Color,
    darkColor: Color
){



    BoxWithConstraints(
        modifier = Modifier
            .padding(top = 15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Medium colored Path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.5f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)

            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()

        }
        Canvas(modifier = Modifier
            .fillMaxSize()
        ){
            drawPath(
                path = mediumColoredPath,
                color = mediumColor
            )

            drawPath(
                path = lightColoredPath,
                color = lightColor
            )
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
        ){

            Text(
                style = MaterialTheme.typography.h1,
                text = title,
                modifier = Modifier.align(Alignment.CenterStart)
            )

            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                        // Handle the click
                    }
                    .align(Alignment.BottomEnd)
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }
    }
}
fun repeat(): List<MusicBoxContent> {
    return listOf(
        MusicBoxContent(
            title = "Sleep meditation",
            BlueViolet1,
            BlueViolet2,
            BlueViolet3
        ),
        MusicBoxContent(
            title = "Tips for sleeping",
            LightGreen1,
            LightGreen2,
            LightGreen3
        ),
        MusicBoxContent(
            title = "Night island",
            OrangeYellow1,
            OrangeYellow2,
            OrangeYellow3
        ),
        MusicBoxContent(
            title = "Calming sounds",
            Beige1,
            Beige2,
            Beige3
        )
    )
}