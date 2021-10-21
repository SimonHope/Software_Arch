package edu.parinya.softarchdesign.structural;
import java.util.Date;

public abstract class HealthcareWorkerDecorator extends HealthcareWorker{
    HealthcareWorker worker;

    public HealthcareWorkerDecorator(HealthcareWorker worker){
        super(worker);
        this.worker = worker;
    }


    @Override
    public void service(){
        worker.service();
    }

    @Override
    public double getPrice() {
        return worker.getPrice();
    }
}

class TimeLoggingHealthcareWorker extends HealthcareWorkerDecorator{

    public TimeLoggingHealthcareWorker(HealthcareWorker worker) {
        super(worker);
        System.out.println("Decorate "+getName()+" TimeLogging");
    }

    @Override
    public void service(){
        System.out.print(new Date() + ": ");
        super.service();
    }
}

class TaxPayingHealthcareWorker extends HealthcareWorkerDecorator{

    public TaxPayingHealthcareWorker(HealthcareWorker worker) {
        super(worker);
        System.out.println("Decorate "+getName()+" TaxPaying");
    }

    public double getPrice() {
        return super.getPrice()*1.1;
    }
}























