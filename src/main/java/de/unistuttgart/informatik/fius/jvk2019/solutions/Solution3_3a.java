/*
 * This source file is part of the FIUS JVK 2019 project.
 * For more information see github.com/FIUS/JVK-2019
 *
 * Copyright (c) 2019 the FIUS JVK 2019 project authors.
 * 
 * This software is available under the MIT license.
 * SPDX-License-Identifier:    MIT
 */
package de.unistuttgart.informatik.fius.jvk2019.solutions;

import de.unistuttgart.informatik.fius.jvk2019.provided.entity.PhoneBooth;
import de.unistuttgart.informatik.fius.jvk2019.provided.Color;
import de.unistuttgart.informatik.fius.jvk2019.provided.entity.Pill;
import de.unistuttgart.informatik.fius.jvk2019.tasks.Task3_3;

/**
 * TODO: Solution for exercise 3 (a) of worksheet 3
 * @author paulesn
 */
public class Solution3_3a extends Task3_3 {

    @Override
    public final void solve() {
        while (!neo.isOnPhoneBooth()) {
            while (!isOnPill() && !neo.isOnPhoneBooth()) {
                neo.move();
            }
            neo.collectOnField();
            neo.turnClockWise();
        }
    }

    private boolean isOnPill() {
        return sim.getPlayfield().getEntitiesOfTypeAt(neo.getPosition(), Pill.class, true).size() > 0;
    }
    
    
}
