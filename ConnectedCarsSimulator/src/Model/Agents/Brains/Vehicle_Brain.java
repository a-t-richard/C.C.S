/*
 * Copyright (C) 2015 Antoine "Avzgui" Richard
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package Model.Agents.Brains;

import Model.Agents.Bodies.Vehicle_Body;
import Model.Environment.Cell;
import Model.Environment.Way;
import Model.Messages.M_Welcome;
import Model.Messages.Message;

/**
 * The class Vehicle_Brain represents the behavior layer of a vehicle agent.
 * 
 * @author Antoine "Avzgui" Richard
 */
public class Vehicle_Brain extends A_Brain {

    protected Way way;
    
    /**
     * Constructor
     * 
     * @param id ID of the brain (by default, the same as the agent).
     * @param body the body of the agent.
     */
    public Vehicle_Brain(int id, Vehicle_Body body) {
        super(id, body);
        this.way = null;
    }

    /**
     * Returns the way the agent have to follow.
     * 
     * @return the way of the agent.
     */
    public Way getWay() {
        return way;
    }

    /**
     * Changes the way of the agent.
     * 
     * @param way the new way to set.
     */
    public void setWay(Way way) {
        this.way = way;
    }
    
    @Override
    public void processMessage(Message mess){
        if(mess instanceof M_Welcome){
            M_Welcome m = (M_Welcome) mess;
            this.way = new Way((Way) m.getDatum().get(0));
            this.way.pop();
            
            Vehicle_Body v_body = (Vehicle_Body) this.body;
            v_body.setSpeed(1.0);
        }
    }

    @Override
    public void run(){
        //Process all the messages
        while(!this.messages_memory.isEmpty()){
            processMessage(this.messages_memory.get(0));
            this.messages_memory.remove(0);
        }
        
        //Update direction
        Vehicle_Body v_body = (Vehicle_Body) this.body;
        if(v_body.getDirection() == null && !this.way.isEmpty())
            v_body.setDirection(this.way.pop());
    }
}
