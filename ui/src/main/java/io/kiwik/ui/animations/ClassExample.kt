package io.kiwik.ui.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit

@Composable
@Preview
fun ClassExample() {
    val context = LocalContext.current

    Column {
        var firstColor by rememberSaveable {
            mutableStateOf(false)
        }

        val realColor = if (firstColor) Color.Red else Color.Yellow

        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor)
            .clickable { firstColor = firstColor.not() })

        Spacer(modifier = Modifier.size(100.dp))

        var secondColor by rememberSaveable {
            mutableStateOf(false)
        }

        val realColor2 by animateColorAsState(targetValue = if (secondColor) Color.Red else Color.Yellow)
        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor2)
            .clickable { secondColor = secondColor.not() })

        Spacer(modifier = Modifier.size(100.dp))

        var thirdColor by rememberSaveable {
            mutableStateOf(false)
        }

        val realColor3 by animateColorAsState(
            targetValue = if (thirdColor) Color.Red else Color.Yellow,
            animationSpec = tween(durationMillis = 2000),
            finishedListener = {
                //Toast.makeText(context, "Termino", Toast.LENGTH_LONG).show()
            },
            label = "asdasd"
        )
        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor3)
            .clickable { thirdColor = thirdColor.not() })

    }
}

@Composable
@Preview
fun ClassSizeExample() {
    var smallSize by rememberSaveable {
        mutableStateOf(true)
    }

    val size by animateDpAsState(
        targetValue = if (smallSize) 50.dp else 100.dp,
        animationSpec = tween(durationMillis = 500),
        finishedListener = {

        }
    )

    Box(
        modifier = Modifier
            .size(size)
            .background(Color.Cyan)
            .clickable { smallSize = smallSize.not() }
    )
}


@Composable
@Preview
fun ClassVisibilityAn() {
    var isVisible by rememberSaveable {
        mutableStateOf(true)
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = { isVisible = isVisible.not() }) {
            Text(text = "Show/Hide")
        }

        Spacer(modifier = Modifier.size(100.dp))

        AnimatedVisibility(
            visible = isVisible
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Cyan)
            )
        }
    }
}

@Composable
@Preview
fun CrossFadeExampleAnimation() {
    var myComposable by rememberSaveable {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Button(onClick = {
            if (myComposable == 2) {
                myComposable = 0
            } else {
                myComposable++
            }
        }) {
            Text(text = "Cambiar")
        }

        Crossfade(targetState = myComposable, label = "") { type ->
            when (type) {
                0 -> TextField(value = "", onValueChange = {})
                1 -> Text(text = "Component 1")
                2 -> Box(modifier = Modifier.size(100.dp))
            }
        }

    }
}

@Composable
@Preview
fun InfiniteColor() {
    val infiniteTransition = rememberInfiniteTransition(label = "infinite")
    val color by infiniteTransition.animateColor(
        initialValue = Color.Green,
        targetValue = Color.Blue,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "color"
    )
    Column(
        modifier = Modifier
            .size(100.dp)
            .background(color)
    ) {

    }
}


@Composable
@Preview
fun InfiniteText() {
    var textSize = remember { Animatable(initialValue = 12.sp.value) }
    var textSize2 = remember { Animatable(initialValue = 12.sp.value) }
    Column {
        Text(text = "Text Animation 1", fontSize = textSize.value.sp)
        Text(text = "Text Animation 2", fontSize = textSize2.value.sp)
    }

    LaunchedEffect(Unit) {
        delay(2000)
        textSize.animateTo(
            targetValue = 28.sp.value,
            animationSpec = tween(durationMillis = 2000)
        )
        textSize2.animateTo(
            targetValue = 28.sp.value,
            animationSpec = tween(durationMillis = 2000)
        )
//        launch {
//            textSize.animateTo(
//                targetValue = 28.sp.value,
//                animationSpec = tween(durationMillis = 2000)
//            )
//        }
//        launch {
//            textSize2.animateTo(
//                targetValue = 28.sp.value,
//                animationSpec = tween(durationMillis = 2000)
//            )
//        }
    }
}

@Composable
@Preview
fun TweenAnimations() {
    var moved by remember { mutableStateOf(false) }
    val offset by animateIntOffsetAsState(
        targetValue = if (moved) {
            IntOffset(1000, 0)
        } else {
            IntOffset.Zero
        },
        animationSpec = tween(
            durationMillis = TimeUnit.SECONDS.toMillis(1).toInt(),
            easing = FastOutLinearInEasing
        ),
        label = "offset"
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {
            moved = !moved
        }) {
            Text(text = "Move")
        }
        Box(
            modifier = Modifier
                .offset {
                    offset
                }
                .background(Color.Yellow)
                .size(100.dp)
        )
    }
}


@Composable
@Preview
fun SpringAnimations() {
    var moved by remember { mutableStateOf(false) }
    val offset by animateIntOffsetAsState(
        targetValue = if (moved) {
            IntOffset(1000, 0)
        } else {
            IntOffset.Zero
        },
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "offset"
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {
            moved = !moved
        }) {
            Text(text = "Move")
        }
        Box(
            modifier = Modifier
                .offset {
                    offset
                }
                .background(Color.Yellow)
                .size(100.dp)
        )
    }
}