/*
 * Copyright 2022 CASL0
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.co.casl0.android.simpleappblocker.ui.molecules

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.co.casl0.android.simpleappblocker.R
import jp.co.casl0.android.simpleappblocker.ui.theme.ApplicationTheme

@Composable
fun BlockLogItem(src: String, dst: String, time: String, modifier: Modifier = Modifier) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.height(IntrinsicSize.Max).fillMaxWidth()
    ) {
        Column(
            modifier = modifier.background(MaterialTheme.colors.background)
                .padding(16.dp).width(IntrinsicSize.Max)
        ) {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) { // ブロック時刻
                Text(text = time, color = MaterialTheme.colors.secondaryVariant)
            }
            Spacer(modifier = modifier.height(4.dp))
            Row { // 送信元IPアドレス
                Text(
                    text = stringResource(R.string.block_log_src),
                    color = MaterialTheme.colors.primary
                )
                Spacer(modifier = modifier.width(8.dp))
                Text(text = src, color = MaterialTheme.colors.primary)
            }
            Spacer(modifier = modifier.height(4.dp))
            Row { // 宛先IPアドレス
                Text(
                    text = stringResource(R.string.block_log_dst),
                    color = MaterialTheme.colors.primary
                )
                Spacer(modifier = modifier.width(8.dp))
                Text(text = dst, color = MaterialTheme.colors.primary)
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewBlockLogItem() {
    ApplicationTheme {
        BlockLogItem(
            src = "1.1.1.1 (40000)",
            dst = "2.2.2.2 (50000)",
            time = "yyyy-MM-dd HH:mm:ss"
        )
    }
}