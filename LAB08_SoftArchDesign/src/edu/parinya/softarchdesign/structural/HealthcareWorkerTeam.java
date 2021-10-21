package edu.parinya.softarchdesign.structural;

import java.util.Set;
import java.util.LinkedHashSet;

public class HealthcareWorkerTeam implements HealthcareServiceable{
    protected Set<HealthcareServiceable> members;

    public HealthcareWorkerTeam() {
        members = new LinkedHashSet<>();
    }

    public void addMember(HealthcareServiceable members){
        this.members.add(members);
    }

    public void removeMember(HealthcareServiceable members){
        this.members.remove(members);
    }

    public void service(){
        for (HealthcareServiceable count : members)
        {
            count.service();
        }
    }

    @Override
    public double getPrice() {
        double price = 0;

        for (HealthcareServiceable count : members)
        {
            price += count.getPrice();
        }
        return price;
    }
}
