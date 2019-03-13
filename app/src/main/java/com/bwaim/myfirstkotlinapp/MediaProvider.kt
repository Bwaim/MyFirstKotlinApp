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
import kotlin.random.Random

/**
 * Created by Fabien Boismoreau on 03/03/2019.
 * <p>
 */
object MediaProvider {
    private val thumbBase = "http://lorempixel.com/400/400/"
    private val rnd = Random(1)

    private var data = emptyList<MediaItem>()

    private fun randomType() = rnd.nextInt(2).let { if (it == 0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO }

    fun mediaAsync(type: String = "cats", callback: (List<MediaItem>) -> Unit) {
        doAsync {
            if (data.isEmpty()) {
                data = dataSync(type)
            }
            uiThread {
                callback(data)
            }
        }
    }

    fun dataSync(type: String): List<MediaItem> {
        Thread.sleep(2_000)
        return (1..10).map {
            MediaItem(it, "Title $it", "$thumbBase$type/$it", randomType())
        }
    }
}