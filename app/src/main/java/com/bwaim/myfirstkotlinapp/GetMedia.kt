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

/**
 * Created by Fabien Boismoreau on 03/03/2019.
 * <p>
 */
private val thumbBase = "http://lorempixel.com/400/400/cats/"

fun getMedia() = listOf(
    MediaItem("Title 1", "${thumbBase}1", MediaItem.Type.PHOTO),
    MediaItem("Title 2", "${thumbBase}2", MediaItem.Type.PHOTO),
    MediaItem("Title 3", "${thumbBase}3", MediaItem.Type.VIDEO),
    MediaItem("Title 4", "${thumbBase}4", MediaItem.Type.PHOTO),
    MediaItem("Title 5", "${thumbBase}5", MediaItem.Type.PHOTO),
    MediaItem("Title 6", "${thumbBase}6", MediaItem.Type.VIDEO),
    MediaItem("Title 7", "${thumbBase}7", MediaItem.Type.VIDEO),
    MediaItem("Title 8", "${thumbBase}8", MediaItem.Type.PHOTO),
    MediaItem("Title 9", "${thumbBase}9", MediaItem.Type.PHOTO),
    MediaItem("Title 10", "${thumbBase}10", MediaItem.Type.VIDEO)
)