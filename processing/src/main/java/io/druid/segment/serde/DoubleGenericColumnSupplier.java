/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.druid.segment.serde;

import com.google.common.base.Supplier;
import io.druid.collections.bitmap.ImmutableBitmap;
import io.druid.segment.column.DoublesColumn;
import io.druid.segment.column.GenericColumn;
import io.druid.segment.data.ColumnarDoubles;

public class DoubleGenericColumnSupplier implements Supplier<GenericColumn>
{
  private final Supplier<ColumnarDoubles> column;
  private final ImmutableBitmap nullValueBitmap;

  DoubleGenericColumnSupplier(Supplier<ColumnarDoubles> column, ImmutableBitmap nullValueBitmap)
  {
    this.column = column;
    this.nullValueBitmap = nullValueBitmap;
  }

  @Override
  public GenericColumn get()
  {
    return DoublesColumn.create(column.get(), nullValueBitmap);
  }
}
