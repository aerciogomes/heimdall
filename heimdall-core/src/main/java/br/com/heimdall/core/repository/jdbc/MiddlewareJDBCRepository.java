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
package br.com.heimdall.core.repository.jdbc;

import java.util.List;

import javax.sql.DataSource;

import br.com.heimdall.core.entity.Middleware;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MiddlewareJDBCRepository {

	private JdbcTemplate jdbcTemplate;

	public MiddlewareJDBCRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Middleware> findAllActive() {
		StringBuilder sql = new StringBuilder(120);
		sql.append("SELECT * FROM MIDDLEWARES WHERE STATUS = 'ACTIVE'");

		return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<Middleware>(Middleware.class));
	}
}
