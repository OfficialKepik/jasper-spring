package org.itstep;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.itstep.customer.Customer;
import org.itstep.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    private CustomerService customerService;

    public String export(List<Customer> customers, String template, String report) throws FileNotFoundException, JRException {
        File file = ResourceUtils.getFile("classpath:reports/" + template);
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(customers);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
        JasperExportManager.exportReportToHtmlFile(jasperPrint, "C:\\Users\\gk\\IdeaProjects\\jasper\\src\\main\\resources\\public\\customers.html" + report);
        return null;
    }
}
