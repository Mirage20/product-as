/*
 *  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied. See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */

package org.wso2.appserver.test.integration.loader;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.wso2.appserver.test.integration.TestConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This sample test class demonstrate how to write a test cases which runs on integration test phase.
 * Every class that requires run in integration test phase should have prefix of <strong>IT</strong>
 */
public class WebappLoaderIT {

    /**
     * This sample test case check if the server is running by sending a request to the server.
     */
    @Test
    public void environmentConfigurationTest() {

        try {
            String url = "http://localhost:" + System.getProperty(TestConstants.APPSERVER_PORT) +
                    "/simple-storage-service/storage/store/get/defaultKey";
            URL requestUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            Assert.assertEquals(200, responseCode);

            if (responseCode == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
                StringBuilder sb = new StringBuilder();
                String output;
                while ((output = br.readLine()) != null) {
                    sb.append(output);
                }
                String expectedDefaultValue = "This is a simple REST storage service for storing key value pairs.";
                Assert.assertEquals(expectedDefaultValue, sb.toString());

            }


        } catch (IOException e) {
            Assert.fail("Fail connection to the server. Error: " + e.getMessage());
        }

    }
}