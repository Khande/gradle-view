/*
 * Copyright 2013 Ray Holder
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.rholder.gradle.intellij;

import com.github.rholder.gradle.ui.ViewActionListener;
import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.project.Project;

import java.util.ArrayList;
import java.util.List;

/**
 * Instances of this class maintain IntelliJ Project specific service state and
 * manage listener callbacks.
 */
public class GradleService extends AbstractProjectComponent {

    private List<ViewActionListener> registeredListeners = new ArrayList<ViewActionListener>();

    public GradleService(Project project) {
        super(project);
    }

    public void addListener(ViewActionListener listener) {
        registeredListeners.add(listener);
    }

    public void reset() {
        for(ViewActionListener r : registeredListeners) {
            r.reset();
        }
    }

    public void refresh() {
        for(ViewActionListener r : registeredListeners) {
            r.refresh();
        }
    }

    public void toggleShowReplaced() {
        for(ViewActionListener r : registeredListeners) {
            r.toggleShowReplaced();
        }
    }
}
