/*
 * This source file is part of the FIUS JVK 2019 project.
 * For more information see github.com/FIUS/JVK-2019
 *
 * Copyright (c) 2019 the FIUS JVK 2019 project authors.
 * 
 * This software is available under the MIT license.
 * SPDX-License-Identifier:    MIT
 */
package de.unistuttgart.informatik.fius.jvk2019.tasks;

import de.unistuttgart.informatik.fius.icge.log.Logger;
import de.unistuttgart.informatik.fius.icge.simulation.Direction;
import de.unistuttgart.informatik.fius.icge.simulation.Simulation;
import de.unistuttgart.informatik.fius.jvk2019.provided.entity.Coin;
import de.unistuttgart.informatik.fius.jvk2019.provided.entity.MyNeo;


/**
 * 
 * Task for Sheet 2, Task 1 2019
 * 
 * @author Tim-Julian Ehret, Stefan Zindl
 */
public abstract class Task2_1 extends TaskWithHelperFunctions {
    
    protected MyNeo myNeo;
    
    /**
     * Spawns a cage with a coin in it.
     */
    @Override
    public void prepare(Simulation sim) {
        super.prepare(sim);
        //spawning a grid of coins
        for (int i = -9; i <= 9; i += 2) {
            for (int j = -9; j <= 9; j += 2) {
                this.spawnEntity(new Coin(), i, j);
            }
        }
    }
    
    @Override
    public final boolean verify() {
        //output the value of the coins that neo currently holds (1 should be collected during solve)
        Logger.out.append("\nmyNeo has currently coins with the value of " + this.myNeo.getBalance() + "\n");
        Direction lookingDirection = this.myNeo.getLookingDirection();
        
        this.myNeo.turnCounterClockwise();
        if (lookingDirection.clockWiseNext().clockWiseNext().clockWiseNext() != this.myNeo.getLookingDirection()) return false;
        
        this.myNeo.turnAround();
        if (lookingDirection.clockWiseNext() != this.myNeo.getLookingDirection()) return false;
        int bal = this.myNeo.getCoinsInWallet();
        this.myNeo.gainCoins(12);
        if (this.myNeo.getBalance() != bal + 24) return false;
        
        return true;
    }
}
