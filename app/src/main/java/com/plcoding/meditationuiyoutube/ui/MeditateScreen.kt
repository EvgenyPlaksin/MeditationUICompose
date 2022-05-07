package com.plcoding.meditationuiyoutube.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import com.plcoding.meditationuiyoutube.R
import com.plcoding.meditationuiyoutube.utils.standardQuadFromTo

import com.plcoding.meditationuiyoutube.ui.theme.*
import com.plcoding.meditationuiyoutube.utils.data.Feature


@Composable
fun MeditateScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
      Column{


          Title()

     Box(
         modifier = Modifier
             .fillMaxWidth()
             .height(300.dp),
         contentAlignment = Alignment.Center
     ) {
         BigCustomBox(
             R.drawable.ic_headphone,
             BlueViolet1,
             BlueViolet2,
             BlueViolet3
         )
     }
          Description()

          FeatureSection(
              features = listOf(
                  Feature(
                      title = "Sleep meditation",
                      R.drawable.ic_headphone,
                      BlueViolet1,
                      BlueViolet2,
                      BlueViolet3
                  ),
                  Feature(
                      title = "Tips for sleeping",
                      R.drawable.ic_videocam,
                      LightGreen1,
                      LightGreen2,
                      LightGreen3
                  ),
                  Feature(
                      title = "Night island",
                      R.drawable.ic_headphone,
                      OrangeYellow1,
                      OrangeYellow2,
                      OrangeYellow3
                  ),
                  Feature(
                      title = "Calming sounds",
                      R.drawable.ic_headphone,
                      Beige1,
                      Beige2,
                      Beige3
                  )
              ),
              title = "Related"
          )

      }
    }
}

@Composable
fun Title(
     titleText: String = "Sleep Meditation",
     bodyText: String = "Best practice meditations"
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 15.dp, top = 15.dp)
    ){
        Column(
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = titleText,
                style = MaterialTheme.typography.h1
            )

            Text(
                text = bodyText,
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Composable
fun BigCustomBox(
    @DrawableRes iconId: Int,
    lightColor: Color,
    mediumColor: Color,
    darkColor: Color
){
    BoxWithConstraints(
        modifier = Modifier
            .padding(top = 15.dp, start = 15.dp, end = 15.dp)
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

            Icon(
                painter = painterResource(id = iconId),
                contentDescription = "Listen",
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
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

@Composable
fun Description() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ){
        Text(
            text = "Sleep music  •  45 min",
            style = MaterialTheme.typography.body1,
            fontSize = 16.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Light
        )

        Spacer(modifier = Modifier.fillMaxWidth().height(5.dp))

        Text(
            text = "Ease the mind into a restful night's sleep",
            style = MaterialTheme.typography.body1,
            fontSize = 16.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Light
        )

        Text(
            text = "with these deep, ambient tones",
            style = MaterialTheme.typography.body1,
            fontSize = 16.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Light
        )

        Spacer(modifier = Modifier.fillMaxWidth().height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Row{
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_star_24),
                        contentDescription = "Saved",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "12,542 Saved",
                    style = MaterialTheme.typography.body1,
                    fontSize = 16.sp,
                    fontFamily = fontFamily
                )

            }
            Row{
                Icon(
                    painter = painterResource(id = R.drawable.ic_headphone),
                    contentDescription = "Saved",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "43,453 Listening",
                    style = MaterialTheme.typography.body1,
                    fontSize = 16.sp,
                    fontFamily = fontFamily
                )

            }
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(15.dp))
        Divider(color = DarkerButtonBlue, thickness = 1.dp)

    }
}

val fontFamily = FontFamily(
    Font(R.font.gothica1_black, FontWeight.ExtraBold),
    Font(R.font.gothica1_bold, FontWeight.Bold),
    Font(R.font.gothica1_medium, FontWeight.Medium),
    Font(R.font.gothica1_regular, FontWeight.Light),
    Font(R.font.gothica1_semibold, FontWeight.Normal)
)
