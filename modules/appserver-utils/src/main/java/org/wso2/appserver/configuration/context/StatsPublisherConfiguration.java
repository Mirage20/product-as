/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.appserver.configuration.context;

import java.util.Optional;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A class which models a holder for context level statistics publishing configurations.
 *
 * @since 6.0.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class StatsPublisherConfiguration {
    @XmlElement(name = "enable-stats-publisher")
    private Boolean enableStatsPublisher;

    public Boolean isStatsPublisherEnabled() {
        return enableStatsPublisher;
    }

    public void enableStatsPublisher(Boolean enableStatsPublisher) {
        this.enableStatsPublisher = enableStatsPublisher;
    }

    /**
     * Merges the context level stats-publishing configuration defined globally and overridden at
     * context level (if any).
     *
     * @param configuration the local, context level group of stats-publishing configuration to be merged with
     */
    public void merge(org.wso2.appserver.configuration.context.StatsPublisherConfiguration configuration) {
        Optional.ofNullable(configuration).
                ifPresent(mergeable -> enableStatsPublisher = Optional.ofNullable(mergeable.enableStatsPublisher).
                        orElse(enableStatsPublisher));
    }
}
