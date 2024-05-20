package io.kiwik.ui.animations

import android.widget.Toast
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit


@Composable
@Preview
fun AnimationCompose() {
    Column {
        var changeColor by remember {
            mutableStateOf(false)
        }

        val colorAnimation by animateColorAsState(targetValue = if (changeColor) Color.Red else Color.Blue)

        Box(
            modifier = Modifier
                .background(colorAnimation)
                .size(100.dp)
        )
        Button(onClick = {
            changeColor = changeColor.not()
        }) {
            Text(text = "Change Color")
        }


        Spacer(modifier = Modifier.size(100.dp))

        var changeSize by remember { mutableStateOf(false) }

        val sizeAnimation by animateDpAsState(targetValue = if (changeSize) 50.dp else 100.dp)

        Box(
            modifier = Modifier
                .background(colorAnimation)
                .size(sizeAnimation)
        )
        Button(onClick = {
            changeSize = changeSize.not()
        }) {
            Text(text = "Change size")
        }

        Spacer(modifier = Modifier.size(100.dp))


        var changeTextSize by remember { mutableStateOf(false) }

        val textSizeAnimation by animateFloatAsState(targetValue = if (changeTextSize) 12.sp.value else 24.sp.value)

        Text(text = "TextSize to change", fontSize = textSizeAnimation.sp)

        Button(onClick = {
            changeTextSize = changeTextSize.not()
        }) {
            Text(text = "Change size")
        }

        Spacer(modifier = Modifier.size(100.dp))

    }

}

@Composable
@Preview
fun TweenOffSetExample() {
    val context = LocalContext.current
    var move by remember { mutableStateOf(false) }

    val offset by animateIntOffsetAsState(
        targetValue = if (move) IntOffset(1000, 0) else IntOffset.Zero,
        animationSpec = tween(
            durationMillis = TimeUnit.SECONDS.toMillis(1).toInt(),
            easing = FastOutLinearInEasing
        ),
        finishedListener = {
            Toast.makeText(context, "Fin", Toast.LENGTH_SHORT).show()
        },
        label = "offsetAnimation"
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .offset {
                    offset
                }
                .background(Color.Green)
                .clip(CircleShape)
                .size(50.dp)
        )

        Button(onClick = {
            move = move.not()
        }) {
            Text(text = "Move")
        }
    }
}

@Composable
@Preview
fun SpringOffSetExample() {
    val context = LocalContext.current
    var move by remember { mutableStateOf(false) }

    val offset by animateIntOffsetAsState(
        targetValue = if (move) IntOffset(1000, 0) else IntOffset.Zero,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessLow
        ),
        finishedListener = {
            Toast.makeText(context, "Fin", Toast.LENGTH_SHORT).show()
        },
        label = "offsetAnimation"
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .offset {
                    offset
                }
                .background(Color.Green)
                .clip(CircleShape)
                .size(50.dp)
        )

        Button(onClick = {
            move = move.not()
        }) {
            Text(text = "Move")
        }
    }
}

@Composable
@Preview
fun InfiniteColor() {
    val infiniteAnimation = rememberInfiniteTransition(label = "infinite")

    val color by infiniteAnimation.animateColor(
        initialValue = Color.Green,
        targetValue = Color.Red,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = TimeUnit.SECONDS.toMillis(1).toInt(),
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "color"
    )

    Box(modifier = Modifier
        .size(100.dp)
        .background(color = color))
}


@Composable
@Preview
fun InfiniteText() {
    val infiniteAnimation = rememberInfiniteTransition(label = "infinite")

    val size by infiniteAnimation.animateFloat(
        initialValue = 12.sp.value,
        targetValue = 24.sp.value,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = TimeUnit.SECONDS.toMillis(1).toInt(),
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "color"
    )

    Text(text = "My infinite text", fontSize =  size.sp)
}

@Composable
@Preview
fun TextChain() {
    var textSize1 = remember { Animatable(initialValue = 12.sp.value) }
    var textSize2 = remember { Animatable(initialValue = 12.sp.value) }

    Column {
        Text(text = "Text 1", fontSize = textSize1.value.sp)
        Text(text = "Text 2", fontSize = textSize2.value.sp)
    }

    LaunchedEffect(Unit) {
        delay(2000)
        textSize1.animateTo(
            targetValue = 24.sp.value,
            animationSpec = tween(
                durationMillis = TimeUnit.SECONDS.toMillis(1).toInt(),
                easing = LinearEasing
            )
        )
        textSize2.animateTo(
            targetValue = 24.sp.value,
            animationSpec = tween(
                durationMillis = TimeUnit.SECONDS.toMillis(1).toInt(),
                easing = LinearEasing
            )
        )
    }
}

@Composable
@Preview
fun TextAnimation() {
    var textSize1 = remember { Animatable(initialValue = 12.sp.value) }
    var textSize2 = remember { Animatable(initialValue = 12.sp.value) }

    Column {
        Text(text = "Text 1", fontSize = textSize1.value.sp)
        Text(text = "Text 2", fontSize = textSize2.value.sp)
    }

    LaunchedEffect(Unit) {
        delay(2000)
        launch {
            textSize1.animateTo(
                targetValue = 24.sp.value,
                animationSpec = tween(
                    durationMillis = TimeUnit.SECONDS.toMillis(1).toInt(),
                    easing = LinearEasing
                )
            )
        }
        launch {
            textSize2.animateTo(
                targetValue = 24.sp.value,
                animationSpec = tween(
                    durationMillis = TimeUnit.SECONDS.toMillis(1).toInt(),
                    easing = LinearEasing
                )
            )
        }
    }
}