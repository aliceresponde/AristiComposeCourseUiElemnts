package com.aliceresponde.aristicomposecourse

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

//@Preview(showBackground = true)
@Composable
fun MyHorizontalChain() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxYellow, boxBlue, boxRed) = createRefs()

        Box(
            Modifier
                .size(100.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    start.linkTo(parent.start)
                    end.linkTo(boxBlue.start)
                }
        )

        Box(
            Modifier
                .size(100.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    start.linkTo(boxYellow.end)
                    end.linkTo(boxRed.start)
                }
        )

        Box(
            Modifier
                .size(100.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    start.linkTo(boxBlue.end)
                    end.linkTo(parent.end)
                }
        )

        createHorizontalChain(boxYellow, boxBlue, boxRed, chainStyle = ChainStyle.Packed)

    }
}

@Composable
fun MyBarrierConstrain() {
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val (boxRed, boxCyan, boxBlue) = createRefs()
        val endBarrier = createEndBarrier(boxRed, boxCyan)

        Box( // Center Cyan
            modifier = Modifier
                .size(300.dp)
                .background(Color.Cyan)
                .constrainAs(boxCyan) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )

        Box(  // red
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
        )

        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    start.linkTo(endBarrier)
                }
        )
    }
}

@Composable
fun MyGuideLineConstrain() {
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        val (boxYellow, boxRed, boxCyan) = createRefs()
        val horizontalTopGuideLine = createGuidelineFromTop(0.3f)
        val verticalStartGuideLine = createGuidelineFromStart(0.5f)

        Box( // Center Cyan
            modifier = Modifier
                .size(100.dp)
                .background(Color.Cyan)
                .constrainAs(boxCyan) {
                    top.linkTo(horizontalTopGuideLine)
                }
        )

        Box(  // yellow
            modifier = Modifier
                .size(50.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    end.linkTo(verticalStartGuideLine)
                    top.linkTo(horizontalTopGuideLine)
                }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    start.linkTo(verticalStartGuideLine)
                    bottom.linkTo(horizontalTopGuideLine)
                }
        )
    }
}

@Composable
fun MyConstraint() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxYellow, boxRed, boxGreen, boxCyan, boxBlue) = createRefs()

        Box( // Center Cyan
            modifier = Modifier
                .size(100.dp)
                .background(Color.Cyan)
                .constrainAs(boxCyan) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Box(  // in relation to center Cyan  diagonal ->; down ::: Yellow
            modifier = Modifier
                .size(100.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    top.linkTo(boxCyan.bottom)
                    start.linkTo(boxCyan.end)
                }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(boxCyan.bottom)
                    end.linkTo(boxCyan.start)
                }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    bottom.linkTo(boxCyan.top)
                    start.linkTo(boxCyan.end)
                }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
                .constrainAs(
                    boxBlue
                ) {
                    bottom.linkTo(boxCyan.top)
                    end.linkTo(boxCyan.start)
                }
        )
    }
}
