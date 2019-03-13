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

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy { findViewById<RecyclerView>(R.id.recycler) }
    private val adapter = MediaAdapter { navigateToDetail(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MediaProvider.mediaAsync { adapter.items = it }

        recyclerView.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val filter = when (item.itemId) {
            R.id.filter_photos -> Filter.ByType(MediaItem.Type.PHOTO)
            R.id.filter_videos -> Filter.ByType(MediaItem.Type.VIDEO)
            else -> Filter.None()
        }

        GlobalScope.launch(Dispatchers.Main) {
            val media1 = async(Dispatchers.IO) { MediaProvider.dataSync("cats") }
            val media2 = async(Dispatchers.IO) { MediaProvider.dataSync("nature") }
            updateData(media1.await() + media2.await(), filter)
        }

        return true
    }

    private fun updateData(media: List<MediaItem>, filter: Filter) {
            adapter.items = when (filter) {
                is Filter.None -> media
                is Filter.ByType -> media.filter { it.type == filter.type }
        }
    }

    private fun navigateToDetail(item: MediaItem) {
        startActivity<DetailActivity>(DetailActivity.ID to item.id)
    }
}

sealed class Filter {
    class None : Filter()
    class ByType(val type: MediaItem.Type) : Filter()
}
