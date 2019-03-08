/*
 *    Copyright 2018 Fabien Boismoreau
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.bwaim.myfirstkotlinapp

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by Fabien Boismoreau on 03/03/2019.
 * <p>
 */
object MediaProvider {
    private val thumbBase = "http://lorempixel.com/400/400/cats/"

    private var data = emptyList<MediaItem>()

    fun mediaAsync(callback: (List<MediaItem>) -> Unit) {
        doAsync {
            if (data.isEmpty()) {
                Thread.sleep(2_000)
                data = (1..10).map {
                    MediaItem(
                        it, "Title $it", "$thumbBase$it",
                        if (it % 3 == 0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO
                    )
                }
            }
            uiThread {
                callback(data)
            }
        }
    }
}