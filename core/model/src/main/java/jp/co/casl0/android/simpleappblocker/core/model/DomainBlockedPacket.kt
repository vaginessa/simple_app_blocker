/*
 * Copyright 2022 CASL0
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.co.casl0.android.simpleappblocker.core.model

data class DomainBlockedPacket(
    val packageName: CharSequence,
    val appName: CharSequence,
    val srcAddress: CharSequence,
    val srcPort: Int,
    val dstAddress: CharSequence,
    val dstPort: Int,
    val protocol: CharSequence,
    val blockedAt: CharSequence
) {
    /** 送信元のIP・ポートの情報を取得する関数 */
    val srcAddressAndPort: CharSequence get() = "$srcAddress ($srcPort)"

    /** 宛先のIP・ポートの情報を取得する関数 */
    val dstAddressAndPort: CharSequence get() = "$dstAddress ($dstPort)"
}
