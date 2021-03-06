/**
 * Copyright 2012 Apache Wave
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

package org.waveprotocol.box.server.waveserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Valid search query types.
 *
 * @author yurize@apache.org (Yuri Zelikov)
 */
public enum TokenQueryType {
  IN("in"),
  ORDERBY("orderby"),
  WITH("with"),
  CREATOR("creator"),
  ID("id"),
  ;

  final String token;

  TokenQueryType(String token) {
    this.token = token;
  }

  String getToken() {
    return token;
  }

  private static final Map<String, TokenQueryType> reverseLookupMap =
      new HashMap<String, TokenQueryType>();
  static {
    for (TokenQueryType type : TokenQueryType.values()) {
      reverseLookupMap.put(type.getToken(), type);
    }
  }

  /**
   * Looks up the type by the string token.
   *
   * @param token the token in the search, like: "in" or "with".
   * @return the corresponding TokenType.
   */
  public static TokenQueryType fromToken(String token) {
    TokenQueryType qyeryToken = reverseLookupMap.get(token);
    if (qyeryToken == null) {
      throw new IllegalArgumentException("Illegal query param: " + token);
    }
    return reverseLookupMap.get(token);
  }

  /**
   * @return true if there such token in the enum, false otherwise.
   */
  public static boolean hasToken(String token) {
    return reverseLookupMap.keySet().contains(token);
  }
}
