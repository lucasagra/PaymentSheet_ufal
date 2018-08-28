package models.employees;

import models.Sale;
import models.employees.info.*;
import models.employees.info.Payment;
import models.payday.WeeklyPayday;
import models.employees.info.WorkedTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Commissioned extends Salaried {

    private Stack<Sale> sales = new Stack<>();
    private Payment payment_schedule;
    private int commission_percent;

    public Commissioned(int id, String name, Address address, Syndicate syndicate, double salary, int commission, String type, WorkedTime worked_hours){
        super(id, name, address, syndicate, salary, type, worked_hours);
        this.payment_schedule = new Payment(new WeeklyPayday(2,5), salary, type);
        this.commission_percent = commission;
    }


    public Commissioned(int id, String name, Address address, Syndicate syndicate, int commission, Payment payment_schedule, Stack<Sale> sales, WorkedTime worked_hours){
        super(id, name, address, syndicate, payment_schedule, worked_hours);
        this.payment_schedule = payment_schedule;
        this.commission_percent = commission;
        this.sales = sales;
    }

    public Stack<Sale> getSales() {
        return sales;
    }

    @Override
    public Payment getPayment_schedule() {
        return payment_schedule;
    }

    public void setCommission_percent(int commission_percent) {
        this.commission_percent = commission_percent;
    }

    public int getCommission_percent() {
        return commission_percent;
    }

    public void addSale(Sale sale){
        if(sale != null){
            sales.push(sale);
        }
    }

    @Override
    public String toString(){
        return super.toString() +
                "Employee type: Commissioned \n" +
                payment_schedule.toString() +
                "Commission: " + commission_percent + "%\n";
    }
}
