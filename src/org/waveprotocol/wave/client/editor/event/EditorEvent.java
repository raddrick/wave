/**
 * Copyright 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.waveprotocol.wave.client.editor.event;

import org.waveprotocol.wave.client.common.util.SignalEvent;
import org.waveprotocol.wave.client.editor.content.ContentPoint;

/**
 * Editor extensions to {@link SignalEvent}
 *
 * @author danilatos@google.com (Daniel Danilatos)
 */
public interface EditorEvent extends SignalEvent {

  /**
   * Indicate that the default browser behaviour should be allowed for this
   * event. This will only be honoured for some event types, such as navigation
   * events.
   */
  void allowBrowserDefault();

  /**
   * @return true if it was indicated that the default browser behaviour should
   * be allowed.
   */
  boolean shouldAllowBrowserDefault();

  /**
   * TODO(danilatos): Get rid of this
   *
   * @param caret
   */
  void setCaret(ContentPoint caret);

  /**
   * @return the caret
   */
  ContentPoint getCaret();
}
