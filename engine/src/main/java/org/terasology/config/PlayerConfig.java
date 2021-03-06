/*
 * Copyright 2016 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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
 */

package org.terasology.config;

import java.util.List;

import org.terasology.rendering.nui.Color;
import org.terasology.rendering.nui.layers.mainMenu.settings.CieCamColors;
import org.terasology.utilities.random.FastRandom;
import org.terasology.utilities.random.Random;

public class PlayerConfig {

    private static final float DEFAULT_PLAYER_HEIGHT = 1.8f;

    private static final float DEFAULT_PLAYER_EYE_HEIGHT = 0.7f;

    private String name = defaultPlayerName();

    private Color color = defaultPlayerColor();

    private Float height = DEFAULT_PLAYER_HEIGHT;

    private Float eyeHeight = DEFAULT_PLAYER_EYE_HEIGHT;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getEyeHeight() {
        return eyeHeight;
    }

    public void setEyeHeight(Float eyeHeight) {
        if (eyeHeight < this.height) {
            this.eyeHeight = eyeHeight;
        }
    }

    private static String defaultPlayerName() {
        try {
            String login = System.getProperty("user.name");
            if (login != null && !login.isEmpty()) {
                return login;
            }
        } catch (SecurityException e) {
            // thrown by all Sandbox RIAs (Webstart, Applets)
            e.getMessage(); // dummy method call to trick CheckStyle
        }
        return "Player_" + new FastRandom().nextInt(10000, 99999);
    }

    private Color defaultPlayerColor() {
        Random rng = new FastRandom();
        List<Color> colors = CieCamColors.L65C65;
        return colors.get(rng.nextInt(colors.size()));
    }
}
