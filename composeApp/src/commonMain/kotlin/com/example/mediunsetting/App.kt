package com.example.mediunsetting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.painterResource
import mediunsetting.composeapp.generated.resources.Res
import mediunsetting.composeapp.generated.resources.ic_back
import mediunsetting.composeapp.generated.resources.ic_support_question
import mediunsetting.composeapp.generated.resources.ic_account
import mediunsetting.composeapp.generated.resources.ic_lock
import mediunsetting.composeapp.generated.resources.ic_camera
import mediunsetting.composeapp.generated.resources.ic_wallet
import mediunsetting.composeapp.generated.resources.ic_share
import mediunsetting.composeapp.generated.resources.ic_qr
import mediunsetting.composeapp.generated.resources.ic_bell
import mediunsetting.composeapp.generated.resources.ic_book
import mediunsetting.composeapp.generated.resources.ic_umbrella
import mediunsetting.composeapp.generated.resources.ic_accessibility
import mediunsetting.composeapp.generated.resources.ic_drop
import mediunsetting.composeapp.generated.resources.ic_chevron_right
import mediunsetting.composeapp.generated.resources.ic_pen
import mediunsetting.composeapp.generated.resources.ic_status_battery
import mediunsetting.composeapp.generated.resources.ic_status_wifi
import mediunsetting.composeapp.generated.resources.ic_status_cellular

@Composable
@Preview
fun App() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFFFFFFF)) {
            SettingsScreen()
        }
    }
}

@Composable
private fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFFFFFFF))
    ) {
        StatusBar()
        TopBar(title = "Privacy and settings")

        Section(
            header = "ACCOUNT",
            items = listOf(
                "Manage my account",
                "Privacy and safety",
                "Content preferences",
                "Balance",
                "Share profile",
                "TikCode"
            )
        )

        Section(
            header = "GENERAL",
            items = listOf(
                "Push notifications",
                "Language",
                "Digital Wellbeing",
                "Accessibility",
                "Data Saver"
            )
        )

        SupportSection()

        HomeIndicator()
    }
}

@Composable
private fun StatusBarSpacer(height: Dp) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
private fun StatusBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "9:41",
            color = Color(0xFF171717),
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(Res.drawable.ic_status_cellular), contentDescription = null, modifier = Modifier.padding(end = 8.dp).size(width = 18.77.dp, height = 10.67.dp))
            Image(painter = painterResource(Res.drawable.ic_status_wifi), contentDescription = null, modifier = Modifier.padding(end = 8.dp).size(width = 16.86.dp, height = 10.97.dp))
            Image(painter = painterResource(Res.drawable.ic_status_battery), contentDescription = null, modifier = Modifier.size(width = 24.5.dp, height = 10.5.dp))
        }
    }
}

@Composable
private fun TopBar(title: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .background(Color(0xFFFFFFFF)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(Res.drawable.ic_back),
                contentDescription = null,
                modifier = Modifier.padding(start = 16.dp).size(18.dp)
            )
            Text(
                text = title,
                color = Color(0xFF161722),
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun Section(header: String, items: List<String>) {
    Text(
        text = header,
        color = Color(0xFF86878B),
        fontSize = 13.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(start = 16.dp, top = 20.dp, bottom = 4.dp)
    )

    items.forEachIndexed { index, label ->
        if (index == 0) {
            // first row sits right under header
        }
        SettingsRow(label)
    }

    DividerHorizontal(padding = PaddingValues(horizontal = 16.dp))
}

@Composable
private fun SettingsRow(label: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .background(Color(0xFFFFFFFF))
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val iconRes = when (label) {
            "Manage my account" -> Res.drawable.ic_account
            "Privacy and safety" -> Res.drawable.ic_lock
            "Content preferences" -> Res.drawable.ic_camera
            "Balance" -> Res.drawable.ic_wallet
            "Share profile" -> Res.drawable.ic_share
            "TikCode" -> Res.drawable.ic_qr
            "Push notifications" -> Res.drawable.ic_bell
            "Language" -> Res.drawable.ic_book
            "Digital Wellbeing" -> Res.drawable.ic_umbrella
            "Accessibility" -> Res.drawable.ic_accessibility
            "Data Saver" -> Res.drawable.ic_drop
            else -> null
        }
        if (iconRes != null) {
            Image(painter = painterResource(iconRes), contentDescription = null, modifier = Modifier.size(18.dp))
        } else {
            Spacer(modifier = Modifier.size(18.dp))
        }

        Text(
            text = label,
            color = Color(0xFF161722),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(start = 14.dp)
                .weight(1f)
        )

        Image(
            painter = painterResource(Res.drawable.ic_chevron_right),
            contentDescription = null,
            modifier = Modifier.size(10.5.dp)
        )
    }
}

@Composable
private fun SupportSection() {
    Text(
        text = "SUPPORT",
        color = Color(0xFF86878B),
        fontSize = 13.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(start = 16.dp, top = 20.dp, bottom = 4.dp)
    )

    // Report a problem
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .background(Color(0xFFFFFFFF))
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(Res.drawable.ic_pen),
            contentDescription = null,
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = "Report a problem",
            color = Color(0xFF161722),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 14.dp)
        )
    }

    // Help Center with question icon
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .background(Color(0xFFFFFFFF))
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(Res.drawable.ic_support_question),
            contentDescription = null,
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = "Help Center",
            color = Color(0xFF161722),
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 14.dp)
        )
    }

    DividerHorizontal(padding = PaddingValues(horizontal = 16.dp))
}

@Composable
private fun DividerHorizontal(padding: PaddingValues) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.padding(padding).fillMaxWidth().height(1.dp).background(Color(0xFFD0D1D3)))
    }
}

@Composable
private fun HomeIndicator() {
    Spacer(modifier = Modifier.height(16.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(width = 134.dp, height = 5.dp)
                .background(Color(0xFF060606))
        )
    }
}