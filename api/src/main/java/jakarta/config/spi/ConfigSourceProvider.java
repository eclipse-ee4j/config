/*
 * Copyright (c) 2021 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jakarta.config.spi;

/**
 * A provider for <em>configuration source</em> instances.
 * <p>
 * Implementations of this interface may supply zero or more {@linkplain ConfigSource configuration source} instances
 * for a given application (as defined by the application's {@link ClassLoader}).
 * <p>
 * Instances of this interface will be {@linkplain ConfigBuilder#addDiscoveredSources() discovered} via the
 * {@link java.util.ServiceLoader} mechanism and can be registered by providing a
 * {@code META-INF/services/jakarta.config.spi.ConfigSourceProvider}
 * {@linkplain ClassLoader#getResource(String) resource} which contains the fully qualified class name of the custom
 * {@code ConfigSourceProvider} implementation.
 *
 * @author <a href="mailto:struberg@apache.org">Mark Struberg</a>
 * @author <a href="mailto:gpetracek@apache.org">Gerhard Petracek</a>
 * @author <a href="mailto:emijiang@uk.ibm.com">Emily Jiang</a>
 */
public interface ConfigSourceProvider {
    /**
     * Return the {@link ConfigSource} instances that are provided by this provider. The {@link Iterable
     * Iterable} contains a fixed number of {@linkplain ConfigSource configuration sources}, determined at application
     * start time, and the config sources themselves may be static or dynamic. An empty {@link Iterable
     * Iterable} may be returned if no sources are to be provided.
     *
     * @param forClassLoader
     *            the class loader which should be used for discovery and resource loading purposes
     * @return the {@link ConfigSource} instances to register to the configuration
     */
    Iterable<ConfigSource> getConfigSources(ClassLoader forClassLoader);
}
