/*
 * Copyright 2018 TestProject LTD. and/or its affiliates
 * and other contributors as indicated by the @author tags.
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
package io.testproject.addon.android_network;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.NetworkSpeed;
import io.testproject.java.annotations.v2.Action;
import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.sdk.v2.addons.AndroidAction;
import io.testproject.java.sdk.v2.addons.helpers.AndroidAddonHelper;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;

@Action(name = "Set Network Speed",
        description = "Set the Android emulators perceived network speed",
        summary = "Sets the synthetic network speed for an Android emulator to match one of a variety of pre-set network speeds")
public class AndroidNetworkAction implements AndroidAction {

    @Parameter(description = "The network speed to adopt. Must be one of the following values: GSM, SCSD, GPRS, EDGE, UMTS, HSDPA, LTE, EVDO, FULL")
    public String speed = "LTE";

    @Override
    public ExecutionResult execute(AndroidAddonHelper helper) throws FailureException {
        AndroidDriver<AndroidElement> driver = helper.getDriver();
        driver.setNetworkSpeed(NetworkSpeed.valueOf(speed));
        return ExecutionResult.PASSED;
    }

}
