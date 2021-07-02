package br.com.heimdall.core.interceptor.impl;

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

import br.com.heimdall.core.dto.interceptor.RateLimitDTO;
import br.com.heimdall.core.entity.Interceptor;
import br.com.heimdall.core.enums.TypeExecutionPoint;
import br.com.heimdall.core.enums.TypeInterceptor;
import br.com.heimdall.core.exception.ExceptionMessage;
import br.com.heimdall.core.interceptor.HeimdallInterceptor;
import br.com.heimdall.core.util.ConstantsCache;
import br.com.heimdall.core.util.JsonUtils;
import br.com.heimdall.core.util.TemplateUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the HeimdallInterceptor to type Ratting.
 *
 * @author <a href="https://dijalmasilva.github.io" target="_blank">Dijalma Silva</a>
 */
@Slf4j
public class RattingHeimdallInterceptor implements HeimdallInterceptor {

    @Override
    public String getFile(TypeExecutionPoint typeExecutionPoint) {
        return "ratting.mustache";
    }

    @Override
    public RateLimitDTO parseContent(String content) {
        try {
            return JsonUtils.convertJsonToObject(content, RateLimitDTO.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            ExceptionMessage.INTERCEPTOR_INVALID_CONTENT.raise(TypeInterceptor.RATTING.name(), TemplateUtils.TEMPLATE_RATTING);
        }

        return null;
    }

    @Override
    public Map<String, Object> buildParameters(Interceptor interceptor) {

        Map<String, Object> parameters = new HashMap<>();
        RateLimitDTO rateLimitDTO = this.parseContent(interceptor.getContent());

        parameters.put("calls", rateLimitDTO.getCalls());
        parameters.put("interval", rateLimitDTO.getInterval().name());
        parameters.put("cache-key", ConstantsCache.RATE_LIMIT_KEY_PREFIX + interceptor.getId());

        return parameters;
    }

}
