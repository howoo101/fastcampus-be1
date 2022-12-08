package me.day25.smartstore;

import me.day25.smartstore.customers.Customer;
import me.day25.smartstore.customers.Customers;
import me.day25.smartstore.groups.Group;
import me.day25.smartstore.groups.GroupType;
import me.day25.smartstore.groups.Groups;
import me.day25.smartstore.groups.Parameter;
import me.day25.smartstore.menu.CustomerMenu;
import me.day25.smartstore.menu.GroupMenu;
import me.day25.smartstore.menu.Menu;
import me.day25.smartstore.menu.SummarizedMenu;
import me.day25.smartstore.util.Message;


public class SmartStoreApplication {

    ////////////// singleton ////////////////
    private static SmartStoreApplication smartStoreApp;

    public static SmartStoreApplication getInstance() {
        if (smartStoreApp == null) {
            smartStoreApp = new SmartStoreApplication();
        }
        return smartStoreApp;
    }
    /////////////////////////////////////////

    private final Groups allGroups = Groups.getInstance();
    private final Customers allCustomers = Customers.getInstance();

    private final Menu menu = Menu.getInstance();

    private final CustomerMenu customerMenu = CustomerMenu.getInstance();
    private final GroupMenu groupMenu = GroupMenu.getInstance();
    private final SummarizedMenu classifiedMenu = SummarizedMenu.getInstance();


    public SmartStoreApplication test() {
        allGroups.add(new Group( GroupType.GENERAL, new Parameter(10, 100000)) );
        allGroups.add(new Group( GroupType.VIP, new Parameter(20, 200000)) );
        allGroups.add(new Group( GroupType.VVIP, new Parameter(30, 300000)) );

        for (int i = 0; i < 20; ++i) {
            allCustomers.add(new Customer(
                    Character.toString((char) (97 + i)), (char) (97 + i) + "12345", i * 10, i * 100000));
        }

        allCustomers.refresh(allGroups);
        return this;
    }

    public void run() {
        System.out.println("===========================================");
        System.out.println(" Title : SmartStore Customer Segmentation");
        System.out.println(" Release Date : 22.12.08");
        System.out.println(" Copyright 2022 Eunbin All rights reserved.");
        System.out.println("===========================================");
        System.out.println();

        while (true) {
            int choice = menu.dispMenu(new String[] {"Parameter", "Customer Data", "Classification Summary", "Quit"});

            if (choice == 1) {
                groupMenu.manageParameter();
            } else if (choice == 2) {
                customerMenu.manageCustomerData();
            } else if (choice == 3) {
                classifiedMenu.manageSummaryMenu();
            } else if (choice == 4) {
                System.out.println("\nProgram Finished.");
                break;
            } else {
                System.out.println("\n" + Message.ERR_MSG_INVALID_INPUT_RANGE);
            }
        }

    }
}