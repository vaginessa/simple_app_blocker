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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import jp.co.casl0.android.simpleappblocker.R

@Composable
fun BlockLogContent(
    src: String,
    dst: String,
    protocol: String,
    time: String,
    appName: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.background(MaterialTheme.colors.background)
            .padding(8.dp).width(IntrinsicSize.Max)
    ) {
        Row(modifier = modifier.fillMaxWidth()) {
            Text(
                text = appName,
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
                modifier = modifier.align(Alignment.CenterVertically)
            )
        }
        Spacer(modifier = modifier.height(4.dp))
        Row(modifier = modifier.fillMaxWidth()) {
            // プロトコル
            Text(
                text = protocol,
                textAlign = TextAlign.Left,
                modifier = modifier.weight(1.0f),
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold
            )
            // ブロック時刻
            Text(
                text = time,
                color = MaterialTheme.colors.secondaryVariant,
                textAlign = TextAlign.Right,
                modifier = modifier.weight(1.0f)
            )
        }
        Spacer(modifier = modifier.height(4.dp))
        Row { // 送信元IPアドレス
            Text(
                text = stringResource(R.string.block_log_src),
                color = MaterialTheme.colors.primary
            )
            Spacer(modifier = modifier.width(8.dp))
            Text(
                text = src,
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = modifier.height(4.dp))
        Row { // 宛先IPアドレス
            Text(
                text = stringResource(R.string.block_log_dst),
                color = MaterialTheme.colors.primary
            )
            Spacer(modifier = modifier.width(8.dp))
            Text(
                text = dst,
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}