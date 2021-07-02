package br.com.heimdall.core.util;

/*-
 * =========================LICENSE_START==================================
 * heimdall-core
 * ========================================================================
 *
 * ========================================================================
 * Licensed under the Apache License, Version 2.0 (the "License")
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
 * ==========================LICENSE_END===================================
 */

/**
 * This class holds oAuth constants
 *
 * @author <a href="https://dijalmasilva.github.io" target="_blank">Dijalma Silva</a>
 */
public final class ConstantsOAuth {

    private ConstantsOAuth() { }

    public static final String GRANT_TYPE_PASSWORD = "PASSWORD";
    public static final String GRANT_TYPE_REFRESH_TOKEN = "REFRESH_TOKEN";
    public static final String GRANT_TYPE_IMPLICIT = "IMPLICIT";

}
