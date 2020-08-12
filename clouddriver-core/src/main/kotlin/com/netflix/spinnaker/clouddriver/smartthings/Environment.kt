/*
 * Copyright 2020 Netflix, Inc.
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
 *
 */

package com.netflix.spinnaker.clouddriver.smartthings

const val EXPRESSION = "^([a-z]{2}[0-9]{2}|..global|global|regional|tlm|adt|cellroute|partapi|adt|epna[0-9])([a-z])?"

fun getEnvFromStack(stack: String): String {
  return when (EXPRESSION.toRegex().find(stack)?.groupValues?.get(2)) {
    "" -> "production"
    "a" -> "acceptance"
    "s" -> "staging"
    "d" -> "dev"
    "c" -> "corp"
    "t" -> "loadtest"
    "i" -> "integration"
    else -> stack
  }
}
