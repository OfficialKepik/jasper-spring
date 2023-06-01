package org.itstep;

import net.sf.jasperreports.engine.JRException;
import org.itstep.customer.Customer;
import org.itstep.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
public class ReportController {
    @Autowired
    CustomerService customerService;

    @Autowired
    ReportService reportService;

    @GetMapping(value = "/customers/report", params = {})
    public String report() {
        List<Customer> customers = customerService.findAll();
        try {
            reportService.export(customers, "report2.jrxml", "customers.html");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }
        return "redirect:/customers.html";
    }

    @GetMapping(value = "/customers/report", params = {"sort"})
    public String reportSort(@RequestParam("sort") String sort) {

        List<Customer> customers = customerService.orderBy(sort);
        try {
            reportService.export(customers, "report2.jrxml", "customers2.html");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }
        return "redirect:/customers2.html";
    }

    @GetMapping(value = "/customers2")
    public String reportSort2() {
        return "customers2";
    }
}