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

fun doAsync(x: Int, callBack: (String) -> Unit) {
    // background task
    callBack("Finished ${x}")
}

fun test() {
    doAsync(2) {
        print(it)
    }
}