package com.spirovski.kentapp.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.spirovski.kentapp.navigation.Routes
import com.spirovski.kentapp.navigation.navigateToScreen
import kentapp.composeapp.generated.resources.Res
import kentapp.composeapp.generated.resources.fitness_logo
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource

@Composable
@Preview
fun KentSplashScreen() {

    val scale = remember { Animatable(0f) }

    val overshootEasing = Easing { fraction ->
        val tension = 8f
        val t = fraction - 1f
        t * t * ((tension + 1) * t + tension) + 1f
    }

    LaunchedEffect(key1 = true) {

        scale.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(
                durationMillis = 800,
                easing = overshootEasing

            )
        )

        delay(3000L)
        navigateToScreen(Routes.Login)

    }

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

            Column(modifier = Modifier.scale(scale.value),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {

                Image(painter = painterResource(Res.drawable.fitness_logo),
                    contentDescription = "Logo Kent Fitness",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(95.dp))

                Text("Life solution, in the palm of your hand",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.LightGray)

            }

    }

}