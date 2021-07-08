package ru.astroapps.podlodkacomposetest.screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.astroapps.podlodkacomposetest.R
import ru.astroapps.podlodkacomposetest.model.Session
import ru.astroapps.podlodkacomposetest.screen.element.CircleImage

@Composable
fun SpeakerScreen(session: Session) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(state = ScrollState(0)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircleImage(url = session.imageUrl, size = 300.dp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = session.speaker,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_calendar),
                contentDescription = "Icon Calendar"
            )
            Text(text = "${session.date}, ${session.timeInterval}")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = session.description, modifier = Modifier.fillMaxWidth(), fontSize = 18.sp)
    }
}
