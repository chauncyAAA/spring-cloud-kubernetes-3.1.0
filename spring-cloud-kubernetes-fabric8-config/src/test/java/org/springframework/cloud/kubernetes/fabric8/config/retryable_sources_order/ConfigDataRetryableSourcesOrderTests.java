/*
 * Copyright 2013-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.kubernetes.fabric8.config.retryable_sources_order;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import org.junit.jupiter.api.BeforeAll;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wind57
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = RetryableSourcesOrderApp.class,
		properties = { "spring.application.name=sources-order", "spring.main.cloud-platform=KUBERNETES",
				"spring.config.import=kubernetes:,classpath:./retryable-sources-order.yaml" })
@EnableKubernetesMockClient(crud = true, https = false)
class ConfigDataRetryableSourcesOrderTests extends RetryableSourcesOrderTests {

	private static KubernetesClient mockClient;

	@BeforeAll
	static void setUp() {
		setUpBeforeClass(mockClient);
	}

}
