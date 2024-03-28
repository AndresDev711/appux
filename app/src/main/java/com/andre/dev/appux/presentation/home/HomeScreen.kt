package com.andre.dev.appux.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.andre.dev.appux.R
import com.andre.dev.appux.ui.theme.Zinc

@Composable
fun HomeScreen() {
  Surface(modifier = Modifier.fillMaxSize()) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
      val (nameRow, list, card, topBar) = createRefs()
      Image(
        painter = painterResource(id = R.drawable.backgroundtop),
        contentDescription = null,
        modifier = Modifier.constrainAs(topBar) {
          top.linkTo(parent.top)
          start.linkTo(parent.start)
          end.linkTo(parent.end)
        })
      
      Box(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 32.dp, start = 16.dp, end = 16.dp)
        .constrainAs(nameRow) {
          top.linkTo(parent.top)
          start.linkTo(parent.start)
          end.linkTo(parent.end)
        }) {
        Column() {
          Text(text = "Good Afternoon", fontSize = 24.sp, fontWeight = FontWeight.Bold)
          Text(text = "Code", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
        
        Image(
          painter = painterResource(id = R.drawable.dots_menu),
          contentDescription = null,
          modifier = Modifier.align(CenterEnd)
        )
        
      }
      
      CardItem(
        modifier = Modifier.constrainAs(card) {
          top.linkTo(nameRow.bottom)
          start.linkTo(parent.start)
          end.linkTo(parent.end)
        }
      )
      
      TransactionList(
        modifier = Modifier
          .fillMaxWidth()
          .constrainAs(list) {
            top.linkTo(card.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
            height = Dimension.fillToConstraints
          }
      )
      
    }
  }
}

@Composable
fun CardItem(modifier: Modifier) {
  Column(
    modifier = modifier
      .padding(16.dp)
      .fillMaxWidth()
      .height(200.dp)
      .clip(RoundedCornerShape(16.dp))
      .background(Zinc)
      .padding(15.dp)
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .weight(1f)
    ) {
      Column(modifier = Modifier.align(Alignment.CenterStart)) {
        Text(text = "Total Balance", fontSize = 16.sp, color = Color.White)
        Text(text = "PEN 100,000", fontSize = 16.sp, color = Color.White)
      }
      Image(
        painter = painterResource(id = R.drawable.dots_menu),
        contentDescription = null,
        modifier = Modifier.align(CenterEnd)
      )
    }
    
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .weight(1f),
    ) {
      
      CardRowItem(
        modifier = Modifier.align(Alignment.CenterStart),
        title = "Income",
        amount = "PEN 3,300.00",
        image = R.drawable.dots_menu
      )
      CardRowItem(
        modifier = Modifier.align(CenterEnd),
        title = "Income",
        amount = "PEN 1,000.00",
        image = R.drawable.dots_menu
      )
    }
    
  }
}

@Composable
fun CardRowItem(modifier: Modifier, title: String, amount: String, image: Int) {
  Column(modifier = modifier) {
    Row {
      Image(painter = painterResource(id = R.drawable.dots_menu), contentDescription = null)
      Spacer(modifier = Modifier.size(8.dp))
      Text(text = title, fontSize = 16.sp, color = Color.White)
    }
    Text(text = amount, fontSize = 20.sp, color = Color.White)
  }
  
}

@Composable
fun TransactionList(modifier: Modifier) {
  Column(modifier = modifier.padding(horizontal = 16.dp)) {
    Box(modifier = Modifier.fillMaxWidth()) {
      Text(text = "Recent Transaction", fontSize = 20.sp)
      Text(
        text = "See All", fontSize = 16.sp,
        modifier = Modifier.align(Alignment.CenterEnd)
      )
    }
    TransactionItem(
      title = "mercadopago",
      amount = "500",
      icon = R.drawable.dots_menu,
      date = "10/10/2010"
    )
    TransactionItem(
      title = "PAYPAL",
      amount = "400",
      icon = R.drawable.dots_menu,
      date = "10/10/2010"
    )
  }
}

@Composable
fun TransactionItem(title: String, amount: String, icon: Int, date: String) {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 10.dp)
  ) {
    
    Row() {
      Image(
        painter = painterResource(id = icon),
        contentDescription = null,
        modifier = Modifier.size(50.dp)
      )
      Spacer(modifier = Modifier.size(16.dp))
      Column {
        Text(text = title, fontSize = 16.sp)
        Text(text = date, fontSize = 12.sp)
      }
    }
    Text(text = amount, fontSize = 16.sp, modifier = Modifier.align(CenterEnd))
  }
  
}

@Composable
@Preview(showBackground = true)
fun PreviewHomeScreen() {
  HomeScreen()
}
