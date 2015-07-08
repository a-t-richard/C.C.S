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
package Model.Agents.Bodies;

import Model.Agents.Brains.Infrastructure_Brain;
import Model.Environment.Environment;
import Model.Environment.Infrastructure;
import java.util.ArrayList;

/**
 * The class Infrastructure_Body represents the body of an infrastructure agent.
 * 
 * @author Antoine "Avzgui" Richard
 */
abstract public class Infrastructure_Body extends A_Body {

    protected final Infrastructure infrastructure;
    protected final ArrayList<Vehicle_Body> vehicles;
    protected final ArrayList<Infrastructure_Body> neighbors;
    
    /**
     * Constructor
     * 
     * @param id ID of the body (by default, the same as the agent).
     * @param env environment of the body.
     * @param brain brain linked to the body.
     * @param infrastructure infrastructure that the infrastructure agent is responsible.
     */
    public Infrastructure_Body(int id, Environment env, 
            Infrastructure_Brain brain, Infrastructure infrastructure) {
        super(id, env, brain);
        this.infrastructure = infrastructure;
        this.vehicles = new ArrayList<>();
        this.neighbors = new ArrayList<>();
    }

    /**
     * Returns the infrastructure that the infrastructure agent is responsible.
     * 
     * @return the infrastructure linked to the body.
     */
    public Infrastructure getInfrastructure() {
        return infrastructure;
    }

    /**
     * Returns the array of vehicles in dialog with the infrastructure.
     * 
     * @return the array of vehicles.
     */
    public ArrayList<Vehicle_Body> getVehicles() {
        return vehicles;
    }
    
    /**
     * Adds a vehicle to the array of the vehicles int dialog with infrastructure.
     * 
     * Needs to be surcharged by the children class.
     * 
     * @param vehicle the new vehicle to add.
     */
    abstract public void addVehicle(Vehicle_Body vehicle);

    /**
     * Returns the array of the neighbors of the infrastructure.
     * 
     * @return the array of neighbors.
     */
    public ArrayList<Infrastructure_Body> getNeighbors() {
        return neighbors;
    }
    
    /**
     * Adds a infrastructure to the array of neighbors.
     * 
     * @param neighbor the new neighbor of the infrastructure.
     */
    public void addNeighbor(Infrastructure_Body neighbor){
        this.neighbors.add(neighbor);
    }
}