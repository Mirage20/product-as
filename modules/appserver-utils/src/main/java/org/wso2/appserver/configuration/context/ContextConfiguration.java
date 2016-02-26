/*
 *  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.wso2.appserver.configuration.context;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A Java class which models a holder for context level WSO2 specific configurations.
 *
 * @since 6.0.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wso2as-web")
public class ContextConfiguration {
    @XmlElement(name = "classloading")
    private ClassloadingConfiguration classloadingConfiguration;
    @XmlElement(name = "saml2-single-sign-on")
    private SSOConfiguration singleSignOnConfiguration;

    public ClassloadingConfiguration getClassloadingConfiguration() {
        return classloadingConfiguration;
    }

    public void setClassloadingConfiguration(ClassloadingConfiguration classloadingConfiguration) {
        this.classloadingConfiguration = classloadingConfiguration;
    }

    public SSOConfiguration getSingleSignOnConfiguration() {
        return singleSignOnConfiguration;
    }

    public void setSingleSignOnConfiguration(SSOConfiguration singleSignOnConfiguration) {
        this.singleSignOnConfiguration = singleSignOnConfiguration;
    }

    /**
     * A nested class which models context-level classloading configurations.
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ClassloadingConfiguration {
        @XmlElement(name = "parent-first")
        private Boolean isParentFirst;
        @XmlElement
        private String environments;

        public Boolean isParentFirst() {
            return isParentFirst;
        }

        public void enableParentFirst(Boolean isParentFirst) {
            this.isParentFirst = isParentFirst;
        }

        public String getEnvironments() {
            return environments;
        }

        public void setEnvironments(String environments) {
            this.environments = environments;
        }
    }
}