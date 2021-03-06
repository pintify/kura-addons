/*
 * Copyright (C) 2018 Jens Reimann <jreimann@redhat.com>
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

package de.dentrassi.kura.addons.drools;

import java.util.Properties;
import java.util.function.Consumer;

import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.ReleaseId;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderConfiguration;
import org.osgi.framework.BundleContext;

public interface Drools {

    public interface KnowledgeBuilderBaseBuilder {

        public KnowledgeBuilderBaseBuilder configure(Properties properties,
                Consumer<KnowledgeBuilderConfiguration> customizer);

        public default KnowledgeBuilderBaseBuilder configure(final Consumer<KnowledgeBuilderConfiguration> customizer) {
            return configure(null, customizer);
        }

        public KnowledgeBuilderBaseBuilder configureBase(Properties properties,
                final Consumer<KieBaseConfiguration> customizer);

        public default KnowledgeBuilderBaseBuilder configureBase(final Consumer<KieBaseConfiguration> customizer) {
            return configureBase(null, customizer);
        }

        public KnowledgeBuilderBaseBuilder customize(Consumer<KnowledgeBuilder> customizer);

        public KieBase build();

    }

    /**
     * @deprecated This is untested
     */
    @Deprecated
    public interface KieBaseBuilder {

        public KieBaseBuilder baseConfigurationProperties(Properties baseConfigurationProperties);

        public KieBaseBuilder customizeBaseConfiguration(Consumer<KieBaseConfiguration> customizeBaseConfiguration);

        public KieBaseBuilder releaseId(ReleaseId releaseId);

        public KieBaseBuilder fileSystem(Consumer<KieFileSystem> fileSystem);

        public KieBase build();

    }

    public KnowledgeBuilderBaseBuilder newKnowledgeBuilderBaseBuilder(BundleContext context);

    public KieBaseBuilder newKieBaseBuilder(BundleContext context);
}
