/*
 * Copyright (C) 2023 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package app.cash.paparazzi.internal.resources.base

import app.cash.paparazzi.internal.resources.ResourceSourceFile
import com.android.resources.ResourceType
import com.android.resources.ResourceVisibility
import com.android.utils.HashCodes
import java.util.Objects

/**
 * Ported from: [BasicValueResourceItem.java](https://cs.android.com/android-studio/platform/tools/base/+/18047faf69512736b8ddb1f6a6785f58d47c893f:resource-repository/main/java/com/android/resources/base/BasicValueResourceItem.java)
 *
 * Resource item representing a value resource, e.g. a string or a color.
 */
class BasicValueResourceItem(
  type: ResourceType,
  name: String,
  sourceFile: ResourceSourceFile,
  visibility: ResourceVisibility,
  private val value: String?
) : BasicValueResourceItemBase(type, name, sourceFile, visibility) {
  override fun getValue() = value

  override fun equals(obj: Any?): Boolean {
    if (this === obj) return true
    if (!super.equals(obj)) return false
    val other = obj as BasicValueResourceItem
    return Objects.equals(value, other.value)
  }

  override fun hashCode(): Int {
    return HashCodes.mix(super.hashCode(), value.hashCode())
  }
}