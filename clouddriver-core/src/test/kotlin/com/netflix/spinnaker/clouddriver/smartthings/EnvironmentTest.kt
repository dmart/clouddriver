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

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class EnvironmentTest {
  @Test
  fun `test environment resolution`() {
    Assertions.assertAll(
      Executable { Assertions.assertEquals(getEnvFromStack("na01d"), "dev") },
      Executable { Assertions.assertEquals(getEnvFromStack("na01d_useast1"), "dev") },
      Executable { Assertions.assertEquals(getEnvFromStack("na01_useast1"), "production") },
      Executable { Assertions.assertEquals(getEnvFromStack("na01"), "production") },
      Executable { Assertions.assertEquals(getEnvFromStack("production"), "production") },
      Executable { Assertions.assertEquals(getEnvFromStack("dev"), "dev") },
      Executable { Assertions.assertEquals(getEnvFromStack("na01z"), "na01z") },
      Executable { Assertions.assertEquals(getEnvFromStack("cn01_cnnorth1_st"), "production") },
      Executable { Assertions.assertEquals(getEnvFromStack("globals_useast1"), "staging") },
      Executable { Assertions.assertEquals(getEnvFromStack("regionald_useast1"), "dev") },
      Executable { Assertions.assertEquals(getEnvFromStack("cellrouted_useast1"), "dev") },
      Executable { Assertions.assertEquals(getEnvFromStack("epna1s_useast1"), "staging") },
      Executable { Assertions.assertEquals(getEnvFromStack("tlm01_useast2"), "production") },
      Executable { Assertions.assertEquals(getEnvFromStack("adt_useast2"), "production") }
    )
  }
}
